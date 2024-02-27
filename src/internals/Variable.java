package internals;

import java.util.List;

public class Variable {
    String _name;
    int _start;
    int _end;

    List<Integer> _values;
    //Para vectores
    public Variable(String variableName,int startInMemory, int reservedSpace, List<Integer> initializedValues) {
        assert(reservedSpace>1);
        assert(variableName!=null);
        assert(initializedValues!=null);
        assert(initializedValues.size() == reservedSpace);

        _name=variableName;
        _start=startInMemory;
        _end=startInMemory+reservedSpace-1;
        _values= initializedValues;
        assert(capacity()==reservedSpace);
    }


    public int capacity(){
        return _end-_start+1;
    }
    public int getStartPosition(){
        return _start;
    }
    public  int getEndPosition(){
        return _end;
    }

    public int getPosition(int offset){
        if(offset > capacity()){
            throw new RuntimeException("OutOfBoundIndex");
        }
        return _values.get(offset);
    }

    public String name() {
        return _name;
    }
}
