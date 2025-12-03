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
        run(fileContent,ObjetiveConfig.ALL);
    }
    public void run(String fileContent,ObjetiveConfig obj) {

        ParseTreeWalker walker = new ParseTreeWalker();

        SicomeLexer lexer = new SicomeLexer(CharStreams.fromString(fileContent));
        tokens = new CommonTokenStream(lexer);
        SicomeParser parser = new SicomeParser(tokens);
        var tree = parser.prog();

        switch (obj) {
            case LOGIC -> {
                //Por hacer
            }
            case INSTRUCTION_SET -> {
                //Por hacer
            }
            case ALL -> {
                //Hacer fase de analisis

                switch (tree) {
                    case SicomeParser.MicroProgramableLogicContext ctx -> {
                        throw new RuntimeException("No se puede compilar");
                    }
                    case SicomeParser.MicroProgramableProgramContext ctx -> {
                        var analysisPass = new MicroAnalisis();
                        walker.walk(analysisPass, tree);

                        var symbols = analysisPass.getSymbolTable();
                        var ids = analysisPass.getIds();

                        var codeGenerationPass = new MicroCodeGenerator(ids, symbols);
                        walker.walk(codeGenerationPass, tree);

                        res = codeGenerationPass;
                    }
                    case SicomeParser.CableProgramContext ctx -> {
                        var analysisPass = new CableAnalisis();
                        walker.walk(analysisPass, tree);

                        var symbols = analysisPass.getSymbolTable();
                        var ids = analysisPass.getIds();

                        var codeGenerationPass = new CableCodeGenerator(ids, symbols);
                        walker.walk(codeGenerationPass, tree);

                        res = codeGenerationPass;
                    }

                    default -> throw new IllegalStateException("Unexpected value: " + tree);
                }

                //Hacer pass de analisis de logica de micro
                //Hacer pass de analisis de micro/cableado
                //Hacer pass de analisis de programa
                //Hacer pass de codegen de micro/cableado
                //Hacer pass de codegen de programa (controlar si se hace con include


            }


        }


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
