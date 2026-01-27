package FullProgramTests;

import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Runner.Runner;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CableInstructionTest {
    @Test
    public void instruccionMismoNombre(){


        String inputText = """
            @cableado
            instrucciones {
                instruccion1(value){
            
                }
                instruccion1(var){
            
                }
            }\
            variables{}\
            programa{}""";



        Runner helper = new Runner();
        var ex = assertThrows(RuntimeException.class, () -> {
            helper.run(inputText);
        });
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.INSTRUCCION_MISMO_NOMBRE));

    }

    @Test
    public void mustHaveArgumentIfIsValue(){
    String inputText = """
            @cableado
            instrucciones {
                instruccion1(value){
                \s
                }\
            }\
            variables{}\
            programa{}""";

    String outputRepositoryText = "halt false 0 q0\ninstruccion1 true 0 q1\n";


        Runner helper = new Runner();
        helper.run(inputText);
        assertEquals(helper.getRepositoryText(),outputRepositoryText);
    }
    @Test
    public void mustHaveArgumentIfIsDir(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1(dir){
                    \s
                    }\
                }\
                variables{}\
                programa{}""";

        String outputRepositoryText = "halt false 0 q0\ninstruccion1 true 0 q1\n";


        Runner helper = new Runner();
        helper.run(inputText);
        assertEquals(helper.getRepositoryText(),outputRepositoryText);
    }

    @Test
    public void mustHaveArgumentIfIsVar(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1(var){
                    \s
                    }\
                }\
                variables{}\
                programa{}""";

        String outputRepositoryText = "halt false 0 q0\ninstruccion1 true 0 q1\n";


        Runner helper = new Runner();
        helper.run(inputText);
        assertEquals(helper.getRepositoryText(),outputRepositoryText);
    }
    @Test
    public void musntHaveArgumentIfIsNone(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1(){
                    \s
                    }\
                }\
                variables{}\
                programa{}""";

        String outputRepositoryText = "halt false 0 q0\ninstruccion1 false 0 q1\n";


        Runner helper = new Runner();
        helper.run(inputText);
        assertEquals(helper.getRepositoryText(),outputRepositoryText);
    }

    @Test
    public void mustProcessSimpleStep(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1(){
                     [SR+1->SR] PC+1->PC;
                    }\
                }\
                variables{}\
                programa{}""";

        String outputRepositoryText = "halt false 0 q0\ninstruccion1 false 1 q1\n";

        String outputLogicText = """
                $
                M->GPR:t1
                GPR(OP)->OPR:t2
                PC->MAR:t0
                GPR(AD)->MAR:t2
                PC+1->PC:t1 + t3·q1
                $
                SR+1->SR:t0 + t1 + t2 + t3·q1
                $
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        assertEquals(outputRepositoryText,helper.getRepositoryText());
        assertCableLogic(helper.getLogicText(),outputLogicText);

    }

    public void mustAllowMicroInstructionsWithArguments(){}

    public void mustProhibitMaxValueMicroInstructionWithArguments(){}

    public void mustProhibitMicroInstructionsWithArgumentsDontNeeded(){}

    public void mustProhibitSameMicroInstructionInSameStep(){}

    public void mustHandleMicroInstructionInCorrectSection(){}


    @Test
    public void mustProhibitInvalidMicroInstructionsBetweeenBrackets(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1(){
                     [PC+1->PC] GPR->PC;
                     [LOAD_SR (START)] GPR->PC;
                    }
                }
                variables{}
                programa{}
                """;

        String outputRepositoryText = "halt false 0 q0\ninstruccion1 false 2 q1\n";

        String outputLogicText = """
                $
                M->GPR:t1
                GPR(OP)->OPR:t2
                PC->MAR:t0
                GPR(AD)->MAR:t2
                PC+1->PC:t1 + t3·q1
                GPR->PC:t4·q1
                $
                SR+1->SR:t0 + t1 + t2 + t3·q1
                LOAD SR:t4·q1-0
                $
                """;

        Runner helper = new Runner();
        assertThrows(RuntimeException.class, () -> {
            helper.run(inputText);
        });

        System.out.println(helper.getLogicText());


    }

    @Test
    public void mustHandleLoadSC(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1(){
                     [SR+1->SR] LOAD_SC(8) PC+1->PC;
                     [LOAD_SR(START)] GPR->PC;
                    }
                }
                variables{}
                programa{}
                """;

        String outputRepositoryText = "halt false 0 q0\ninstruccion1 false 2 q1\n";

        String outputLogicText = """
                $
                M->GPR:t1
                GPR(OP)->OPR:t2
                PC->MAR:t0
                GPR(AD)->MAR:t2
                PC+1->PC:t1 + t3·q1
                GPR->PC:t4·q1
                $
                SR+1->SR:t0 + t1 + t2 + t3·q1
                LOAD SR:t4·q1-0
                LOAD SC:t3·q1-8
                $
                """;

        Runner helper = new Runner();
        helper.run(inputText);


        System.out.println(helper.getLogicText());

        assertEquals(outputRepositoryText,helper.getRepositoryText());
        assertCableLogic(helper.getLogicText(),outputLogicText);
    }

    @Test
    public void mustProcessComplexStep(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1(){
                        {
                            X : [SR+1->SR ] PC+1->PC;
                            As: [SR+1->SR ] LOAD_SC(3) 0->ACC;
                        }
                        [LOAD_SR(START)] !ACC->ACC;
                    }
                }
                variables{
                }
                programa{
                }
                """;

        String outputRepositoryText = "halt false 0 q0\ninstruccion1 false 2 q1\n";

        String outputLogicText = """
                $
                M->GPR:t1
                GPR(OP)->OPR:t2
                PC->MAR:t0
                GPR(AD)->MAR:t2
                PC+1->PC:t1 + t3·q1·X
                0->ACC:t3·q1·As
                !ACC->ACC:t4·q1
                $
                SR+1->SR:t0 + t1 + t2 + t3·q1·X + t3·q1·As
                LOAD SC:t3·q1·As-3
                LOAD SR:t4·q1-0
                $
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        System.out.println(helper.getLogicText());

        assertEquals(outputRepositoryText,helper.getRepositoryText());
        assertCableLogic(outputLogicText,helper.getLogicText());
    }


    @Test
    public void fetchTest(){
        String inputText = """
                @cableado
                instrucciones {
                    fetch{
                        |SR+1->SR| PC->MAR;
                        |SR+1->SR| M->GPR PC+1->PC;
                        |SR+1->SR| GPR[OP]->OPR GPR[AD]->MAR;
                    }
                    
                    instruccion1(){
                     |SR+1->SR| PC+1->PC;
                     |LOAD_SR (START)| GPR->PC;
                    }
                }
                variables{}
                programa{}
                """;

        String outputRepositoryText = "instruccion1 false 2 q0\n";

        String outputLogicText = """
                $
                M->GPR:t1
                GPR(OP)->OPR:t2
                PC->MAR:t0
                GPR(AD)->MAR:t2
                PC+1->PC:t1 + t3·q0
                GPR->PC:t4·q0
                $
                SR+1->SR:t0 + t1 + t2 + t3·q0
                LOAD SR:t4·q0-0
                $
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        System.out.println(helper.getLogicText());
        assertCableLogic(helper.getLogicText(),outputLogicText);

        assertEquals(outputRepositoryText,helper.getRepositoryText());
    }










    public void assertCableLogic(String received, String expected){
        String[] receivedSection = received.split("$");
        String[] expectedSection = expected.split("$");

        //Se comprueba sección 1
        {
            String[] lineReceivedSection = receivedSection[0].split("\n");
            String[] lineExpectedSection = expectedSection[0].split("\n");
            for (String lineExpected : lineExpectedSection) {
                assertTrue(Arrays.asList(lineReceivedSection).contains(lineExpected), "Linea no encontrada->" + " " + lineExpected);
            }
        }

       //Se comprueba sección 2
        {
            String[] lineReceivedSection = receivedSection[1].split("\n");
            String[] lineExpectedSection = expectedSection[1].split("\n");
            for (String lineExpected : lineExpectedSection) {
                assertTrue(Arrays.asList(lineReceivedSection).contains(lineExpected), "Linea no encontrada->" + " " + lineExpected);
            }
        }
    }
}
