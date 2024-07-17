package CodeGeneration.Micro;

import Analisis.SymbolTable;
import internals.Function;
import internals.FunctionArg;
import internals.MicroInstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MicroRepositoryHelper {

    private Map<Integer,ArrayList<Integer>> repo = new HashMap<>();

    private SymbolTable _symbols;
    MicroRepositoryHelper(SymbolTable symbolTable){
        _symbols=symbolTable;
        var functions = _symbols.getFunctions();
        for(var func:functions){
            repo.put(func.getId(),new ArrayList<Integer>(func.getNSteps()));
            for(int i=0;i<func.getNSteps();i++){
                repo.get(func.getId()).add(0);
            }
        }
    }
    public void associateControlFlow(int functionId, int stepId, int controlFlowIdentifier){
        int num = repo.get(functionId).get(stepId);
        num+=controlFlowIdentifier*Math.pow(2,8);
        repo.get(functionId).set(stepId,num);

    }
    public void associateMicroInstruction(int functionId, int stepId, MicroInstruction microInstruction){
        int num = repo.get(functionId).get(stepId);
        num+=microInstruction.microCode;
        repo.get(functionId).set(stepId,num);

    }
    public void associateSCvalue(int functionId, int stepId,int value){
        int num = repo.get(functionId).get(stepId);
        num+=value;
        repo.get(functionId).set(stepId,num);

    }
    public void associateBifValue(int functionId,int stepId,int value){
        int num = repo.get(functionId).get(stepId);
        num+=value;
        repo.get(functionId).set(stepId,num);
    }

    public String getText(){
        StringBuilder builder = new StringBuilder();

        builder.append("$\n" +
                "CB 4000100\n" +
                "CB 0201100\n" +
                "CB B000300\n" +
                "$\n");
        for(var entry:repo.entrySet()){
            int functionId =entry.getKey();
            Function fun =_symbols.getFunctionByName(functionId);
            builder.append(fun.getName()).append(" ");


            if(fun.getParam().equals(FunctionArg.None)){
                builder.append("false");
            }else{
                builder.append("true");
            }


            if(entry.getValue().size() == 0){
                builder.append(" ");
                builder.append("0");
            }
            else{
                for(var StepCode:entry.getValue()){
                    builder.append(" ");
                    builder.append(Integer.toHexString(StepCode).toUpperCase());

                }
            }

            builder.append("\n");
        }

        return builder.toString();
    }
}
