package CodeGeneration;

import Analisis.LogicException;
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

public class BasicCodeGenenator extends SicomeBaseListener {
    ParseTreeProperty<Integer> _ids = null;
    SymbolTable _symbols = null;
     public BasicCodeGenenator(ParseTreeProperty<Integer> ids, SymbolTable st){
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
        FunctionArg ExpectedArg =_symbols.getArgument(instrName.getText());
        if(ExpectedArg == null){
            throw new LogicException("La Instrucción no está definida",instrName);
        }

        Integer paramNumber =null;

        switch (ExpectedArg){
            case Value -> {
                if(arg.num!=null) {      //raw number
                    paramNumber = Integer.decode(arg.num.getText());
                }
                else{
                    throw new LogicException("Argumento de tipo valor no encontrado",instrName);
                }
            }
            case Var -> {

                if(arg.var!=null && arg.offset!=null){    //vectorVariable
                    paramNumber = _symbols.getPosFromVariable(arg.var.getText(),Integer.decode(arg.offset.getText()));
                }else if(arg.var!=null && _symbols.isVariable(arg.var.getText())) { //simpleVariable
                    paramNumber = _symbols.getPosFromVariable(instrName.getText(), 0);
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
