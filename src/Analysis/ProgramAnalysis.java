package Analysis;

import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Internals.Errors.EspecificationException;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import Internals.SymbolTable;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.util.ArrayList;
import java.util.List;

import static Analysis.HelperFunctions.parseNumber;

/**
 * Anotates the tree in functions and steps with their number
 * Register in the Symbol Table Marks ,Variables and Function definitions
 */
public class ProgramAnalysis extends SicomeBaseListener {

    public SymbolTable symbolTable = new SymbolTable();
    public ParseTreeProperty<Integer> ids = new ParseTreeProperty<>();

    public ProgramAnalysis(SymbolTable symbolTable, ParseTreeProperty<Integer> ids){
        this.symbolTable = symbolTable;
        this.ids = ids;
    }


    /**
     * Adds to the symbol table the variable definition
     * @param ctx the parse tree
     */
    @Override
    public void exitSimpleVariableDeclaration(SicomeParser.SimpleVariableDeclarationContext ctx) {
        String id =ctx.id.getText();

        int value = parseNumber(ctx.value.getText(),null);
        //TODO comprobar maximo de tamaño
        try {
            symbolTable.addSimpleVariable(id, value);
        } catch (EspecificationException e){
            ErrorController.getInstance().addNewError(ErrorEnum.VARIABLE_MISMO_NOMBRE,List.of(ctx.id.getText()),ctx.id);
        }
    }
    /**
     * Adds the variable definition to the symbol table
     * @param ctx the parse tree
     */
    @Override
    public void exitVectorVariableDeclaration(SicomeParser.VectorVariableDeclarationContext ctx) {

        String id = ctx.id.getText();
        int size = parseNumber(ctx.size.getText(),null);
        List<Integer> values= new ArrayList<>();
        ctx.value.forEach(token -> {
            values.add(parseNumber(token.getText(),null));
        });

        try {
            if (size <= 1) {
                ErrorController.getInstance().addNewError(ErrorEnum.TAMANYO_VECTOR_INVALIDO,List.of(ctx.size + "< 2"),ctx.size);
            } else if (values.size() == 1) {
                symbolTable.addVectorVariable(id, size, values.get(0));
            } else if (size == values.size()) {
                symbolTable.addVectorVariable(id, size, values);
            } else {
                ErrorController.getInstance().addNewError(ErrorEnum.INICIALIZACION_VECTOR_INVALIDA,null,ctx.size);
            }
        }catch (EspecificationException e){
            ErrorController.getInstance().addNewError(ErrorEnum.VARIABLE_MISMO_NOMBRE,List.of(id), ctx.id);
        }
    }

    int ProgramLine = 0;

    /**
     * Increments the program line to count the current line being processed
     * @param ctx the parse tree
     */
    @Override
    public void exitInstructionUse(SicomeParser.InstructionUseContext ctx) {
        ProgramLine++;
    }

    /**
     * Adds to the symbol table the label defintion
     * @param ctx the parse tree
     */
    @Override
    public void exitMarkUse(SicomeParser.MarkUseContext ctx) {
        try {
            symbolTable.addLabel(ctx.label.getText(), ProgramLine);
        } catch (EspecificationException e ){
            ErrorController.getInstance().addNewError(ErrorEnum.ETIQUETA_MISMO_NOMBRE,List.of(ctx.label.getText()), ctx.label);
        }
    }


}
