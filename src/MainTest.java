import Analisis.LogicException;

public class MainTest {

    public static void main(String[] args) {
        String programContent=
            """
            @cableado
                instrucciones {
                    instruccion1(){
                        {
                            X : [SR+1->SR] PC->MAR;
                            As: [SR+1->SR LOAD_SC(3)] 0->ACC;
                        }
                        [LOAD_SR(START)] !ACC->ACC;
                    }
                }
                variables{
                }
                programa{
                }
            """;

        Runner runner = new Runner();

            runner.run(programContent);



        runner.printTokens();

        System.out.println("Repositorio");
        System.out.println(runner.getRepositoryText());
        System.out.println("Logica");
        System.out.println(runner.getLogicText());
        System.out.println("programa");
        System.out.println(runner.getProgramText());
    }

}
