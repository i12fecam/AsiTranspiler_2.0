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
        System.out.println(getMicroInstructionTable());
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

    public  String getTestTable(){
        var res = new StringBuilder();
        res.append("""
                 \\begin{tabular}{|l|p{0.8\\textwidth}|}
                 Nombre | Descripción \\\\
                 \\hline
                 """);
        res.append("CableInstructionTest");
        getTestInfo("SemanticTests.CableInstructionTest").forEach(i ->{
            res.append(i.name()).append(" & ");
            res.append(i.description()).append(" \\\\");
            res.append("\\hline");

        });
        return res.toString();
    }

    private List<testInfo> getTestInfo(String className){
        try {
            var test = Class.forName(className);
            return Arrays.stream(test.getMethods())
                    .filter(m -> {
                        return m.isAnnotationPresent(Test.class) ||
                                m.isAnnotationPresent(ParameterizedTest.class);
                    })
                    .map(m ->
                            new testInfo(m.getName(),
                                    m.getAnnotation(DisplayName.class).value()))
                    .toList();
        }catch (RuntimeException | ClassNotFoundException e){

        }
        return null;
    }
    record testInfo(String name, String description){}






}
