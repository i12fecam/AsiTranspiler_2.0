package Analisis;

import internals.Cableado.Function;

import java.util.Vector;

public class SymbolTable {
    Vector<Function> functions = new Vector<>();

    int addFunction(String functionName,String functionArg){
        functions.add(new Function(functionName,functionArg,functions.size()+1));
        return functions.size();
    }


    public void addStepToFunction(int id, int stepId) {
        functions.elementAt(id).addStep(stepId);
    }

    public int getNsteps(int idFunction) {
        return functions.elementAt(idFunction).getNSteps();
    }

    public  Vector<Function> getFunctions(){
        return functions;
    }
}
