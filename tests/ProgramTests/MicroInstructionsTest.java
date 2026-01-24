package ProgramTests;

import Analysis.LogicException;
import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Runner.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MicroInstructionsTest {

    @Test
    public void instruccionMismoNombre(){


        String inputText = """
            estados{
                 inc ->  INCR
            }
            
            @microinstruccion
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
        //ErrorController.getInstance().printToConsole(false);
        assertTrue(ErrorController.getInstance()
                .containsErrorEnum(ErrorEnum.INSTRUCCION_MISMO_NOMBRE));

    }
    @Test
    void MICROINSTRUCCION_NO_RECONOCIDA(){

    }
    @Test
    void emptyProgram(){
        String inputText = """
                estados{
                 inc ->  INCR
                }
                
                @microinstruccion
                instrucciones {
                    instruccion1(value){
                    
                    }
                }
                variables{}
                programa{}
                """;

        String outputRepositoryText = """
                $
                CB 4000100
                CB 0201100
                CB B000300
                $
                halt false 0
                instruccion1 true 0
                """;

        String outputLogicText = """
                B3 B2 B1 B0 F Zb Za Zac Zsc X Qn Qn1 As Qs Bs N I B R E
                0  0  0  0  X X  X  X   X   X X  X   X  X  X  X 1 0 0 1
                """;


        Runner helper = new Runner();
        helper.run(inputText);
        assertEquals(outputRepositoryText,helper.getRepositoryText());
        assertEquals(outputLogicText,helper.getLogicText());
    }

    @Test
    void StatusCheck(){
        String inputText = """
                estados{
                 inc ->  INCR
                 bif ->  BIF
                 ret -> RET
                 inc_disable -> INCR DISABLE
                 bif_disable -> BIF DISABLE
                 ret_disable -> RET DISABLE
                 
                 
                }
                
                @microinstruccion
                instrucciones {
                    instruccion1(value){
                    
                    }
                }
                variables{}
                programa{}
                """;

        String outputRepositoryText = """
                $
                CB 4000100
                CB 0201100
                CB B000300
                $
                halt false 0
                instruccion1 true 0
                """;

        String outputLogicText = """
                B3 B2 B1 B0 F Zb Za Zac Zsc X Qn Qn1 As Qs Bs N I B R E
                0  0  0  0  X X  X  X   X   X X  X   X  X  X  X 1 0 0 1
                0  0  0  1  X X  X  X   X   X X  X   X  X  X  X 0 1 0 1
                0  0  1  0  X X  X  X   X   X X  X   X  X  X  X 0 0 1 1
                0  0  1  1  X X  X  X   X   X X  X   X  X  X  X 1 0 0 0
                0  1  0  0  X X  X  X   X   X X  X   X  X  X  X 0 1 0 0
                0  1  0  1  X X  X  X   X   X X  X   X  X  X  X 0 0 1 0
                """;


        Runner helper = new Runner();
        helper.run(inputText);
        assertEquals(outputRepositoryText,helper.getRepositoryText());
        assertEquals(outputLogicText,helper.getLogicText());
    }

    @Test
    void ComplexStatusCheck(){
        String inputText = """
                estados{
                 inc ->  INCR
                 bif ->  BIF
                 ret -> RET
                 bif1 -> {
                    F, Zb, Za, Zac, Zsc, X, Qn, Qn+, As, Qs, Bs, N: INCR
                    !F, !Zb, !Za, !Zac, !Zsc, !X, !Qn, !Qn+, !As, !Qs, !Bs, !N: BIF
                    As: RET DISABLE
                 }
                 
                 
                }
                
                @microinstruccion
                instrucciones {
                    instruccion1(value){
                    
                    }
                }
                variables{}
                programa{}
                """;

        String outputRepositoryText = """
                $
                CB 4000100
                CB 0201100
                CB B000300
                $
                halt false 0
                instruccion1 true 0
                """;

        String outputLogicText = """
                B3 B2 B1 B0 F Zb Za Zac Zsc X Qn Qn1 As Qs Bs N I B R E
                0  0  0  0  X X  X  X   X   X X  X   X  X  X  X 1 0 0 1
                0  0  0  1  X X  X  X   X   X X  X   X  X  X  X 0 1 0 1
                0  0  1  0  X X  X  X   X   X X  X   X  X  X  X 0 0 1 1
                0  0  1  1  1 1  1  1   1   1 1  1   1  1  1  1 1 0 0 1
                0  0  1  1  0 0  0  0   0   0 0  0   0  0  0  0 0 1 0 1
                0  0  1  1  X X  X  X   X   X X  X   1  X  X  X 0 0 1 0
                """;


        Runner helper = new Runner();

        helper.run(inputText);


        assertEquals(outputRepositoryText,helper.getRepositoryText());
        assertEquals(outputLogicText,helper.getLogicText());
    }

    @Test
    void instructionCheck(){
        String inputText = """
                estados{
                 nop -> INCR DISABLE
                 inc ->  INCR
                 bif ->  BIF
                 ret -> RET
                 
                 
                 
                }
                
                @microinstruccion
                instrucciones {
                    push(value){
                          [inc] M->GPR SP-1->SP ;
                          [inc] SP->MAR;
                          [bif(0)] GPR->M;
                    }
                }
                variables{}
                programa{}
                """;

        String outputRepositoryText = """
                $
                CB 4000100
                CB 0201100
                CB B000300
                $
                halt false 0
                push true 801100 C000100 1000200      
                """;

        String outputLogicText = """
                B3 B2 B1 B0 F Zb Za Zac Zsc X Qn Qn1 As Qs Bs N I B R E
                0  0  0  0  X X  X  X   X   X X  X   X  X  X  X 1 0 0 0
                0  0  0  1  X X  X  X   X   X X  X   X  X  X  X 1 0 0 1
                0  0  1  0  X X  X  X   X   X X  X   X  X  X  X 0 1 0 1
                0  0  1  1  X X  X  X   X   X X  X   X  X  X  X 0 0 1 1
                """;


        Runner helper = new Runner();

        helper.run(inputText);




        assertEquals(outputRepositoryText,helper.getRepositoryText());
        assertEquals(outputLogicText,helper.getLogicText());
    }

    void mustHaveArgumentIfisVar(){
        String inputText = """
                estados{
                 nop -> INCR DISABLE
                 inc ->  INCR
                 bif ->  BIF
                 ret -> RET
                 
                 
                 
                }
                
                @microinstruccion
                instrucciones {
                    instruccion1(var){
                    
                    }
                    instruccion2(value){
                    
                    }
                    instruccion3(dir){
                    
                    }
                    instruccion4(){
                    
                    }
                }
                variables{}
                programa{}
                """;

        String outputRepositoryText = """
                $
                CB 4000100
                CB 0201100
                CB B000300
                $
                halt false 0
                instruccion1 true 0
                instruccion2 true 0
                instruccion3
                """;

        String outputLogicText = """
                B3 B2 B1 B0 F Zb Za Zac Zsc X Qn Qn1 As Qs Bs N I B R E
                0  0  0  0  X X  X  X   X   X X  X   X  X  X  X 1 0 0 0
                0  0  0  1  X X  X  X   X   X X  X   X  X  X  X 1 0 0 1
                0  0  1  0  X X  X  X   X   X X  X   X  X  X  X 0 1 0 1
                0  0  1  1  X X  X  X   X   X X  X   X  X  X  X 0 0 1 1
                """;


        Runner helper = new Runner();

        helper.run(inputText);




        assertEquals(outputRepositoryText,helper.getRepositoryText());
        assertEquals(outputLogicText,helper.getLogicText());
    }
    void mustHaveArgumentIfisValue(){}
    void mustHaveArgumentIfisDir(){}
    void mustNotHaveArgumentIfisNone(){}

    public void mustAllowMicroInstructionsWithArguments(){}

    public void mustProhibitMaxValueMicroInstructionWithArguments(){}

    public void mustProhibitMicroInstructionsWithArgumentsDontNeeded(){}

    public void mustProhibitSameMicroInstructionInSameStep(){}

    public void mustProhibitMicroInstructionSameGroup(){}

    public void mustProhibitMicroInstructionOfTypeCable1(){}

    public void mustProhibitMicroInstructionOfTypeCable2(){}

    public void mustProhibitBifLogicWithArgumentDontNeed(){}
    public void mustAllowBifLogicWithArgument(){}
    public void mustProhibitBifLogicWithArgumentMaxValue1(){}
    public void mustProhibitBifLogicWithArgumentMaxValue2(){}

    public void mustProhibitBifWithArgumentAndMicroInstructionInSameStep(){}
    @Test
    void p2(){
        String inputText = """
                estados{
                 nop -> INCR DISABLE //0
                 inc ->  INCR //1
                 bif ->  BIF  //2
                 ret -> RET //3
                 jmp_if_Z -> { //4
                    !F:INCR
                     F:BIF
                 }
                 bif_disable_if_F ->{ //5
                    !F:BIF
                    F: BIF DISABLE
                 }
                 jmp_if_not_Zb -> { //6
                    !Zb:BIF
                     Zb:INCR
                 }
                 bif_and_disable_if_not_Zb -> { //7
                    !Zb:BIF DISABLE
                    Zb:BIF
                 }
                 jmp_and_disable_if_Zac -> { //8
                    !Zac: INCR
                    Zac: BIF DISABLE
                 }
                 bifurcate_and_disable_if_not_As -> { //9
                    !As: BIF DISABLE
                     As: BIF
                 }
                 continue_and_disable_if_As -> { //10
                    !As: INCR
                     As: INCR DISABLE
                 }
                    
                 jmp_and_disable_if_Zsc -> { //11
                    !Zsc:BIF DISABLE
                    Zsc:INCR
                 }
                 
                 continue_and_disable_if_Zb -> {  //12
                    !Zb:INCR
                    Zb: INCR DISABLE
                 }
                }
                
                @microinstruccion
                instrucciones {
                    isz(value){
                          [inc] M->GPR;
                          [inc] GPR+1->GPR;
                          [inc] GPR->M;
                          [jmp_if_not_Zb(0)] ;
                          [bif(0)] PC+1->PC;
                    }
                    isz_r(value){
                          [inc] M->GPR;
                          [inc] GPR+1->GPR;
                          [inc] GPR->M;
                          [bif_and_disable_if_not_Zb(0)] PC+1->PC;
                    }
                    push(value){
                        [inc] M->GPR SP-1->SP;
                        [inc] SP->MAR;
                        [bif(0)] GPR->M;
                    }
                    pop(value){
                        [inc] SP->MAR;
                        [inc] M->QR SP+1->SP;
                        [inc] GPR{AD}->MAR;
                        [bif(0)] QR->M;
                    }
                    push_i(value){
                        [inc] M->GPR SP-1->SP;
                        [inc] GPR{AD}->MAR;
                        [inc] M->GPR;
                        [inc] SP->MAR;
                        [bif(0)] GPR->M;
                    }
                    pop_i(value){
                        [inc] SP->MAR;
                        [inc] M->QR SP+1->SP;
                        [inc] GPR{AD}->MAR;
                        [inc] M->GPR;
                        [inc] GPR{AD}->MAR;
                        [bif(0)] QR->M;
                    }
                    jazpn(){
                        [jmp_and_disable_if_Zac(0)] PC+1->PC;
                        [bifurcate_and_disable_if_not_As(0)] PC+1->PC;
                    }
                    jmpr(dir){
                        [inc] GPR->QR SP-1->SP;
                        [inc] ACC->GPR SP->MAR;
                        [inc] GPR->M 0->ACC;
                        [inc] QR->GPR !ACC->ACC;
                        [inc] PC->GPR GPR->PC;
                        [inc] GPR+ACC->ACC;
                        [inc] PC->GPR;
                        [inc] GPR+ACC->ACC;
                        [inc] ACC->GPR;
                        [inc] GPR->PC 0->ACC;
                        [inc] M->GPR SP+1->SP;
                        [bif(0)] GPR+ACC->ACC;
                    }
                    
                    
                }
                variables{}
                programa{}
                """;

        String outputRepositoryText = """
                $
                CB 4000100
                CB 0201100
                CB B000300
                $
                halt false 0
                isz true 1100 4100 1000100 600 200200
                isz_r true 1100 4100 1000100 200700
                push true 801100 C000100 1000200
                pop true C000100 670100 8000100 2000200
                push_i true 801100 8000100 1100 C000100 1000200
                pop_i true C000100 670100 8000100 1100 8000100 2000200
                jazpn false 200800 200900
                jmpr true 868100 C002100 1008100 15100 403100 28100 3100 28100 2100 408100 601100 28200
                """;
                //JEG11 true 8000100 840100 C068100 AB2105 1008100 C90100 8B5D A90106 2100 8100 10C00 C98100 C000B63 1100 F100 28100 5100 28100 200A00 609100 28200

        String outputLogicText = """
                B3 B2 B1 B0 F Zb Za Zac Zsc X Qn Qn1 As Qs Bs N I B R E
                0  0  0  0  X X  X  X   X   X X  X   X  X  X  X 1 0 0 0
                0  0  0  1  X X  X  X   X   X X  X   X  X  X  X 1 0 0 1
                0  0  1  0  X X  X  X   X   X X  X   X  X  X  X 0 1 0 1
                0  0  1  1  X X  X  X   X   X X  X   X  X  X  X 0 0 1 1
                0  1  0  0  0 X  X  X   X   X X  X   X  X  X  X 1 0 0 1
                0  1  0  0  1 X  X  X   X   X X  X   X  X  X  X 0 1 0 1
                0  1  0  1  0 X  X  X   X   X X  X   X  X  X  X 0 1 0 1
                0  1  0  1  1 X  X  X   X   X X  X   X  X  X  X 0 1 0 0
                0  1  1  0  X 0  X  X   X   X X  X   X  X  X  X 0 1 0 1
                0  1  1  0  X 1  X  X   X   X X  X   X  X  X  X 1 0 0 1
                0  1  1  1  X 0  X  X   X   X X  X   X  X  X  X 0 1 0 0
                0  1  1  1  X 1  X  X   X   X X  X   X  X  X  X 0 1 0 1
                1  0  0  0  X X  X  0   X   X X  X   X  X  X  X 1 0 0 1
                1  0  0  0  X X  X  1   X   X X  X   X  X  X  X 0 1 0 0
                1  0  0  1  X X  X  X   X   X X  X   0  X  X  X 0 1 0 0
                1  0  0  1  X X  X  X   X   X X  X   1  X  X  X 0 1 0 1
                1  0  1  0  X X  X  X   X   X X  X   0  X  X  X 1 0 0 1
                1  0  1  0  X X  X  X   X   X X  X   1  X  X  X 1 0 0 0
                1  0  1  1  X X  X  X   0   X X  X   X  X  X  X 0 1 0 0
                1  0  1  1  X X  X  X   1   X X  X   X  X  X  X 1 0 0 1
                1  1  0  0  X 0  X  X   X   X X  X   X  X  X  X 1 0 0 1
                1  1  0  0  X 1  X  X   X   X X  X   X  X  X  X 1 0 0 0
                """;


        Runner helper = new Runner();
        try {
            helper.run(inputText);
        }catch (LogicException e){
            System.out.println(e.getMessage());
            System.out.println(e.getToken());
        }



        assertEquals(outputRepositoryText,helper.getRepositoryText());
        assertEquals(outputLogicText,helper.getLogicText());
    }

}
