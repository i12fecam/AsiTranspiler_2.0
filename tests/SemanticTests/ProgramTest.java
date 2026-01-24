package SemanticTests;

import Analysis.LogicException;
import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Runner.Runner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProgramTest {

    private final Runner helper = new Runner();
    @Test
    @DisplayName("Comprueba que se pueda definir vectores de tamaño 1")
    void VARIABLE_MISMO_NOMBRE(){
        String inputText = """
        @cableado
        instrucciones {
        instruccion1(){}
        }
        variables{
        variableRepetida = 0;
        variableRepetida = 5;
        }
        programa{
        instruccion1;
        }
        """;

        Runner helper = new Runner();
        assertThrows(RuntimeException.class, () -> helper.run(inputText));
        assertTrue(ErrorController.getInstance()
        .containsErrorEnum(ErrorEnum.VARIABLE_MISMO_NOMBRE));

    }
    @Test
    @DisplayName("Comprueba que no se pueda definir vectores de tamaño 0")
    void TAMANYO_VECTOR_INVALIDO1(){
        String inputText = """
        @cableado
        instrucciones {
        instruccion1(){}
        }
        variables{
        vector[0] = {1};
        }
        programa{
        instruccion1;
        }
        """;

        Runner helper = new Runner();
        assertThrows(RuntimeException.class, () -> helper.run(inputText));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.TAMANYO_VECTOR_INVALIDO));

    }


    @Test
    @DisplayName("Comprueba que no se pueda definir vectores de tamaño 1")
    void TAMANYO_VECTOR_INVALIDO2(){
        String inputText = """
        @cableado
        instrucciones {
        instruccion1(){}
        }
        variables{
        vector[1] = {1};
        }
        programa{
        instruccion1;
        }
        """;

        Runner helper = new Runner();
        assertThrows(RuntimeException.class, () -> helper.run(inputText));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.TAMANYO_VECTOR_INVALIDO));

    }

    @Test
    @DisplayName("Comprueba que no se pueda incializar el vector con un número diferente")
    void INICIALIZACION_VECTOR_INVALIDA1(){
        String inputText = """
        @cableado
        instrucciones {
        instruccion1(){}
        }
        variables{
        vector[3] = {2,2};
        }
        programa{
        instruccion1;
        }
        """;

        Runner helper = new Runner();
        assertThrows(RuntimeException.class, () -> helper.run(inputText));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.INICIALIZACION_VECTOR_INVALIDA));

    }
    @Test
    @DisplayName("Comprueba que no se pueda escribir dos etiquetas con el mismo nombre")
    void ETIQUETA_MISMO_NOMBRE(){
        String inputText = """
               @cableado
                instrucciones {
                    instruccion1(){
                    
                    }
                }
                variables{
                }
                programa{
                MARK label1;
                instruccion1;
                MARK label1;
                instruccion1;
                }
               """;

        Runner helper = new Runner();
        var ex = assertThrows(RuntimeException.class, () -> {
            helper.run(inputText);
        });
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.ETIQUETA_MISMO_NOMBRE));

    }

}
