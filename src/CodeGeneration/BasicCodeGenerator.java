package CodeGeneration;

import Analisis.LogicException;
import Analisis.SymbolTable;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import internals.FunctionArg;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import static Analisis.HelperFunctions.parseNumber;

public class BasicCodeGenerator extends SicomeBaseListener {
    protected ParseTreeProperty<Integer> _ids = null;
    protected SymbolTable _symbols = null;
     public BasicCodeGenerator(ParseTreeProperty<Integer> ids, SymbolTable st){
        _ids = ids;
        _symbols = st;
        program = new ProgramGenerator(_symbols);
    }



     ProgramGenerator program;

    public String getLogicFileString(){
        return "";
    }

    public String getRepositoryFileString(){
        return "";
    }

    public String getProgramFileString() {return program.getText();}



    @Override
    public void exitInstructionUse(SicomeParser.InstructionUseContext ctx) {
        Token instrName =ctx.name;
        SicomeParser.InstructionUseArgumentContext arg =ctx.instructionUseArgument();
        FunctionArg expectedArg =_symbols.getArgument(instrName.getText());
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
                        paramNumber = _symbols.getPosFromVariable(arg.var.getText(), parseNumber(arg.offset.getText(),null));
                    }catch (RuntimeException e){
                        throw new LogicException(e.getMessage(),instrName);
                    }
                }else if(arg.var!=null && _symbols.isVariable(arg.var.getText())) { //simpleVariable
                    try{
                        paramNumber = _symbols.getPosFromVariable(arg.var.getText(), 0);
                    }catch (RuntimeException e){
                        throw new LogicException(e.getMessage(),instrName);
                    }

                }else {
                    throw new LogicException("Argumento de tipo variable no encontrado",instrName);
                }
            }
            case Dir -> {
                if (arg.var != null && _symbols.isLabel(arg.var.getText())) { //jump label
                    paramNumber = _symbols.getPosFromLabel(arg.var.getText());
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
