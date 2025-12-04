package CodeGeneration.Micro;

import Analisis.LogicException;
import Analisis.SymbolTable;
import CodeGeneration.ProgramCodeGenerator;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import internals.FlagState;
import internals.Micro.BifurcationLogic;
import internals.MicroInstruction;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;

import static Analisis.HelperFunctions.parseNumber;

public class MicroCodeGenerator extends SicomeBaseListener {

    private SymbolTable _symbols;
    private ParseTreeProperty<Integer> _ids;

    private MicroLogicHelper logic = new MicroLogicHelper();

    private MicroRepositoryHelper repository;

    public MicroCodeGenerator(ParseTreeProperty<Integer> ids, SymbolTable st) {
        this._ids = ids;
        this._symbols = st;
        repository = new MicroRepositoryHelper(st);
    }

    public String getLogicFileString(){
        return logic.getString();
    }

    public String getRepositoryFileString(){
        return repository.getText();
    }

    @Override
    public void enterSimpleStatusLogic(SicomeParser.SimpleStatusLogicContext ctx) {
        String name = ctx.name.getText();
        BifurcationLogic bifLogic = _symbols.getBifurcationLogic(name);
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
            BifurcationLogic bifLogic = _symbols.getBifurcationLogic(name);
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

    @Override
    public void enterMicroStep(SicomeParser.MicroStepContext ctx) {
        int id_func = _ids.get(ctx.getParent());
        int id_step = _ids.get(ctx);

        //Se asocian las micro instrucciones
        for(var mInstrToken:ctx.instr){
            MicroInstruction mi = MicroInstruction.valueOfInput(mInstrToken.getText());
            if(mi==null) throw new LogicException("Microinstruccion no reconocida",mInstrToken);
            repository.associateMicroInstruction(id_func,id_step,mi);
        }

        //Se asocian las instrucciones relacionadas con SC y la lógica de bifurcación
        boolean usedArg = false;//TODO por que hice esto
        for(var flowControl:ctx.flow){
           switch (flowControl.action.getText()){
               case "LOAD_SC":
                   usedArg=true;
                   repository.associateMicroInstruction(id_func,id_step,MicroInstruction.load_sc);
                   Integer sc_value = parseNumber(flowControl.value.getText(),null);
                   repository.associateSCvalue(id_func,id_step,sc_value);
                   break;
               case "SC-1->SC":
                   repository.associateMicroInstruction(id_func,id_step,MicroInstruction.sc_minus_to_sc);
                   break;
               default:
                   BifurcationLogic bifLogic =_symbols.getBifurcationLogic(flowControl.action.getText());
                   if(bifLogic == null) throw new LogicException("La lógica de bifurcación no ha sido definida anteriormente", flowControl.action);
                   if(bifLogic.needsArg() && flowControl.value==null ){
                       throw new LogicException("La logica de bifurcación necesita de un argumento", flowControl.action);
                   }
                   repository.associateControlFlow(id_func,id_step, bifLogic.getId());
                   if(flowControl.value!=null){
                       int value = parseNumber(flowControl.value.getText(),null);
                       repository.associateBifValue(id_func,id_step,value);
                   }

                   break;

           }
        }

    }
}
