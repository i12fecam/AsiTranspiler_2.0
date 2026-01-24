package CodeGeneration;

import Analysis.LogicException;
import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Internals.Instruction;
import Internals.SymbolTable;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import Internals.InstructionArgumentTypeEnum;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.List;

import static Analysis.HelperFunctions.parseNumber;

public class ProgramCodeGenerator extends SicomeBaseListener {
    protected ParseTreeProperty<Integer> ids = null;
    protected SymbolTable symbols = null;
     public ProgramCodeGenerator(ParseTreeProperty<Integer> ids, SymbolTable st){
        this.ids = ids;
        symbols = st;
        program = new ProgramCodeGeneratorHelper(symbols);
    }



     ProgramCodeGeneratorHelper program;



    public String getProgramFileString() {return program.getText();}



    @Override
    public void exitInstructionUse(SicomeParser.InstructionUseContext ctx) {
        Token instrName =ctx.name;
        SicomeParser.InstructionUseArgumentContext arg =ctx.instructionUseArgument();
        InstructionArgumentTypeEnum expectedArg = symbols.getArgumentType(instrName.getText());
        if(expectedArg == null){
            ErrorController.getInstance()
                    .addNewError(ErrorEnum.INSTRUCCION_NO_DEFINIDA, List.of(instrName),ctx.name);
        }

        Integer paramNumber =null;

        switch (expectedArg){
            case Value -> {
                if(arg.num!=null) {      //raw number
                    paramNumber = parseNumber(arg.num.getText(),null);
                }
                else{
                    ErrorController.getInstance()
                            .addNewError(ErrorEnum.ARGUMENTO_DE_TIPO_VALOR_NO_ENCONTRADO, List.of(instrName, "\" \""),ctx.name);
                }
            }
            case Var -> {

                if(arg.var!=null && arg.offset!=null){    //vectorVariable
                    try {
                        paramNumber = symbols.getPosFromVariable(arg.var.getText(), parseNumber(arg.offset.getText(),null));
                    }catch (RuntimeException e){
                        throw new LogicException(e.getMessage(),instrName);
                    }
                }else if(arg.var!=null && symbols.isVariable(arg.var.getText())) { //simpleVariable
                    try{
                        paramNumber = symbols.getPosFromVariable(arg.var.getText(), 0);
                    }catch (RuntimeException e){
                        throw new LogicException(e.getMessage(),instrName);
                    }

                }else {
                    throw new LogicException("Argumento de tipo variable no encontrado",instrName);
                }
            }
            case Dir -> {
                if (arg.var != null && symbols.isLabel(arg.var.getText())) { //jump label
                    paramNumber = symbols.getPosFromLabel(arg.var.getText());
                } else {
                    throw new LogicException("Argumento de tipo dirección no encontrado",instrName);
                }
            }


            case None -> {
                if(arg.var!= null || arg.num!= null || arg.offset!=null){
                    throw new LogicException("Se ha encontrado argumento cuando no debería haber",instrName);
                }
            }
        }
        program.addInstructionUse(instrName.getText(),paramNumber);
    }
}
