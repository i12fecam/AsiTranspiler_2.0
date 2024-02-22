package internals.Cableado;

import internals.FunctionParam;

public class Function {


    private String _functionName;
    private int _id;
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
        //TODO
    }

    public String getFunctionName(){
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
