package DocumentationPrinter;

import Internals.FlagEnum;
import Internals.MicroInstructionEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintDocumentation {
     public static void main(String[] args) {
        //System.out.println(getMicroInstructionTable());
         System.out.println(getTestTable());
    }

    public static String getMicroInstructionTable(){
         var res = new StringBuilder();
         res.append("""
                 \\begin{tabular}{|l|p{0.8\\textwidth}|}
                 nombre | equivalente SICOME | Grupo \
                 
                 """);
        Arrays.stream(MicroInstructionEnum.values()).forEach(microInstruction ->{
            res
            .append(microInstruction.inputName)
            .append(" & ")
            .append(microInstruction.outputName)
            .append(" & ")
            .append(microInstruction.getType().name())
            .append("\n").append("\\\\").append("\\hline");
        });
        return res.toString();
    }

    public static String getFlagTable(){
        var res = new StringBuilder();
        res.append("""
                 \\begin{tabular}{|l|p{0.8\\textwidth}|}
                 nombre | equivalente SICOME \
                 
                 """);
        Arrays.stream(FlagEnum.values()).forEach(flag ->{
            res
                    .append(flag.inputName)
                    .append(" & ")
                    .append(flag.outputName)
                    .append("\n").append("\\\\").append("\\hline");
        });
        return res.toString();
    }

    public static String getTestTable(){
        var res = new StringBuilder();
        res.append("""
                \\begin{longtable}{|p{0.4\\textwidth}|p{0.6\\textwidth}|}
                \\hline
                 Nombre & Descripción \\\\
                 \\hline
                 """);

        res.append("""
        \\hline
        \\multicolumn{2}{|c|}{MicroLogicInstructionTest} \\\\ \n
        \\hline
        """);
        getTestInfo("SemanticTests.MicroLogicInstructionTest").forEach(i ->{
            res.append(i.name()).append(" & ");
            res.append(i.description()).append(" \\\\");
            res.append("\\hline\n");

        });

        res.append("""
        \\hline
        \\multicolumn{2}{|c|}{MicroInstructionTest} \\\\ \n
        \\hline
        """);
        getTestInfo("SemanticTests.MicroInstructionsTest").forEach(i ->{
            res.append(i.name()).append(" & ");
            res.append(i.description()).append(" \\\\");
            res.append("\\hline\n");

        });

        res.append("""
        \\hline
        \\multicolumn{2}{|c|}{CableInstructionTest} \\\\ \n
        \\hline
        """);
        getTestInfo("SemanticTests.CableInstructionTest").forEach(i ->{
            res.append(i.name()).append(" & ");
            res.append(i.description()).append(" \\\\");
            res.append("\\hline\n");

        });

        res.append("""
        \\hline
        \\multicolumn{2}{|c|}{ProgramTest} \\\\ \n
        \\hline
        """);
        getTestInfo("SemanticTests.ProgramTest").forEach(i ->{
            res.append(i.name()).append(" & ");
            res.append(i.description()).append(" \\\\");
            res.append("\\hline\n");

        });

        res.append("\\end{longtable}");
        return res.toString().replace("_","\\allowbreak\\_");
    }

    private static List<testInfo> getTestInfo(String className){
        try {
            var test = Class.forName(className);
            return Arrays.stream(test.getDeclaredMethods())
                    //.peek(m -> System.out.println("Method: " + m.getName())) // Debug: Print method names
                    .filter(m -> {
                        return m.isAnnotationPresent(Test.class) ||
                                m.isAnnotationPresent(ParameterizedTest.class);
                    })
                    .sorted((m1, m2) -> {
                        return m1.getName().compareTo(m2.getName());

                        //return Integer.compare(test.getDeclaredMethods().indexOf(m1),
                        //                                test.getDeclaredMethods().indexOf(m2));
                    })
                    .map(m ->{
                        var description = (m.isAnnotationPresent(DisplayName.class))
                                ? m.getAnnotation(DisplayName.class).value()
                                : " ";
                        return new testInfo(m.getName(),description);
                    })

                    .toList();
        }catch (RuntimeException | ClassNotFoundException e){
            System.out.println(e);
        }
        return null;
    }
    record testInfo(String name, String description){}






}
