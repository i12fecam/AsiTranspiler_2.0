import Analisis.*;
import CodeGeneration.BasicCodeGenerator;
import CodeGeneration.Cable.CableCodeGenerator;
import CodeGeneration.Micro.MicroCodeGenerator;
import Parsing.SicomeLexer;
import Parsing.SicomeParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.Token;

import java.nio.file.Path;

enum  ObjetiveConfig{
    LOGIC,
    INSTRUCTION_SET,
    ALL
}
enum VerbConfig{
    ANALYZE,
    COMPILE
}
record Config(
    VerbConfig verb,
    ObjetiveConfig obj,
    Path inputFilePath,
    Path outputPath,
    String outputName,
    Path includeInputFilePath
){
    public Config{
        if (outputName == null){
            outputName = inputFilePath.getFileName().toString().split("\\.")[0];
        }
    }

}
public class Runner {
    private BasicCodeGenerator res = null;
    private CommonTokenStream tokens = null;
    public void run(String fileContent){


        //Inicar parseado
        SicomeLexer lexer = new SicomeLexer(CharStreams.fromString(fileContent));
        tokens = new CommonTokenStream(lexer);
        SicomeParser parser = new SicomeParser(tokens);
        var tree = parser.prog();


        boolean isCable = switch (tree){
             case SicomeParser.CableProgramContext CableContext ->  true;
             case SicomeParser.MicroCableProgramContext microCableProgramContext-> false;
            default -> false;
        };
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

    public void printTokens(){
        tokens.fill();
        for (Token token : tokens.getTokens()) {
            String tokenName = SicomeLexer.VOCABULARY.getSymbolicName(token.getType());
            if (tokenName == null) {
                tokenName = SicomeLexer.VOCABULARY.getDisplayName(token.getType());
            }
            System.out.println("Token: " + tokenName + " (" + token.getText() + ")");
        }
    }
}
