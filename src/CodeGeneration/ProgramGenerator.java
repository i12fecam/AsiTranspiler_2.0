package CodeGeneration;

import Analisis.SymbolTable;
import internals.Variable;

public class ProgramGenerator {

    SymbolTable _symbols;

    StringBuilder InstructionBuilder= new StringBuilder();
    public ProgramGenerator(SymbolTable symbols){
        _symbols =symbols;
    }
    /*
    0 0
    1 1
    2 FFFF
    @
    3
    @
    LDA 0
    LDQ 2
    ADDAQ 0
    HALT
     */
    public String getText(){
        StringBuilder buider =new StringBuilder();
        for(Variable var : _symbols.getVariables()){
                Integer memDir=var.getStartPosition();
                for(int i = 0; i<var.capacity(); i++){
                    int memValue=var.getValue(i);
                    buider.append(Integer.toHexString(memDir));
                    buider.append(" ");
                    buider.append(Integer.toHexString(memValue));
                    buider.append("\n");
                    memDir++;
                }
        }
        buider.append("@").append("\n");
        buider.append(Integer.toHexString(_symbols.getStartOfInstruction())).append("\n");
        buider.append("@").append("\n");
        buider.append(InstructionBuilder.toString());
        return buider.toString();
    }

    public void addInstructionUse(String instruction, Integer param) {
        InstructionBuilder.append(instruction);
        if(param!=null){
            InstructionBuilder.append(" ");
            InstructionBuilder.append(Integer.toHexString(param));
        }
        InstructionBuilder.append("\n");
    }
}
