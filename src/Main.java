import Runner.ObjetiveConfig;
import Runner.VerbConfig;

import Runner.Runner;
import picocli.CommandLine;
import picocli.CommandLine.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class Main {
    private static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readString(path);
    }


    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static Runner runner = new Runner();


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

        String fileContent1 = readFileContent(file);
        String fileContent2 = null;
        if (includedFile != null)  fileContent2 = readFileContent(includedFile);
        if(name == null) name = file.getName();

        try{
            runner.run(fileContent1,objetive,fileContent2);
        } catch (RuntimeException e) {
            //System.out.println(e);
            runner.printErrors(true);
        }


        switch (verb){
            case ANALYZE -> {
                //DO NOTHING
            }
            case COMPILE -> {
                if(!runner.canCompile()){
                    System.out.println("No se puede convertir los archivos debido a los errores encontrados.");
                    return 1;
                }
                switch (objetive){
                    case LOGIC -> {
                        createFile(outputPath,name + ".lcb", runner.getLogicText());
                    }
                    case INSTRUCTION_SET -> {
                        createFile(outputPath,name + ".lcb", runner.getLogicText());
                        createFile(outputPath,name +".rep",runner.getRepositoryText());
                    }
                    case ALL ->{
                        createFile(outputPath,name + ".lcb", runner.getLogicText());
                        createFile(outputPath,name +".rep",runner.getRepositoryText());
                        createFile(outputPath,name + ".prog",runner.getProgramText());
                    }
                }
            }
        }
        return 1;// your business logic goes here...
}

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        int exitCode = new CommandLine(new AsiTranspiler()).execute(args);
        System.exit(exitCode);
    }
}


    private static void createFile(Path parentFolder, String fileName, String fileContent) {
        File file = new File(parentFolder.toFile(), fileName);
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