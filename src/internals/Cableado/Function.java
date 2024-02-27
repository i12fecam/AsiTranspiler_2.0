package internals.Cableado;

import internals.FunctionParam;

public class Function {


    private final String _functionName;
    private final int _id;
    private FunctionParam _params;
    private int _nSteps=0;
    /**
     *
     * @param functionName
     * @param functionArg Can be "value","dir" or ""
     * @return FunctionNumber
     */
    public Function(String functionName,String functionArg,int id){
        this._functionName = functionName;
        switch (functionArg){
            case "dir": _params=FunctionParam.Dir;
            case "value": _params=FunctionParam.Value;
            case "" : _params=FunctionParam.None;
        }//TODO meter esto dentro del enum?
        _id=id;
    }

    public String getName(){
        return _functionName;
    }

    public int getId(){
        return _id;
    }

    public Boolean getBooleanParam(){
        if(_params.equals(FunctionParam.None)){
            return Boolean.FALSE;
        }else{
            return Boolean.TRUE;
        }
    }

    public int getNSteps() {
        return _nSteps;
    }
    public void addStep(int nSteps){
        assert(nSteps>0);
        _nSteps+=nSteps;

    }


}
