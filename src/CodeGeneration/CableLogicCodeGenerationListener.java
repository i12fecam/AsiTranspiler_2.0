package CodeGeneration;

import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import internals.Cableado.ControlAction;
import internals.FlagStatus;
import internals.MicroInstruction;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CableLogicCodeGenerationListener extends SicomeBaseListener {
    ParseTreeProperty<Integer> _ids = null;
    public CableLogicCodeGenerationListener(ParseTreeProperty<Integer> ids){
        _ids = ids;
    }


    public String getLogicFileString(){
        return null;
    }

    public String getRepositoryFileString(){
        return null;
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
