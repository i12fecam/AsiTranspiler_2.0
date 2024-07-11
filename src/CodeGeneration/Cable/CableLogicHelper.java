package CodeGeneration.Cable;

import internals.Cableado.ControlAction;
import internals.Cableado.ControlEnum;
import internals.FlagState;
import internals.MicroInstruction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CableLogicHelper {
    /*
    GPR+1->GPR:t4·q5 + t11·q6 + t6·q7·As' + t10·q8·F·Zsc + t10·q8·F·Zsc'
     */
    private Map<MicroInstruction, String> MImap = new HashMap<>(24);

    /**
     * Initializes the generator adding manually the microinstructions referring to the fetch functionality
     */
    public CableLogicHelper(){
        //Se añade las instrucciones correspondientes al fetch
        addMicroInstructionUse(MicroInstruction.pc_to_mar,null,0,null);

        addMicroInstructionUse(MicroInstruction.pc_plus_to_pc,null,1,null);
        addMicroInstructionUse(MicroInstruction.m_to_gpr,null,1,null);

        addMicroInstructionUse(MicroInstruction.gpr_ad_to_mar,null,2,null);
        addMicroInstructionUse(MicroInstruction.gpr_op_to_opr,null,2,null);


        addControlActionUse(new ControlAction(ControlEnum.SR_PLUS,null),null,0,null);
        addControlActionUse(new ControlAction(ControlEnum.SR_PLUS,null),null,1,null);
        addControlActionUse(new ControlAction(ControlEnum.SR_PLUS,null),null,2,null);

    }

    /**
     * Registers a new use of a microInstruction, the first step of a function is assumed to be 0 unless the id of the fuction is null in which case it will not account for the steps of the fetch function
     * @param mi microinstruction used
     * @param idFunc the id of the function in which it is used
     * @param idStep the step the in which the microinstruction is used, The first step of a fuction is assumed to be 0
     * @param flags the flags that are to be activated to use the micro instruction
     */
    public void addMicroInstructionUse(MicroInstruction mi, Integer idFunc, int idStep, List<FlagState> flags) {

        /*Cuando no tiene funciones asociadas se asume que es una instrucción de fetch
         Si no es de fetch se le añade 3 pasos mas porque esos tres son los que pertence al inicio de fetch
         */
        if(idFunc != null){
            idStep+=3;
        }


        String uses = MImap.get(mi);
        StringBuilder builder = null;
        if (uses == null) {
            builder = new StringBuilder();
            builder.append(mi.outputName);
            builder.append(":");
        }else {
            builder = new StringBuilder(uses);
            builder.append(" + ");
        }
        builder.append("t").append(idStep);
        if(idFunc!=null) {
            builder.append("·");
            builder.append("q").append(idFunc);
        }
        if(flags!=null) {
            for (FlagState flag : flags) {
                builder.append("·");
                builder.append(flag.getOutputName());
            }
        }
        MImap.put(mi, builder.toString());


    }

    private Map<ControlAction, String> ControlMap = new HashMap<>(24);

    public void addControlActionUse(ControlAction action, Integer idFunc, int idStep, List<FlagState> flags) {

        if(idFunc != null){
            idStep+=3;
        }
        String uses = ControlMap.get(action);
        StringBuilder builder;
        if (uses == null) {
            builder = new StringBuilder();
            builder.append(action.getControlText());
            builder.append(":");
        } else {
            builder = new StringBuilder(uses);
            builder.append(" + ");
        }

        builder.append("t").append(idStep);
        if(idFunc != null) {
            builder.append("·");
            builder.append("q").append(idFunc);
        }
        if(flags!=null) {
            for (FlagState flag : flags) {
                builder.append("·");
                builder.append(flag.getOutputName());
            }
        }
        if(action.getValue()!=null){
            builder.append("-").append(action.getValue());
        }
        ControlMap.put(action, builder.toString());


    }


    public String getText(){
        StringBuilder builder = new StringBuilder();

        builder.append("$").append("\n");
        for (Map.Entry<MicroInstruction,String> entry :MImap.entrySet()){
            builder.append(entry.getValue());
            builder.append("\n");

        }
        builder.append("$").append("\n");
        for(Map.Entry<ControlAction,String> entry: ControlMap.entrySet()){
            builder.append(entry.getValue());
            builder.append("\n");
        }
        builder.append("$").append("\n");
        return builder.toString();
    }
}
