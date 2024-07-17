package Analisis;

import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.util.ArrayList;
import java.util.List;

import static Analisis.HelperFunctions.parseNumber;

/**
 * Anotates the tree in functions and steps with their number
 * Register in the Symbol Table Marks ,Variables and Function definitions
 */
public class BasicAnalisis extends SicomeBaseListener {

    SymbolTable symbolTable = new SymbolTable();
    ParseTreeProperty<Integer> ids = new ParseTreeProperty<>();




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
        }catch (RuntimeException e){
            throw new LogicException(e.getMessage(),ctx.id);
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
        List<Integer> values= new ArrayList<Integer>();
        ctx.value.forEach(token -> {
            values.add(parseNumber(ctx.size.getText(),null));
        });

        try {
            if (size <= 1) {
                throw new LogicException("El tamaño del vector no puede ser menor que 2",ctx.size );
            } else if (values.size() == 1) {
                symbolTable.addVectorVariable(id, size, values.get(0));
            } else if (size == values.size()) {
                symbolTable.addVectorVariable(id, size, values);
            } else {
                throw new LogicException("El numero de valores inicializados no coinciden con el tamaño del vector",ctx.size);
            }
        }catch (RuntimeException e){
            throw new LogicException(e.getMessage(),ctx.id);
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
        }catch (RuntimeException e ){
            throw new LogicException(e.getMessage(),ctx.label);
        }
    }

    /**
     * Returns the ids the tree is annotated with
     * @return the ids
     */
    public ParseTreeProperty<Integer> getIds(){
        return ids;
    }

    /**
     * Returns the completed symbolTable
     * @return the completed symbolTable
     */
    public SymbolTable getSymbolTable(){
        return symbolTable;
    }
}
