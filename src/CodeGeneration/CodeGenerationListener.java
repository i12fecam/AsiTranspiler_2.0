package CodeGeneration;

import Analisis.SymbolTable;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import internals.Cableado.ControlAction;
import internals.FlagStatus;
import internals.MicroInstruction;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class CodeGenerationListener extends SicomeBaseListener {
    ParseTreeProperty<Integer> _ids = null;
    SymbolTable _symbols = null;
     public CodeGenerationListener(ParseTreeProperty<Integer> ids, SymbolTable st){
        _ids = ids;
        _symbols=st;
    }

    LogicFileGenerator logic = new LogicFileGenerator();

     RepositoryFileGenerator repository = new RepositoryFileGenerator(_symbols);

    public String getLogicFileString(){
        return logic.getLogicText();
    }

    public String getRepositoryFileString(){
        return repository.getTextRepository();
    }


    @Override
    public void exitSimpleCableStep(SicomeParser.SimpleCableStepContext ctx) {
        int id_func = _ids.get(ctx.getParent());
        int id_step = _ids.get(ctx);

        List<TerminalNode> mInstrs = ctx.MICRO_INSTR();
        for (TerminalNode mInstr : mInstrs) {
            MicroInstruction mi = MicroInstruction.valueOfInput(ctx.getText());
            logic.addMicroInstructionUse(mi, id_func, id_step, (FlagStatus) null);

        }

        //TODO reestructurar para que los listeners estén más abajo en el arbol
    }
}
