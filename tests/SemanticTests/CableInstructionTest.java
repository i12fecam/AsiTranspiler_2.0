package SemanticTests;

import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Internals.FlagEnum;
import Internals.MicroInstructionEnum;
import Internals.MicroInstructionTypeEnum;
import Runner.Runner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static Runner.ObjetiveConfig.INSTRUCTION_SET;
import static org.junit.jupiter.api.Assertions.*;

public class CableInstructionTest {

    private final Runner helper = new Runner();
    @Test
    @DisplayName("Comprueba que no haya dos instrucciones de distinto argumento con el mismo nombre")
    public void INSTRUCCION_MISMO_NOMBRE(){
        String inputText = """
            @cableado
            instrucciones {
                instruccion1(value){}
                instruccion1(var){}
            }
            """;
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.INSTRUCCION_MISMO_NOMBRE));
    }

    @Test
    @DisplayName("Comprueba que no haya dos instrucciones de mismo argumento con el mismo nombre")
    public void INSTRUCCION_MISMO_NOMBRE2(){
        String inputText = """
            @cableado
            instrucciones {
                instruccion1(value){}
                instruccion1(var){}
            }
            """;
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.INSTRUCCION_MISMO_NOMBRE));
    }

    @Test
    @DisplayName("Comprueba que señala correctamente cuando la microinstrucción no esté escrita correctamente")
    void MICROINSTRUCCION_NO_RECONOCIDA1(){
        String inputText = """
            @cableado
            instrucciones {
                instruccion1(value){
                [SR+1->SR] GOR->PC;
                }
            }\
            """;
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.MICROINSTRUCCION_NO_RECONOCIDA));
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
            @cableado
            instrucciones {
                instruccion1(value){
                [SR+1->SR] %s;
                }
            }\
            """,microinstruction);
        assertDoesNotThrow(() -> helper.run(inputText,INSTRUCTION_SET,null));

    }

    private static Stream<Arguments> provideInvalidMicroInstructionCombination() {
        return Arrays.stream(MicroInstructionEnum.values())
                .filter(a ->
                        a.getType() !=MicroInstructionTypeEnum.cable)
                .map(a ->
                       Arguments.of(a.inputName,a.inputName)
                );

    }
    @ParameterizedTest
    @MethodSource("provideInvalidMicroInstructionCombination")
    @DisplayName("Comprueba que no haya dos microinstrucciones iguales en el mismo paso")
    void MICROINSTRUCCION_INVALIDA1(String microinstruccion1,String microinstruccion2){
        String inputText = String.format("""
            @cableado
            instrucciones {
                instruccion1(value){
                [SR+1->SR] %s %s;
                }
            }\
            """,microinstruccion1,microinstruccion2);
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.MICROINSTRUCCION_INVALIDA));
    }
    private static Stream<String> provideCableMicroInstructions() {
        return Arrays.stream(MicroInstructionEnum.values())
                .filter(microInstructionEnum ->
                        microInstructionEnum.getType() == MicroInstructionTypeEnum.cable)
                .map(microInstructionEnum ->
                        microInstructionEnum.inputName);

    }
    private static Stream<String> provideNotCableMicroInstructions() {
        return Arrays.stream(MicroInstructionEnum.values())
                .filter(microInstructionEnum ->
                        microInstructionEnum.getType() != MicroInstructionTypeEnum.cable)
                .map(microInstructionEnum ->
                        microInstructionEnum.inputName);

    }
    @ParameterizedTest
    @MethodSource("provideCableMicroInstructions")
    @DisplayName("Comprueba que no haya instrucciones de tipo cable en la parte derecha del paso")
    void MICROINSTRUCCION_INVALIDA2(String microinstruccion){
        String inputText = String.format("""
            @cableado
            instrucciones {
                instruccion1(value){
                [SR+1->SR] %s;
                }
            }\
            """,microinstruccion);
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.MICROINSTRUCCION_INVALIDA));
    }

    @ParameterizedTest
    @MethodSource("provideNotCableMicroInstructions")
    @DisplayName("Comprueba que no haya instrucciones de tipo no cable en la parte izquierda del paso")
    void MICROINSTRUCCION_INVALIDA3(String microinstruccion){
        String inputText = String.format("""
            @cableado
            instrucciones {
                instruccion1(value){
                [%s] ;
                }
            }\
            """,microinstruccion);
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
            
            @cableado
            instrucciones {
                instruccion1(value){
                   {
                     A: [SR+1->SR] GPR->PC;
                     !A: [SR+1->SR] GPR->PC;
                   }
                }
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
            @cableado
            instrucciones {
                instruccion1(value){
                    {
                     %s: [SR+1->SR] GPR->PC;
                     !%s: [SR+1->SR] GPR->PC;
                    }
                }
            }\
            """,flag,flag);
        assertDoesNotThrow(() -> helper.run(inputText,INSTRUCTION_SET,null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ()","( )"})
    @DisplayName("Comprueba que las microinstrucciones que necesiten de argumento, lo reciban")
    void MICROINSTRUCCION_CON_ARGUMENTO_INVALIDO(String argument){
        String inputText = String.format("""
            @cableado
            instrucciones {
                instruccion1(value){
                [SR+1->SR] LOAD_SC%s;
                }
            }\
            """,argument);
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.MICROINSTRUCCION_CON_ARGUMENTO_INVALIDO));
    }

    //TODO Test sobre posible argumentos???

    @ParameterizedTest
    @ValueSource(strings = {"(0)", "(1)","( )"})
    void MICROINSTRUCCION_CON_ARGUMENTO_INNECESARIO(String argument){
        String inputText = String.format("""
            @cableado
            instrucciones {
                instruccion1(value){
                [SR+1->SR] GPR->PC%s;
                }
            }\
            """,argument);
        assertThrows(RuntimeException.class, () -> helper.run(inputText,INSTRUCTION_SET,null));
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.MICROINSTRUCCION_CON_ARGUMENTO_INNECESARIO));
    }


}
