package SemanticTests;

import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Internals.FlagEnum;
import Runner.Runner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static Runner.ObjetiveConfig.INSTRUCTION_SET;
import static Runner.ObjetiveConfig.LOGIC;
import static org.junit.jupiter.api.Assertions.*;

public class MicroLogicInstructionTest {
    private final Runner helper = new Runner();
    @Test
    @DisplayName("Comprueba que no haya dos logicas de bifurcación con el mismo nombre")
    public void LOGICA_BIFURCACION_MISMO_NOMBRE(){
        String inputText = """
            estados{
                 inc ->  INCR
                 inc -> BIF
            }
            """;
        assertThrows(RuntimeException.class, () -> helper.run(inputText,LOGIC,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.LOGICA_BIFURCACION_MISMO_NOMBRE));
    }
    @Test
    @DisplayName("Comprueba que no se ha superado el número máximo de lógicas de bifurcacion permitida por la arquitectura (16)")
    public void NUMERO_LOGICA_BIFURCACION_SUPERADO(){
        String inputText = """
            estados{
                 inc ->  INCR
                 inc2 -> INCR
                 inc3 -> INCR
                 inc4 -> INCR
                 inc5 -> INCR
                 inc6 -> INCR
                 inc7 -> INCR
                 inc8 -> INCR
                 inc9 -> INCR
                 inc10 -> INCR
                 inc11 -> INCR
                 inc12 -> INCR
                 inc13 -> INCR
                 inc14 -> INCR
                 inc15 -> INCR
                 inc16 -> INCR
                 inc17 -> INCR
            }
            """;
        assertThrows(RuntimeException.class, () -> helper.run(inputText,LOGIC,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.NUMERO_LOGICA_BIFURCACION_SUPERADO));
    }

    @Test
    @DisplayName("Comprueba que señala correctamente cuando la bandera no este escrita correctamente")
    void BANDERA_NO_RECONOCIDA1(){
        String inputText = """
            estados{
                 inc ->  INCR
                 bif_if_flag -> {
                    A : BIF
                    A : INCR
                 }
            }
            @microinstruccion
            instrucciones {
                instruccion1(value){}
            }\
            """;
        var helper = new Runner();
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.BANDERA_NO_RECONOCIDA));
    }

    private static Stream<String> provideValidFlags() {
        return Arrays.stream(FlagEnum.values())
                .map(flag ->
                        flag.inputName);

    }

    @ParameterizedTest
    @MethodSource("provideValidFlags")
    @DisplayName("Comprueba que todas las banderas se recnozcan de forma correcta")
    void BANDERA_NO_RECONOCIDA2(String flag){
        String inputText = String.format("""
            estados{
                 inc ->  INCR
                 bif_if_flag -> {
                    %s: BIF
                    !%s: INCR
                 }
            }
            @microinstruccion
            instrucciones {
                instruccion1(value){}
            }\
            """,flag,flag);
        var helper = new Runner();
        assertDoesNotThrow(() -> helper.run(inputText,INSTRUCTION_SET,null));
    }


}
