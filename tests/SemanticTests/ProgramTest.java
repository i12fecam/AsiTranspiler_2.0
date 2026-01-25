package SemanticTests;

import Analysis.LogicException;
import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Runner.Runner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProgramTest {

    //private final Runner helper = new Runner();
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
        vector(0) = { 1 };
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
        vector(1) = { 1 };
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
        vector(3) = {2,2};
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

    @Test
    @DisplayName("Comprueba si la instrucción no está definida en cableado")
    void INSTRUCCION_NO_DEFINIDA1(){
        String inputText = """
               @cableado
                instrucciones {
                    instruccion1(){
                    
                    }
                }
                variables{
                }
                programa{
                    instruccion2;
                }
               """;
        var helper = new Runner();
        assertThrows(RuntimeException.class, () -> {
            helper.run(inputText);
        });
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.INSTRUCCION_NO_DEFINIDA));
    }

    @Test
    @DisplayName("Comprueba si la instrucción no está definida en microprogramado")
    void INSTRUCCION_NO_DEFINIDA2(){
        String inputText = """
               estados{
                 inc ->  INCR
               }
               @microinstruccion
                instrucciones {
                    instruccion1(){}
                }
                variables{
                }
                programa{
                    instruccion2;
                }
               """;
        var helper = new Runner();

        assertThrows(RuntimeException.class, () -> {
            helper.run(inputText);
        });
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.INSTRUCCION_NO_DEFINIDA));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "","etiqueta1","variable1","vector1(1)"})
    @DisplayName("Comprueba que las llamadas a funciones de tipo value solo reciban valores literales")
    void ARGUMENTO_DE_TIPO_VALOR_NO_ENCONTRADO(String argument){
        String inputText = String.format("""
               @cableado
                instrucciones {
                    instruccion1(value){}
                }
                variables{
                    variable1 = 1;
                    vector1(2) = { 1 };
                }
                programa{
                    MARK etiqueta1;
                    instruccion1 %s;
                }
               """,argument);
        var helper = new Runner();
        assertThrows(RuntimeException.class, () -> {
            helper.run(inputText);
        });
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.ARGUMENTO_DE_TIPO_VALOR_NO_ENCONTRADO));
    }

    @ParameterizedTest
    @ValueSource(strings = {"","etiqueta1","5"})
    @DisplayName("Comprueba que las llamadas a funciones de tipo variable solo reciban variables")
    void ARGUMENTO_DE_TIPO_VARIABLE_NO_ENCONTRADO(String argument){
        String inputText = String.format("""
               @cableado
                instrucciones {
                    instruccion1(var){}
                }
                variables{
                    variable1 = 1;
                    vector1(2) = {1 };
                }
                programa{
                    MARK etiqueta1;
                    instruccion1 %s;
                }
               """,argument);
        var helper = new Runner();
        assertThrows(RuntimeException.class, () -> {
            helper.run(inputText);
        });
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.ARGUMENTO_DE_TIPO_VARIABLE_NO_ENCONTRADO));
    }

    @ParameterizedTest
    @ValueSource(strings = {"","variable1","vector1(1)","5"})
    @DisplayName("Comprueba que las llamadas a funciones de tipo direccion solo reciban etiquetas")
    void ARGUMENTO_DE_TIPO_DIRECCION_NO_ENCONTRADO(String argument){
        String inputText = String.format("""
               @cableado
                instrucciones {
                    instruccion1(dir){}
                }
                variables{
                    variable1 = 1;
                    vector1(2) = { 1 };
                }
                programa{
                    MARK etiqueta1;
                    instruccion1 %s;
                }
               """,argument);
        var helper = new Runner();
        assertThrows(RuntimeException.class, () -> {
            helper.run(inputText);
        });
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.ARGUMENTO_DE_TIPO_DIRECCION_NO_ENCONTRADO));
    }



    @ParameterizedTest
    @ValueSource(strings = {"variable1","vector1(1)","5"})
    @DisplayName("Comprueba que las llamadas a funciones que no necesiten de argumento, no se le pase")
    void ARGUMENTO_INSTRUCCION_INNECESARIO(String argument){
        String inputText = String.format("""
               @cableado
                instrucciones {
                    instruccion1(){}
                }
                variables{
                    variable1 = 1;
                    vector1(2) = { 1 };
                }
                programa{
                    MARK etiqueta1;
                    instruccion1 %s;
                }
               """,argument);
        var helper = new Runner();
        assertThrows(RuntimeException.class, () -> {
            helper.run(inputText);
        });
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.ARGUMENTO_INSTRUCCION_INNECESARIO));
    }

    @ParameterizedTest
    @ValueSource(strings = {"variable2","vector2(0)"})
    @DisplayName("Comprueba que las variables usadas estén definidas")
    void VARIABLE_NO_DEFINIDA(String argument){
        String inputText = String.format("""
               @cableado
                instrucciones {
                    instruccion1(var){}
                }
                variables{
                    variable1 = 1;
                }
                programa{
                    MARK etiqueta1;
                    instruccion1 %s;
                }
               """,argument);
        var helper = new Runner();
        assertThrows(RuntimeException.class, () -> {
            helper.run(inputText);
        });
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.VARIABLE_NO_DEFINIDA));
    }

    @Test
    @DisplayName("Comprueba que las etiquetas usadas estén definidas")
    void ETIQUETA_NO_DEFINIDA(){
        String inputText = """
               @cableado
                instrucciones {
                    instruccion1(dir){}
                }
                variables{}
                programa{
                    MARK etiqueta1;
                    instruccion1 etiqueta3;
                    MARK etiqueta2;
                }
               """;
        var helper = new Runner();
        assertThrows(RuntimeException.class, () -> {
            helper.run(inputText);
        });
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.ETIQUETA_NO_DEFINIDA));
    }
    @ParameterizedTest
    @ValueSource(strings = {"4","5"})
    @DisplayName("Comprueba que el indice del vector utilizado es menor que el tamaño del vector")
    void INDICE_ARGUMENTO_VECTOR_INVALIDO(String argument){
        String inputText = String.format("""
               @cableado
                instrucciones {
                    instruccion1(var){}
                }
                variables{
                    vector(4) = { 1 };
                }
                programa{
                    instruccion1 vector(%s);
                }
               """,argument);
        var helper = new Runner();
        assertThrows(RuntimeException.class, () -> {
            helper.run(inputText);
        });
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.INDICE_ARGUMENTO_VECTOR_INVALIDO));
    }






}
