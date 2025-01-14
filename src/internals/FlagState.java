package internals;

import java.util.Objects;

public class FlagState implements Comparable {



    private final Flag flag;
    private final Boolean activated;

    public FlagState(Flag flag, Boolean activated) {
        this.flag = flag;
        this.activated = activated;
    }

    public static FlagState ValueOfInput(String input){
        Flag flag = null;
        if(input.startsWith("!")){
            flag = Flag.ValueofInput(input.substring(1));
            if(flag == null) return null;
            return new FlagState(flag, false);
        }
        flag = Flag.ValueofInput(input);
        if(flag == null) return null;
        return new FlagState(flag,true);
    }

    public String getOutputName(){
        String res = new String();
        if(activated) return flag.outputName;
        else return flag.outputName +"'";
    }

    public String getInputName(){
        String res = new String();
        if(activated) return flag.outputName;
        else return "!" + flag.outputName;
    }

    public Flag getFlag() {
        return flag;
    }

    public boolean isStateDefined(){return activated != null;}
    public boolean getState(){
        return activated;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlagState flagState = (FlagState) o;
        return activated == flagState.activated && flag == flagState.flag;
    }




    @Override
    public int hashCode() {
        return Objects.hash(flag, activated);
    }

    @Override
    public int compareTo(Object o) {
        var other = (FlagState) o;
        var cmp = Integer.compare(this.flag.ordinal(),other.flag.ordinal() );
        switch (cmp){
            case 0 :
                if(this.activated == other.activated) return 0;
                if(this.activated) return 1;
                return -1;
            default:
                return cmp;
        }
    }
}
