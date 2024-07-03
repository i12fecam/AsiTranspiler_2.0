import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

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

    String outputRepositoryText = "instruccion1 true 0 q0\n";


        TestHelper helper = new TestHelper();
        helper.startTest(inputText);
        System.out.println(helper.getRepositoryText());
        assertEquals(helper.getRepositoryText(),outputRepositoryText);
    }

    public void mustHaveArgumentIfIsDir(){}

    public void mustHaveArgumentIfIsVar(){
    }

    public void musntHaveArgumentIfIsNone(){}


    public void mustProcessSimpleStep(){

    }

    public void mustAssumeSrPlusWhenOmitted(){

    }
}
