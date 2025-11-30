package internals.errors;

import org.antlr.v4.runtime.Token;

import java.util.List;
import java.util.ResourceBundle;


public class ErrorMessage {
    ErrorLevel level;
    ErrorEnum id;
    Token token;
    List<Object> arguments;

    ErrorMessage(ErrorLevel level, ErrorEnum id, Token token){
        this.level = level;
        this.id = id;
        this.token = token;
    }

    ErrorMessage(ErrorLevel level, ErrorEnum id,List<Object> args, Token token){
        this.level = level;
        this.id = id;
        this.token = token;
        this.arguments = args;
    }

    String print(ResourceBundle errorTranslations,boolean terminalColors){
        String res = "";


        //ANSI_RED[AVISO] linea 4: DATO_ERRONEO_BIF, El valor del bif no puede ser repetido
        String levelText = switch (level) {
            case WARNING -> "Aviso";
            case FATAL_ERROR-> "Error";
        };

        String errorExplanation = String.format(
                errorTranslations.getString(id.name()),
                arguments.toArray()
        );



        res = String.format("[%s] linea %s:%s, %s",
                levelText,
                token.getLine(),
                id.name(),
                errorExplanation
                );

        if(terminalColors){
            String ANSI_RED = "\u001B[31m";
            String ANSI_YELLOW = "\u001B[0;33m";
            String ANSI_RESET = "\u001B[0m";
            res = switch (level){
                case WARNING -> ANSI_YELLOW + res + ANSI_RESET;
                case FATAL_ERROR -> ANSI_RED + res + ANSI_RESET;
            };
        }
        return res;
    }

}


