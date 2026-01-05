package Analisis;

import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import internals.SymbolTable;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.List;

public class CableAnalisis extends SicomeBaseListener {
    private SymbolTable symbolTable;
    private ParseTreeProperty<Integer> ids;

    public CableAnalisis(ParseTreeProperty<Integer> ids, SymbolTable symbolTable) {
        this.ids = ids;
        this.symbolTable = symbolTable;
    }

    /**
     * Anotates the tree with the ids of the steps and the id of the function
     * Also adds to the symbol table the function definition
     * @param ctx the parse tree
     */
    @Override
    public void enterCableInstruction(SicomeParser.CableInstructionContext ctx) {
        String functionName =ctx.IDENTIFIER().getText();
        String args = "";
        if(ctx.arg!= null)  args =ctx.arg.getText();

        List<SicomeParser.CableStepContext> steps =ctx.cableStep();
        int instr_id;
        try {
            instr_id = symbolTable.addFunction(functionName, args, steps.size());
        }catch (RuntimeException e){
            throw new LogicException(e.getMessage(),ctx.IDENTIFIER().getSymbol());
        }
        ids.put(ctx,instr_id);
        int step_id = 0 ;
        for(SicomeParser.CableStepContext step : steps){
            ids.put(step,step_id);
            step_id++;
        }
    }

    @Override
    public void enterCableInstructionBlock(SicomeParser.CableInstructionBlockContext ctx) {
        symbolTable.addFunction("halt","",0);
    }
}
