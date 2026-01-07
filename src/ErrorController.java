import Internals.Errors.ErrorEnum;
import Internals.Errors.ErrorLevel;
import Internals.Errors.ErrorMessage;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ErrorController {
    private List<ErrorMessage> msgs = new ArrayList<>();

    public void printToConsole(boolean terminalColors){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Error_messages");
        msgs.forEach(msg -> System.out.println(msg.toString(resourceBundle,terminalColors)));
    }
    public void addNewFatalError(ErrorEnum id,List<Object> args, Token token ){
        ErrorMessage msg = new ErrorMessage(
                ErrorLevel.FATAL_ERROR,
                id,
                args,
                token
                );
        addNewErrorMsg(msg);
        throw new RuntimeException("Falta Error");
    }
    public void createNewWarning(ErrorEnum id,List<Object> args, Token token ){
        ErrorMessage msg = new ErrorMessage(
                ErrorLevel.WARNING,
                id,
                args,
                token
        );
        addNewErrorMsg(msg);
    }
    private void addNewErrorMsg(ErrorMessage msg){
        msgs.add(msg);
    }


}
