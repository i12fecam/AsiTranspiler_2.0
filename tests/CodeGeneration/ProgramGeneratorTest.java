package CodeGeneration;

import static org.junit.jupiter.api.Assertions.*;

class ProgramGeneratorTest {

    String test1= """
            @cableado
            instrucciones {
                instruccion1(){
                    [SR+1->SR] PC+1->PC;
                }
            }

            variables{
                variable1 = 95 ;
                variableHexadecimal = 0x13E ;
                vector[3] = {1} ;
                vector[4] = {1,2,3,4} ;
            }

            programa{

            }""";
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void getText() {
    }

    @org.junit.jupiter.api.Test
    void addInstructionUse() {
    }
}