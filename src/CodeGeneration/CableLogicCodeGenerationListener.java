package CodeGeneration;

import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import internals.FlagStatus;
import internals.MicroInstruction;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CableLogicCodeGenerationListener extends SicomeBaseListener {
    ParseTreeProperty<Integer> _ids = null;
    CableLogicCodeGenerationListener(ParseTreeProperty<Integer> ids){
        _ids = ids;
    }

    class MicroInstructionMapper{
        Map<MicroInstruction,String> map = new HashMap<>(24);
         public void addMicroInstructionUse(MicroInstruction mi, int id_func, int id_step, FlagStatus... flags ) {
             String uses = map.get(mi);
             if (uses == null) {
                 map.put(mi, mi.outputName + ": ");
                 uses = map.get(mi);
             }

             uses += "t" + id_step + " " + "q" + id_func;
             for (FlagStatus flag : flags) {
                uses+=flag.getOutputName();//TODO refinar por las comas
             }
         }
    }
    @Override
    public void exitSimpleStep(SicomeParser.SimpleStepContext ctx) {
        int id_func =_ids.get(ctx.getParent());
        int id_step = _ids.get(ctx);

        List<TerminalNode> mInstrs =ctx.MICRO_INSTR();
        for(TerminalNode mInstr : mInstrs){
           MicroInstruction mi = MicroInstruction.valueOfInput(ctx.getText());


        }
    }

}
