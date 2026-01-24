package SemanticTests;

import Analysis.LogicException;
import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Internals.FlagEnum;
import Internals.MicroInstructionEnum;
import Internals.MicroInstructionTypeEnum;
import Runner.Runner;
import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static Runner.ObjetiveConfig.INSTRUCTION_SET;
import static org.junit.jupiter.api.Assertions.*;

public class MicroInstructionsTest {
    private final Runner helper = new Runner();
    @Test
    @DisplayName("Comprueba que no haya dos instrucciones de mismo argumento con el mismo nombre")
    public void INSTRUCCION_MISMO_NOMBRE(){
        String inputText = """
            estados{
                 inc ->  INCR
            }
            @microinstruccion
            instrucciones {
                instruccion1(value){}
                instruccion1(value){}
            }\
            """;
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.INSTRUCCION_MISMO_NOMBRE));
    }
    @Test
    @DisplayName("Comprueba que no haya dos instrucciones de diferente argumento con el mismo nombre")
    void INSTRUCCION_MISMO_NOMBRE2(){
        String inputText = """
            estados{
                 inc ->  INCR
            }
            @microinstruccion
            instrucciones {
                instruccion1(value){}
                instruccion1(var){}
            }\
            """;
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.INSTRUCCION_MISMO_NOMBRE));
    }

    @Test
    @DisplayName("Comprueba que señala correctamente cuando la microinstrucción no esté escrita correctamente")
    void MICROINSTRUCCION_NO_RECONOCIDA1(){
        String inputText = """
            estados{
                 inc ->  INCR
            }
            @microinstruccion
            instrucciones {
                instruccion1(value){
                [inc] GOR->PC;
                }
            }\
            """;
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.INSTRUCCION_MISMO_NOMBRE));
    }

    private static Stream<String> provideValidMicroInstructions() {
        return Arrays.stream(MicroInstructionEnum.values())
                .filter(microInstructionEnum ->
                            !microInstructionEnum.needsArgument
                            && microInstructionEnum.getType() != MicroInstructionTypeEnum.cable)
                .map(microInstructionEnum ->
                        microInstructionEnum.inputName);

    }


    @ParameterizedTest
    @DisplayName("comprueba que todas las microinstrucciones válidas sean reconocidas correctamente")
    @MethodSource("provideValidMicroInstructions")
    void MICROINSTRUCCION_NO_RECONOCIDA2(String microinstruction){
        String inputText = String.format("""
            estados{
                 inc ->  INCR
            }
            @microinstruccion
            instrucciones {
                instruccion1(value){
                [inc] %s;
                }
            }\
            """,microinstruction);
        assertDoesNotThrow(() -> helper.run(inputText,INSTRUCTION_SET,null));

    }

    private static Stream<Arguments> provideInvalidMicroInstructionCombination() {
        return Arrays.stream(MicroInstructionEnum.values())
                .filter(a ->
                        a.getType() !=MicroInstructionTypeEnum.cable)
                .flatMap(a ->
                        Arrays.stream(MicroInstructionEnum.values())
                        .filter(b -> b.getType() == a.getType())
                        .map(b -> Arguments.of(a.inputName,b.inputName))
                );

    }
    @ParameterizedTest
    @MethodSource("provideInvalidMicroInstructionCombination")
    @DisplayName("Comprueba que no haya dos microinstrucciones del mismo tipo en el mismo paso")
    void MICROINSTRUCCION_INVALIDA1(String microinstruccion1,String microinstruccion2){
        String inputText = String.format("""
            estados{
                 inc ->  INCR
            }
            @microinstruccion
            instrucciones {
                instruccion1(value){
                [inc] %s %s;
                }
            }\
            """,microinstruccion1,microinstruccion2);
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.MICROINSTRUCCION_INVALIDA));
    }
    private static Stream<String> provideInvalidValidMicroInstructions() {
        return Arrays.stream(MicroInstructionEnum.values())
                .filter(microInstructionEnum ->
                    microInstructionEnum.getType() == MicroInstructionTypeEnum.cable)
                .map(microInstructionEnum ->
                        microInstructionEnum.inputName);

    }
    @ParameterizedTest
    @MethodSource("provideInvalidValidMicroInstructions")
    @DisplayName("Comprueba que no haya instrucciones de tipo cable")
    void MICROINSTRUCCION_INVALIDA2(String microinstruccion){
        String inputText = String.format("""
            estados{
                 inc ->  INCR
            }
            @microinstruccion
            instrucciones {
                instruccion1(value){
                [inc] %s;
                }
            }\
            """,microinstruccion);
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.MICROINSTRUCCION_INVALIDA));
    }

    @Test
    @DisplayName("Comprueba que no haya instrucciones con argumentos a la vez de una lógica de bifurcación que requiera argumento")
    void MICROINSTRUCCION_INVALIDA3(){
        String inputText = """
            estados{
                 inc ->  INCR
                 bif -> BIF
            }
            @microinstruccion
            instrucciones {
                instruccion1(value){
                [bif(0)] LOAD_SC(5);
                }
            }\
            """;
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.MICROINSTRUCCION_INVALIDA));
    }

    private static Stream<String> provideValidFlags() {
        return Arrays.stream(FlagEnum.values())
                .map(flag ->
                        flag.inputName);

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
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.BANDERA_NO_RECONOCIDA));
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
        assertDoesNotThrow(() -> helper.run(inputText,INSTRUCTION_SET,null));
    }



}
