import Analisis.LogicException;

public class MainTest {

    public static void main(String[] args) {
        String programContent=
            """
            estados{
                 inc ->  INCR
                 bif ->  BIF
                 ret -> RET
                 bif1 -> {
                    F, Zb, Za, Zac, Zsc, X, Qn, Qn1, As, Qs, Bs, N: INCR
                    !F, !Zb, !Za, !Zac, !Zsc, !X, !Qn, !Qn1, !As, !Qs, !Bs, !N: BIF
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

        Runner runner = new Runner();
        try {
            runner.run(programContent);
        }catch (RuntimeException e){

        }




        runner.printTokens();

        System.out.println("Repositorio");
        System.out.println(runner.getRepositoryText());
        System.out.println("Logica");
        System.out.println(runner.getLogicText());
        System.out.println("programa");
        System.out.println(runner.getProgramText());
    }

}
