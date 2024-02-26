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

    public void addMicroInstructionUse(MicroInstruction mi, int id_func, int id_step, List<FlagStatus> flags) {
        String uses = MImap.get(mi);
        StringBuilder builder = null;
        if (uses == null) {
            builder = new StringBuilder();
            builder.append(mi.outputName);
            builder.append(":");
            builder.append("t").append(id_step);
            builder.append("·");
            builder.append("q").append(id_func);
            if(flags!=null) {
                for (FlagStatus flag : flags) {
                    builder.append("·");
                    builder.append(flag.getOutputName());
                }
            }
            MImap.put(mi, builder.toString());
        } else {
            builder = new StringBuilder(uses);
            builder.append(" + ");
            builder.append("t").append(id_step);
            builder.append("·");
            builder.append("q").append(id_func);
            if(flags!=null) {
                for (FlagStatus flag : flags) {
                    builder.append("·");
                    builder.append(flag.getOutputName());
                }
            }
            MImap.put(mi, builder.toString());
        }

    }

    Map<ControlAction, String> ControlMap = new HashMap<>(24);

    public void addControlActionUse(ControlAction action, int id_func, int id_step, List<FlagStatus> flags) {
        String uses = ControlMap.get(action);
        StringBuilder builder;
        if (uses == null) {//TODO detecta que siempre sera null posible error?
            builder = new StringBuilder();
            builder.append(action.getControlText());
            builder.append(":");
            builder.append("t").append(id_step);
            builder.append("·");
            builder.append("q").append(id_func);
            if(flags!=null) {
                for (FlagStatus flag : flags) {
                    builder.append("·");
                    builder.append(flag.getOutputName());
                }
            }
            ControlMap.put(action, builder.toString());
        } else {
            builder = new StringBuilder(uses);
            builder.append(" + ");
            builder.append("t").append(id_step);
            builder.append("·");
            builder.append("q").append(id_func);
            if(flags!=null) {
                for (FlagStatus flag : flags) {
                    builder.append("·");
                    builder.append(flag.getOutputName());
                }
            }
            ControlMap.put(action, builder.toString());
        }
    }


    public String getLogicText(){
        StringBuilder builder = new StringBuilder();
        //TODO añadir instrucciones de bucle incial
        for (Map.Entry<MicroInstruction,String> entry :MImap.entrySet()){
            builder.append(entry.getValue());
            builder.append("\n");

        }

        for(Map.Entry<ControlAction,String> entry: ControlMap.entrySet()){
            builder.append(entry.getValue());
            builder.append("\n");
        }

        return builder.toString();
    }
}
