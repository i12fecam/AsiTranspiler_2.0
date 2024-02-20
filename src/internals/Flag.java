package internals;

public enum Flag {
    Zb("Zb","Zb"),
    Za("Za","Za"),
    Zac("Zac","Zac"),
    Zsc("Zsc","Zsc"),
    Ovf("Ovf","Ovf"),
    N("N","N"),
    Qn("Qn","Qn"),
    Qn_plus("Qn_plus","Qn_plus"),
    As("As","As"),
    Qs("Qs","Qs"),
    Bs("Bs","Bs"),
    X("X","X");

    public final String outputName;

    public final String inputName;

    public static Flag ValueofInput(String input){
        for (Flag e : values()) {
            if (e.inputName.equals(input)) {
                return e;
            }
        }
        return null;
    }

    public static Flag ValueofOutput(String output){
        for (Flag e : values()) {
            if (e.outputName.equals(output)) {
                return e;
            }
        }
        return null;
    }


    private Flag(String inputName, String outputName){
        this.outputName = outputName;
        this.inputName = inputName;
    }
}
