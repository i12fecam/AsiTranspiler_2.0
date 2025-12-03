// Generated from /home/abi/Proyectos/SicomeTranspiler/grammar/Sicome.g4 by ANTLR 4.13.2
package Parsing;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SicomeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, NUMBER=27, LOAD_SC=28, LOAD_SR=29, SR_INCREMENT=30, 
		SC_DECREMENT=31, FLAG=32, IDENTIFIER=33, MICRO_INSTR=34, LINE_COMMENT=35, 
		COMMENT=36, NEWLINE=37, WS=38;
	public static final int
		RULE_prog = 0, RULE_variablesBlock = 1, RULE_variableDeclaration = 2, 
		RULE_programBlock = 3, RULE_programLine = 4, RULE_instructionUseArgument = 5, 
		RULE_cableInstructionBlock = 6, RULE_cableInstruction = 7, RULE_cableStep = 8, 
		RULE_conditionalCableStep = 9, RULE_cableFlowControl = 10, RULE_statusLogicBlock = 11, 
		RULE_statusLogic = 12, RULE_statusLogicOption = 13, RULE_microInstructionBlock = 14, 
		RULE_microInstruction = 15, RULE_microStep = 16, RULE_microFlowControl = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "variablesBlock", "variableDeclaration", "programBlock", "programLine", 
			"instructionUseArgument", "cableInstructionBlock", "cableInstruction", 
			"cableStep", "conditionalCableStep", "cableFlowControl", "statusLogicBlock", 
			"statusLogic", "statusLogicOption", "microInstructionBlock", "microInstruction", 
			"microStep", "microFlowControl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'variables'", "'{'", "'}'", "'='", "';'", "'['", "']'", "','", 
			"'programa'", "'MARK'", "'@cableado'", "'instrucciones'", "'('", "'value'", 
			"'dir'", "'var'", "')'", "':'", "'START'", "'estados'", "'->'", "'INCR'", 
			"'BIF'", "'RET'", "'DISABLE'", "'@microinstruccion'", null, "'LOAD_SC'", 
			"'LOAD_SR'", "'SR+1->SR'", "'SC-1->SC'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "NUMBER", "LOAD_SC", "LOAD_SR", "SR_INCREMENT", "SC_DECREMENT", 
			"FLAG", "IDENTIFIER", "MICRO_INSTR", "LINE_COMMENT", "COMMENT", "NEWLINE", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Sicome.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SicomeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CableProgramContext extends ProgContext {
		public CableInstructionBlockContext cableInstructionBlock() {
			return getRuleContext(CableInstructionBlockContext.class,0);
		}
		public VariablesBlockContext variablesBlock() {
			return getRuleContext(VariablesBlockContext.class,0);
		}
		public ProgramBlockContext programBlock() {
			return getRuleContext(ProgramBlockContext.class,0);
		}
		public CableProgramContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterCableProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitCableProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitCableProgram(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MicroProgramableLogicContext extends ProgContext {
		public StatusLogicBlockContext statusLogicBlock() {
			return getRuleContext(StatusLogicBlockContext.class,0);
		}
		public MicroProgramableLogicContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterMicroProgramableLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitMicroProgramableLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitMicroProgramableLogic(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MicroProgramableProgramContext extends ProgContext {
		public StatusLogicBlockContext statusLogicBlock() {
			return getRuleContext(StatusLogicBlockContext.class,0);
		}
		public MicroInstructionBlockContext microInstructionBlock() {
			return getRuleContext(MicroInstructionBlockContext.class,0);
		}
		public VariablesBlockContext variablesBlock() {
			return getRuleContext(VariablesBlockContext.class,0);
		}
		public ProgramBlockContext programBlock() {
			return getRuleContext(ProgramBlockContext.class,0);
		}
		public MicroProgramableProgramContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterMicroProgramableProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitMicroProgramableProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitMicroProgramableProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new MicroProgramableLogicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				statusLogicBlock();
				}
				break;
			case 2:
				_localctx = new CableProgramContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				cableInstructionBlock();
				setState(44);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(38);
					variablesBlock();
					setState(39);
					programBlock();
					}
					break;
				case T__8:
					{
					setState(41);
					programBlock();
					setState(42);
					variablesBlock();
					}
					break;
				case EOF:
					break;
				default:
					break;
				}
				}
				break;
			case 3:
				_localctx = new MicroProgramableProgramContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__19:
					{
					setState(46);
					statusLogicBlock();
					setState(47);
					microInstructionBlock();
					}
					break;
				case T__25:
					{
					setState(49);
					microInstructionBlock();
					setState(50);
					statusLogicBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(60);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(54);
					variablesBlock();
					setState(55);
					programBlock();
					}
					break;
				case T__8:
					{
					setState(57);
					programBlock();
					setState(58);
					variablesBlock();
					}
					break;
				case EOF:
					break;
				default:
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariablesBlockContext extends ParserRuleContext {
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public VariablesBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variablesBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterVariablesBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitVariablesBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitVariablesBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesBlockContext variablesBlock() throws RecognitionException {
		VariablesBlockContext _localctx = new VariablesBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variablesBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__0);
			setState(65);
			match(T__1);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(66);
				variableDeclaration();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	 
		public VariableDeclarationContext() { }
		public void copyFrom(VariableDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleVariableDeclarationContext extends VariableDeclarationContext {
		public Token id;
		public Token value;
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public TerminalNode NUMBER() { return getToken(SicomeParser.NUMBER, 0); }
		public SimpleVariableDeclarationContext(VariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterSimpleVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitSimpleVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitSimpleVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VectorVariableDeclarationContext extends VariableDeclarationContext {
		public Token id;
		public Token size;
		public Token NUMBER;
		public List<Token> value = new ArrayList<Token>();
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(SicomeParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SicomeParser.NUMBER, i);
		}
		public VectorVariableDeclarationContext(VariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterVectorVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitVectorVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitVectorVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variableDeclaration);
		int _la;
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new SimpleVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				((SimpleVariableDeclarationContext)_localctx).id = match(IDENTIFIER);
				setState(75);
				match(T__3);
				setState(76);
				((SimpleVariableDeclarationContext)_localctx).value = match(NUMBER);
				setState(77);
				match(T__4);
				}
				break;
			case 2:
				_localctx = new VectorVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				((VectorVariableDeclarationContext)_localctx).id = match(IDENTIFIER);
				setState(79);
				match(T__5);
				setState(80);
				((VectorVariableDeclarationContext)_localctx).size = match(NUMBER);
				setState(81);
				match(T__6);
				setState(82);
				match(T__3);
				setState(83);
				match(T__1);
				setState(84);
				((VectorVariableDeclarationContext)_localctx).NUMBER = match(NUMBER);
				((VectorVariableDeclarationContext)_localctx).value.add(((VectorVariableDeclarationContext)_localctx).NUMBER);
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(85);
					match(T__7);
					setState(86);
					((VectorVariableDeclarationContext)_localctx).NUMBER = match(NUMBER);
					((VectorVariableDeclarationContext)_localctx).value.add(((VectorVariableDeclarationContext)_localctx).NUMBER);
					}
					}
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(92);
				match(T__2);
				setState(93);
				match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramBlockContext extends ParserRuleContext {
		public List<ProgramLineContext> programLine() {
			return getRuleContexts(ProgramLineContext.class);
		}
		public ProgramLineContext programLine(int i) {
			return getRuleContext(ProgramLineContext.class,i);
		}
		public ProgramBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterProgramBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitProgramBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitProgramBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramBlockContext programBlock() throws RecognitionException {
		ProgramBlockContext _localctx = new ProgramBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_programBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__8);
			setState(97);
			match(T__1);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9 || _la==IDENTIFIER) {
				{
				{
				setState(98);
				programLine();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramLineContext extends ParserRuleContext {
		public ProgramLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programLine; }
	 
		public ProgramLineContext() { }
		public void copyFrom(ProgramLineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstructionUseContext extends ProgramLineContext {
		public Token name;
		public InstructionUseArgumentContext arg;
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public InstructionUseArgumentContext instructionUseArgument() {
			return getRuleContext(InstructionUseArgumentContext.class,0);
		}
		public InstructionUseContext(ProgramLineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterInstructionUse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitInstructionUse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitInstructionUse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MarkUseContext extends ProgramLineContext {
		public Token label;
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public MarkUseContext(ProgramLineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterMarkUse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitMarkUse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitMarkUse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramLineContext programLine() throws RecognitionException {
		ProgramLineContext _localctx = new ProgramLineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_programLine);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new InstructionUseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				((InstructionUseContext)_localctx).name = match(IDENTIFIER);
				setState(107);
				((InstructionUseContext)_localctx).arg = instructionUseArgument();
				setState(108);
				match(T__4);
				}
				break;
			case T__9:
				_localctx = new MarkUseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(T__9);
				setState(111);
				((MarkUseContext)_localctx).label = match(IDENTIFIER);
				setState(112);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstructionUseArgumentContext extends ParserRuleContext {
		public Token var;
		public Token offset;
		public Token num;
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public TerminalNode NUMBER() { return getToken(SicomeParser.NUMBER, 0); }
		public InstructionUseArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionUseArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterInstructionUseArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitInstructionUseArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitInstructionUseArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionUseArgumentContext instructionUseArgument() throws RecognitionException {
		InstructionUseArgumentContext _localctx = new InstructionUseArgumentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instructionUseArgument);
		int _la;
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				((InstructionUseArgumentContext)_localctx).var = match(IDENTIFIER);
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(116);
					match(T__5);
					setState(117);
					((InstructionUseArgumentContext)_localctx).offset = match(NUMBER);
					setState(118);
					match(T__6);
					}
				}

				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				((InstructionUseArgumentContext)_localctx).num = match(NUMBER);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CableInstructionBlockContext extends ParserRuleContext {
		public List<CableInstructionContext> cableInstruction() {
			return getRuleContexts(CableInstructionContext.class);
		}
		public CableInstructionContext cableInstruction(int i) {
			return getRuleContext(CableInstructionContext.class,i);
		}
		public CableInstructionBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cableInstructionBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterCableInstructionBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitCableInstructionBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitCableInstructionBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CableInstructionBlockContext cableInstructionBlock() throws RecognitionException {
		CableInstructionBlockContext _localctx = new CableInstructionBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cableInstructionBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__10);
			setState(126);
			match(T__11);
			setState(127);
			match(T__1);
			setState(129); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(128);
				cableInstruction();
				}
				}
				setState(131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(133);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CableInstructionContext extends ParserRuleContext {
		public Token arg;
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public List<CableStepContext> cableStep() {
			return getRuleContexts(CableStepContext.class);
		}
		public CableStepContext cableStep(int i) {
			return getRuleContext(CableStepContext.class,i);
		}
		public CableInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cableInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterCableInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitCableInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitCableInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CableInstructionContext cableInstruction() throws RecognitionException {
		CableInstructionContext _localctx = new CableInstructionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cableInstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(IDENTIFIER);
			setState(136);
			match(T__12);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) {
				{
				setState(137);
				((CableInstructionContext)_localctx).arg = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
					((CableInstructionContext)_localctx).arg = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(140);
			match(T__16);
			setState(141);
			match(T__1);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==T__5) {
				{
				{
				setState(142);
				cableStep();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CableStepContext extends ParserRuleContext {
		public CableStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cableStep; }
	 
		public CableStepContext() { }
		public void copyFrom(CableStepContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalCableStepBlockContext extends CableStepContext {
		public List<ConditionalCableStepContext> conditionalCableStep() {
			return getRuleContexts(ConditionalCableStepContext.class);
		}
		public ConditionalCableStepContext conditionalCableStep(int i) {
			return getRuleContext(ConditionalCableStepContext.class,i);
		}
		public ConditionalCableStepBlockContext(CableStepContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterConditionalCableStepBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitConditionalCableStepBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitConditionalCableStepBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleCableStepContext extends CableStepContext {
		public Token MICRO_INSTR;
		public List<Token> instr = new ArrayList<Token>();
		public List<CableFlowControlContext> cableFlowControl() {
			return getRuleContexts(CableFlowControlContext.class);
		}
		public CableFlowControlContext cableFlowControl(int i) {
			return getRuleContext(CableFlowControlContext.class,i);
		}
		public List<TerminalNode> MICRO_INSTR() { return getTokens(SicomeParser.MICRO_INSTR); }
		public TerminalNode MICRO_INSTR(int i) {
			return getToken(SicomeParser.MICRO_INSTR, i);
		}
		public SimpleCableStepContext(CableStepContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterSimpleCableStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitSimpleCableStep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitSimpleCableStep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CableStepContext cableStep() throws RecognitionException {
		CableStepContext _localctx = new CableStepContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cableStep);
		int _la;
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new SimpleCableStepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(T__5);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4026531840L) != 0)) {
					{
					{
					setState(151);
					cableFlowControl();
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157);
				match(T__6);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MICRO_INSTR) {
					{
					{
					setState(158);
					((SimpleCableStepContext)_localctx).MICRO_INSTR = match(MICRO_INSTR);
					((SimpleCableStepContext)_localctx).instr.add(((SimpleCableStepContext)_localctx).MICRO_INSTR);
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(164);
				match(T__4);
				}
				break;
			case T__1:
				_localctx = new ConditionalCableStepBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(T__1);
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(166);
					conditionalCableStep();
					}
					}
					setState(169); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==FLAG );
				setState(171);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalCableStepContext extends ParserRuleContext {
		public Token FLAG;
		public List<Token> flags = new ArrayList<Token>();
		public Token MICRO_INSTR;
		public List<Token> instr = new ArrayList<Token>();
		public List<TerminalNode> FLAG() { return getTokens(SicomeParser.FLAG); }
		public TerminalNode FLAG(int i) {
			return getToken(SicomeParser.FLAG, i);
		}
		public List<CableFlowControlContext> cableFlowControl() {
			return getRuleContexts(CableFlowControlContext.class);
		}
		public CableFlowControlContext cableFlowControl(int i) {
			return getRuleContext(CableFlowControlContext.class,i);
		}
		public List<TerminalNode> MICRO_INSTR() { return getTokens(SicomeParser.MICRO_INSTR); }
		public TerminalNode MICRO_INSTR(int i) {
			return getToken(SicomeParser.MICRO_INSTR, i);
		}
		public ConditionalCableStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalCableStep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterConditionalCableStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitConditionalCableStep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitConditionalCableStep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalCableStepContext conditionalCableStep() throws RecognitionException {
		ConditionalCableStepContext _localctx = new ConditionalCableStepContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_conditionalCableStep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			((ConditionalCableStepContext)_localctx).FLAG = match(FLAG);
			((ConditionalCableStepContext)_localctx).flags.add(((ConditionalCableStepContext)_localctx).FLAG);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(176);
				match(T__7);
				setState(177);
				((ConditionalCableStepContext)_localctx).FLAG = match(FLAG);
				((ConditionalCableStepContext)_localctx).flags.add(((ConditionalCableStepContext)_localctx).FLAG);
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(183);
			match(T__17);
			setState(184);
			match(T__5);
			setState(186); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(185);
				cableFlowControl();
				}
				}
				setState(188); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4026531840L) != 0) );
			setState(190);
			match(T__6);
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MICRO_INSTR) {
				{
				{
				setState(191);
				((ConditionalCableStepContext)_localctx).MICRO_INSTR = match(MICRO_INSTR);
				((ConditionalCableStepContext)_localctx).instr.add(((ConditionalCableStepContext)_localctx).MICRO_INSTR);
				}
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(197);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CableFlowControlContext extends ParserRuleContext {
		public Token type;
		public Token value;
		public TerminalNode LOAD_SC() { return getToken(SicomeParser.LOAD_SC, 0); }
		public TerminalNode NUMBER() { return getToken(SicomeParser.NUMBER, 0); }
		public TerminalNode LOAD_SR() { return getToken(SicomeParser.LOAD_SR, 0); }
		public TerminalNode SR_INCREMENT() { return getToken(SicomeParser.SR_INCREMENT, 0); }
		public TerminalNode SC_DECREMENT() { return getToken(SicomeParser.SC_DECREMENT, 0); }
		public CableFlowControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cableFlowControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterCableFlowControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitCableFlowControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitCableFlowControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CableFlowControlContext cableFlowControl() throws RecognitionException {
		CableFlowControlContext _localctx = new CableFlowControlContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cableFlowControl);
		int _la;
		try {
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD_SC:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				((CableFlowControlContext)_localctx).type = match(LOAD_SC);
				setState(200);
				match(T__12);
				setState(201);
				((CableFlowControlContext)_localctx).value = match(NUMBER);
				setState(202);
				match(T__16);
				}
				break;
			case LOAD_SR:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				((CableFlowControlContext)_localctx).type = match(LOAD_SR);
				setState(204);
				match(T__12);
				setState(205);
				((CableFlowControlContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__18 || _la==NUMBER) ) {
					((CableFlowControlContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(206);
				match(T__16);
				}
				break;
			case SR_INCREMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				((CableFlowControlContext)_localctx).type = match(SR_INCREMENT);
				}
				break;
			case SC_DECREMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				((CableFlowControlContext)_localctx).type = match(SC_DECREMENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatusLogicBlockContext extends ParserRuleContext {
		public List<StatusLogicContext> statusLogic() {
			return getRuleContexts(StatusLogicContext.class);
		}
		public StatusLogicContext statusLogic(int i) {
			return getRuleContext(StatusLogicContext.class,i);
		}
		public StatusLogicBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statusLogicBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterStatusLogicBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitStatusLogicBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitStatusLogicBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatusLogicBlockContext statusLogicBlock() throws RecognitionException {
		StatusLogicBlockContext _localctx = new StatusLogicBlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statusLogicBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__19);
			setState(212);
			match(T__1);
			setState(214); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(213);
				statusLogic();
				}
				}
				setState(216); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(218);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatusLogicContext extends ParserRuleContext {
		public StatusLogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statusLogic; }
	 
		public StatusLogicContext() { }
		public void copyFrom(StatusLogicContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleStatusLogicContext extends StatusLogicContext {
		public Token name;
		public Token option;
		public Token disable;
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public SimpleStatusLogicContext(StatusLogicContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterSimpleStatusLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitSimpleStatusLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitSimpleStatusLogic(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComplexStatusLogicContext extends StatusLogicContext {
		public Token name;
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public List<StatusLogicOptionContext> statusLogicOption() {
			return getRuleContexts(StatusLogicOptionContext.class);
		}
		public StatusLogicOptionContext statusLogicOption(int i) {
			return getRuleContext(StatusLogicOptionContext.class,i);
		}
		public ComplexStatusLogicContext(StatusLogicContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterComplexStatusLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitComplexStatusLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitComplexStatusLogic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatusLogicContext statusLogic() throws RecognitionException {
		StatusLogicContext _localctx = new StatusLogicContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statusLogic);
		int _la;
		try {
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new SimpleStatusLogicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				((SimpleStatusLogicContext)_localctx).name = match(IDENTIFIER);
				setState(221);
				match(T__20);
				setState(222);
				((SimpleStatusLogicContext)_localctx).option = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 29360128L) != 0)) ) {
					((SimpleStatusLogicContext)_localctx).option = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(223);
					((SimpleStatusLogicContext)_localctx).disable = match(T__24);
					}
				}

				}
				break;
			case 2:
				_localctx = new ComplexStatusLogicContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				((ComplexStatusLogicContext)_localctx).name = match(IDENTIFIER);
				setState(227);
				match(T__20);
				setState(228);
				match(T__1);
				setState(230); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(229);
					statusLogicOption();
					}
					}
					setState(232); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==FLAG );
				setState(234);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatusLogicOptionContext extends ParserRuleContext {
		public Token FLAG;
		public List<Token> flags = new ArrayList<Token>();
		public Token option;
		public Token disable;
		public List<TerminalNode> FLAG() { return getTokens(SicomeParser.FLAG); }
		public TerminalNode FLAG(int i) {
			return getToken(SicomeParser.FLAG, i);
		}
		public StatusLogicOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statusLogicOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterStatusLogicOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitStatusLogicOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitStatusLogicOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatusLogicOptionContext statusLogicOption() throws RecognitionException {
		StatusLogicOptionContext _localctx = new StatusLogicOptionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statusLogicOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			((StatusLogicOptionContext)_localctx).FLAG = match(FLAG);
			((StatusLogicOptionContext)_localctx).flags.add(((StatusLogicOptionContext)_localctx).FLAG);
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(239);
				match(T__7);
				setState(240);
				((StatusLogicOptionContext)_localctx).FLAG = match(FLAG);
				((StatusLogicOptionContext)_localctx).flags.add(((StatusLogicOptionContext)_localctx).FLAG);
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(246);
			match(T__17);
			setState(247);
			((StatusLogicOptionContext)_localctx).option = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 29360128L) != 0)) ) {
				((StatusLogicOptionContext)_localctx).option = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(248);
				((StatusLogicOptionContext)_localctx).disable = match(T__24);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MicroInstructionBlockContext extends ParserRuleContext {
		public List<MicroInstructionContext> microInstruction() {
			return getRuleContexts(MicroInstructionContext.class);
		}
		public MicroInstructionContext microInstruction(int i) {
			return getRuleContext(MicroInstructionContext.class,i);
		}
		public MicroInstructionBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_microInstructionBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterMicroInstructionBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitMicroInstructionBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitMicroInstructionBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MicroInstructionBlockContext microInstructionBlock() throws RecognitionException {
		MicroInstructionBlockContext _localctx = new MicroInstructionBlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_microInstructionBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(T__25);
			setState(252);
			match(T__11);
			setState(253);
			match(T__1);
			setState(255); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(254);
				microInstruction();
				}
				}
				setState(257); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(259);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MicroInstructionContext extends ParserRuleContext {
		public Token arg;
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public List<MicroStepContext> microStep() {
			return getRuleContexts(MicroStepContext.class);
		}
		public MicroStepContext microStep(int i) {
			return getRuleContext(MicroStepContext.class,i);
		}
		public MicroInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_microInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterMicroInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitMicroInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitMicroInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MicroInstructionContext microInstruction() throws RecognitionException {
		MicroInstructionContext _localctx = new MicroInstructionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_microInstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(IDENTIFIER);
			setState(262);
			match(T__12);
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) {
				{
				setState(263);
				((MicroInstructionContext)_localctx).arg = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
					((MicroInstructionContext)_localctx).arg = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(266);
			match(T__16);
			setState(267);
			match(T__1);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(268);
				microStep();
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(274);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MicroStepContext extends ParserRuleContext {
		public MicroFlowControlContext microFlowControl;
		public List<MicroFlowControlContext> flow = new ArrayList<MicroFlowControlContext>();
		public Token MICRO_INSTR;
		public List<Token> instr = new ArrayList<Token>();
		public List<MicroFlowControlContext> microFlowControl() {
			return getRuleContexts(MicroFlowControlContext.class);
		}
		public MicroFlowControlContext microFlowControl(int i) {
			return getRuleContext(MicroFlowControlContext.class,i);
		}
		public List<TerminalNode> MICRO_INSTR() { return getTokens(SicomeParser.MICRO_INSTR); }
		public TerminalNode MICRO_INSTR(int i) {
			return getToken(SicomeParser.MICRO_INSTR, i);
		}
		public MicroStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_microStep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterMicroStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitMicroStep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitMicroStep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MicroStepContext microStep() throws RecognitionException {
		MicroStepContext _localctx = new MicroStepContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_microStep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(T__5);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 11005853696L) != 0)) {
				{
				{
				setState(277);
				((MicroStepContext)_localctx).microFlowControl = microFlowControl();
				((MicroStepContext)_localctx).flow.add(((MicroStepContext)_localctx).microFlowControl);
				}
				}
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(283);
			match(T__6);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MICRO_INSTR) {
				{
				{
				setState(284);
				((MicroStepContext)_localctx).MICRO_INSTR = match(MICRO_INSTR);
				((MicroStepContext)_localctx).instr.add(((MicroStepContext)_localctx).MICRO_INSTR);
				}
				}
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(290);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MicroFlowControlContext extends ParserRuleContext {
		public Token action;
		public Token value;
		public TerminalNode LOAD_SC() { return getToken(SicomeParser.LOAD_SC, 0); }
		public TerminalNode NUMBER() { return getToken(SicomeParser.NUMBER, 0); }
		public TerminalNode SC_DECREMENT() { return getToken(SicomeParser.SC_DECREMENT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public MicroFlowControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_microFlowControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterMicroFlowControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitMicroFlowControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitMicroFlowControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MicroFlowControlContext microFlowControl() throws RecognitionException {
		MicroFlowControlContext _localctx = new MicroFlowControlContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_microFlowControl);
		int _la;
		try {
			setState(303);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOAD_SC:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				((MicroFlowControlContext)_localctx).action = match(LOAD_SC);
				setState(293);
				match(T__12);
				setState(294);
				((MicroFlowControlContext)_localctx).value = match(NUMBER);
				setState(295);
				match(T__16);
				}
				break;
			case SC_DECREMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				((MicroFlowControlContext)_localctx).action = match(SC_DECREMENT);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(297);
				((MicroFlowControlContext)_localctx).action = match(IDENTIFIER);
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(298);
					match(T__12);
					setState(299);
					((MicroFlowControlContext)_localctx).value = match(NUMBER);
					setState(300);
					match(T__16);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u0132\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u0000-\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u00005\b\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000=\b\u0000"+
		"\u0003\u0000?\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"D\b\u0001\n\u0001\f\u0001G\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002X\b\u0002\n\u0002\f\u0002[\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002_\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"d\b\u0003\n\u0003\f\u0003g\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004r\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005x\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005|\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u0082\b\u0006\u000b"+
		"\u0006\f\u0006\u0083\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u008b\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u0090\b\u0007\n\u0007\f\u0007\u0093\t\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0005\b\u0099\b\b\n\b\f\b\u009c\t\b\u0001\b\u0001\b\u0005"+
		"\b\u00a0\b\b\n\b\f\b\u00a3\t\b\u0001\b\u0001\b\u0001\b\u0004\b\u00a8\b"+
		"\b\u000b\b\f\b\u00a9\u0001\b\u0001\b\u0003\b\u00ae\b\b\u0001\t\u0001\t"+
		"\u0001\t\u0005\t\u00b3\b\t\n\t\f\t\u00b6\t\t\u0001\t\u0001\t\u0001\t\u0004"+
		"\t\u00bb\b\t\u000b\t\f\t\u00bc\u0001\t\u0001\t\u0005\t\u00c1\b\t\n\t\f"+
		"\t\u00c4\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00d2\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0004\u000b\u00d7\b\u000b\u000b\u000b\f\u000b\u00d8"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00e1"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0004\f\u00e7\b\f\u000b\f\f\f\u00e8"+
		"\u0001\f\u0001\f\u0003\f\u00ed\b\f\u0001\r\u0001\r\u0001\r\u0005\r\u00f2"+
		"\b\r\n\r\f\r\u00f5\t\r\u0001\r\u0001\r\u0001\r\u0003\r\u00fa\b\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u0100\b\u000e\u000b"+
		"\u000e\f\u000e\u0101\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u0109\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005"+
		"\u000f\u010e\b\u000f\n\u000f\f\u000f\u0111\t\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u0117\b\u0010\n\u0010\f\u0010\u011a"+
		"\t\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u011e\b\u0010\n\u0010\f\u0010"+
		"\u0121\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u012e\b\u0011\u0003\u0011\u0130\b\u0011\u0001\u0011\u0000"+
		"\u0000\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"\u0000\u0003\u0001\u0000\u000e\u0010\u0002"+
		"\u0000\u0013\u0013\u001b\u001b\u0001\u0000\u0016\u0018\u0149\u0000>\u0001"+
		"\u0000\u0000\u0000\u0002@\u0001\u0000\u0000\u0000\u0004^\u0001\u0000\u0000"+
		"\u0000\u0006`\u0001\u0000\u0000\u0000\bq\u0001\u0000\u0000\u0000\n{\u0001"+
		"\u0000\u0000\u0000\f}\u0001\u0000\u0000\u0000\u000e\u0087\u0001\u0000"+
		"\u0000\u0000\u0010\u00ad\u0001\u0000\u0000\u0000\u0012\u00af\u0001\u0000"+
		"\u0000\u0000\u0014\u00d1\u0001\u0000\u0000\u0000\u0016\u00d3\u0001\u0000"+
		"\u0000\u0000\u0018\u00ec\u0001\u0000\u0000\u0000\u001a\u00ee\u0001\u0000"+
		"\u0000\u0000\u001c\u00fb\u0001\u0000\u0000\u0000\u001e\u0105\u0001\u0000"+
		"\u0000\u0000 \u0114\u0001\u0000\u0000\u0000\"\u012f\u0001\u0000\u0000"+
		"\u0000$?\u0003\u0016\u000b\u0000%,\u0003\f\u0006\u0000&\'\u0003\u0002"+
		"\u0001\u0000\'(\u0003\u0006\u0003\u0000(-\u0001\u0000\u0000\u0000)*\u0003"+
		"\u0006\u0003\u0000*+\u0003\u0002\u0001\u0000+-\u0001\u0000\u0000\u0000"+
		",&\u0001\u0000\u0000\u0000,)\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000"+
		"\u0000-?\u0001\u0000\u0000\u0000./\u0003\u0016\u000b\u0000/0\u0003\u001c"+
		"\u000e\u000005\u0001\u0000\u0000\u000012\u0003\u001c\u000e\u000023\u0003"+
		"\u0016\u000b\u000035\u0001\u0000\u0000\u00004.\u0001\u0000\u0000\u0000"+
		"41\u0001\u0000\u0000\u00005<\u0001\u0000\u0000\u000067\u0003\u0002\u0001"+
		"\u000078\u0003\u0006\u0003\u00008=\u0001\u0000\u0000\u00009:\u0003\u0006"+
		"\u0003\u0000:;\u0003\u0002\u0001\u0000;=\u0001\u0000\u0000\u0000<6\u0001"+
		"\u0000\u0000\u0000<9\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000"+
		"=?\u0001\u0000\u0000\u0000>$\u0001\u0000\u0000\u0000>%\u0001\u0000\u0000"+
		"\u0000>4\u0001\u0000\u0000\u0000?\u0001\u0001\u0000\u0000\u0000@A\u0005"+
		"\u0001\u0000\u0000AE\u0005\u0002\u0000\u0000BD\u0003\u0004\u0002\u0000"+
		"CB\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000HI\u0005\u0003\u0000\u0000I\u0003\u0001\u0000\u0000\u0000"+
		"JK\u0005!\u0000\u0000KL\u0005\u0004\u0000\u0000LM\u0005\u001b\u0000\u0000"+
		"M_\u0005\u0005\u0000\u0000NO\u0005!\u0000\u0000OP\u0005\u0006\u0000\u0000"+
		"PQ\u0005\u001b\u0000\u0000QR\u0005\u0007\u0000\u0000RS\u0005\u0004\u0000"+
		"\u0000ST\u0005\u0002\u0000\u0000TY\u0005\u001b\u0000\u0000UV\u0005\b\u0000"+
		"\u0000VX\u0005\u001b\u0000\u0000WU\u0001\u0000\u0000\u0000X[\u0001\u0000"+
		"\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001"+
		"\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\]\u0005\u0003\u0000\u0000"+
		"]_\u0005\u0005\u0000\u0000^J\u0001\u0000\u0000\u0000^N\u0001\u0000\u0000"+
		"\u0000_\u0005\u0001\u0000\u0000\u0000`a\u0005\t\u0000\u0000ae\u0005\u0002"+
		"\u0000\u0000bd\u0003\b\u0004\u0000cb\u0001\u0000\u0000\u0000dg\u0001\u0000"+
		"\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fh\u0001"+
		"\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000hi\u0005\u0003\u0000\u0000"+
		"i\u0007\u0001\u0000\u0000\u0000jk\u0005!\u0000\u0000kl\u0003\n\u0005\u0000"+
		"lm\u0005\u0005\u0000\u0000mr\u0001\u0000\u0000\u0000no\u0005\n\u0000\u0000"+
		"op\u0005!\u0000\u0000pr\u0005\u0005\u0000\u0000qj\u0001\u0000\u0000\u0000"+
		"qn\u0001\u0000\u0000\u0000r\t\u0001\u0000\u0000\u0000sw\u0005!\u0000\u0000"+
		"tu\u0005\u0006\u0000\u0000uv\u0005\u001b\u0000\u0000vx\u0005\u0007\u0000"+
		"\u0000wt\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x|\u0001\u0000"+
		"\u0000\u0000y|\u0005\u001b\u0000\u0000z|\u0001\u0000\u0000\u0000{s\u0001"+
		"\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{z\u0001\u0000\u0000\u0000"+
		"|\u000b\u0001\u0000\u0000\u0000}~\u0005\u000b\u0000\u0000~\u007f\u0005"+
		"\f\u0000\u0000\u007f\u0081\u0005\u0002\u0000\u0000\u0080\u0082\u0003\u000e"+
		"\u0007\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000"+
		"\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u0003"+
		"\u0000\u0000\u0086\r\u0001\u0000\u0000\u0000\u0087\u0088\u0005!\u0000"+
		"\u0000\u0088\u008a\u0005\r\u0000\u0000\u0089\u008b\u0007\u0000\u0000\u0000"+
		"\u008a\u0089\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u0011\u0000\u0000"+
		"\u008d\u0091\u0005\u0002\u0000\u0000\u008e\u0090\u0003\u0010\b\u0000\u008f"+
		"\u008e\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000\u0000\u0091"+
		"\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092"+
		"\u0094\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0005\u0003\u0000\u0000\u0095\u000f\u0001\u0000\u0000\u0000\u0096"+
		"\u009a\u0005\u0006\u0000\u0000\u0097\u0099\u0003\u0014\n\u0000\u0098\u0097"+
		"\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009d"+
		"\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u00a1"+
		"\u0005\u0007\u0000\u0000\u009e\u00a0\u0005\"\u0000\u0000\u009f\u009e\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000\u0000\u00a1\u009f\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a4\u00ae\u0005"+
		"\u0005\u0000\u0000\u00a5\u00a7\u0005\u0002\u0000\u0000\u00a6\u00a8\u0003"+
		"\u0012\t\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u0003"+
		"\u0000\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad\u0096\u0001\u0000"+
		"\u0000\u0000\u00ad\u00a5\u0001\u0000\u0000\u0000\u00ae\u0011\u0001\u0000"+
		"\u0000\u0000\u00af\u00b4\u0005 \u0000\u0000\u00b0\u00b1\u0005\b\u0000"+
		"\u0000\u00b1\u00b3\u0005 \u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b6\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u0012\u0000\u0000"+
		"\u00b8\u00ba\u0005\u0006\u0000\u0000\u00b9\u00bb\u0003\u0014\n\u0000\u00ba"+
		"\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc"+
		"\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd"+
		"\u00be\u0001\u0000\u0000\u0000\u00be\u00c2\u0005\u0007\u0000\u0000\u00bf"+
		"\u00c1\u0005\"\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005\u0005\u0000\u0000\u00c6\u0013"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005\u001c\u0000\u0000\u00c8\u00c9"+
		"\u0005\r\u0000\u0000\u00c9\u00ca\u0005\u001b\u0000\u0000\u00ca\u00d2\u0005"+
		"\u0011\u0000\u0000\u00cb\u00cc\u0005\u001d\u0000\u0000\u00cc\u00cd\u0005"+
		"\r\u0000\u0000\u00cd\u00ce\u0007\u0001\u0000\u0000\u00ce\u00d2\u0005\u0011"+
		"\u0000\u0000\u00cf\u00d2\u0005\u001e\u0000\u0000\u00d0\u00d2\u0005\u001f"+
		"\u0000\u0000\u00d1\u00c7\u0001\u0000\u0000\u0000\u00d1\u00cb\u0001\u0000"+
		"\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d2\u0015\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\u0014"+
		"\u0000\u0000\u00d4\u00d6\u0005\u0002\u0000\u0000\u00d5\u00d7\u0003\u0018"+
		"\f\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00db\u0005\u0003\u0000"+
		"\u0000\u00db\u0017\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005!\u0000\u0000"+
		"\u00dd\u00de\u0005\u0015\u0000\u0000\u00de\u00e0\u0007\u0002\u0000\u0000"+
		"\u00df\u00e1\u0005\u0019\u0000\u0000\u00e0\u00df\u0001\u0000\u0000\u0000"+
		"\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00ed\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e3\u0005!\u0000\u0000\u00e3\u00e4\u0005\u0015\u0000\u0000\u00e4"+
		"\u00e6\u0005\u0002\u0000\u0000\u00e5\u00e7\u0003\u001a\r\u0000\u00e6\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005\u0003\u0000\u0000\u00eb\u00ed"+
		"\u0001\u0000\u0000\u0000\u00ec\u00dc\u0001\u0000\u0000\u0000\u00ec\u00e2"+
		"\u0001\u0000\u0000\u0000\u00ed\u0019\u0001\u0000\u0000\u0000\u00ee\u00f3"+
		"\u0005 \u0000\u0000\u00ef\u00f0\u0005\b\u0000\u0000\u00f0\u00f2\u0005"+
		" \u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f6\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f6\u00f7\u0005\u0012\u0000\u0000\u00f7\u00f9\u0007\u0002"+
		"\u0000\u0000\u00f8\u00fa\u0005\u0019\u0000\u0000\u00f9\u00f8\u0001\u0000"+
		"\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u001b\u0001\u0000"+
		"\u0000\u0000\u00fb\u00fc\u0005\u001a\u0000\u0000\u00fc\u00fd\u0005\f\u0000"+
		"\u0000\u00fd\u00ff\u0005\u0002\u0000\u0000\u00fe\u0100\u0003\u001e\u000f"+
		"\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000"+
		"\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000"+
		"\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0104\u0005\u0003\u0000"+
		"\u0000\u0104\u001d\u0001\u0000\u0000\u0000\u0105\u0106\u0005!\u0000\u0000"+
		"\u0106\u0108\u0005\r\u0000\u0000\u0107\u0109\u0007\u0000\u0000\u0000\u0108"+
		"\u0107\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109"+
		"\u010a\u0001\u0000\u0000\u0000\u010a\u010b\u0005\u0011\u0000\u0000\u010b"+
		"\u010f\u0005\u0002\u0000\u0000\u010c\u010e\u0003 \u0010\u0000\u010d\u010c"+
		"\u0001\u0000\u0000\u0000\u010e\u0111\u0001\u0000\u0000\u0000\u010f\u010d"+
		"\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0112"+
		"\u0001\u0000\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0112\u0113"+
		"\u0005\u0003\u0000\u0000\u0113\u001f\u0001\u0000\u0000\u0000\u0114\u0118"+
		"\u0005\u0006\u0000\u0000\u0115\u0117\u0003\"\u0011\u0000\u0116\u0115\u0001"+
		"\u0000\u0000\u0000\u0117\u011a\u0001\u0000\u0000\u0000\u0118\u0116\u0001"+
		"\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119\u011b\u0001"+
		"\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011b\u011f\u0005"+
		"\u0007\u0000\u0000\u011c\u011e\u0005\"\u0000\u0000\u011d\u011c\u0001\u0000"+
		"\u0000\u0000\u011e\u0121\u0001\u0000\u0000\u0000\u011f\u011d\u0001\u0000"+
		"\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120\u0122\u0001\u0000"+
		"\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0122\u0123\u0005\u0005"+
		"\u0000\u0000\u0123!\u0001\u0000\u0000\u0000\u0124\u0125\u0005\u001c\u0000"+
		"\u0000\u0125\u0126\u0005\r\u0000\u0000\u0126\u0127\u0005\u001b\u0000\u0000"+
		"\u0127\u0130\u0005\u0011\u0000\u0000\u0128\u0130\u0005\u001f\u0000\u0000"+
		"\u0129\u012d\u0005!\u0000\u0000\u012a\u012b\u0005\r\u0000\u0000\u012b"+
		"\u012c\u0005\u001b\u0000\u0000\u012c\u012e\u0005\u0011\u0000\u0000\u012d"+
		"\u012a\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e"+
		"\u0130\u0001\u0000\u0000\u0000\u012f\u0124\u0001\u0000\u0000\u0000\u012f"+
		"\u0128\u0001\u0000\u0000\u0000\u012f\u0129\u0001\u0000\u0000\u0000\u0130"+
		"#\u0001\u0000\u0000\u0000#,4<>EY^eqw{\u0083\u008a\u0091\u009a\u00a1\u00a9"+
		"\u00ad\u00b4\u00bc\u00c2\u00d1\u00d8\u00e0\u00e8\u00ec\u00f3\u00f9\u0101"+
		"\u0108\u010f\u0118\u011f\u012d\u012f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}