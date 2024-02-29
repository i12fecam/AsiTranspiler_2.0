package Analisis;

import internals.Cableado.Function;
import internals.FunctionArg;
import internals.Variable;

import java.util.*;

public class SymbolTable {
    private Vector<Function> functions = new Vector<>();

    /**
     * Registers a new function
     * @param functionName the fucntionName
     * @param functionArg the function arguments
     * @param steps the number of steps of the function
     * @return the id of the registered function
     */
    public int addFunction(String functionName,String functionArg,int steps){
        functions.add(new Function(functionName,functionArg,steps,functions.size()));
        return functions.size()-1;
    }


    /**
     * Gets the number of steps of the given function
     * @param idFunction the fuction we are referring
     * @return the number of steps
     */
    public int getSteps(int idFunction) {
        return functions.elementAt(idFunction).getNSteps();
    }

    /**
     * Gets all the function defined
     * @return The functions
     */
    public  Vector<Function> getFunctions(){
        return functions;
    }

    /**
     * Returns the type of argument given an instruction name
     * @param InstructionName the name of the instruction
     * @return type of argument
     */
    public FunctionArg getArgument(String InstructionName){
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
    private Vector<Variable> variables = new Vector<>();

    /**
     * Adds a simple variable
     * @param variableName name of the variable
     * @param initializedValue initial value
     */
    public void addSimpleVariable(String variableName, int initializedValue ){
        List<Integer> value = new ArrayList<>();
        value.add(initializedValue);
        variables.add(new Variable(variableName, getNextAvailablePos(),1,value));
    }

    /**
     * Adds a vector variable that is initialized with the same value
     * @param variableName the name of the variable
     * @param reservedSpace the size of the vector
     * @param initializedValue the value that all the vector spaces are initialized to
     */
    public void addVectorVariable(String variableName, int reservedSpace,int initializedValue){

        List<Integer> values = new ArrayList<>(Collections.nCopies(reservedSpace, initializedValue));
        variables.add(new Variable(variableName, getNextAvailablePos(),reservedSpace,values));
    }

    /**
     * Adds a vector variable that is initialized specifying each value
     * @param variableName the name of the variable
     * @param reservedSpace the size of the vector
     * @param initializedValues A list with the same size as the size of the vector, filled with the initialized value as the vector
     */
    public void addVectorVariable(String variableName, int reservedSpace, List<Integer> initializedValues){
        variables.add(new Variable(variableName, getNextAvailablePos(),reservedSpace,initializedValues));
    }

    /**
     * Gets the registered variables
     * @return registered variables
     */
    public List<Variable> getVariables(){
        return variables;
    }

    /**
     * Gets the postion of the variable in memory
     * @param variableName the name of the variable
     * @param offset 0 if simple value or the index in case it is a vector
     * @return the position in memory
     */
    public Integer getPosFromVariable(String variableName, int offset){
        for(Variable var:variables){
            if(Objects.equals(var.name(), variableName)){
                return var.getPosition(offset);
            }
        }
        return null;
    }

    /**
     * Checks if the given string corresponds to a variable
     * @param variableName the string to be checked
     * @return true if it corresponds to a variable
     */
    public boolean isVariable(String variableName) {
        if(getPosFromVariable(variableName,0)==null){
            return false;
        }
        return true;
    }

    /**
     * Gets the next available position in memory not reserved
     * @return next available position in memory not reserved
     */
    private int getNextAvailablePos(){
        if(variables.size()==0){
            return 0;
        } else {
            return variables.lastElement().getEndPosition()+1;
        }
    }

    /**
     * When all the instructions have been reserved in memory, will return the position in memory in which the instructions can be written
     * @return the position in memory in which the instructions can start to be written
     */
    public int getStartOfInstruction(){
        return getNextAvailablePos();
    }
    /*
        Labels
     */

    private final Map<String,Integer> labels = new HashMap<>();

    /**
     * Registers a new label
     * @param label name of the label
     * @param pos position in memory the label is referring to,Assummes the postion 0 refers to the first instruction
     */
    public void addLabel(String label,int pos){
        if(labels.get(label) != null) throw new RuntimeException("Ya hay un label con este nombre");

        labels.put(label,pos);
    }

    /**
     * Gets the position in memory the label is referring to, taking to account the reserved positions of the variables
     * @param label
     * @return
     */
    public int getPosFromLabel(String label){
        if(labels.get(label) == null) throw new RuntimeException("El label al que se refiere no existe");
        return labels.get(label) + getStartOfInstruction();
    }

    /**
     * Checks if the given string refers to a registered label
     * @param labelName the given string
     * @return true if it refers to a registered label, else no
     */

    public boolean isLabel(String labelName) {
        if(labels.get(labelName) == null) return false;
        return true;
    }
}
