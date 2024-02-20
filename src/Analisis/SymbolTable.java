package Analisis;

import internals.Cableado.Function;

import java.util.Vector;

public class SymbolTable {
    Vector<Function> functions = new Vector<>();
    /*

    Map<MicroInstruction, ActivationRequirements> MicroInstructionReq = HashMap.newHashMap(23);
    void addMicroInstruction(int functionNumber, int stepNumber, Vector<SicomeMicroInstruction> mi){
        //Comprobar que que sean compatibles en el mismo tiempo las microinstrucciones
    }

    void addConditionalMicroInstruction(int functionNumber, int stepNumber, Vector<BitStatus> statuses, Vector<SicomeMicroInstruction> mi){
    }
    void addControl(int functionNumber, int stepNumber, Vector<ControlAction> control){

    }
    */
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
}
