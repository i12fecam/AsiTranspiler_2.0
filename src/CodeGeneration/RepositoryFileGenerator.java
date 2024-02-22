package CodeGeneration;

import Analisis.SymbolTable;
import internals.Cableado.Function;

public class RepositoryFileGenerator {
    SymbolTable _symbols;
    public RepositoryFileGenerator(SymbolTable symbols) {

    _symbols= symbols;
    }
    /*
    HALT false 0 q0
    LDA true 2 q1
    LDQ true 1 q2
    STA true 2 q3
    STQ true 1 q4
    LDAQ true 5 q5
    STAQ true 11 q6
    ZEROS32 true 7 q7
     */
    public String getTextRepository(){
        StringBuilder builder = new StringBuilder();
        for(Function func: _symbols.getFunctions()){
            builder.append(func.getFunctionName());
            builder.append(" ");
            builder.append(func.getBooleanParam().toString());
            builder.append(" ");
            builder.append(func.getNSteps());
            builder.append(" ");
            builder.append("q").append(func.getId());

            builder.append("\n");
        }
        return builder.toString();
    }
}
