package CodeGeneration;

import internals.Cableado.ControlAction;
import internals.FlagStatus;
import internals.MicroInstruction;

import java.util.HashMap;
import java.util.Map;

class MicroInstructionMapper {
    /*
    GPR+1->GPR:t4·q5 + t11·q6 + t6·q7·As' + t10·q8·F·Zsc + t10·q8·F·Zsc'
     */
    Map<MicroInstruction, String> MImap = new HashMap<>(24);

    public void addMicroInstructionUse(MicroInstruction mi, int id_func, int id_step, FlagStatus... flags) {
        String uses = MImap.get(mi);
        StringBuilder builder = new StringBuilder(uses);
        if (uses == null) {
            builder.append(mi.outputName);
            builder.append(":");
            builder.append("t").append(id_step);
            builder.append("·");
            builder.append("q").append(id_func);
            for (FlagStatus flag : flags) {
                builder.append("·");
                builder.append(flag.getOutputName());
            }
            MImap.put(mi, builder.toString());
        } else {
            builder.append(" + ");
            builder.append("t").append(id_step);
            builder.append("·");
            builder.append("q").append(id_func);
            for (FlagStatus flag : flags) {
                builder.append("·");
                builder.append(flag.getOutputName());
            }
            MImap.put(mi, builder.toString());
        }

    }

    Map<ControlAction, String> ControlMap = new HashMap<>(24);

    public void addControlActionUse(ControlAction action, int id_func, int id_step, FlagStatus... flags) {
        String uses = ControlMap.get(action);
        StringBuilder builder = new StringBuilder(uses);
        if (uses == null) {
            builder.append(action.getControlText());//TODO terminar
            builder.append(":");
            builder.append("t").append(id_step);
            builder.append("·");
            builder.append("q").append(id_func);
            for (FlagStatus flag : flags) {
                builder.append("·");
                builder.append(flag.getOutputName());
            }
            ControlMap.put(action, builder.toString());
        } else {
            builder.append(" + ");
            builder.append("t").append(id_step);
            builder.append("·");
            builder.append("q").append(id_func);
            for (FlagStatus flag : flags) {
                builder.append("·");
                builder.append(flag.getOutputName());
            }
            ControlMap.put(action, builder.toString());
        }
    }
}
