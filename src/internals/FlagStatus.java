package internals;

import java.util.Objects;

public class FlagStatus {



    private final Flag flag;
    private final boolean activated;

    public FlagStatus(Flag flag, boolean activated) {
        this.flag = flag;
        this.activated = activated;
    }

    public static FlagStatus ValueOfInput(String input){
        Flag flag = null;
        if(input.startsWith("!")){
            flag = Flag.ValueofInput(input.substring(1));
            if(flag == null) return null;
            return new FlagStatus(flag, false);
        }
        flag = Flag.ValueofInput(input);
        if(flag == null) return null;
        return new FlagStatus(flag,true);
    }

    public String getOutputName(){
        String res = new String();
        if(activated) return flag.outputName;
        else return flag.outputName +"'";
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlagStatus flagStatus = (FlagStatus) o;
        return activated == flagStatus.activated && flag == flagStatus.flag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flag, activated);
    }
}
