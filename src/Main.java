import Analisis.FirstPassListener;
import Analisis.SecondPassListener;
import Analisis.SymbolTable;
import CodeGeneration.CodeGenerationListener;
import Parsing.SicomeLexer;
import Parsing.SicomeParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readString(path);
    }
    public static void main(String[] args) throws IOException{

        String filePath = "";
        String fileContent = "@cableado\n" +
                "instrucciones {\n" +
                "    instruccion1(){\n" +
                "        [SR+1->SR] PC+1->PC;\n" +
                "        [LOAD_SC ( 0 ) ] ACC->GPR;\n" +
                "        {\n" +
                "        Zsc : [LOAD_SR(0)] QR->GPR;\n" +
                "        !Zsc: [LOAD_SR(START)] M->QR;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "}";

        //fileContent = readFile(filePath);


        //System.err.println("Error reading the file" + ex.getMessage());

        SicomeLexer lexer = new SicomeLexer(CharStreams.fromString(fileContent));

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill(); // Ensure all tokens are loaded
        tokens.getTokens().forEach(System.out::println);

        SicomeParser parser = new SicomeParser(tokens);
        ParseTree tree = parser.prog();


        System.out.println(tree.toStringTree(parser));

        copileInstructions(tree);


    }

    private static void copileInstructions(ParseTree tree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        FirstPassListener fpass = new FirstPassListener();
        walker.walk(fpass,tree);

        SymbolTable symbols = fpass.getSymbolTable();
        ParseTreeProperty<Integer> ids = fpass.getIds();

        SecondPassListener spass = new SecondPassListener(ids,symbols);
        walker.walk(spass,tree);
        CodeGenerationListener cpass = new CodeGenerationListener(ids,symbols);
        walker.walk(cpass,tree);

        System.out.println("Lógica:");
        System.out.println(cpass.getLogicFileString());
        System.out.println("Repositorio:");
        System.out.println(cpass.getRepositoryFileString());
        System.out.println("Programa:");

    }
}