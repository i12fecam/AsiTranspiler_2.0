package Internals;

public class Instruction {


    private final String _functionName;
    private final int _id;
    private InstructionArgumentType _params;
    private int _nSteps=0;
    /**
     *
     * @param functionName
     * @param functionArg Can be "value","dir","var" or ""
     * @return FunctionNumber
     */
    public Instruction(String functionName, String functionArg, int nSteps , int id){
        this._functionName = functionName;
        switch (functionArg){
            case "dir": _params= InstructionArgumentType.Dir; break;
            case "value": _params= InstructionArgumentType.Value; break;
            case "var" : _params= InstructionArgumentType.Var;break;
            case "" : _params= InstructionArgumentType.None; break;
            default: _params= InstructionArgumentType.None;break;
        }//TODO meter esto dentro del enum?
        _id=id;
        _nSteps=nSteps;
    }

    public String getName(){
        return _functionName;
    }

    public int getId(){
        return _id;
    }

    public Boolean getBooleanParam(){
        if(_params.equals(InstructionArgumentType.None)){
            return Boolean.FALSE;
        }else{
            return Boolean.TRUE;
        }
    }

    public InstructionArgumentType getParam(){
        return _params;
    }

    public int getNSteps() {
        return _nSteps;
    }



}
