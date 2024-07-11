import Analisis.LogicException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MicroInstructionsTest {
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
                CB 3000300
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
                CB 3000300
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
                CB 3000300
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
}
