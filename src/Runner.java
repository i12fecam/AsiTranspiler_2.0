import Analisis.*;
import CodeGeneration.BasicCodeGenerator;
import CodeGeneration.CableCodeGenerator;
import CodeGeneration.MicroCodeGenerator;
import Parsing.SicomeLexer;
import Parsing.SicomeParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Runner {
    private BasicCodeGenerator res = null;
    public void run(String fileContent){


        //Inicar parseado
        SicomeLexer lexer = new SicomeLexer(CharStreams.fromString(fileContent));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SicomeParser parser = new SicomeParser(tokens);
        var tree = parser.prog();

        //Se comprueba si es de tipo cable o no , si esta el bloque de estados sera de microcableado
        Boolean isCable = true;
        if (tree.getChildCount() == 4){
            isCable = false;
        }
        //Hacer analisis
        ParseTreeWalker walker = new ParseTreeWalker();

        BasicAnalisis fpass = null;
        if(isCable){
            fpass = new CableAnalisis();
        } else fpass = new MicroAnalisis();

        walker.walk(fpass,tree);

        SymbolTable symbols = fpass.getSymbolTable();
        ParseTreeProperty<Integer> ids = fpass.getIds();

        //Se hace generación de código
        BasicCodeGenerator cpass = null;
        if(isCable){
            cpass = new CableCodeGenerator(ids,symbols);
        }  else cpass = new MicroCodeGenerator(ids,symbols);

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
