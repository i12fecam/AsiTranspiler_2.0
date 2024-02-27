package internals;

import java.util.ArrayList;
import java.util.List;

public class Variable {
    String _name;
    int _start;
    int _end;

    List<int> _values;

    public Variable(String variableName,int startInMemory, int reservedSpace, List<int> initializedValues) {
        assert(reservedSpace>1);
        assert(variableName!=null);
        assert(initializedValues!=null);
        assert(initializedValues.size() == reservedSpace);

        _name=variableName;
        _start=startInMemory;
        _end=startInMemory+reservedSpace;
        _values= initializedValues;

    }

    public Variable(String variableName,int startInMemory, int reservedSpace, int initializedValue) {
        assert(variableName!=null);
        assert(startInMemory>0);
        assert(reservedSpace>0);


        _name=variableName;
        _start=startInMemory;
        _end=startInMemory+reservedSpace;
        _values = new ArrayList<int>(reservedSpace);
        for(int pos=0;pos<size();pos++){
            _values.add(initializedValue);
        }

    }

    public int size(){
        return _end-_start;
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
        return _end + offset;
    }

    public String name() {
        return _name;
    }
}
