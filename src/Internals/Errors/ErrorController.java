package Internals.Errors;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

public class ErrorController {

    private static ErrorController instance;

    //private final List<ErrorMessage> msgs = new ArrayList<>();
    private final ThreadLocal<List<ErrorMessage>> msgs = ThreadLocal.withInitial(ArrayList::new);

    public static synchronized ErrorController getInstance() {
        if (instance == null) {
            instance = new ErrorController();
        }
        return instance;
    }

    public void printToConsole(boolean terminalColors){
        msgs.get().forEach(msg -> System.err.println(msg.toString(terminalColors)));
    }

    public boolean containsErrorEnum(ErrorEnum errorEnum){
        return msgs.get().stream().anyMatch(errorMsg -> errorMsg.errorEnum == errorEnum );
    }
    public void addNewError(ErrorEnum id,List<Object> args, Token token ){
        ErrorMessage msg = new ErrorMessage(
                id,
                args,
                token
                );
        addNewErrorMsg(msg);
        throw new RuntimeException("Falta Error");
    }

    private void addNewANTLRError(){

    }

    private void addNewErrorMsg(ErrorMessage msg){
        msgs.get().add(msg);
    }


}
