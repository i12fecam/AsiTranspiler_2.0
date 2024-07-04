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
    public void mustAssumeSrPlusWhenOmitted(){
        String inputText = "@cableado\n" +
                "instrucciones {\n" +
                "    instruccion1(){\n" +
                "     [] PC+1->PC;\n" +
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
