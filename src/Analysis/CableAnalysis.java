package Analysis;

import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import Internals.SymbolTable;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.util.List;

import static Internals.Errors.ErrorEnum.NUMERO_INSTRUCCIONES_SUPERADO;

public class CableAnalysis extends SicomeBaseListener {
    private final SymbolTable symbolTable;
    private final ParseTreeProperty<Integer> ids;

    public CableAnalysis(ParseTreeProperty<Integer> ids, SymbolTable symbolTable) {
        this.ids = ids;
        this.symbolTable = symbolTable;
    }


    @Override
    public void enterCableInstructionBlock(SicomeParser.CableInstructionBlockContext ctx){
        if(ctx.cableInstruction().size() > 32){
            ErrorController.getInstance()
                    .addNewError(NUMERO_INSTRUCCIONES_SUPERADO,List.of(),ctx.start);
        }
    }
    /**
     * Annotates the tree with the ids of the steps and the id of the function
     * Also adds to the symbol table the function definition
     * @param ctx the parse tree
     */
    @Override
    public void enterCableInstruction(SicomeParser.CableInstructionContext ctx) {
        String functionName =ctx.IDENTIFIER().getText();
        String args = "";
        if(ctx.arg!= null)  args =ctx.arg.getText();

        List<SicomeParser.CableStepContext> steps =ctx.cableStep();
        int instr_id = -1;
        try {
            instr_id = symbolTable.addInstruction(functionName, args, steps.size());
        }catch (RuntimeException e){
            ErrorController.getInstance().addNewError(ErrorEnum.INSTRUCCION_MISMO_NOMBRE, List.of(ctx.IDENTIFIER().getText()), ctx.IDENTIFIER().getSymbol());
        }
        ids.put(ctx,instr_id);
        int step_id = 0 ;
        for(SicomeParser.CableStepContext step : steps){
            ids.put(step,step_id);
            step_id++;
        }
    }
    @Override
    public void enterFetchCableInstruction(SicomeParser.FetchCableInstructionContext ctx) {
        ids.put(ctx,null);
        int step_id = 0 ;
        for(var step : ctx.cableStep()){
            ids.put(step,step_id);
            step_id++;
        }
    }

}
