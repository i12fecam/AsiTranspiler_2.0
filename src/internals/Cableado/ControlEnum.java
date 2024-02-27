package internals.Cableado;

public enum ControlEnum {

    LOAD_SR("LOAD_SR"),
    LOAD_SC("LOAD_SC"),
    SR_PLUS("SR+1->SR"),
    SC_MINUS("SR+1->SR");

    public String _input_text;
    private  ControlEnum(String input_text){
        _input_text=input_text;
    }

    public static ControlEnum valueOfInput(String input_text){
        for(ControlEnum ctlr: values()){
            if(ctlr._input_text.equals(input_text)){
                return ctlr;
            }
        }
        return null;
    }
}
