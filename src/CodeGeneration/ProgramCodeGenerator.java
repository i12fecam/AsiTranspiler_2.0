package CodeGeneration;

import Analisis.LogicException;
import internals.SymbolTable;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import internals.InstructionArgumentType;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import static Analisis.HelperFunctions.parseNumber;

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
        InstructionArgumentType expectedArg = symbols.getArgument(instrName.getText());
        if(expectedArg == null){
            throw new LogicException("La Instrucción no está definida",instrName);
        }

        Integer paramNumber =null;

        switch (expectedArg){
            case Value -> {
                if(arg.num!=null) {      //raw number
                    paramNumber = parseNumber(arg.num.getText(),null);
                }
                else{
                    throw new LogicException("Argumento de tipo valor no encontrado",instrName);
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
