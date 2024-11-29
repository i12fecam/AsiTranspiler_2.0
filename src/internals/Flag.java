package internals;

public enum Flag {
    Zb("Zb","Zb"), //micro, cable
    Za("Za","Za"), //micro ,cable
    Zac("Zac","Zac"), //micro, cable
    Zsc("Zsc","Zsc"), //micro, cable
    Ovf("Ovf","Ovf"), //TODO que hacer sobre este
    N("N","N"), //micro ,cable
    Qn("Qn","Qn"), //micro , cable
    Qn1("Qn+","Qn_plus"), //micro, cable
    As("As","As"), //micro, cable
    Qs("Qs","Qs"), //micro, cable
    Bs("Bs","Bs"), //micro, cable
    X("X","X"), //micro ,cable

    F("F","F"); //micro , cable

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



    /*
    public static void main(String[] arg){
        for(Flag e:values()){
            System.out.println("- " + e.inputName);
        }

    }

     */
}
