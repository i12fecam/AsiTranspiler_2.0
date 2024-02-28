import Analisis.FirstPassListener;
import Analisis.SecondPassListener;
import Analisis.SymbolTable;
import CodeGeneration.CodeGenerationListener;
import Parsing.SicomeLexer;
import Parsing.SicomeParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {
    private static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readString(path);
    }
    public static void main(String[] args) throws IOException{
        /*
        asi copile programa.txt /folder
        asi test programa.txt
        asi help
         */
        if(args.length>0 && Objects.equals(args[0], "copile")){
            CodeGenerationListener cg = null;
            if(args.length>1){
                File program= new File(args[1]);
                cg=testProgram(program);
            }else{printHelp();}

            if(args.length>2){
                saveResults(args[2],cg.getRepositoryFileString(),cg.getLogicFileString(), cg.getProgramFileString());
            }

        } else if (args.length>0 && Objects.equals(args[0], "test")) {
            if(args.length>1){
                File program= new File(args[1]);
                testProgram(program);
            }else{printHelp();}
        } else if (args.length>0 && Objects.equals(args[0], "help")) {
            printHelp();
        }


    }

    private static void printHelp() {
    }


    private static boolean saveResults(String FolderPath, String repositoryContent, String logicContent, String programContent) {
        try {
            File baseFolder = new File(FolderPath);
            String commonName= baseFolder.getName();
            if (baseFolder.exists()) {
                System.out.println("Directory already exists. Skipping creation.");
                return false;
            }

            if (baseFolder.mkdir()) {
                System.out.println("Base folder created: " + baseFolder.getAbsolutePath());

                // Create dummy files inside the base folder
                createFile(baseFolder, commonName + ".rep",repositoryContent);
                createFile(baseFolder, commonName + ".lcb",logicContent);
                createFile(baseFolder, commonName + ".txt",programContent);

                return true;
            } else {
                System.err.println("Failed to create base folder.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void createFile(File parentFolder, String fileName, String fileContent) {
        File file = new File(parentFolder, fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
                FileWriter writer = new FileWriter(file);
                writer.write(fileContent);
                writer.close();
            } else {
                System.err.println("Failed to create file: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("IOException while creating file: " + e.getMessage());
        }
    }
    private static CodeGenerationListener testProgram(File programFile)  {
        String programContent;
        try {
            programContent =readFileContent(programFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Inicar parseado
        SicomeLexer lexer = new SicomeLexer(CharStreams.fromString(programContent));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SicomeParser parser = new SicomeParser(tokens);
        ParseTree tree = parser.prog();

        //Iniciar walker
        ParseTreeWalker walker = new ParseTreeWalker();
        FirstPassListener fpass = new FirstPassListener();
        walker.walk(fpass,tree);

        SymbolTable symbols = fpass.getSymbolTable();
        ParseTreeProperty<Integer> ids = fpass.getIds();

        SecondPassListener spass = new SecondPassListener(ids,symbols);
        walker.walk(spass,tree);
        CodeGenerationListener cpass = new CodeGenerationListener(ids,symbols);
        walker.walk(cpass,tree);
        return cpass;
    }

    public static String readFileContent(File file) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        return content.toString();
    }

}