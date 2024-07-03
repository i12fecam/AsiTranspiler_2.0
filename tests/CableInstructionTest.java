import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CableInstructionTest {

    @Test
    public void mustHaveArgumentIfIsValue(){
    String inputText = "@cableado\n" +
            "instrucciones {\n" +
            "    instruccion1(value){\n" +
            "     \n" +
            "    }" +
            "}";

    String outputRepositoryText = "instruccion1 false 1 q0";


        TestHelper helper = new TestHelper();
        helper.startTest(inputText);

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
