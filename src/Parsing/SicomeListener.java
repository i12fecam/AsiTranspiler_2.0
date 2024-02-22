package Parsing;// Generated from Sicome.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SicomeParser}.
 */
public interface SicomeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SicomeParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SicomeParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SicomeParser.ProgContext ctx);
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
	 * Enter a parse tree produced by {@link SicomeParser#instructionArgument}.
	 * @param ctx the parse tree
	 */
	void enterInstructionArgument(SicomeParser.InstructionArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#instructionArgument}.
	 * @param ctx the parse tree
	 */
	void exitInstructionArgument(SicomeParser.InstructionArgumentContext ctx);
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
	 * Enter a parse tree produced by the {@code complexCableFlowControl}
	 * labeled alternative in {@link SicomeParser#cableFlowControl}.
	 * @param ctx the parse tree
	 */
	void enterComplexCableFlowControl(SicomeParser.ComplexCableFlowControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code complexCableFlowControl}
	 * labeled alternative in {@link SicomeParser#cableFlowControl}.
	 * @param ctx the parse tree
	 */
	void exitComplexCableFlowControl(SicomeParser.ComplexCableFlowControlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleCableFlowControl}
	 * labeled alternative in {@link SicomeParser#cableFlowControl}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCableFlowControl(SicomeParser.SimpleCableFlowControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleCableFlowControl}
	 * labeled alternative in {@link SicomeParser#cableFlowControl}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCableFlowControl(SicomeParser.SimpleCableFlowControlContext ctx);
}