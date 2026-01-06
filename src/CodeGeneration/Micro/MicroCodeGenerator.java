package CodeGeneration.Micro;

import Analisis.LogicException;
import internals.MicroInstructionType;
import internals.SymbolTable;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;

import internals.MicroInstructionEnum;
import org.antlr.v4.runtime.tree.ParseTreeProperty;


import static Analisis.HelperFunctions.parseNumber;

public class MicroCodeGenerator extends SicomeBaseListener {

    private final SymbolTable symbols;
    private final ParseTreeProperty<Integer> ids;
    private final MicroRepositoryHelper repository;

    public MicroCodeGenerator(ParseTreeProperty<Integer> ids, SymbolTable st) {
        this.ids = ids;
        this.symbols = st;
        repository = new MicroRepositoryHelper(st);
    }

    @Override
    public void enterMicroStep(SicomeParser.MicroStepContext ctx) {
        int id_func = ids.get(ctx.getParent());
        int id_step = ids.get(ctx);

        //We associate the bifurcation logic
        var bifLogic = symbols.getBifurcationLogic(ctx.biflogic.getText());
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
