package CodeGeneration;

import Analysis.LogicException;
import Internals.Errors.ErrorController;
import Internals.Errors.ErrorEnum;
import Internals.Instruction;
import Internals.SymbolTable;
import Internals.Variable;
import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import Internals.InstructionArgumentTypeEnum;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.List;

import static Analysis.HelperFunctions.parseNumber;
import static Internals.Errors.ErrorEnum.ESPACIO_MEMORIA_SUPERADO;
import static Internals.InstructionArgumentTypeEnum.Var;

public class ProgramCodeGenerator extends SicomeBaseListener {
    protected ParseTreeProperty<Integer> ids = null;
    protected SymbolTable symbols = null;
     public ProgramCodeGenerator(ParseTreeProperty<Integer> ids, SymbolTable st){
        this.ids = ids;
        symbols = st;
        program = new ProgramCodeGeneratorHelper(symbols);
    }



     ProgramCodeGeneratorHelper program;



    public String getProgramFileString() {return program.getText();}

    @Override
    public void enterProgramBlock(SicomeParser.ProgramBlockContext ctx){
        var programLines = ctx.programLine().stream()
                .filter(lineCtx -> lineCtx instanceof SicomeParser.InstructionUseContext)
                .count();
        var instructionSpace = symbols.getVariables().stream()
                                        .mapToLong(Variable::capacity)
                                        .sum();
        if (programLines + instructionSpace >= 2048){
            ErrorController.getInstance()
                    .addNewError(ESPACIO_MEMORIA_SUPERADO,List.of(), ctx.getStart());
        }
    }
    @Override
    public void exitInstructionUse(SicomeParser.InstructionUseContext ctx) {
        Token instrName =ctx.name;
        SicomeParser.InstructionUseArgumentContext arg =ctx.instructionUseArgument();
        InstructionArgumentTypeEnum expectedArg = symbols.getArgumentType(instrName.getText());
        if(expectedArg == null){
            ErrorController.getInstance()
                    .addNewError(ErrorEnum.INSTRUCCION_NO_DEFINIDA, List.of(instrName.getText()),ctx.name);
        }
        assert expectedArg != null;
        Integer paramNumber =null;

        switch (expectedArg){
            case Value -> {
                if(arg.num == null){
                    ErrorController.getInstance()
                            .addNewError(ErrorEnum.ARGUMENTO_DE_TIPO_VALOR_NO_ENCONTRADO, List.of(instrName.getText(), "\" \""),ctx.name);
                }

                paramNumber = parseNumber(arg.num.getText(),null);

                if(paramNumber >= 2048){
                    ErrorController.getInstance()
                            .addNewError(ErrorEnum.VALOR_ARGUMENTO_LITERAL_NO_VALIDO, List.of(),arg.num);

                }
            }
            case Var -> {

                if(arg.var == null){
                    ErrorController.getInstance()
                            .addNewError(ErrorEnum.ARGUMENTO_DE_TIPO_VARIABLE_NO_ENCONTRADO, List.of(instrName.getText(), "\" \""),ctx.name);
                }


                var variable_name = arg.var.getText();
                var offset_value = (arg.offset != null)
                    ? parseNumber(arg.offset.getText(),null)
                    : 0;

                if(symbols.isLabel(variable_name)){
                    ErrorController.getInstance()
                            .addNewError(ErrorEnum.ARGUMENTO_DE_TIPO_VARIABLE_NO_ENCONTRADO, List.of(instrName.getText(), "\" \""),ctx.name);
                }

                if(!symbols.isVariable(variable_name)){
                    ErrorController.getInstance()
                            .addNewError(ErrorEnum.VARIABLE_NO_DEFINIDA, List.of(instrName.getText(), "\" \""),ctx.name);
                }

                paramNumber = symbols.getPosFromVariable(variable_name,offset_value);

                if(paramNumber == -1){
                    ErrorController.getInstance()
                            .addNewError(ErrorEnum.INDICE_ARGUMENTO_VECTOR_INVALIDO, List.of(variable_name, "\" \""),ctx.name);
                }

            }
            case Dir -> {

                if(arg.var == null){
                    ErrorController.getInstance()
                            .addNewError(ErrorEnum.ARGUMENTO_DE_TIPO_DIRECCION_NO_ENCONTRADO, List.of(instrName.getText(), "\" \""),ctx.name);
                }

                var dir_name = arg.var.getText();

                if(symbols.isVariable(dir_name)){
                    ErrorController.getInstance()
                            .addNewError(ErrorEnum.ARGUMENTO_DE_TIPO_DIRECCION_NO_ENCONTRADO, List.of(instrName.getText(), "\" \""),ctx.name);
                }
                if(!symbols.isLabel(dir_name)){
                    ErrorController.getInstance()
                            .addNewError(ErrorEnum.ETIQUETA_NO_DEFINIDA, List.of(instrName.getText(), "\" \""),ctx.name);
                }

                paramNumber = symbols.getPosFromLabel(dir_name);

            }


            case None -> {
                if(arg.var!= null || arg.num!= null || arg.offset!=null){
                    ErrorController.getInstance()
                            .addNewError(ErrorEnum.ARGUMENTO_INSTRUCCION_INNECESARIO, List.of(instrName.getText(), "\" \""),ctx.name);
                }
            }
        }
        program.addInstructionUse(instrName.getText(),paramNumber);
    }
}
