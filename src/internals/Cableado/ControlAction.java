package internals.Cableado;

public class ControlAction {
    ControlEnum tipo;
    int value;




    public ControlAction(String text){
            //TODO rellenar
    }

    public String getControlText(){
        switch (tipo){
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

    public int getValue(){
        return value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ControlAction that = (ControlAction) o;

        return tipo == that.tipo;
    }

    @Override
    public int hashCode() {
        return tipo != null ? tipo.hashCode() : 0;
    }


}
