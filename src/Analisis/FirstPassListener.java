package Analisis;

import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Anotates the tree in functions and steps with their number
 * Register in the Symbol Table Marks and FUnction definitions
 */
public class FirstPassListener extends SicomeBaseListener {

    SymbolTable symbolTable = new SymbolTable();
    ParseTreeProperty<Integer> ids = new ParseTreeProperty<Integer>();




    @Override
    public void enterCableInstruction(SicomeParser.CableInstructionContext ctx) {
        String functionName =ctx.IDENTIFIER().getText();
        String args = null;
        if(ctx.instructionArgument() == null){
            args = "";
        }
        else{
            args =ctx.instructionArgument().getText();
        }
        int instr_id = symbolTable.addFunction(functionName,args);//TODO Posible mejor forma de lanzar errores

        ids.put(ctx,instr_id);
        List<SicomeParser.CableStepContext> steps =ctx.cableStep();
        int step_id = 0 ;
        for(SicomeParser.CableStepContext step : steps){
            ids.put(step,step_id);
            step_id++;
            symbolTable.addStepToFunction(instr_id,1);
        }
    }

    @Override
    public void exitSimpleVariableDeclaration(SicomeParser.SimpleVariableDeclarationContext ctx) {
        String id =ctx.id.getText();
        int value =Integer.decode(ctx.value.getText());
        //TODO comprobar maximo de tamaño
        symbolTable.addSimpleVariable(id,value);
    }

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
    @Override
    public void exitInstructionUse(SicomeParser.InstructionUseContext ctx) {
        ProgramLine++;
    }

    @Override
    public void exitMarkUse(SicomeParser.MarkUseContext ctx) {
        symbolTable.addLabel(ctx.label.getText(),ProgramLine);
    }

    public ParseTreeProperty<Integer> getIds(){
        return ids;
    }

    public SymbolTable getSymbolTable(){
        return symbolTable;
    }
}
