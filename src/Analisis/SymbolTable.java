package Analisis;

import internals.Cableado.Function;
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

    /*
        Variables
     */
    Vector<Variable> variables = new Vector<>();
    public void addSimpleVariable(String variableName, int initializedValue ){
        List<Integer> value = new ArrayList<>();
        value.add(initializedValue);
        variables.add(new Variable(variableName,getNextAvailablePositionInMemory(),1,value));
    }

    public void addVectorVariable(String variableName, int reservedSpace,int initializedValue){

        List<Integer> values = new ArrayList<>(Collections.nCopies(reservedSpace, initializedValue));
        variables.add(new Variable(variableName,getNextAvailablePositionInMemory(),reservedSpace,values));
    }
    public void addVectorVariable(String variableName, int reservedSpace, List<Integer> initializedValues){
        variables.add(new Variable(variableName,getNextAvailablePositionInMemory(),reservedSpace,initializedValues));
    }
    public List<Variable> getVariables(){
        return variables;
    }
    public Integer getVariablePositionInMemory(String variableName,int offset){
        for(Variable var:variables){
            if(Objects.equals(var.name(), variableName)){
                return var.getMemoryDir(offset);
            }
        }
        return null;
    }

    public int getNextAvailablePositionInMemory(){
        if(variables.size()==0){
            return 0;
        } else {
            return variables.lastElement().endOfMemory()+1;
        }
    }

    public int getStartOfInstruction(){
        return getNextAvailablePositionInMemory();
    }
    /*
        Labels
     */
    public void addLabel(String label,int pos){

    }

    public int getPosFromLabel(String label){
        return 0;
    }
}
