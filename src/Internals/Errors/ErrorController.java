package Internals.Errors;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

public class ErrorController {

    private static ErrorController instance;

    private final List<ErrorMessage> msgs = new ArrayList<>();

    public static synchronized ErrorController getInstance() {
        if (instance == null) {
            instance = new ErrorController();
        }
        return instance;
    }

    public void printToConsole(boolean terminalColors){
        msgs.forEach(msg -> System.out.println(msg.toString(terminalColors)));
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

    private void addNewErrorMsg(ErrorMessage msg){
        msgs.add(msg);
    }


}
