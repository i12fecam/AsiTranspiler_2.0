package Analisis;

import Parsing.SicomeParser;
import org.antlr.v4.runtime.Token;

public class MicroAnalisis extends BasicAnalisis{

    @Override
    public void enterMicroInstructionBlock(SicomeParser.MicroInstructionBlockContext ctx) {
        symbolTable.addFunction("halt","",0);
    }

    @Override
    public void enterMicroInstruction(SicomeParser.MicroInstructionContext ctx) {
        Token identifier = ctx.IDENTIFIER().getSymbol();
        Token arg = ctx.arg;
        int size = ctx.microStep().size();


        int instrId = -1;
        try {
            instrId = symbolTable.addFunction(identifier.getText(), arg.getText(), size);
        }catch (RuntimeException e){
            throw new LogicException(e.getMessage(),identifier);
        }

        //Se anota en el arbol las IDs
        ids.put(ctx,instrId);
        int stepId = 0 ;
        for(var step:ctx.microStep()){
            ids.put(step,stepId);
            stepId++;
        }
    }

    @Override
    public void enterSimpleStatusLogic(SicomeParser.SimpleStatusLogicContext ctx) {
        String name = ctx.name.getText();
        boolean needsArg = false;
        if(ctx.option.getText().equals("BIF")){//TODO reformular para no poner literales
            needsArg = true;
        }

        try {
            symbolTable.addBifurcationLogic(name,needsArg);
        }catch (RuntimeException e){
            throw new LogicException(e.getMessage(),ctx.name);
        }

    }

    @Override
    public void enterComplexStatusLogic(SicomeParser.ComplexStatusLogicContext ctx) {
        String name = ctx.name.getText();
        boolean needsArg = false;
        for(var newCtx :ctx.statusLogicOption() ){
            if(newCtx.option.getText().equals("BIF")){
                needsArg = true;
                break;
            }
        }

        try {
            symbolTable.addBifurcationLogic(name,needsArg);
        }catch (RuntimeException e){
            throw new LogicException(e.getMessage(),ctx.name);
        }

    }
}
