package FullProgramTests;

import Analysis.LogicException;
import Internals.Errors.ErrorController;
import Runner.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramTest {

    private final Runner helper = new Runner();

    @Test
    void oneInstructionProgram(){
        String inputText = """
               @cableado
                instrucciones {
                    fetch{
                       |SR+1->SR|;          
                    }
                    instruccion1(var){
                    
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
                @
                """;
        try {
            Runner helper = new Runner();
            helper.run(inputText);

        }catch (RuntimeException e) {
            helper.printErrors(true);
            throw e;
        }
        //assertEquals(outputProgramText,helper.getProgramText());
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
                @
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
                @
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
                a [10] = {5};
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
                5 5
                6 5
                7 5
                8 5
                9 5
                A A
                @
                B
                @
                instruccion1
                halt
                @
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
                @
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
                @
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        assertEquals(outputProgramText,helper.getProgramText());
    }

    // Debido a que el lexer solo acepta números postivos se convierte en un error del lexer
    //@Test
    void usingVectorVariableNegativeIndex(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1( var ){
                    
                    }
                }
                variables{
                    v1 [5] = {1};
                    v2 [3] = {10};
                }
                programa{
                    instruccion1 v1[-1];
                    instruccion1 v2[-1];
                    halt;
                }
               """;


        Runner helper = new Runner();
        assertThrows(LogicException.class , () -> helper.run(inputText));

        //assertEquals(outputProgramText,helper.getProgramText());
    }
    @Test
    void usingVectorVariableZeroIndex(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1( var ){
                    
                    }
                }
                variables{
                v1 [5] = {1};
                v2 [3] = {10};
                }
                programa{
                instruccion1 v1[0];
                instruccion1 v2[0];
                halt;
                }
               """;



        String outputProgramText = """
                0 1
                1 1
                2 1
                3 1
                4 1
                5 A
                6 A
                7 A
                @
                8
                @
                instruccion1 0
                instruccion1 5
                halt
                @
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        assertEquals(outputProgramText,helper.getProgramText());
    }
    @Test
    void usingVectorVariableMaxIndex(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1( var ){
                    
                    }
                }
                variables{
                v1 [5] = {1};
                v2 [3] = {10};
                }
                programa{
                instruccion1 v1[4];
                instruccion1 v2[2];
                halt;
                }
               """;



        String outputProgramText = """
                0 1
                1 1
                2 1
                3 1
                4 1
                5 A
                6 A
                7 A
                @
                8
                @
                instruccion1 4
                instruccion1 7
                halt
                @
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        assertEquals(outputProgramText,helper.getProgramText());
    }
    @Test
    void usingVectorVariableOutOfIndex(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1( var ){
                    
                    }
                }
                variables{
                    v1 [5] = {1};
                    v2 [3] = {10};
                }
                programa{
                    instruccion1 v1[5];
                    instruccion1 v2[3];
                    halt;
                }
               """;


        Runner helper = new Runner();
        assertThrows(LogicException.class , () -> helper.run(inputText));

        //assertEquals(outputProgramText,helper.getProgramText());
    }
    @Test
    void usingValueArgument(){
        String inputText = """
                @cableado
                instrucciones {
                    instruccion1( value ){
                    
                    }
                }
                variables{
                    
                }
                programa{
                    instruccion1 10;
                    instruccion1 0xA1;
                    halt;
                }
               """;



        String outputProgramText = """
                @
                0
                @
                instruccion1 A
                instruccion1 A1
                halt
                @
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        assertEquals(outputProgramText,helper.getProgramText());
    }

    void usingValueArgumentWhenValue(){}
    void usingVarArgumentWhenValue(){}
    void usingDirArgumentWhenValue(){}
    void usingNoneArgumentWhenValue(){}

    void usingValueArgumentWhenVar(){}
    void usingVarArgumentWhenVar(){}
    void usingDirArgumentWhenVar(){}
    void usingNoneArgumentWhenVar(){}

    void usingValueArgumentWhenDir(){}
    void usingVarArgumentWhenDir(){}
    void usingDirArgumentWhenDir(){}
    void usingNoneArgumentWhenDir(){}

    void usingValueArgumentWhenNone(){}
    void usingVarArgumentWhenNone(){}
    void usingDirArgumentWhenNone(){}
    void usingNoneArgumentWhenNone(){}


    @Test
    void usingMarks(){
        String inputText = """
                @cableado
                instrucciones {
                    jmp( dir ){
                    
                    }
                }
                variables{
                    a[9] = {0};
                }
                programa{
                    MARK inicio;
                        jmp inicio;
                    MARK medio;
                        jmp medio;
                    MARK final;
                        jmp final;
                        halt;
                }
               """;



        String outputProgramText = """
                0 0
                1 0
                2 0
                3 0
                4 0
                5 0
                6 0
                7 0
                8 0
                @
                9
                @
                jmp 9
                jmp A
                jmp B
                halt
                @
                """;

        Runner helper = new Runner();
        helper.run(inputText);

        assertEquals(outputProgramText,helper.getProgramText());
    }

}
