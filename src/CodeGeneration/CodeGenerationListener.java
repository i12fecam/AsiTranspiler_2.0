package CodeGeneration;

import Analisis.SymbolTable;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import internals.Cableado.ControlAction;
import internals.Cableado.ControlEnum;
import internals.FlagStatus;
import internals.MicroInstruction;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerationListener extends SicomeBaseListener {
    ParseTreeProperty<Integer> _ids = null;
    SymbolTable _symbols = null;
     public CodeGenerationListener(ParseTreeProperty<Integer> ids, SymbolTable st){
        _ids = ids;
        _symbols = st;
        logic = new LogicFileGenerator();
        repository = new RepositoryFileGenerator(_symbols);
    }

    LogicFileGenerator logic;

     RepositoryFileGenerator repository;

    public String getLogicFileString(){
        return logic.getLogicText();
    }

    public String getRepositoryFileString(){
        return repository.getTextRepository();
    }


    @Override
    public void exitSimpleCableStep(SicomeParser.SimpleCableStepContext ctx) {
        int id_func = _ids.get(ctx.getParent());
        int id_step = _ids.get(ctx);

        //Añadir todas las instruciones
        for (TerminalNode mInstr : ctx.MICRO_INSTR()) {
            MicroInstruction mi = MicroInstruction.valueOfInput(mInstr.getText());
            if(mi== null) throw new RuntimeException("Microinstruction not recognized");//TODO mejorar este error
            logic.addMicroInstructionUse(mi, id_func, id_step,  null);

        }
        //Añade todos los controlFlow
        for(SicomeParser.CableFlowControlContext cf: ctx.cableFlowControl()){
                if(cf instanceof SicomeParser.LoadSC_FlowControlContext){
                    Integer num =Integer.parseInt(((SicomeParser.LoadSC_FlowControlContext) cf).NUMBER().getText());
                    logic.addControlActionUse(new ControlAction(ControlEnum.LOAD_SC,num),
                                                id_func,
                                                id_step,
                                                null);
                } else if (cf instanceof SicomeParser.LoadSR_CableFlowControlContext) {
                    Integer num = Integer.parseInt(((SicomeParser.LoadSR_CableFlowControlContext) cf).NUMBER().getText());
                    logic.addControlActionUse(new ControlAction(ControlEnum.LOAD_SR,num),
                            id_func,
                            id_step,
                             null);

                } else if (cf instanceof SicomeParser.SRPlus_CableFlowControlContext) {
                    logic.addControlActionUse(new ControlAction(ControlEnum.SR_PLUS,null),
                            id_func,
                            id_step,
                            null);

                } else if (cf instanceof SicomeParser.SCMinus_CableFlowControlContext) {
                    logic.addControlActionUse(new ControlAction(ControlEnum.SC_MINUS,null),
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
        for(TerminalNode flag: ctx.FLAG()){
            FlagStatus newFlag = FlagStatus.ValueOfInput(flag.getText());
            if(newFlag == null) throw new RuntimeException("Flag not recognized"); //TODO reformular error
            flags.add(newFlag);

        }


        for (TerminalNode mInstr : ctx.MICRO_INSTR()) {
            MicroInstruction mi = MicroInstruction.valueOfInput(mInstr.getText());
            if(mi == null) throw new RuntimeException("MicroInstruction not recognized");//TODO reformular
            logic.addMicroInstructionUse(mi, id_func, id_step, flags);

        }

        for(SicomeParser.CableFlowControlContext cf: ctx.cableFlowControl()){
            if(cf instanceof SicomeParser.LoadSC_FlowControlContext){
                Integer num =Integer.parseInt(((SicomeParser.LoadSC_FlowControlContext) cf).NUMBER().getText());
                logic.addControlActionUse(new ControlAction(ControlEnum.LOAD_SC,num),
                        id_func,
                        id_step,
                        flags);
            } else if (cf instanceof SicomeParser.LoadSR_CableFlowControlContext) {
                Integer num = Integer.parseInt(((SicomeParser.LoadSR_CableFlowControlContext) cf).NUMBER().getText());
                logic.addControlActionUse(new ControlAction(ControlEnum.LOAD_SR,num),
                        id_func,
                        id_step,
                        flags);

            } else if (cf instanceof SicomeParser.SRPlus_CableFlowControlContext) {
                logic.addControlActionUse(new ControlAction(ControlEnum.SR_PLUS,null),
                        id_func,
                        id_step,
                        flags);

            } else if (cf instanceof SicomeParser.SCMinus_CableFlowControlContext) {
                logic.addControlActionUse(new ControlAction(ControlEnum.SC_MINUS,null),
                        id_func,
                        id_step,
                        flags);
            }
        }
    }
}
