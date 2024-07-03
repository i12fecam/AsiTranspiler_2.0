import Analisis.CableAnalisis;
import Analisis.SymbolTable;
import CodeGeneration.CableCodeGenerator;
import Parsing.SicomeLexer;
import Parsing.SicomeParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class MainTest {

    public static void main(String[] args) {
        /*String programContent=
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
        */
        String programContent = "@cableado\n" +
                "instrucciones {\n" +
                "    instruccion1(value){\n" +
                "     \n" +
                "    }" +
                "}" +
                "variables{}" +
                "programa{}";
        //Inicar parseado
        SicomeLexer lexer = new SicomeLexer(CharStreams.fromString(programContent));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SicomeParser parser = new SicomeParser(tokens);
        ParseTree tree = parser.prog();

        //Iniciar walker
        ParseTreeWalker walker = new ParseTreeWalker();
        CableAnalisis fpass = new CableAnalisis();
        walker.walk(fpass,tree);

        SymbolTable symbols = fpass.getSymbolTable();
        ParseTreeProperty<Integer> ids = fpass.getIds();

        //SecondPassListener spass = new SecondPassListener(ids,symbols);
        //walker.walk(spass,tree);
        CableCodeGenerator cpass = new CableCodeGenerator(ids,symbols);
        walker.walk(cpass,tree);

        System.out.println("Repositorio");
        System.out.println(cpass.getRepositoryFileString());
        System.out.println("Logica");
        System.out.println(cpass.getLogicFileString());
        System.out.println("programa");
        System.out.println(cpass.getProgramFileString());
    }

}
