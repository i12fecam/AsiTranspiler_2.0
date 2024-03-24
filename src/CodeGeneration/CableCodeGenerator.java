package CodeGeneration;

import Analisis.LogicException;
import Analisis.SymbolTable;
import Parsing.SicomeParser;
import internals.Cableado.ControlAction;
import internals.Cableado.ControlEnum;
import internals.FlagStatus;
import internals.MicroInstruction;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.List;

public class CableCodeGenerator extends BasicCodeGenenator {

    CableLogicHelper logic;

    CableRepositoryHelper repository;


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
        //Añade todos los controlFlow

        for(SicomeParser.CableFlowControlContext cf: ctx.cableFlowControl()) {
            String type = cf.type.getText();
            if (type.equals("LOAD_SC")) {
                Integer value = Integer.decode(cf.value.getText());
                logic.addControlActionUse(new ControlAction(ControlEnum.LOAD_SC, value),
                        id_func,
                        id_step,
                        null);
            } else if (type.equals("LOAD_SR")) {
                Integer value = null;
                if (cf.value.getText().equals("START")) {
                    value = Integer.decode(cf.value.getText());
                }
                logic.addControlActionUse(new ControlAction(ControlEnum.LOAD_SR, value),
                        id_func,
                        id_step,
                        null);
            } else {
                logic.addControlActionUse(new ControlAction(ControlEnum.valueOfInput(cf.type.getText()), null),//TODO reformular esto
                        id_func,
                        id_step,
                        null);
            }
        }
    }

    @Override
    public void exitConditionalCableStep(SicomeParser.ConditionalCableStepContext ctx) {
        int id_func = _ids.get(ctx.getParent().getParent());
        int id_step = _ids.get(ctx.getParent());


        //Procesar las flags
        List<FlagStatus> flags = new ArrayList<>();
        for( Token flag: ctx.flags){
            FlagStatus newFlag = FlagStatus.ValueOfInput(flag.getText());
            if(newFlag == null) throw new LogicException("Bandera no reconocida",flag);
            flags.add(newFlag);

        }


        for (Token mInstr : ctx.instr) {
            MicroInstruction mi = MicroInstruction.valueOfInput(mInstr.getText());
            if(mi== null) throw new LogicException("Microinstrucción no reconocidad",mInstr);
            logic.addMicroInstructionUse(mi, id_func, id_step, flags);

        }

        for(SicomeParser.CableFlowControlContext cf: ctx.cableFlowControl()){
            String type =cf.type.getText();
            if(type.equals("LOAD_SC")){
                Integer value = Integer.decode(cf.value.getText());
                logic.addControlActionUse(new ControlAction(ControlEnum.LOAD_SC,value),
                        id_func,
                        id_step,
                        flags);
            } else if (type.equals("LOAD_SR")) {
                Integer value=null;
                if(cf.value.getText().equals("START")){
                    value = Integer.decode(cf.value.getText());
                }
                logic.addControlActionUse(new ControlAction(ControlEnum.LOAD_SR,value),
                        id_func,
                        id_step,
                        flags);
            } else {
                logic.addControlActionUse(new ControlAction(ControlEnum.valueOf(cf.type.getText()),null),
                        id_func,
                        id_step,
                        flags);
            }

        }
    }
}
