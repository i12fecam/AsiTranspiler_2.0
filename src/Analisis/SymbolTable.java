package Analisis;

import internals.Cableado.Function;
import internals.FunctionParam;
import internals.Variable;

import java.util.*;

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


    public void addStepToFunction(int instr_id, int nStep) {
        functions.elementAt(instr_id).addStep(nStep);
    }

    public int getNsteps(int idFunction) {
        return functions.elementAt(idFunction).getNSteps();
    }

    public  Vector<Function> getFunctions(){
        return functions;
    }

    public FunctionParam getArgument(String InstructionName){
        for(Function fun: functions){
            if(fun.getName().equals(InstructionName)){
                return fun.getParam();
            }
        }
        return null;
    }
    /*
        Variables
     */
    Vector<Variable> variables = new Vector<>();
    public void addSimpleVariable(String variableName, int initializedValue ){
        List<Integer> value = new ArrayList<>();
        value.add(initializedValue);
        variables.add(new Variable(variableName, getNextAvailablePos(),1,value));
    }

    public void addVectorVariable(String variableName, int reservedSpace,int initializedValue){

        List<Integer> values = new ArrayList<>(Collections.nCopies(reservedSpace, initializedValue));
        variables.add(new Variable(variableName, getNextAvailablePos(),reservedSpace,values));
    }
    public void addVectorVariable(String variableName, int reservedSpace, List<Integer> initializedValues){
        variables.add(new Variable(variableName, getNextAvailablePos(),reservedSpace,initializedValues));
    }
    public List<Variable> getVariables(){
        return variables;
    }
    public Integer getPosFromVariable(String variableName, int offset){
        for(Variable var:variables){
            if(Objects.equals(var.name(), variableName)){
                return var.getPosition(offset);
            }
        }
        return null;
    }
    public boolean isVariable(String variableName) {
        if(getPosFromVariable(variableName,0)==null){
            return false;
        }
        return true;
    }
    private int getNextAvailablePos(){
        if(variables.size()==0){
            return 0;
        } else {
            return variables.lastElement().getEndPosition()+1;
        }
    }

    public int getStartOfInstruction(){
        return getNextAvailablePos();
    }
    /*
        Labels
     */

    Map<String,Integer> labels = new HashMap<>();
    public void addLabel(String label,int pos){
        if(labels.get(label) == null) throw new RuntimeException("Ya hay un label con este nombre");

        labels.put(label,pos);
    }

    public int getPosFromLabel(String label){
        if(labels.get(label) == null) throw new RuntimeException("El label al que se refiere no existe");
        return labels.get(label) + getStartOfInstruction();//TODO esto funciona bien si empieza el bloque con mark?
    }


    public boolean isLabel(String labelName) {
        if(labels.get(labelName) == null) return false;
        return true;
    }
}
