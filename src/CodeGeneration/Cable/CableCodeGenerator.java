package CodeGeneration.Cable;

import Analisis.LogicException;
import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Internals.MicroInstruction;
import Internals.SymbolTable;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import Internals.FlagState;
import Internals.MicroInstructionEnum;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.List;

import static Analisis.HelperFunctions.parseNumber;
import static Internals.MicroInstructionEnum.load_sr;
import static Internals.MicroInstructionEnum.sr_plus_to_sr;

public class CableCodeGenerator extends SicomeBaseListener {

    protected CableLogicHelper logic;

    protected CableRepositoryHelper repository;

    protected ParseTreeProperty<Integer> _ids = null;

    public CableCodeGenerator(ParseTreeProperty<Integer> ids, SymbolTable st) {
        _ids = ids;
        logic = new CableLogicHelper();
        repository = new CableRepositoryHelper(st);
    }

    public String getLogicFileString(){
        return logic.getText();
    }

    public String getRepositoryFileString(){
        return repository.getText();
    }

    //To build the repository and logic
    @Override
    public void exitSimpleCableStep(SicomeParser.SimpleCableStepContext ctx) {
        int id_func = _ids.get(ctx.getParent());
        int id_step = _ids.get(ctx);
        //TODO gestionar cuando se le pasa argumento cuando no se debe
        //Process left instruction
        var lmInstrEnum = MicroInstructionEnum.valueOfInput(ctx.linstr.MICRO_INSTR().getText());
        switch (lmInstrEnum){
            case sr_plus_to_sr -> {
                logic.addMicroInstructionUse(new MicroInstruction(lmInstrEnum,null), id_func, id_step,  null);
            }
            case load_sr -> {
                //TODO gestionar que el valor no sea superior a un limite definido
                Integer argValue = null;
                if (ctx.linstr.arg != null && ctx.linstr.arg.getText().equals( "START")){
                   argValue = null;
                }else if(ctx.linstr.arg != null){
                    argValue = parseNumber(ctx.linstr.arg.getText(),null);
                }
                logic.addMicroInstructionUse(new MicroInstruction(lmInstrEnum,argValue), id_func, id_step,  null);
            }
            case null -> ErrorController.getInstance().addNewError(ErrorEnum.MICROINSTRUCCION_NO_RECONOCIDA,List.of(ctx.linstr.MICRO_INSTR().getText()),ctx.linstr.MICRO_INSTR().getSymbol());

            default ->
                    ErrorController.getInstance().addNewError(ErrorEnum.MICROINSTRUCCION_INVALIDA,List.of("Entre brackets solo está permitido las instrucciones"+ load_sr.inputName + " y "+ sr_plus_to_sr.inputName),ctx.linstr.MICRO_INSTR().getSymbol());

        }


        //Process right instruction
        for (var mInstr: ctx.rinstr) {
            var rmIntrEnum = MicroInstructionEnum.valueOfInput(mInstr.MICRO_INSTR().getText());
            switch (rmIntrEnum){
                case sr_plus_to_sr,load_sr -> ErrorController.getInstance().addNewError(ErrorEnum.MICROINSTRUCCION_INVALIDA,List.of("Fuera de brackets no está permitido las instrucciones"+ load_sr.inputName + " y "+ sr_plus_to_sr.inputName),ctx.linstr.MICRO_INSTR().getSymbol());
                case null -> ErrorController.getInstance().addNewError(ErrorEnum.MICROINSTRUCCION_NO_RECONOCIDA,List.of(ctx.linstr.MICRO_INSTR().getText()),ctx.linstr.MICRO_INSTR().getSymbol());
                default -> {
                    Integer argValue = null;
                    if (mInstr.arg != null){
                        argValue = parseNumber(mInstr.arg.getText(),null);
                    }
                    logic.addMicroInstructionUse(new MicroInstruction(rmIntrEnum,argValue), id_func, id_step,  null);
                }
            }


        }
    }

    @Override
    public void exitConditionalCableStep(SicomeParser.ConditionalCableStepContext ctx) {
        int id_func = _ids.get(ctx.getParent().getParent());
        int id_step = _ids.get(ctx.getParent());


        //Process flags
        List<FlagState> flags = new ArrayList<>();
        for( Token flag: ctx.flags){
            FlagState newFlag = FlagState.ValueOfInput(flag.getText());
            if(newFlag == null){
                ErrorController.getInstance().addNewError(ErrorEnum.BANDERA_NO_RECONOCIDA,List.of(flag.getText()),flag);
            }
            flags.add(newFlag);

        }
        //Process left instruction
        var lmInstrEnum = MicroInstructionEnum.valueOfInput(ctx.linstr.MICRO_INSTR().getText());
        switch (lmInstrEnum){
            case sr_plus_to_sr -> {
                logic.addMicroInstructionUse(new MicroInstruction(lmInstrEnum,null), id_func, id_step,  flags);
            }
            case load_sr -> {
                //TODO gestionar que el valor no sea superior a un limite definido
                Integer argValue = null;
                if (ctx.linstr.arg != null && ctx.linstr.arg.getText().equals( "START")) {
                    argValue = null;
                }else if(ctx.linstr.arg != null ){
                    argValue = parseNumber(ctx.linstr.arg.getText(),null);
                }
                logic.addMicroInstructionUse(new MicroInstruction(lmInstrEnum,argValue), id_func, id_step,  flags);
            }
            case null -> throw new RuntimeException("Instrucción no reconocida");
            default -> throw new RuntimeException("Instrucción invalida entre brackets");

        }


        //Process right instruction
        for ( var mInstr: ctx.rinstr) {
            var rmIntrEnum = MicroInstructionEnum.valueOfInput(mInstr.MICRO_INSTR().getText());
            switch (rmIntrEnum){
                case sr_plus_to_sr,load_sr ->  throw new RuntimeException("Instrucción invalida entre brackets");
                case null -> throw new RuntimeException("Instrucción no reconocida");
                default -> {
                    Integer argValue = null;
                    if(mInstr.arg != null){
                        argValue = parseNumber(mInstr.arg.getText(),null);
                    }
                    logic.addMicroInstructionUse(new MicroInstruction(rmIntrEnum,argValue), id_func, id_step,  flags);
                }
            }
        }

    }
}
