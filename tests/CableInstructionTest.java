import Analisis.LogicException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CableInstructionTest {
    //TODO hacer tests que comprueben warnings de que le faltan contenido a las funciones
    @Test
    public void mustHaveArgumentIfIsValue(){
    String inputText = "@cableado\n" +
            "instrucciones {\n" +
            "    instruccion1(value){\n" +
            "     \n" +
            "    }" +
            "}" +
            "variables{}" +
            "programa{}";

    String outputRepositoryText = "halt false 0 q0\ninstruccion1 true 0 q1\n";


        Runner helper = new Runner();
        helper.run(inputText);
        assertEquals(helper.getRepositoryText(),outputRepositoryText);
    }
    @Test
    public void mustHaveArgumentIfIsDir(){
        String inputText = "@cableado\n" +
                "instrucciones {\n" +
                "    instruccion1(dir){\n" +
                "     \n" +
                "    }" +
                "}" +
                "variables{}" +
                "programa{}";

        String outputRepositoryText = "halt false 0 q0\ninstruccion1 true 0 q1\n";


        Runner helper = new Runner();
        helper.run(inputText);
        assertEquals(helper.getRepositoryText(),outputRepositoryText);
    }

    @Test
    public void mustHaveArgumentIfIsVar(){
        String inputText = "@cableado\n" +
                "instrucciones {\n" +
                "    instruccion1(var){\n" +
                "     \n" +
                "    }" +
                "}" +
                "variables{}" +
                "programa{}";

        String outputRepositoryText = "halt false 0 q0\ninstruccion1 true 0 q1\n";


        Runner helper = new Runner();
        helper.run(inputText);
        assertEquals(helper.getRepositoryText(),outputRepositoryText);
    }
    @Test
    public void musntHaveArgumentIfIsNone(){
        String inputText = "@cableado\n" +
                "instrucciones {\n" +
                "    instruccion1(){\n" +
                "     \n" +
                "    }" +
                "}" +
                "variables{}" +
                "programa{}";

        String outputRepositoryText = "halt false 0 q0\ninstruccion1 false 0 q1\n";


        Runner helper = new Runner();
        helper.run(inputText);
        assertEquals(helper.getRepositoryText(),outputRepositoryText);
    }

    @Test
    public void mustProcessSimpleStep(){
        String inputText = "@cableado\n" +
                "instrucciones {\n" +
                "    instruccion1(){\n" +
                "     [SR+1->SR] PC+1->PC;\n" +
                "    }" +
                "}" +
                "variables{}" +
                "programa{}";

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

    @Test
    public void mustHandleLoadSRStart(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1(){
                     [SR+1->SR] PC+1->PC;
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
                $
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        System.out.println(helper.getLogicText());

        assertEquals(outputRepositoryText,helper.getRepositoryText());
        assertCableLogic(helper.getLogicText(),outputLogicText);
    }

    @Test
    public void mustProhibitInvalidMicroInstructionsBetweeenBrackets(){
        String inputText = """
                @cableadoSR+1->SR
                instrucciones {
                    instruccion1(){
                     [PC+1->PC] PC+1->PC;
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
                $
                """;

        Runner helper = new Runner();
        assertThrows(RuntimeException.class, () -> {
            helper.run(inputText);
        });

        System.out.println(helper.getLogicText());

        assertEquals(outputRepositoryText,helper.getRepositoryText());
        assertCableLogic(helper.getLogicText(),outputLogicText);
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

    //TODO test de comprobar que no se pase argumento a quien no necesita
    //TODO test de comprobar que se pase argumento a quien lo necesita
    //TODO test que no se pueda utilizar instrucciones de tipo cable en microprogramado
    //TODO Comprobar que no haya la misma microinstrucciones en el mismo paso tanto en cableado como micro
    //TODO test que se pone bien cada cosa en su sección en la salida
    //TODO hacer test que compruebe que en microprogramado no se pueda hacer que haya una instrucción con bif con valor además de una instrucción con argumento
    //TODO hacer comprobraciones de valor máximo de arguumento de load sc y de arg de bif
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
        assertCableLogic(helper.getLogicText(),outputLogicText);
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
