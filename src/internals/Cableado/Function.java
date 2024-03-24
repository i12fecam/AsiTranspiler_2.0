package internals.Cableado;

import internals.FunctionArg;

public class Function {


    private final String _functionName;
    private final int _id;
    private FunctionArg _params;
    private int _nSteps=0;
    /**
     *
     * @param functionName
     * @param functionArg Can be "value","dir" or ""
     * @return FunctionNumber
     */
    public Function(String functionName,String functionArg,int nSteps ,int id){
        this._functionName = functionName;
        switch (functionArg){
            case "dir": _params= FunctionArg.Dir; break;
            case "value": _params= FunctionArg.Value; break;
            case "var" : _params=FunctionArg.Var;break;
            case "" : _params= FunctionArg.None; break;
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
        if(_params.equals(FunctionArg.None)){
            return Boolean.FALSE;
        }else{
            return Boolean.TRUE;
        }
    }

    public FunctionArg getParam(){
        return _params;
    }

    public int getNSteps() {
        return _nSteps;
    }
    public void addStep(int nSteps){
        assert(nSteps>0);
        _nSteps+=nSteps;

    }


}
