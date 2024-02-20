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
	 * Enter a parse tree produced by {@link SicomeParser#instrucciones_C}.
	 * @param ctx the parse tree
	 */
	void enterInstrucciones_C(SicomeParser.Instrucciones_CContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#instrucciones_C}.
	 * @param ctx the parse tree
	 */
	void exitInstrucciones_C(SicomeParser.Instrucciones_CContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#instruccion_C}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion_C(SicomeParser.Instruccion_CContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#instruccion_C}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion_C(SicomeParser.Instruccion_CContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#instr_arg}.
	 * @param ctx the parse tree
	 */
	void enterInstr_arg(SicomeParser.Instr_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#instr_arg}.
	 * @param ctx the parse tree
	 */
	void exitInstr_arg(SicomeParser.Instr_argContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleStep}
	 * labeled alternative in {@link SicomeParser#step}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStep(SicomeParser.SimpleStepContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleStep}
	 * labeled alternative in {@link SicomeParser#step}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStep(SicomeParser.SimpleStepContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalStep}
	 * labeled alternative in {@link SicomeParser#step}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStep(SicomeParser.ConditionalStepContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalStep}
	 * labeled alternative in {@link SicomeParser#step}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStep(SicomeParser.ConditionalStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#cond_step}.
	 * @param ctx the parse tree
	 */
	void enterCond_step(SicomeParser.Cond_stepContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#cond_step}.
	 * @param ctx the parse tree
	 */
	void exitCond_step(SicomeParser.Cond_stepContext ctx);
	/**
	 * Enter a parse tree produced by the {@code complexFlowControl}
	 * labeled alternative in {@link SicomeParser#flow_control_C}.
	 * @param ctx the parse tree
	 */
	void enterComplexFlowControl(SicomeParser.ComplexFlowControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code complexFlowControl}
	 * labeled alternative in {@link SicomeParser#flow_control_C}.
	 * @param ctx the parse tree
	 */
	void exitComplexFlowControl(SicomeParser.ComplexFlowControlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleFlowControl}
	 * labeled alternative in {@link SicomeParser#flow_control_C}.
	 * @param ctx the parse tree
	 */
	void enterSimpleFlowControl(SicomeParser.SimpleFlowControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleFlowControl}
	 * labeled alternative in {@link SicomeParser#flow_control_C}.
	 * @param ctx the parse tree
	 */
	void exitSimpleFlowControl(SicomeParser.SimpleFlowControlContext ctx);
}