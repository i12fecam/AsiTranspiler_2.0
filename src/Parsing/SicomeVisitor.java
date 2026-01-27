// Generated from /home/abi/Proyectos/SicomeTranspiler/grammar/Sicome.g4 by ANTLR 4.13.2
package Parsing;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SicomeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SicomeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code microProgramableLogic}
	 * labeled alternative in {@link SicomeParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMicroProgramableLogic(SicomeParser.MicroProgramableLogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cableProgram}
	 * labeled alternative in {@link SicomeParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCableProgram(SicomeParser.CableProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code microProgramableProgram}
	 * labeled alternative in {@link SicomeParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMicroProgramableProgram(SicomeParser.MicroProgramableProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#variablesBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariablesBlock(SicomeParser.VariablesBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleVariableDeclaration}
	 * labeled alternative in {@link SicomeParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleVariableDeclaration(SicomeParser.SimpleVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vectorVariableDeclaration}
	 * labeled alternative in {@link SicomeParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorVariableDeclaration(SicomeParser.VectorVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#programBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramBlock(SicomeParser.ProgramBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instructionUse}
	 * labeled alternative in {@link SicomeParser#programLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionUse(SicomeParser.InstructionUseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code markUse}
	 * labeled alternative in {@link SicomeParser#programLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkUse(SicomeParser.MarkUseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#instructionUseArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionUseArgument(SicomeParser.InstructionUseArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#cableInstructionBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCableInstructionBlock(SicomeParser.CableInstructionBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#cableInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCableInstruction(SicomeParser.CableInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#fetchCableInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFetchCableInstruction(SicomeParser.FetchCableInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleCableStep}
	 * labeled alternative in {@link SicomeParser#cableStep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleCableStep(SicomeParser.SimpleCableStepContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalCableStepBlock}
	 * labeled alternative in {@link SicomeParser#cableStep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalCableStepBlock(SicomeParser.ConditionalCableStepBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#conditionalCableStep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalCableStep(SicomeParser.ConditionalCableStepContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#microIntr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMicroIntr(SicomeParser.MicroIntrContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#specialMicroIntr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialMicroIntr(SicomeParser.SpecialMicroIntrContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#statusLogicBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatusLogicBlock(SicomeParser.StatusLogicBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleStatusLogic}
	 * labeled alternative in {@link SicomeParser#statusLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStatusLogic(SicomeParser.SimpleStatusLogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code complexStatusLogic}
	 * labeled alternative in {@link SicomeParser#statusLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexStatusLogic(SicomeParser.ComplexStatusLogicContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#statusLogicOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatusLogicOption(SicomeParser.StatusLogicOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#microInstructionBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMicroInstructionBlock(SicomeParser.MicroInstructionBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#fetchMicroInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFetchMicroInstruction(SicomeParser.FetchMicroInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#microInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMicroInstruction(SicomeParser.MicroInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SicomeParser#microStep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMicroStep(SicomeParser.MicroStepContext ctx);
}