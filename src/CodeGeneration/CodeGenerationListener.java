package CodeGeneration;

import Analisis.SymbolTable;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import internals.Cableado.ControlAction;
import internals.Cableado.ControlEnum;
import internals.FlagStatus;
import internals.FunctionArg;
import internals.MicroInstruction;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

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
        program = new ProgramGenerator(_symbols);
    }

    LogicFileGenerator logic;

     RepositoryFileGenerator repository;

     ProgramGenerator program;

    public String getLogicFileString(){
        return logic.getText();
    }

    public String getRepositoryFileString(){
        return repository.getText();
    }

    public String getProgramFileString() {return program.getText();}

    //To build the repository and logic
    @Override
    public void exitSimpleCableStep(SicomeParser.SimpleCableStepContext ctx) {
        int id_func = _ids.get(ctx.getParent());
        int id_step = _ids.get(ctx);

        //Añadir todas las instruciones
        for ( SicomeParser.Micro_instrContext mInstr: ctx.micro_instr()) {
            MicroInstruction mi = MicroInstruction.valueOfInput(mInstr.getText());
            if(mi== null) throw new RuntimeException("Microinstruction not recognized");//TODO mejorar este error
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
                logic.addControlActionUse(new ControlAction(ControlEnum.valueOfInput(cf.type.getText()), null),
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
        for( SicomeParser.FlagContext flag: ctx.flag()){
            FlagStatus newFlag = FlagStatus.ValueOfInput(flag.getText());
            if(newFlag == null) throw new RuntimeException("Flag not recognized"); //TODO reformular error
            flags.add(newFlag);

        }


        for (SicomeParser.Micro_instrContext mInstr : ctx.micro_instr()) {
            MicroInstruction mi = MicroInstruction.valueOfInput(mInstr.getText());
            if(mi == null) throw new RuntimeException("MicroInstruction not recognized");//TODO reformular
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

    //To build the program


    @Override
    public void exitInstructionUse(SicomeParser.InstructionUseContext ctx) {
        Token instrName =ctx.name;
        SicomeParser.InstructionUseArgumentContext arg =ctx.instructionUseArgument();
        FunctionArg ExpectedArg =_symbols.getArgument(instrName.getText());
        if(ExpectedArg == null){
            throw new RuntimeException("La Instrucción no está definida");
        }

        Integer paramNumber =null;

        switch (ExpectedArg){
            case Value -> {
                if(arg.num!=null){      //raw number
                    paramNumber = Integer.decode(arg.num.getText());
                }else if(arg.var!=null && arg.offset!=null){    //vectorVariable
                    paramNumber = _symbols.getPosFromVariable(arg.var.getText(),Integer.decode(arg.offset.getText()));
                }else if(arg.var!=null && _symbols.isVariable(arg.var.getText())) { //simpleVariable
                    paramNumber = _symbols.getPosFromVariable(instrName.getText(), 0);
                }else {
                    throw new RuntimeException("Expected argument of type value not found");
                }
            }

            case Dir -> {
                if (arg.var != null && _symbols.isLabel(arg.var.getText())) { //jump label
                    paramNumber = _symbols.getPosFromLabel(arg.var.getText());
                } else {
                    throw new RuntimeException("Expected argument of type dir not found");
                }
            }


            case None -> {
                if(arg.var!= null || arg.num!= null || arg.offset!=null){
                    throw new RuntimeException("Expected not argument and found argument");
                }
            }
        }
        program.addInstructionUse(instrName.getText(),paramNumber);
    }
}
