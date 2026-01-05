package CodeGeneration.Cable;

import Analisis.LogicException;
import internals.MicroInstruction;
import internals.SymbolTable;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import internals.FlagState;
import internals.MicroInstructionEnum;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.List;

import static Analisis.HelperFunctions.parseNumber;

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
        var lmInstrEnum = MicroInstructionEnum.valueOfInput(ctx.linstr.getText());
        switch (lmInstrEnum){
            case sr_plus_to_sr -> {
                logic.addMicroInstructionUse(new MicroInstruction(lmInstrEnum,null), id_func, id_step,  null);
            }
            case load_sr -> {
                //TODO gestionar que el valor no sea superior a un limite definido
                var argValue = parseNumber(ctx.linstr.arg.getText(),null);
                logic.addMicroInstructionUse(new MicroInstruction(lmInstrEnum,argValue), id_func, id_step,  null);
            }
            case null -> throw new RuntimeException("Instrucción no reconocida");
            default -> //TODO manejar bien
                    throw new RuntimeException("Instrucción invalida entre brackets");

        }


        //Process right instruction
        for (var mInstr: ctx.rinstr) {
            var rmIntrEnum = MicroInstructionEnum.valueOfInput(mInstr.MICRO_INSTR().getText());
            switch (rmIntrEnum){
                case sr_plus_to_sr,load_sr ->  throw new RuntimeException("Instrucción invalida entre brackets");
                case null -> throw new RuntimeException("Instrucción no reconocida");
                default -> {
                    var argValue = parseNumber(mInstr.arg.getText(),null);
                    logic.addMicroInstructionUse(new MicroInstruction(lmInstrEnum,argValue), id_func, id_step,  null);
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
            if(newFlag == null) throw new LogicException("Bandera no reconocida",flag);
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
                var argValue = parseNumber(ctx.linstr.arg.getText(),null);
                logic.addMicroInstructionUse(new MicroInstruction(lmInstrEnum,argValue), id_func, id_step,  null);
            }
            case null -> throw new RuntimeException("Instrucción no reconocida");
            default -> throw new RuntimeException("Instrucción invalida entre brackets");

        }


        //Process right instruction
        for ( var mInstr: ctx.rinstr) {
            var rmIntrEnum = MicroInstructionEnum.valueOfInput(mInstr.getText());
            switch (rmIntrEnum){
                case sr_plus_to_sr,load_sr ->  throw new RuntimeException("Instrucción invalida entre brackets");
                case null -> throw new RuntimeException("Instrucción no reconocida");
                default -> {
                    var argValue = parseNumber(mInstr.arg.getText(),null);
                    logic.addMicroInstructionUse(new MicroInstruction(lmInstrEnum,argValue), id_func, id_step,  null);
                }
            }
        }

    }
}
