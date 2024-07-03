import Analisis.BasicAnalisis;
import Analisis.SecondPassListener;
import Analisis.SymbolTable;
import CodeGeneration.BasicCodeGenerator;
import Parsing.SicomeLexer;
import Parsing.SicomeParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class TestHelper {
    private BasicCodeGenerator res = null;
    public void startTest(String fileContent){


        //Inicar parseado
        SicomeLexer lexer = new SicomeLexer(CharStreams.fromString(fileContent));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SicomeParser parser = new SicomeParser(tokens);
        ParseTree tree = parser.prog();

        //Iniciar walker
        ParseTreeWalker walker = new ParseTreeWalker();
        BasicAnalisis fpass = new BasicAnalisis();
        walker.walk(fpass,tree);

        SymbolTable symbols = fpass.getSymbolTable();
        ParseTreeProperty<Integer> ids = fpass.getIds();

        SecondPassListener spass = new SecondPassListener(ids,symbols);
        walker.walk(spass,tree);
        BasicCodeGenerator cpass = new BasicCodeGenerator(ids,symbols);
        walker.walk(cpass,tree);
        res = cpass;
    }

    public String getRepositoryText(){

        return res.getRepositoryFileString();
    }

    public String getLogicText(){
        return res.getLogicFileString();
    }

    public String getProgramText(){
        return res.getProgramFileString();
    }
}
