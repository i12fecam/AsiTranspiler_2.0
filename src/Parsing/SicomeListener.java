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
	 * Enter a parse tree produced by the {@code LoadSC_FlowControl}
	 * labeled alternative in {@link SicomeParser#cableFlowControl}.
	 * @param ctx the parse tree
	 */
	void enterLoadSC_FlowControl(SicomeParser.LoadSC_FlowControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoadSC_FlowControl}
	 * labeled alternative in {@link SicomeParser#cableFlowControl}.
	 * @param ctx the parse tree
	 */
	void exitLoadSC_FlowControl(SicomeParser.LoadSC_FlowControlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoadSR_CableFlowControl}
	 * labeled alternative in {@link SicomeParser#cableFlowControl}.
	 * @param ctx the parse tree
	 */
	void enterLoadSR_CableFlowControl(SicomeParser.LoadSR_CableFlowControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoadSR_CableFlowControl}
	 * labeled alternative in {@link SicomeParser#cableFlowControl}.
	 * @param ctx the parse tree
	 */
	void exitLoadSR_CableFlowControl(SicomeParser.LoadSR_CableFlowControlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SRPlus_CableFlowControl}
	 * labeled alternative in {@link SicomeParser#cableFlowControl}.
	 * @param ctx the parse tree
	 */
	void enterSRPlus_CableFlowControl(SicomeParser.SRPlus_CableFlowControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SRPlus_CableFlowControl}
	 * labeled alternative in {@link SicomeParser#cableFlowControl}.
	 * @param ctx the parse tree
	 */
	void exitSRPlus_CableFlowControl(SicomeParser.SRPlus_CableFlowControlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SCMinus_CableFlowControl}
	 * labeled alternative in {@link SicomeParser#cableFlowControl}.
	 * @param ctx the parse tree
	 */
	void enterSCMinus_CableFlowControl(SicomeParser.SCMinus_CableFlowControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SCMinus_CableFlowControl}
	 * labeled alternative in {@link SicomeParser#cableFlowControl}.
	 * @param ctx the parse tree
	 */
	void exitSCMinus_CableFlowControl(SicomeParser.SCMinus_CableFlowControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#micro_instr}.
	 * @param ctx the parse tree
	 */
	void enterMicro_instr(SicomeParser.Micro_instrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#micro_instr}.
	 * @param ctx the parse tree
	 */
	void exitMicro_instr(SicomeParser.Micro_instrContext ctx);
	/**
	 * Enter a parse tree produced by {@link SicomeParser#flag}.
	 * @param ctx the parse tree
	 */
	void enterFlag(SicomeParser.FlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link SicomeParser#flag}.
	 * @param ctx the parse tree
	 */
	void exitFlag(SicomeParser.FlagContext ctx);
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
}