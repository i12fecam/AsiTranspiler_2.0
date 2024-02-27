package internals;

import java.util.ArrayList;
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
        assert(size()==reservedSpace);
    }


    public int size(){
        return _end-_start+1;
    }
    public int startOfMemory(){
        return _start;
    }
    public  int endOfMemory(){
        return _end;
    }

    public int getMemoryDir(int offset){
        if(offset>size()){
            throw new RuntimeException("OutOfBOundIndex");
        }
        return _values.get(offset);
    }

    public String name() {
        return _name;
    }
}
