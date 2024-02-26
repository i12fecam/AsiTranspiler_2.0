package Analisis;

import internals.Cableado.Function;

import java.util.Vector;

public class SymbolTable {
    Vector<Function> functions = new Vector<>();

    /**
     *
     * @param functionName
     * @param functionArg
     * @return the id of the registered function
     */
    int addFunction(String functionName,String functionArg){
        functions.add(new Function(functionName,functionArg,functions.size()));
        return functions.size()-1;
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
