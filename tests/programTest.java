import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class programTest {

    @Test
    void oneInstructionProgram(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1(){
                    
                    }
                }
                variables{
                
                }
                programa{
                instruccion1;
                }
               """;



        String outputProgramText = """
                @
                0
                @
                instruccion1
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        assertEquals(outputProgramText,helper.getProgramText());
    }
    @Test
    void usingHaltInstruction(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1(){
                    
                    }
                }
                variables{
                
                }
                programa{
                instruccion1;
                halt;
                }
               """;



        String outputProgramText = """
                @
                0
                @
                instruccion1
                halt
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        assertEquals(outputProgramText,helper.getProgramText());
    }
    @Test
    void declaringSimpleVariable(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1(){
                    
                    }
                }
                variables{
                a = 5;
                b= 10;
                c = 15;
                d = 0xA1;
                }
                programa{
                instruccion1;
                halt;
                }
               """;



        String outputProgramText = """
                0 5
                1 A
                2 F
                3 A1
                @
                4
                @
                instruccion1
                halt
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        assertEquals(outputProgramText,helper.getProgramText());
    }
    @Test
    void declaringVectorVariableFill(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1(){
                    
                    }
                }
                variables{
                a [5] = {5};
                b= 10;
                }
                programa{
                instruccion1;
                halt;
                }
               """;



        String outputProgramText = """
                0 5
                1 5
                2 5
                3 5
                4 5
                5 A
                @
                6
                @
                instruccion1
                halt
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        assertEquals(outputProgramText,helper.getProgramText());
    }
    @Test
    void declaringVectorVariableExact(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1(){
                    
                    }
                }
                variables{
                a [5] = {0,1,2,3,4};
                b= 10;
                }
                programa{
                instruccion1;
                halt;
                }
               """;



        String outputProgramText = """
                0 0
                1 1
                2 2
                3 3
                4 4
                5 A
                @
                6
                @
                instruccion1
                halt
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        assertEquals(outputProgramText,helper.getProgramText());
    }
    @Test
    void usingSimpleVariable(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1( var ){
                    
                    }
                }
                variables{
                a = 1;
                b = 10;
                }
                programa{
                instruccion1 a;
                halt;
                }
               """;



        String outputProgramText = """
                0 1
                1 A
                @
                2
                @
                instruccion1 0
                halt
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        assertEquals(outputProgramText,helper.getProgramText());
    }

    void usingVectorVariable(){

    }

    void usingLiteralDecimalArgument(){

    }

    void usingLiteralHexadecimalArgument(){

    }

    void usingMarks(){

    }

}
