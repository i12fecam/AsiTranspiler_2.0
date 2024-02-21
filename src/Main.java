import Analisis.FirstPassListener;
import Analisis.SecondPassListener;
import CodeGeneration.CableLogicCodeGenerationListener;
import Parsing.SicomeLexer;
import Parsing.SicomeParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ANTLRInputStream input = new ANTLRInputStream(System.in);
        SicomeLexer lexer = new SicomeLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SicomeParser parser = new SicomeParser(tokens);
        ParseTree tree = parser.prog();


        System.out.println(tree.toStringTree(parser));

        copileInstructions(tree);


    }

    private static void copileInstructions(ParseTree tree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        FirstPassListener fpass = new FirstPassListener();
        walker.walk(fpass,tree);
        SecondPassListener spass = new SecondPassListener(fpass.getIds(), fpass.getSymbolTable());
        walker.walk(spass,tree);
        CableLogicCodeGenerationListener cpass = new CableLogicCodeGenerationListener(fpass.getIds());
        walker.walk(cpass,tree);

        System.out.println("Lógica:");
        System.out.println(cpass.getLogicFileString());
        System.out.println("Repositorio:");
        System.out.println(cpass.getRepositoryFileString());
    }
}