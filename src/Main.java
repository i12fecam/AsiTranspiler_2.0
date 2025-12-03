import Analisis.LogicException;
import picocli.CommandLine;
import picocli.CommandLine.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.Callable;

public class Main {
    private static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readString(path);
    }


    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static Runner runner = new Runner();


//    public static void main(String[] args) throws IOException{
//        /*
//        asi copile programa.txt /folder
//        asi test programa.txt
//        asi help
//         */
//        try {
//            if (args.length > 0 && Objects.equals(args[0], "copile")) {
//
//                if (args.length > 1) {
//                    File program = new File(args[1]);
//                    String fileContent = readFileContent(program);
//                    runner.run(fileContent);
//                } else {
//                    printHelp();
//                }
//
//                if (args.length > 2) {
//                    saveResults(args[2], runner.getRepositoryText(), runner.getLogicText(), runner.getProgramText());
//                }
//
//            } else if (args.length > 0 && Objects.equals(args[0], "test")) {
//                if (args.length > 1) {
//                    File program = new File(args[1]);
//                    String fileContent = readFileContent(program);
//                    runner.run(fileContent);
//                } else {
//                    printHelp();
//                }
//            } else if (args.length > 0 && Objects.equals(args[0], "help")) {
//                printHelp();
//            } else {
//                printHelp();
//
//            }
//        }catch (LogicException e){
//            System.out.println(ANSI_RED+ "line "+e.getLine()+":"+e.getCharInLine()+" "+ e.getMessage()+ANSI_RESET);
//
//        }
//
//
//    }
@Command(name = "AsiTranspiler", mixinStandardHelpOptions = true, version = "AsiTranspiler 0.4",
        description = "Covierte archivos .asi a archivos .lcb, .rep, .prog para ser utilizados con el programa SICOME.")
static class AsiTranspiler implements Callable<Integer> {


    @Parameters(index = "0",description = "La acción a realizar")
    VerbConfig verb;
    @Parameters(index = "1",description = "Que objetivo tendrá a compilar")
    ObjetiveConfig objetive;
    @Parameters(index = "2", description = "El archivo a compilar")
    private File file;

    @Parameters(index="3",description = "El directorio donde se creará los nuevos archivos")
    private Path outputPath;

    @Option(names = {"-n", "--nombre"}, description = "El nombre de los archivos a crear")
    private String name;

    @Option(names = {"-i", "--incluir"}, description = "Archivo que utilizar para repertorio y lógica")
    private File includedFile;
    @Override
    public Integer call() throws Exception {
        Runner runner = new Runner();
        String fileContent = readFileContent(file);

        return 1;// your business logic goes here...
}

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        int exitCode = new CommandLine(new AsiTranspiler()).execute(args);
        System.exit(exitCode);
    }
}


//    public static void main(String[] args){
//        var errController = new ErrorController();
//        VerbConfig verb;
//        ObjetiveConfig obj;
//        Path inputFilePath;
//        Path outputPath;
//        String outputName;
//        Path includeInputFilePath;
//
//        switch (args[0]){
//            case "analizar":
//                verb = VerbConfig.ANALYZE;
//                break;
//            case "compilar":
//                verb = VerbConfig.COMPILE;
//
//            case null,default:
//                throw new RuntimeException("Error detecting verb");
//        }
//
//        obj = switch (args[1]) {
//            case "logica" -> ObjetiveConfig.LOGIC;
//            case "repertorio" -> ObjetiveConfig.INSTRUCTION_SET;
//            case "todo" -> ObjetiveConfig.ALL;
//            case null, default -> throw new RuntimeException("Error detecting objetive");
//        };
//
//        //var config = new Config()
//
//    }

    private static void printHelp() {
        String text=
                """
                Funcionamiento de AST
                ast test programaAst.txt
                ast copile programaAst.txt dir/to/output
                
                """;
        System.out.println(text);
    }


    private static boolean saveResults(String FolderPath, String repositoryContent, String logicContent, String programContent) {
        try {
            File baseFolder = new File(FolderPath);
            String commonName= baseFolder.getName();
            if (baseFolder.exists()) {
                System.out.println("El directorio ya existe, no se volvera a crear.");//Hace a pesar de que exista?
                return false;
            }

            if (baseFolder.mkdir()) {
                System.out.println("Carpeta creada en: " + baseFolder.getAbsolutePath());


                createFile(baseFolder, commonName + ".rep",repositoryContent);
                createFile(baseFolder, commonName + ".lcb",logicContent);
                createFile(baseFolder, commonName + ".txt",programContent);

                return true;
            } else {
                System.err.println("Hubo un fallo al crear la carpeta.");
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
                System.out.println("Archivo creado en: " + file.getAbsolutePath());
                FileWriter writer = new FileWriter(file);
                writer.write(fileContent);
                writer.close();
            } else {
                System.err.println("Hubo un problema creando el archivo en: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Hubo un problema creando el archivo: " + e.getMessage());
        }
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