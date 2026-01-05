package CodeGeneration.Micro;

import Analisis.LogicException;
import internals.MicroInstructionType;
import internals.SymbolTable;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import internals.FlagState;
import internals.Micro.BifurcationLogic;
import internals.MicroInstructionEnum;
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

        //We associate the bifurcation logic
        var bifLogic = _symbols.getBifurcationLogic(ctx.biflogic.getText());
        if (bifLogic == null) throw new RuntimeException("La lógica de bifurcación no estaba definida anteriormente");
        if (bifLogic.needsArg() && ctx.arg == null) throw new RuntimeException("la logica de bifurcación necesita de un argumento");
        repository.associateControlFlow(id_func,id_step, bifLogic.getId());
        if(ctx.arg != null){
            int value = parseNumber(ctx.arg.getText(),null);
            repository.associateBifValue(id_func,id_step,value);
        }

        //We associate the microInstructions
        for(var mInstr:ctx.instr ){
            MicroInstructionEnum mi = MicroInstructionEnum.valueOfInput(mInstr.MICRO_INSTR().getText());
            if(mi==null) throw new LogicException("Microinstruccion no reconocida",mInstr.MICRO_INSTR().getSymbol());
            if(mi.getType() == MicroInstructionType.cable) throw new RuntimeException("Instrucción solo se puede utlizar en modo cambleado");
            repository.associateMicroInstruction(id_func,id_step,mi);
            if(mi.needsArgument && mInstr.arg == null) throw new RuntimeException("La instrucción necesita de argumento");
            if(!mi.needsArgument && mInstr.arg != null) throw new RuntimeException("La instrucción no necesita de argumento");

            if(mi.needsArgument){
                var argNumber = parseNumber(mInstr.arg.getText(),null);
                repository.associateSCvalue(id_func,id_step,argNumber);
            }
        }



    }
}
