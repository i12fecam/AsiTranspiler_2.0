package Analisis;

import Parsing.SicomeParser;

public class MicroAnalisis extends BasicAnalisis{

    @Override
    public void enterMicroInstruction(SicomeParser.MicroInstructionContext ctx) {
        String name = ctx.IDENTIFIER().toString();
        String arg = ctx.arg.getText();
        int size = ctx.microStep().size();
        int instrId = -1;
        try {
            instrId = symbolTable.addFunction(name, arg, size);
        }catch (RuntimeException e){
            throw new LogicException(e.getMessage(),ctx.IDENTIFIER().getSymbol());
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
