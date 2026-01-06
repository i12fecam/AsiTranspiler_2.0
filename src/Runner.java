import Analisis.*;
import CodeGeneration.Micro.MicrocodeLogicGenerator;
import CodeGeneration.ProgramCodeGenerator;
import CodeGeneration.Cable.CableCodeGenerator;
import CodeGeneration.Micro.MicrocodeGenerator;
import Parsing.SicomeLexer;
import Parsing.SicomeParser;
import internals.SymbolTable;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

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
    String logicText;
    String repositoryText;
    String programText;
    public void run(String fileContent){
        run(fileContent,ObjetiveConfig.ALL,null);
    }
    public void run(String fileContent,ObjetiveConfig obj,String includeFileContent) {

        SicomeParser.ProgContext programTree = null;
        SicomeParser.ProgContext restTree = null;

        SicomeLexer lexerFile = new SicomeLexer(CharStreams.fromString(fileContent));
        var tokensFile = new CommonTokenStream(lexerFile);
        SicomeParser parserFile = new SicomeParser(tokensFile);
        programTree = parserFile.prog();
        restTree = programTree;

        if(includeFileContent != null){
            SicomeLexer lexerFile2 = new SicomeLexer(CharStreams.fromString(includeFileContent));
            var tokensFile2 = new CommonTokenStream(lexerFile2);
            SicomeParser parserFile2 = new SicomeParser(tokensFile2);
            restTree = parserFile2.prog();
        }



        var symbols = new SymbolTable();
        var ids = new ParseTreeProperty<Integer>();
        ParseTreeWalker walker = new ParseTreeWalker();

        switch (obj) {
            case LOGIC -> {
                switch (restTree){
                    case SicomeParser.MicroProgramableLogicContext ctx ->{
                        var analysisMicrocodeLogicPass = new MicrocodeLogicAnalisis(symbols);
                        walker.walk(analysisMicrocodeLogicPass, ctx.statusLogicBlock());

                        var microcodeLogicCodeGeneratorPass = new MicrocodeLogicGenerator(symbols);
                        walker.walk(microcodeLogicCodeGeneratorPass, restTree);

                        logicText = microcodeLogicCodeGeneratorPass.getLogicFileString();
                    }
                    case SicomeParser.MicroProgramableProgramContext ctx ->{
                        var analysisMicrocodeLogicPass = new MicrocodeLogicAnalisis(symbols);
                        walker.walk(analysisMicrocodeLogicPass, ctx.statusLogicBlock());

                        var microcodeLogicCodeGeneratorPass = new MicrocodeLogicGenerator(symbols);
                        walker.walk(microcodeLogicCodeGeneratorPass, restTree);

                        logicText = microcodeLogicCodeGeneratorPass.getLogicFileString();
                    }
                    default -> throw new RuntimeException("No existe el bloque necesario");
                }
            }
            case INSTRUCTION_SET -> {
                switch (restTree){
                    case SicomeParser.MicroProgramableProgramContext ctx -> {
                        var analysisMicrocodeLogicPass = new MicrocodeLogicAnalisis(symbols);
                        walker.walk(analysisMicrocodeLogicPass, ctx.statusLogicBlock());

                        var analysisMicroPass = new MicrocodeAnalisis(ids,symbols);
                        walker.walk(analysisMicroPass,ctx.microInstructionBlock());


                        //Code generation
                        var microcodeLogicCodeGeneratorPass = new MicrocodeLogicGenerator(symbols);
                        walker.walk(microcodeLogicCodeGeneratorPass, restTree);

                        logicText = microcodeLogicCodeGeneratorPass.getLogicFileString();

                        var microCodeGeneratorPass = new MicrocodeGenerator(ids, symbols);
                        walker.walk(microCodeGeneratorPass, restTree);

                        repositoryText = microCodeGeneratorPass.getRepositoryFileString();
                    }
                    case SicomeParser.CableProgramContext ctx-> {
                        var cableAnalysisPass = new CableAnalisis(ids,symbols);
                        walker.walk(cableAnalysisPass, restTree);

                        var cableCodeGeneratorPass = new CableCodeGenerator(ids, symbols);
                        walker.walk(cableCodeGeneratorPass, restTree);

                        logicText = cableCodeGeneratorPass.getLogicFileString();
                        repositoryText = cableCodeGeneratorPass.getRepositoryFileString();

                    }
                    default -> throw new RuntimeException("No existe el bloque necesario");
                }

            }
            case ALL -> {

                switch (restTree) {
                    case SicomeParser.MicroProgramableLogicContext ctx -> {
                        throw new RuntimeException("No existe los bloques necesarios");
                    }
                    case SicomeParser.MicroProgramableProgramContext ctx -> {
                        //analisis
                        var analysisMicrocodeLogicPass = new MicrocodeLogicAnalisis(symbols);
                        walker.walk(analysisMicrocodeLogicPass, ctx.statusLogicBlock());

                        var analysisMicroPass = new MicrocodeAnalisis(ids,symbols);
                        walker.walk(analysisMicroPass,ctx.microInstructionBlock());

                        var analysisProgram = new ProgramAnalysis(symbols,ids);
                        walker.walk(analysisProgram,programTree);

                        //Code generation
                        var microcodeLogicCodeGeneratorPass = new MicrocodeLogicGenerator(symbols);
                        walker.walk(microcodeLogicCodeGeneratorPass, restTree);

                        logicText = microcodeLogicCodeGeneratorPass.getLogicFileString();

                        var microCodeGeneratorPass = new MicrocodeGenerator(ids, symbols);
                        walker.walk(microCodeGeneratorPass, restTree);

                        repositoryText = microCodeGeneratorPass.getRepositoryFileString();

                        var codeGenerationProgramPass = new ProgramCodeGenerator(ids,symbols);
                        walker.walk(codeGenerationProgramPass,programTree);

                        programText = codeGenerationProgramPass.getProgramFileString();
                    }
                    case SicomeParser.CableProgramContext ctx -> {

                        var cableAnalysisPass = new CableAnalisis(ids,symbols);
                        walker.walk(cableAnalysisPass, restTree);

                        var programAnalysisPass = new ProgramAnalysis(symbols,ids);
                        walker.walk(programAnalysisPass,programTree);
                        var cableCodeGeneratorPass = new CableCodeGenerator(ids, symbols);
                        walker.walk(cableCodeGeneratorPass, restTree);

                        logicText = cableCodeGeneratorPass.getLogicFileString();
                        repositoryText = cableCodeGeneratorPass.getRepositoryFileString();

                        var programCodeGenerationPass = new ProgramCodeGenerator(ids,symbols);
                        walker.walk(programCodeGenerationPass,programTree);

                        programText = programCodeGenerationPass.getProgramFileString();

                    }

                    default -> throw new IllegalStateException("Unexpected value: ");
                }



            }


        }


    }

    public String getRepositoryText(){
        return repositoryText;
    }

    public String getLogicText(){
        return logicText;
    }

    public String getProgramText(){
        return programText;
    }

//    public void printTokens(){
//        tokens.fill();
//        for (Token token : tokens.getTokens()) {
//            String tokenName = SicomeLexer.VOCABULARY.getSymbolicName(token.getType());
//            if (tokenName == null) {
//                tokenName = SicomeLexer.VOCABULARY.getDisplayName(token.getType());
//            }
//            System.out.println("Token: " + tokenName + " (" + token.getText() + ")");
//        }
//    }
}
