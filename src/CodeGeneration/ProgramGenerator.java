package CodeGeneration;

import Analisis.SymbolTable;
import internals.Variable;

public class ProgramGenerator {

    SymbolTable _symbols;
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
                int memDir=var.startOfMemory();
                for(int i =0;i<var.size();i++){
                    int memValue=var.getMemoryDir(i);
                    buider.append(memDir);
                    buider.append(" ");
                    buider.append(memValue);//Todo esto se debe poner en hexadecimal?
                    buider.append("\n");
                    memDir++;
                }
        }
        buider.append("@").append("\n");
        buider.append(_symbols.getStartOfInstruction()).append("\n");
        buider.append("@").append("\n");
        /**
         * Por completar
         */
        return buider.toString();
    }
}
