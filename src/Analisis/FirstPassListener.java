package Analisis;

import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.List;

/**
 * Anotates the tree in functions and steps with their number
 * Register in the Symbol Table Marks and FUnction definitions
 */
public class FirstPassListener extends SicomeBaseListener {

    SymbolTable cl = new SymbolTable();
    ParseTreeProperty<Integer> ids = new ParseTreeProperty<Integer>();




    @Override
    public void enterCableInstruction(SicomeParser.CableInstructionContext ctx) {
        int id =cl.addFunction(ctx.IDENTIFIER().getText(),ctx.instructionArgument().getText());//TODO Posible mejor forma de lanzar errores

        ids.put(ctx,id);
        List<SicomeParser.CableStepContext> steps =ctx.cableStep();
        int step_id = 0 ;
        for(SicomeParser.CableStepContext step : steps){
            ids.put(ctx,step_id);
            step_id++;
            cl.addStepToFunction(id,step_id);
        }
    }

    public ParseTreeProperty<Integer> getIds(){
        return ids;
    }

    public SymbolTable getSymbolTable(){
        return cl;
    }
}
