package CodeGeneration;

import Analisis.SymbolTable;
import Parsing.SicomeParser;
import internals.Micro.BifurcationLogic;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;

public class MicroCodeGenerator extends BasicCodeGenerator{

    private MicroLogicHelper logic = new MicroLogicHelper();

    private MicroRepositoryHelper repository = new MicroRepositoryHelper();

    public MicroCodeGenerator(ParseTreeProperty<Integer> ids, SymbolTable st) {
        super(ids, st);
    }

    @Override
    public void enterSimpleStatusLogic(SicomeParser.SimpleStatusLogicContext ctx) {
        String name = ctx.name.getText();
        BifurcationLogic bifLogic = _symbols.getBifurcationLogic(name);
        boolean inc = false;
        boolean bif = false;
        boolean ret = false;
        switch (ctx.option.getText()){
            case "bif":bif=true; break;
            case "inc":inc=true;break;
            case "ret":ret=true;break;
        }
        boolean dis = false;
        if(ctx.disable!=null) dis=true;

        logic.addStatusLogic(bifLogic.getId(),new ArrayList<>(){},inc,bif,ret,dis);
    }

    @Override
    public void enterComplexStatusLogic(SicomeParser.ComplexStatusLogicContext ctx) {
        String name = ctx.name.getText();
        for(var paths:ctx.statusLogicOption()){

        }
    }
}
