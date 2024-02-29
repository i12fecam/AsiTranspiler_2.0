package Analisis;

import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Anotates the tree in functions and steps with their number
 * Register in the Symbol Table Marks ,Variables and Function definitions
 */
public class FirstPassListener extends SicomeBaseListener {

    SymbolTable symbolTable = new SymbolTable();
    ParseTreeProperty<Integer> ids = new ParseTreeProperty<Integer>();


    /**
     * Anotates the tree with the ids of the steps and the id of the function
     * Also adds to the symbol table the function definition
     * @param ctx the parse tree
     */
    @Override
    public void enterCableInstruction(SicomeParser.CableInstructionContext ctx) {
        String functionName =ctx.IDENTIFIER().getText();
        String args = null;
        if(ctx.arg== null){
            args = "";
        }
        else{
            args =ctx.arg.getText();
        }
        List<SicomeParser.CableStepContext> steps =ctx.cableStep();
        int instr_id = symbolTable.addFunction(functionName,args,steps.size());

        ids.put(ctx,instr_id);
        int step_id = 0 ;
        for(SicomeParser.CableStepContext step : steps){
            ids.put(step,step_id);
            step_id++;
        }
    }

    /**
     * Adds to the symbol table the variable definition
     * @param ctx the parse tree
     */
    @Override
    public void exitSimpleVariableDeclaration(SicomeParser.SimpleVariableDeclarationContext ctx) {
        String id =ctx.id.getText();
        int value =Integer.decode(ctx.value.getText());
        //TODO comprobar maximo de tamaño
        symbolTable.addSimpleVariable(id,value);
    }
    /**
     * Adds the variable definition to the symbol table
     * @param ctx the parse tree
     */
    @Override
    public void exitVectorVariableDeclaration(SicomeParser.VectorVariableDeclarationContext ctx) {

        String id = ctx.id.getText();
        int size = Integer.decode(ctx.size.getText());
        List<Integer> values= new ArrayList<Integer>();
        ctx.value.forEach(token -> {
            values.add(Integer.decode(token.getText()));
        });

        if(size<=1){
            throw new RuntimeException("Vector size incorrect");
        }else if(values.size()==1){
            symbolTable.addVectorVariable(id,size,values.get(0));
        }else if(size==values.size()){
            symbolTable.addVectorVariable(id,size,values);
        }else{
            throw new RuntimeException("Vector initializer not valid");
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
        symbolTable.addLabel(ctx.label.getText(),ProgramLine);
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
