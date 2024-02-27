package CodeGeneration;

import internals.Cableado.ControlAction;
import internals.FlagStatus;
import internals.MicroInstruction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LogicFileGenerator {
    /*
    GPR+1->GPR:t4·q5 + t11·q6 + t6·q7·As' + t10·q8·F·Zsc + t10·q8·F·Zsc'
     */
    Map<MicroInstruction, String> MImap = new HashMap<>(24);

    LogicFileGenerator(){
        //Se añade las instrucciones correspondientes al fetch
        addMicroInstructionUse(MicroInstruction.pc_to_mar,null,0,null);

        addMicroInstructionUse(MicroInstruction.pc_plus_to_pc,null,1,null);
        addMicroInstructionUse(MicroInstruction.m_to_gpr,null,1,null);

        addMicroInstructionUse(MicroInstruction.gpr_ad_to_mar,null,2,null);
        addMicroInstructionUse(MicroInstruction.gpr_op_to_opr,null,2,null);
    }

    public void addMicroInstructionUse(MicroInstruction mi, Integer id_func, int id_step, List<FlagStatus> flags) {

        /*Cuando no tiene funciones asociadas se asume que es una instrucción de fetch
         Si no es de fetch se le ñade 3 pasos mas porque esos tres son los que pertence al inicio de fetch
         */
        if(id_func != null){
            id_step+=3;
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
        builder.append("t").append(id_step);
        if(id_func!=null) {
            builder.append("·");
            builder.append("q").append(id_func);
        }
        if(flags!=null) {
            for (FlagStatus flag : flags) {
                builder.append("·");
                builder.append(flag.getOutputName());
            }
        }
        MImap.put(mi, builder.toString());


    }

    Map<ControlAction, String> ControlMap = new HashMap<>(24);

    public void addControlActionUse(ControlAction action, Integer id_func, int id_step, List<FlagStatus> flags) {

        if(id_func != null){
            id_step+=3;
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

        builder.append("t").append(id_step);
        if(id_func != null) {
            builder.append("·");
            builder.append("q").append(id_func);
        }
        if(flags!=null) {
            for (FlagStatus flag : flags) {
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
