package CodeGeneration.Micro;

import Internals.Flag;
import Internals.FlagState;

import java.util.List;

public class MicroLogicHelper {

    private StringBuilder builder= new StringBuilder("B3 B2 B1 B0 F Zb Za Zac Zsc X Qn Qn1 As Qs Bs N I B R E\n");

    public String getString(){
        return builder.toString();
    }
    public void addStatusLogic(int id, List<FlagState> flags, boolean inc, boolean bif, boolean ret, boolean enable){
        assert(id<16);

        String stringId =Integer.toBinaryString(id);
        //Se padea a que llegue a cuatro números
        while(true){
            if(stringId.length()<4){
                stringId = "0" + stringId;
            }else{
                break;
            }
        }

        for(var charID: stringId.toCharArray()){
            builder.append(charID);
            builder.append("  ");
        }

        processFlag(flags,Flag.F);
        processFlag(flags,Flag.Zb);
        processFlag(flags,Flag.Za);
        processFlag(flags,Flag.Zac);
        processFlag(flags,Flag.Zsc);
        processFlag(flags,Flag.X);
        processFlag(flags,Flag.Qn);
        processFlag(flags,Flag.Qn1);
        processFlag(flags,Flag.As);
        processFlag(flags,Flag.Qs);
        processFlag(flags,Flag.Bs);
        processFlag(flags,Flag.N);

        if(inc){
            builder.append("1");
        }else{
            builder.append("0");
        }

        builder.append(" ");

        if(bif){
            builder.append("1");
        }else{
            builder.append("0");
        }

        builder.append(" ");

        if(ret){
            builder.append("1");
        }else{
            builder.append("0");
        }

        builder.append(" ");

        if(enable){
            builder.append("1");
        }else{
            builder.append("0");
        }

        builder.append("\n");
    }

    private Boolean checkFlag(List<FlagState> flags, Flag flag){//TODO reformular?
        for (var i:flags){
            if(i.getFlag().equals(flag)){
                return  i.getState();
            }
        }
        return null;
    }

    private void processFlag(List<FlagState> flags, Flag flag){
        Boolean FlagStatus = checkFlag(flags,flag);
        if(FlagStatus==null){
            builder.append("X");
        } else if (FlagStatus) {
            builder.append("1");
        }else {
            builder.append("0");
        }
        for(int i = 0; i<flag.toString().length(); i++){
            builder.append(" ");
        }

    }

}
