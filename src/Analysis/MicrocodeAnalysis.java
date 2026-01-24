package Analysis;

import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import Internals.SymbolTable;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.List;

public class MicrocodeAnalysis extends SicomeBaseListener {
    public ParseTreeProperty<Integer> ids = new ParseTreeProperty<>();
    public SymbolTable symbolTable = new SymbolTable();


    public MicrocodeAnalysis(ParseTreeProperty<Integer> ids, SymbolTable symbolTable) {
        this.ids = ids;
        this.symbolTable = symbolTable;
    }

    @Override
    public void enterMicroInstructionBlock(SicomeParser.MicroInstructionBlockContext ctx) {
        symbolTable.addInstruction("halt","",0);
    }

    @Override
    public void enterMicroInstruction(SicomeParser.MicroInstructionContext ctx) {
        Token identifier = ctx.IDENTIFIER().getSymbol();
        Token arg = ctx.arg;
        String argString = "";
        if(arg!= null)  argString =ctx.arg.getText();
        int size = ctx.microStep().size();


        int instrId = -1;
        try {
            instrId = symbolTable.addInstruction(identifier.getText(), argString, size);
        }catch (RuntimeException e){
            ErrorController.getInstance().addNewError(ErrorEnum.INSTRUCCION_MISMO_NOMBRE, List.of(ctx.IDENTIFIER().getText()), ctx.IDENTIFIER().getSymbol());

        }

        //Se anota en el arbol las IDs
        ids.put(ctx,instrId);
        int stepId = 0 ;
        for(var step:ctx.microStep()){
            ids.put(step,stepId);
            stepId++;
        }
    }

}
