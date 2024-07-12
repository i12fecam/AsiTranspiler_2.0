package CodeGeneration.Cable;

import Analisis.LogicException;
import Analisis.SymbolTable;
import CodeGeneration.BasicCodeGenerator;
import Parsing.SicomeParser;
import internals.Cableado.ControlAction;
import internals.Cableado.ControlEnum;
import internals.FlagState;
import internals.MicroInstruction;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.List;

public class CableCodeGenerator extends BasicCodeGenerator {

    protected CableLogicHelper logic;

    protected CableRepositoryHelper repository;


    public CableCodeGenerator(ParseTreeProperty<Integer> ids, SymbolTable st) {
        super(ids, st);
        logic = new CableLogicHelper();
        repository = new CableRepositoryHelper(st);
    }
    @Override
    public String getLogicFileString(){
        return logic.getText();
    }
    @Override
    public String getRepositoryFileString(){
        return repository.getText();
    }

    //To build the repository and logic
    @Override
    public void exitSimpleCableStep(SicomeParser.SimpleCableStepContext ctx) {
        int id_func = _ids.get(ctx.getParent());
        int id_step = _ids.get(ctx);

        //Añadir todas las instruciones
        for ( Token mInstr: ctx.instr) {
            MicroInstruction mi = MicroInstruction.valueOfInput(mInstr.getText());
            if(mi== null) throw new LogicException("Microinstrucción no reconocida",mInstr);
            logic.addMicroInstructionUse(mi, id_func, id_step,  null);

        }

        //Se gestiona los control flow


        //Si no hay nada se asume que se quiere decir SR+1->SR
        if(ctx.cableFlowControl().size()==0){
            logic.addControlActionUse(new ControlAction(ControlEnum.SR_PLUS, null),
                    id_func,
                    id_step,
                    null);
            return;
        }

        boolean found_SR_Cable_Flow = false;

        for(SicomeParser.CableFlowControlContext cf: ctx.cableFlowControl()) {
            String type = cf.type.getText();
            String valueString = cf.value == null ? "" : cf.value.getText();
            Integer value = null;
            ControlEnum ce = ControlEnum.valueOfInput(type);

            switch (ce){
                case LOAD_SC -> {
                    value = Integer.decode(cf.value.getText());
                }
                case LOAD_SR -> {
                    if(found_SR_Cable_Flow) throw new LogicException("No puede haber dos controles de tipo SR en el mismo paso", cf.type);
                    found_SR_Cable_Flow = true;

                    if(valueString.equals("START")){
                        value = null;
                    } else value = Integer.decode(cf.value.getText());
                }

                case SR_PLUS, SC_MINUS -> {
                    if(found_SR_Cable_Flow) throw new LogicException("No puede haber dos controles de tipo SR en el mismo paso", cf.type);
                    found_SR_Cable_Flow = true;
                }

                default -> {
                    System.out.println("Error al leer la microinstrucción");
                }
            }

            logic.addControlActionUse(new ControlAction(ce, value),
                    id_func,
                    id_step,
                    null);


        }
    }

    @Override
    public void exitConditionalCableStep(SicomeParser.ConditionalCableStepContext ctx) {
        int id_func = _ids.get(ctx.getParent().getParent());
        int id_step = _ids.get(ctx.getParent());


        //Procesar las flags
        List<FlagState> flags = new ArrayList<>();
        for( Token flag: ctx.flags){
            FlagState newFlag = FlagState.ValueOfInput(flag.getText());
            if(newFlag == null) throw new LogicException("Bandera no reconocida",flag);
            flags.add(newFlag);

        }


        for (Token mInstr : ctx.instr) {
            MicroInstruction mi = MicroInstruction.valueOfInput(mInstr.getText());
            if(mi== null) throw new LogicException("Microinstrucción no reconocida",mInstr);
            logic.addMicroInstructionUse(mi, id_func, id_step, flags);

        }

        boolean found_SR_Cable_Flow = false;

        for(SicomeParser.CableFlowControlContext cf: ctx.cableFlowControl()) {
            String type = cf.type.getText();
            String valueString = cf.value == null ? "" : cf.value.getText();
            Integer value = null;
            ControlEnum ce = ControlEnum.valueOfInput(type);

            switch (ce){
                case LOAD_SC -> {
                    value = Integer.decode(cf.value.getText());
                }
                case LOAD_SR -> {
                    if(found_SR_Cable_Flow) throw new LogicException("No puede haber dos controles de tipo SR en el mismo paso", cf.type);
                    found_SR_Cable_Flow = true;

                    if(valueString.equals("START")){
                        value = null;
                    } else value = Integer.decode(cf.value.getText());
                }

                case SR_PLUS, SC_MINUS -> {
                    if(found_SR_Cable_Flow) throw new LogicException("No puede haber dos controles de tipo SR en el mismo paso", cf.type);
                    found_SR_Cable_Flow = true;
                }

                default -> {
                    System.out.println("Error al leer la microinstrucción");
                }
            }

            logic.addControlActionUse(new ControlAction(ce, value),
                    id_func,
                    id_step,
                    flags);


        }
    }
}
