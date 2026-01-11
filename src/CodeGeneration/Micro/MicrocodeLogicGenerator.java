package CodeGeneration.Micro;

import Analysis.LogicException;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import Internals.FlagState;
import Internals.BifurcationLogic;
import Internals.SymbolTable;

import java.util.ArrayList;

public class MicrocodeLogicGenerator extends SicomeBaseListener {

    private final SymbolTable symbols;
    //private ParseTreeProperty<Integer> ids;

    private final MicroLogicHelper logic = new MicroLogicHelper();


    public MicrocodeLogicGenerator(SymbolTable st) {
        this.symbols = st;
    }


    @Override
    public void enterSimpleStatusLogic(SicomeParser.SimpleStatusLogicContext ctx) {
        String name = ctx.name.getText();
        BifurcationLogic bifLogic = symbols.getBifurcationLogic(name);
        boolean inc = false;
        boolean bif = false;
        boolean ret = false;
        switch (ctx.option.getText()){
            case "BIF":bif=true; break;
            case "INCR":inc=true;break;
            case "RET":ret=true;break;
        }
        boolean enable = true;
        if(ctx.disable!=null) enable=false;

        logic.addStatusLogic(bifLogic.getId(),new ArrayList<>(){},inc,bif,ret,enable);
    }

    @Override
    public void enterComplexStatusLogic(SicomeParser.ComplexStatusLogicContext ctx) {
        String name = ctx.name.getText();


        for(var optionCtx:ctx.statusLogicOption()){
            //Se registra flags
            ArrayList<FlagState> flags = new ArrayList<>();
            for(var flagToken:optionCtx.flags){
                FlagState flag = FlagState.ValueOfInput(flagToken.getText());
                if(flag==null) throw new LogicException("Flag no reconocida",flagToken);
                flags.add(flag);
            }
            BifurcationLogic bifLogic = symbols.getBifurcationLogic(name);
            boolean inc = false;
            boolean bif = false;
            boolean ret = false;
            switch (optionCtx.option.getText()){
                case "BIF":bif=true; break;
                case "INCR":inc=true;break;
                case "RET":ret=true;break;
            }
            boolean enable = true;
            if(optionCtx.disable!=null) enable=false;

            logic.addStatusLogic(bifLogic.getId(),flags,inc,bif,ret,enable);
        }
    }

    public String getLogicFileString() {
        return logic.getText();
    }
}
