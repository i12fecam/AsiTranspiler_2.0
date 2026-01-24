package CodeGeneration.Micro;

import Analysis.LogicException;
import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Internals.MicroInstructionTypeEnum;
import Internals.SymbolTable;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;

import Internals.MicroInstructionEnum;
import org.antlr.v4.runtime.tree.ParseTreeProperty;


import java.util.List;

import static Analysis.HelperFunctions.parseNumber;
import static Internals.Errors.ErrorEnum.*;

public class MicrocodeGenerator extends SicomeBaseListener {

    private final SymbolTable symbols;
    private final ParseTreeProperty<Integer> ids;
    private final MicroRepositoryHelper repository;

    public MicrocodeGenerator(ParseTreeProperty<Integer> ids, SymbolTable st) {
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
        if (bifLogic == null) ErrorController.getInstance().addNewError(LOGICA_BIFURCACION_NO_DEFINIDA, List.of(ctx.biflogic.getText()), ctx.biflogic);
        if (bifLogic.needsArg() && ctx.arg == null) ErrorController.getInstance()
                .addNewError(ARGUMENTO_USO_LOGICA_BIFURCACION_INVALIDO, List.of(ctx.biflogic.getText()), ctx.biflogic);
        repository.associateControlFlow(id_func,id_step, bifLogic.getId());
        if(ctx.arg != null){
            int value = parseNumber(ctx.arg.getText(),null);
            repository.associateBifValue(id_func,id_step,value);
        }

        //We associate the microInstructions
        for(var mInstr:ctx.instr ){
            MicroInstructionEnum mi = MicroInstructionEnum.valueOfInput(mInstr.MICRO_INSTR().getText());
            if(mi==null) ErrorController.getInstance()
                    .addNewError(MICROINSTRUCCION_NO_RECONOCIDA,List.of(mInstr.MICRO_INSTR().getText()),mInstr.MICRO_INSTR().getSymbol());
            assert mi != null;
            if(mi.getType() == MicroInstructionTypeEnum.cable) ErrorController.getInstance()
                    .addNewError(MICROINSTRUCCION_INVALIDA,List.of(mInstr.MICRO_INSTR().getText()),mInstr.MICRO_INSTR().getSymbol());
            repository.associateMicroInstruction(id_func,id_step,mi);
            if(mi.needsArgument && mInstr.arg == null) ErrorController.getInstance()
                    .addNewError(MICROINSTRUCCION_CON_ARGUMENTO_INVALIDO,List.of(mInstr.MICRO_INSTR().getText()),mInstr.MICRO_INSTR().getSymbol());
            if(!mi.needsArgument && mInstr.arg != null) ErrorController.getInstance()
                    .addNewError(MICROINSTRUCCION_CON_ARGUMENTO_INNECESARIO,List.of(mInstr.MICRO_INSTR().getText()),mInstr.MICRO_INSTR().getSymbol());

            if(mi.needsArgument){
                var argNumber = parseNumber(mInstr.arg.getText(),null);
                repository.associateSCvalue(id_func,id_step,argNumber);
            }
        }



    }

    public String getRepositoryFileString() {
        return repository.getText();
    }
}
