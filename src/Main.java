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




    }
}