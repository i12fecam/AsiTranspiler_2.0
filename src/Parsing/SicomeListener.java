// Generated from /home/abi/Proyectos/SicomeTranspiler/grammar/Sicome.g4 by ANTLR 4.13.2
package Parsing;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SicomeParser}.
 */
public interface SicomeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code microProgramableLogic}
	 * labeled alternative in {@link SicomeParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterMicroProgramableLogic(SicomeParser.MicroProgramableLogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code microProgramableLogic}
	 * labeled alternative in {@link SicomeParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitMicroProgramableLogic(SicomeParser.MicroProgramableLogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cableProgram}
	 * labeled alternative in {@link SicomeParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterCableProgram(SicomeParser.CableProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cableProgram}
	 * labeled alternative in {@link SicomeParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitCableProgram(SicomeParser.CableProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code microProgramableProgram}
	 * labeled alternative in {@link SicomeParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterMicroProgramableProgram(SicomeParser.MicroProgramableProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code microProgramableProgram}
	 * labeled alternative in {@link SicomeParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitMicroProgramableProgram(SicomeParser.MicroProgramableProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#variablesBlock}.
	 * @param ctx the parse tree
	 */
	void enterVariablesBlock(SicomeParser.VariablesBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#variablesBlock}.
	 * @param ctx the parse tree
	 */
	void exitVariablesBlock(SicomeParser.VariablesBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleVariableDeclaration}
	 * labeled alternative in {@link SicomeParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSimpleVariableDeclaration(SicomeParser.SimpleVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleVariableDeclaration}
	 * labeled alternative in {@link SicomeParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSimpleVariableDeclaration(SicomeParser.SimpleVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorVariableDeclaration}
	 * labeled alternative in {@link SicomeParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVectorVariableDeclaration(SicomeParser.VectorVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorVariableDeclaration}
	 * labeled alternative in {@link SicomeParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVectorVariableDeclaration(SicomeParser.VectorVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#programBlock}.
	 * @param ctx the parse tree
	 */
	void enterProgramBlock(SicomeParser.ProgramBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#programBlock}.
	 * @param ctx the parse tree
	 */
	void exitProgramBlock(SicomeParser.ProgramBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instructionUse}
	 * labeled alternative in {@link SicomeParser#programLine}.
	 * @param ctx the parse tree
	 */
	void enterInstructionUse(SicomeParser.InstructionUseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instructionUse}
	 * labeled alternative in {@link SicomeParser#programLine}.
	 * @param ctx the parse tree
	 */
	void exitInstructionUse(SicomeParser.InstructionUseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code markUse}
	 * labeled alternative in {@link SicomeParser#programLine}.
	 * @param ctx the parse tree
	 */
	void enterMarkUse(SicomeParser.MarkUseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code markUse}
	 * labeled alternative in {@link SicomeParser#programLine}.
	 * @param ctx the parse tree
	 */
	void exitMarkUse(SicomeParser.MarkUseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#instructionUseArgument}.
	 * @param ctx the parse tree
	 */
	void enterInstructionUseArgument(SicomeParser.InstructionUseArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#instructionUseArgument}.
	 * @param ctx the parse tree
	 */
	void exitInstructionUseArgument(SicomeParser.InstructionUseArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#cableInstructionBlock}.
	 * @param ctx the parse tree
	 */
	void enterCableInstructionBlock(SicomeParser.CableInstructionBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#cableInstructionBlock}.
	 * @param ctx the parse tree
	 */
	void exitCableInstructionBlock(SicomeParser.CableInstructionBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#cableInstruction}.
	 * @param ctx the parse tree
	 */
	void enterCableInstruction(SicomeParser.CableInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#cableInstruction}.
	 * @param ctx the parse tree
	 */
	void exitCableInstruction(SicomeParser.CableInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#fetchCableInstruction}.
	 * @param ctx the parse tree
	 */
	void enterFetchCableInstruction(SicomeParser.FetchCableInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#fetchCableInstruction}.
	 * @param ctx the parse tree
	 */
	void exitFetchCableInstruction(SicomeParser.FetchCableInstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleCableStep}
	 * labeled alternative in {@link SicomeParser#cableStep}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCableStep(SicomeParser.SimpleCableStepContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleCableStep}
	 * labeled alternative in {@link SicomeParser#cableStep}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCableStep(SicomeParser.SimpleCableStepContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalCableStepBlock}
	 * labeled alternative in {@link SicomeParser#cableStep}.
	 * @param ctx the parse tree
	 */
	void enterConditionalCableStepBlock(SicomeParser.ConditionalCableStepBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalCableStepBlock}
	 * labeled alternative in {@link SicomeParser#cableStep}.
	 * @param ctx the parse tree
	 */
	void exitConditionalCableStepBlock(SicomeParser.ConditionalCableStepBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#conditionalCableStep}.
	 * @param ctx the parse tree
	 */
	void enterConditionalCableStep(SicomeParser.ConditionalCableStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#conditionalCableStep}.
	 * @param ctx the parse tree
	 */
	void exitConditionalCableStep(SicomeParser.ConditionalCableStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#microIntr}.
	 * @param ctx the parse tree
	 */
	void enterMicroIntr(SicomeParser.MicroIntrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#microIntr}.
	 * @param ctx the parse tree
	 */
	void exitMicroIntr(SicomeParser.MicroIntrContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#specialMicroIntr}.
	 * @param ctx the parse tree
	 */
	void enterSpecialMicroIntr(SicomeParser.SpecialMicroIntrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#specialMicroIntr}.
	 * @param ctx the parse tree
	 */
	void exitSpecialMicroIntr(SicomeParser.SpecialMicroIntrContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#statusLogicBlock}.
	 * @param ctx the parse tree
	 */
	void enterStatusLogicBlock(SicomeParser.StatusLogicBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#statusLogicBlock}.
	 * @param ctx the parse tree
	 */
	void exitStatusLogicBlock(SicomeParser.StatusLogicBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleStatusLogic}
	 * labeled alternative in {@link SicomeParser#statusLogic}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStatusLogic(SicomeParser.SimpleStatusLogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleStatusLogic}
	 * labeled alternative in {@link SicomeParser#statusLogic}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStatusLogic(SicomeParser.SimpleStatusLogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code complexStatusLogic}
	 * labeled alternative in {@link SicomeParser#statusLogic}.
	 * @param ctx the parse tree
	 */
	void enterComplexStatusLogic(SicomeParser.ComplexStatusLogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code complexStatusLogic}
	 * labeled alternative in {@link SicomeParser#statusLogic}.
	 * @param ctx the parse tree
	 */
	void exitComplexStatusLogic(SicomeParser.ComplexStatusLogicContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#statusLogicOption}.
	 * @param ctx the parse tree
	 */
	void enterStatusLogicOption(SicomeParser.StatusLogicOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#statusLogicOption}.
	 * @param ctx the parse tree
	 */
	void exitStatusLogicOption(SicomeParser.StatusLogicOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#microInstructionBlock}.
	 * @param ctx the parse tree
	 */
	void enterMicroInstructionBlock(SicomeParser.MicroInstructionBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#microInstructionBlock}.
	 * @param ctx the parse tree
	 */
	void exitMicroInstructionBlock(SicomeParser.MicroInstructionBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#fetchMicroInstruction}.
	 * @param ctx the parse tree
	 */
	void enterFetchMicroInstruction(SicomeParser.FetchMicroInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#fetchMicroInstruction}.
	 * @param ctx the parse tree
	 */
	void exitFetchMicroInstruction(SicomeParser.FetchMicroInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#microInstruction}.
	 * @param ctx the parse tree
	 */
	void enterMicroInstruction(SicomeParser.MicroInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#microInstruction}.
	 * @param ctx the parse tree
	 */
	void exitMicroInstruction(SicomeParser.MicroInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#microStep}.
	 * @param ctx the parse tree
	 */
	void enterMicroStep(SicomeParser.MicroStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#microStep}.
	 * @param ctx the parse tree
	 */
	void exitMicroStep(SicomeParser.MicroStepContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instructionBifLogicArgument}
	 * labeled alternative in {@link SicomeParser#bifLogicArgument}.
	 * @param ctx the parse tree
	 */
	void enterInstructionBifLogicArgument(SicomeParser.InstructionBifLogicArgumentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instructionBifLogicArgument}
	 * labeled alternative in {@link SicomeParser#bifLogicArgument}.
	 * @param ctx the parse tree
	 */
	void exitInstructionBifLogicArgument(SicomeParser.InstructionBifLogicArgumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code startBifLogicArgument}
	 * labeled alternative in {@link SicomeParser#bifLogicArgument}.
	 * @param ctx the parse tree
	 */
	void enterStartBifLogicArgument(SicomeParser.StartBifLogicArgumentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code startBifLogicArgument}
	 * labeled alternative in {@link SicomeParser#bifLogicArgument}.
	 * @param ctx the parse tree
	 */
	void exitStartBifLogicArgument(SicomeParser.StartBifLogicArgumentContext ctx);
}