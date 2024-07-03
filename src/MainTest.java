public class MainTest {

    public static void main(String[] args) {
        String programContent=
            """
            @cableado
            instrucciones {
                instruccion1(){
                    [SR+1->SR] PC+1->PC;
                }

                instruccion2 ( value ) {
                    [SR+1->SR] PC+1->PC;
                }

                instruccion3 ( dir ) {
                    [SR+1->SR] PC+1->PC;
                }
            }
            variables {
            }
            programa{}
            """;

        Runner runner = new Runner();
        runner.run(programContent);

        System.out.println("Repositorio");
        System.out.println(runner.getRepositoryText());
        System.out.println("Logica");
        System.out.println(runner.getLogicText());
        System.out.println("programa");
        System.out.println(runner.getProgramText());
    }

}
