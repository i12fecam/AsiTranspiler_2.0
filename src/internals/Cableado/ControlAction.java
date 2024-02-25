package internals.Cableado;

public class ControlAction {
    ControlEnum _tipo;
    int _value;




    public ControlAction(ControlEnum control,Integer value){
            _tipo=control;
            if(value!=null){
                _value=value;
            }


    }

    public String getControlText(){
        switch (_tipo){
            case LOAD_SC -> {
                return "LOAD SC";
            }
            case LOAD_SR -> {
                return "LOAD SR";
            }
            case SR_PLUS ->
            {
                return "SR+1->SR";
            }
            case SC_MINUS -> {
                return "SC-1->SC";
            }
        }
        return null;
    }

    public int get_value(){
        return _value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ControlAction that = (ControlAction) o;

        return _tipo == that._tipo;
    }

    @Override
    public int hashCode() {
        return _tipo != null ? _tipo.hashCode() : 0;
    }


}
