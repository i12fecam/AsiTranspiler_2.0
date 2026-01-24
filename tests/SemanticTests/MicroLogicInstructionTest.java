package SemanticTests;

import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Runner.Runner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Runner.ObjetiveConfig.INSTRUCTION_SET;
import static Runner.ObjetiveConfig.LOGIC;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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


}
