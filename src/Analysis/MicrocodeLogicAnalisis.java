package Analysis;

import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import Internals.SymbolTable;

public class MicrocodeLogicAnalisis extends SicomeBaseListener {
    public SymbolTable symbolTable = new SymbolTable();

    public MicrocodeLogicAnalisis(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
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
