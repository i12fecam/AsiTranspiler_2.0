import Analisis.LogicException;

public class MainTest {

    public static void main(String[] args) {
        String programContent=
            """
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
