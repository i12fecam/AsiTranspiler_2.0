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
		T__24=25, NUMBER=26, LOAD_SC=27, LOAD_SR=28, SR_INCREMENT=29, SC_DECREMENT=30, 
		FLAG=31, IDENTIFIER=32, MICRO_INSTR=33, LINE_COMMENT=34, COMMENT=35, NEWLINE=36, 
		WS=37;
	public static final int
		RULE_prog = 0, RULE_variablesBlock = 1, RULE_variableDeclaration = 2, 
		RULE_programBlock = 3, RULE_programLine = 4, RULE_instructionUseArgument = 5, 
		RULE_cableInstructionBlock = 6, RULE_cableInstruction = 7, RULE_cableStep = 8, 
		RULE_conditionalCableStep = 9, RULE_microIntr = 10, RULE_statusLogicBlock = 11, 
		RULE_statusLogic = 12, RULE_statusLogicOption = 13, RULE_microInstructionBlock = 14, 
		RULE_microInstruction = 15, RULE_microStep = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "variablesBlock", "variableDeclaration", "programBlock", "programLine", 
			"instructionUseArgument", "cableInstructionBlock", "cableInstruction", 
			"cableStep", "conditionalCableStep", "microIntr", "statusLogicBlock", 
			"statusLogic", "statusLogicOption", "microInstructionBlock", "microInstruction", 
			"microStep"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'variables'", "'{'", "'}'", "'='", "';'", "'['", "']'", "','", 
			"'programa'", "'MARK'", "'@cableado'", "'instrucciones'", "'('", "'value'", 
			"'dir'", "'var'", "')'", "':'", "'estados'", "'->'", "'INCR'", "'BIF'", 
			"'RET'", "'DISABLE'", "'@microinstruccion'", null, "'LOAD_SC'", "'LOAD_SR'", 
			"'SR+1->SR'", "'SC-1->SC'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "NUMBER", "LOAD_SC", "LOAD_SR", "SR_INCREMENT", "SC_DECREMENT", 
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
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new MicroProgramableLogicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				statusLogicBlock();
				}
				break;
			case 2:
				_localctx = new CableProgramContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				cableInstructionBlock();
				setState(42);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(36);
					variablesBlock();
					setState(37);
					programBlock();
					}
					break;
				case T__8:
					{
					setState(39);
					programBlock();
					setState(40);
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
				setState(50);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__18:
					{
					setState(44);
					statusLogicBlock();
					setState(45);
					microInstructionBlock();
					}
					break;
				case T__24:
					{
					setState(47);
					microInstructionBlock();
					setState(48);
					statusLogicBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(58);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(52);
					variablesBlock();
					setState(53);
					programBlock();
					}
					break;
				case T__8:
					{
					setState(55);
					programBlock();
					setState(56);
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
			setState(62);
			match(T__0);
			setState(63);
			match(T__1);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(64);
				variableDeclaration();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
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
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new SimpleVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				((SimpleVariableDeclarationContext)_localctx).id = match(IDENTIFIER);
				setState(73);
				match(T__3);
				setState(74);
				((SimpleVariableDeclarationContext)_localctx).value = match(NUMBER);
				setState(75);
				match(T__4);
				}
				break;
			case 2:
				_localctx = new VectorVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				((VectorVariableDeclarationContext)_localctx).id = match(IDENTIFIER);
				setState(77);
				match(T__5);
				setState(78);
				((VectorVariableDeclarationContext)_localctx).size = match(NUMBER);
				setState(79);
				match(T__6);
				setState(80);
				match(T__3);
				setState(81);
				match(T__1);
				setState(82);
				((VectorVariableDeclarationContext)_localctx).NUMBER = match(NUMBER);
				((VectorVariableDeclarationContext)_localctx).value.add(((VectorVariableDeclarationContext)_localctx).NUMBER);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(83);
					match(T__7);
					setState(84);
					((VectorVariableDeclarationContext)_localctx).NUMBER = match(NUMBER);
					((VectorVariableDeclarationContext)_localctx).value.add(((VectorVariableDeclarationContext)_localctx).NUMBER);
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(90);
				match(T__2);
				setState(91);
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
			setState(94);
			match(T__8);
			setState(95);
			match(T__1);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9 || _la==IDENTIFIER) {
				{
				{
				setState(96);
				programLine();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
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
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new InstructionUseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				((InstructionUseContext)_localctx).name = match(IDENTIFIER);
				setState(105);
				((InstructionUseContext)_localctx).arg = instructionUseArgument();
				setState(106);
				match(T__4);
				}
				break;
			case T__9:
				_localctx = new MarkUseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(T__9);
				setState(109);
				((MarkUseContext)_localctx).label = match(IDENTIFIER);
				setState(110);
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
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				((InstructionUseArgumentContext)_localctx).var = match(IDENTIFIER);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(114);
					match(T__5);
					setState(115);
					((InstructionUseArgumentContext)_localctx).offset = match(NUMBER);
					setState(116);
					match(T__6);
					}
				}

				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
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
			setState(123);
			match(T__10);
			setState(124);
			match(T__11);
			setState(125);
			match(T__1);
			setState(127); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(126);
				cableInstruction();
				}
				}
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(131);
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
			setState(133);
			match(IDENTIFIER);
			setState(134);
			match(T__12);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) {
				{
				setState(135);
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

			setState(138);
			match(T__16);
			setState(139);
			match(T__1);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==T__5) {
				{
				{
				setState(140);
				cableStep();
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
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
		public MicroIntrContext linstr;
		public MicroIntrContext microIntr;
		public List<MicroIntrContext> rinstr = new ArrayList<MicroIntrContext>();
		public List<MicroIntrContext> microIntr() {
			return getRuleContexts(MicroIntrContext.class);
		}
		public MicroIntrContext microIntr(int i) {
			return getRuleContext(MicroIntrContext.class,i);
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
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new SimpleCableStepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(T__5);
				setState(149);
				((SimpleCableStepContext)_localctx).linstr = microIntr();
				setState(150);
				match(T__6);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MICRO_INSTR) {
					{
					{
					setState(151);
					((SimpleCableStepContext)_localctx).microIntr = microIntr();
					((SimpleCableStepContext)_localctx).rinstr.add(((SimpleCableStepContext)_localctx).microIntr);
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157);
				match(T__4);
				}
				break;
			case T__1:
				_localctx = new ConditionalCableStepBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(T__1);
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(160);
					conditionalCableStep();
					}
					}
					setState(163); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==FLAG );
				setState(165);
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
		public MicroIntrContext linstr;
		public MicroIntrContext microIntr;
		public List<MicroIntrContext> rinstr = new ArrayList<MicroIntrContext>();
		public List<TerminalNode> FLAG() { return getTokens(SicomeParser.FLAG); }
		public TerminalNode FLAG(int i) {
			return getToken(SicomeParser.FLAG, i);
		}
		public List<MicroIntrContext> microIntr() {
			return getRuleContexts(MicroIntrContext.class);
		}
		public MicroIntrContext microIntr(int i) {
			return getRuleContext(MicroIntrContext.class,i);
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
			setState(169);
			((ConditionalCableStepContext)_localctx).FLAG = match(FLAG);
			((ConditionalCableStepContext)_localctx).flags.add(((ConditionalCableStepContext)_localctx).FLAG);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(170);
				match(T__7);
				setState(171);
				((ConditionalCableStepContext)_localctx).FLAG = match(FLAG);
				((ConditionalCableStepContext)_localctx).flags.add(((ConditionalCableStepContext)_localctx).FLAG);
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(177);
			match(T__17);
			setState(178);
			match(T__5);
			setState(179);
			((ConditionalCableStepContext)_localctx).linstr = microIntr();
			setState(180);
			match(T__6);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MICRO_INSTR) {
				{
				{
				setState(181);
				((ConditionalCableStepContext)_localctx).microIntr = microIntr();
				((ConditionalCableStepContext)_localctx).rinstr.add(((ConditionalCableStepContext)_localctx).microIntr);
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
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
	public static class MicroIntrContext extends ParserRuleContext {
		public Token arg;
		public TerminalNode MICRO_INSTR() { return getToken(SicomeParser.MICRO_INSTR, 0); }
		public TerminalNode NUMBER() { return getToken(SicomeParser.NUMBER, 0); }
		public MicroIntrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_microIntr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterMicroIntr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitMicroIntr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitMicroIntr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MicroIntrContext microIntr() throws RecognitionException {
		MicroIntrContext _localctx = new MicroIntrContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_microIntr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(MICRO_INSTR);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(190);
				match(T__12);
				setState(191);
				((MicroIntrContext)_localctx).arg = match(NUMBER);
				setState(192);
				match(T__16);
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
			setState(195);
			match(T__18);
			setState(196);
			match(T__1);
			setState(198); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(197);
				statusLogic();
				}
				}
				setState(200); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(202);
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
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new SimpleStatusLogicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				((SimpleStatusLogicContext)_localctx).name = match(IDENTIFIER);
				setState(205);
				match(T__19);
				setState(206);
				((SimpleStatusLogicContext)_localctx).option = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14680064L) != 0)) ) {
					((SimpleStatusLogicContext)_localctx).option = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__23) {
					{
					setState(207);
					((SimpleStatusLogicContext)_localctx).disable = match(T__23);
					}
				}

				}
				break;
			case 2:
				_localctx = new ComplexStatusLogicContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				((ComplexStatusLogicContext)_localctx).name = match(IDENTIFIER);
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
					statusLogicOption();
					}
					}
					setState(216); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==FLAG );
				setState(218);
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
			setState(222);
			((StatusLogicOptionContext)_localctx).FLAG = match(FLAG);
			((StatusLogicOptionContext)_localctx).flags.add(((StatusLogicOptionContext)_localctx).FLAG);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(223);
				match(T__7);
				setState(224);
				((StatusLogicOptionContext)_localctx).FLAG = match(FLAG);
				((StatusLogicOptionContext)_localctx).flags.add(((StatusLogicOptionContext)_localctx).FLAG);
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(230);
			match(T__17);
			setState(231);
			((StatusLogicOptionContext)_localctx).option = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14680064L) != 0)) ) {
				((StatusLogicOptionContext)_localctx).option = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(232);
				((StatusLogicOptionContext)_localctx).disable = match(T__23);
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
			setState(235);
			match(T__24);
			setState(236);
			match(T__11);
			setState(237);
			match(T__1);
			setState(239); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(238);
				microInstruction();
				}
				}
				setState(241); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(243);
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
			setState(245);
			match(IDENTIFIER);
			setState(246);
			match(T__12);
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) {
				{
				setState(247);
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

			setState(250);
			match(T__16);
			setState(251);
			match(T__1);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(252);
				microStep();
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(258);
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
		public Token biflogic;
		public Token arg;
		public MicroIntrContext microIntr;
		public List<MicroIntrContext> instr = new ArrayList<MicroIntrContext>();
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public TerminalNode NUMBER() { return getToken(SicomeParser.NUMBER, 0); }
		public List<MicroIntrContext> microIntr() {
			return getRuleContexts(MicroIntrContext.class);
		}
		public MicroIntrContext microIntr(int i) {
			return getRuleContext(MicroIntrContext.class,i);
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
			setState(260);
			match(T__5);
			setState(261);
			((MicroStepContext)_localctx).biflogic = match(IDENTIFIER);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(262);
				match(T__12);
				setState(263);
				((MicroStepContext)_localctx).arg = match(NUMBER);
				setState(264);
				match(T__16);
				}
			}

			setState(267);
			match(T__6);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MICRO_INSTR) {
				{
				{
				setState(268);
				((MicroStepContext)_localctx).microIntr = microIntr();
				((MicroStepContext)_localctx).instr.add(((MicroStepContext)_localctx).microIntr);
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(274);
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

	public static final String _serializedATN =
		"\u0004\u0001%\u0115\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000+\b\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u00003\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u0000;\b\u0000\u0003\u0000=\b\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001B\b\u0001\n\u0001\f\u0001E\t"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002V\b\u0002\n\u0002"+
		"\f\u0002Y\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002]\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003b\b\u0003\n\u0003\f\u0003e\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004p\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005v\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005z\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0004\u0006\u0080\b\u0006\u000b\u0006\f\u0006\u0081\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0089"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u008e\b\u0007"+
		"\n\u0007\f\u0007\u0091\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0005\b\u0099\b\b\n\b\f\b\u009c\t\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0004\b\u00a2\b\b\u000b\b\f\b\u00a3\u0001\b\u0001\b\u0003\b"+
		"\u00a8\b\b\u0001\t\u0001\t\u0001\t\u0005\t\u00ad\b\t\n\t\f\t\u00b0\t\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00b7\b\t\n\t\f\t\u00ba"+
		"\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00c2\b\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u00c7\b\u000b\u000b\u000b"+
		"\f\u000b\u00c8\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0003\f\u00d1\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0004\f\u00d7\b\f\u000b"+
		"\f\f\f\u00d8\u0001\f\u0001\f\u0003\f\u00dd\b\f\u0001\r\u0001\r\u0001\r"+
		"\u0005\r\u00e2\b\r\n\r\f\r\u00e5\t\r\u0001\r\u0001\r\u0001\r\u0003\r\u00ea"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u00f0"+
		"\b\u000e\u000b\u000e\f\u000e\u00f1\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u00f9\b\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0005\u000f\u00fe\b\u000f\n\u000f\f\u000f\u0101\t\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u010a\b\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u010e"+
		"\b\u0010\n\u0010\f\u0010\u0111\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0000\u0000\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \u0000\u0002\u0001\u0000\u000e\u0010\u0001"+
		"\u0000\u0015\u0017\u0126\u0000<\u0001\u0000\u0000\u0000\u0002>\u0001\u0000"+
		"\u0000\u0000\u0004\\\u0001\u0000\u0000\u0000\u0006^\u0001\u0000\u0000"+
		"\u0000\bo\u0001\u0000\u0000\u0000\ny\u0001\u0000\u0000\u0000\f{\u0001"+
		"\u0000\u0000\u0000\u000e\u0085\u0001\u0000\u0000\u0000\u0010\u00a7\u0001"+
		"\u0000\u0000\u0000\u0012\u00a9\u0001\u0000\u0000\u0000\u0014\u00bd\u0001"+
		"\u0000\u0000\u0000\u0016\u00c3\u0001\u0000\u0000\u0000\u0018\u00dc\u0001"+
		"\u0000\u0000\u0000\u001a\u00de\u0001\u0000\u0000\u0000\u001c\u00eb\u0001"+
		"\u0000\u0000\u0000\u001e\u00f5\u0001\u0000\u0000\u0000 \u0104\u0001\u0000"+
		"\u0000\u0000\"=\u0003\u0016\u000b\u0000#*\u0003\f\u0006\u0000$%\u0003"+
		"\u0002\u0001\u0000%&\u0003\u0006\u0003\u0000&+\u0001\u0000\u0000\u0000"+
		"\'(\u0003\u0006\u0003\u0000()\u0003\u0002\u0001\u0000)+\u0001\u0000\u0000"+
		"\u0000*$\u0001\u0000\u0000\u0000*\'\u0001\u0000\u0000\u0000*+\u0001\u0000"+
		"\u0000\u0000+=\u0001\u0000\u0000\u0000,-\u0003\u0016\u000b\u0000-.\u0003"+
		"\u001c\u000e\u0000.3\u0001\u0000\u0000\u0000/0\u0003\u001c\u000e\u0000"+
		"01\u0003\u0016\u000b\u000013\u0001\u0000\u0000\u00002,\u0001\u0000\u0000"+
		"\u00002/\u0001\u0000\u0000\u00003:\u0001\u0000\u0000\u000045\u0003\u0002"+
		"\u0001\u000056\u0003\u0006\u0003\u00006;\u0001\u0000\u0000\u000078\u0003"+
		"\u0006\u0003\u000089\u0003\u0002\u0001\u00009;\u0001\u0000\u0000\u0000"+
		":4\u0001\u0000\u0000\u0000:7\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000"+
		"\u0000;=\u0001\u0000\u0000\u0000<\"\u0001\u0000\u0000\u0000<#\u0001\u0000"+
		"\u0000\u0000<2\u0001\u0000\u0000\u0000=\u0001\u0001\u0000\u0000\u0000"+
		">?\u0005\u0001\u0000\u0000?C\u0005\u0002\u0000\u0000@B\u0003\u0004\u0002"+
		"\u0000A@\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000"+
		"\u0000\u0000CD\u0001\u0000\u0000\u0000DF\u0001\u0000\u0000\u0000EC\u0001"+
		"\u0000\u0000\u0000FG\u0005\u0003\u0000\u0000G\u0003\u0001\u0000\u0000"+
		"\u0000HI\u0005 \u0000\u0000IJ\u0005\u0004\u0000\u0000JK\u0005\u001a\u0000"+
		"\u0000K]\u0005\u0005\u0000\u0000LM\u0005 \u0000\u0000MN\u0005\u0006\u0000"+
		"\u0000NO\u0005\u001a\u0000\u0000OP\u0005\u0007\u0000\u0000PQ\u0005\u0004"+
		"\u0000\u0000QR\u0005\u0002\u0000\u0000RW\u0005\u001a\u0000\u0000ST\u0005"+
		"\b\u0000\u0000TV\u0005\u001a\u0000\u0000US\u0001\u0000\u0000\u0000VY\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Z[\u0005\u0003\u0000"+
		"\u0000[]\u0005\u0005\u0000\u0000\\H\u0001\u0000\u0000\u0000\\L\u0001\u0000"+
		"\u0000\u0000]\u0005\u0001\u0000\u0000\u0000^_\u0005\t\u0000\u0000_c\u0005"+
		"\u0002\u0000\u0000`b\u0003\b\u0004\u0000a`\u0001\u0000\u0000\u0000be\u0001"+
		"\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000"+
		"df\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000fg\u0005\u0003\u0000"+
		"\u0000g\u0007\u0001\u0000\u0000\u0000hi\u0005 \u0000\u0000ij\u0003\n\u0005"+
		"\u0000jk\u0005\u0005\u0000\u0000kp\u0001\u0000\u0000\u0000lm\u0005\n\u0000"+
		"\u0000mn\u0005 \u0000\u0000np\u0005\u0005\u0000\u0000oh\u0001\u0000\u0000"+
		"\u0000ol\u0001\u0000\u0000\u0000p\t\u0001\u0000\u0000\u0000qu\u0005 \u0000"+
		"\u0000rs\u0005\u0006\u0000\u0000st\u0005\u001a\u0000\u0000tv\u0005\u0007"+
		"\u0000\u0000ur\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vz\u0001"+
		"\u0000\u0000\u0000wz\u0005\u001a\u0000\u0000xz\u0001\u0000\u0000\u0000"+
		"yq\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000yx\u0001\u0000\u0000"+
		"\u0000z\u000b\u0001\u0000\u0000\u0000{|\u0005\u000b\u0000\u0000|}\u0005"+
		"\f\u0000\u0000}\u007f\u0005\u0002\u0000\u0000~\u0080\u0003\u000e\u0007"+
		"\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000"+
		"\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u0003\u0000\u0000"+
		"\u0084\r\u0001\u0000\u0000\u0000\u0085\u0086\u0005 \u0000\u0000\u0086"+
		"\u0088\u0005\r\u0000\u0000\u0087\u0089\u0007\u0000\u0000\u0000\u0088\u0087"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0011\u0000\u0000\u008b\u008f"+
		"\u0005\u0002\u0000\u0000\u008c\u008e\u0003\u0010\b\u0000\u008d\u008c\u0001"+
		"\u0000\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001"+
		"\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0092\u0001"+
		"\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0093\u0005"+
		"\u0003\u0000\u0000\u0093\u000f\u0001\u0000\u0000\u0000\u0094\u0095\u0005"+
		"\u0006\u0000\u0000\u0095\u0096\u0003\u0014\n\u0000\u0096\u009a\u0005\u0007"+
		"\u0000\u0000\u0097\u0099\u0003\u0014\n\u0000\u0098\u0097\u0001\u0000\u0000"+
		"\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009d\u0001\u0000\u0000"+
		"\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u009e\u0005\u0005\u0000"+
		"\u0000\u009e\u00a8\u0001\u0000\u0000\u0000\u009f\u00a1\u0005\u0002\u0000"+
		"\u0000\u00a0\u00a2\u0003\u0012\t\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0005\u0003\u0000\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a7\u0094\u0001\u0000\u0000\u0000\u00a7\u009f\u0001\u0000\u0000\u0000"+
		"\u00a8\u0011\u0001\u0000\u0000\u0000\u00a9\u00ae\u0005\u001f\u0000\u0000"+
		"\u00aa\u00ab\u0005\b\u0000\u0000\u00ab\u00ad\u0005\u001f\u0000\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0005\u0012\u0000\u0000\u00b2\u00b3\u0005\u0006\u0000\u0000\u00b3"+
		"\u00b4\u0003\u0014\n\u0000\u00b4\u00b8\u0005\u0007\u0000\u0000\u00b5\u00b7"+
		"\u0003\u0014\n\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001"+
		"\u0000\u0000\u0000\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001"+
		"\u0000\u0000\u0000\u00bb\u00bc\u0005\u0005\u0000\u0000\u00bc\u0013\u0001"+
		"\u0000\u0000\u0000\u00bd\u00c1\u0005!\u0000\u0000\u00be\u00bf\u0005\r"+
		"\u0000\u0000\u00bf\u00c0\u0005\u001a\u0000\u0000\u00c0\u00c2\u0005\u0011"+
		"\u0000\u0000\u00c1\u00be\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c2\u0015\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005\u0013"+
		"\u0000\u0000\u00c4\u00c6\u0005\u0002\u0000\u0000\u00c5\u00c7\u0003\u0018"+
		"\f\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000"+
		"\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005\u0003\u0000"+
		"\u0000\u00cb\u0017\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005 \u0000\u0000"+
		"\u00cd\u00ce\u0005\u0014\u0000\u0000\u00ce\u00d0\u0007\u0001\u0000\u0000"+
		"\u00cf\u00d1\u0005\u0018\u0000\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00dd\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d3\u0005 \u0000\u0000\u00d3\u00d4\u0005\u0014\u0000\u0000\u00d4"+
		"\u00d6\u0005\u0002\u0000\u0000\u00d5\u00d7\u0003\u001a\r\u0000\u00d6\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0001\u0000\u0000\u0000\u00da\u00db\u0005\u0003\u0000\u0000\u00db\u00dd"+
		"\u0001\u0000\u0000\u0000\u00dc\u00cc\u0001\u0000\u0000\u0000\u00dc\u00d2"+
		"\u0001\u0000\u0000\u0000\u00dd\u0019\u0001\u0000\u0000\u0000\u00de\u00e3"+
		"\u0005\u001f\u0000\u0000\u00df\u00e0\u0005\b\u0000\u0000\u00e0\u00e2\u0005"+
		"\u001f\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e6\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e7\u0005\u0012\u0000\u0000\u00e7\u00e9\u0007"+
		"\u0001\u0000\u0000\u00e8\u00ea\u0005\u0018\u0000\u0000\u00e9\u00e8\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u001b\u0001"+
		"\u0000\u0000\u0000\u00eb\u00ec\u0005\u0019\u0000\u0000\u00ec\u00ed\u0005"+
		"\f\u0000\u0000\u00ed\u00ef\u0005\u0002\u0000\u0000\u00ee\u00f0\u0003\u001e"+
		"\u000f\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000"+
		"\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005\u0003"+
		"\u0000\u0000\u00f4\u001d\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005 \u0000"+
		"\u0000\u00f6\u00f8\u0005\r\u0000\u0000\u00f7\u00f9\u0007\u0000\u0000\u0000"+
		"\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000"+
		"\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005\u0011\u0000\u0000"+
		"\u00fb\u00ff\u0005\u0002\u0000\u0000\u00fc\u00fe\u0003 \u0010\u0000\u00fd"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fe\u0101\u0001\u0000\u0000\u0000\u00ff"+
		"\u00fd\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100"+
		"\u0102\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0102"+
		"\u0103\u0005\u0003\u0000\u0000\u0103\u001f\u0001\u0000\u0000\u0000\u0104"+
		"\u0105\u0005\u0006\u0000\u0000\u0105\u0109\u0005 \u0000\u0000\u0106\u0107"+
		"\u0005\r\u0000\u0000\u0107\u0108\u0005\u001a\u0000\u0000\u0108\u010a\u0005"+
		"\u0011\u0000\u0000\u0109\u0106\u0001\u0000\u0000\u0000\u0109\u010a\u0001"+
		"\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u010f\u0005"+
		"\u0007\u0000\u0000\u010c\u010e\u0003\u0014\n\u0000\u010d\u010c\u0001\u0000"+
		"\u0000\u0000\u010e\u0111\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000"+
		"\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0112\u0001\u0000"+
		"\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0112\u0113\u0005\u0005"+
		"\u0000\u0000\u0113!\u0001\u0000\u0000\u0000\u001f*2:<CW\\couy\u0081\u0088"+
		"\u008f\u009a\u00a3\u00a7\u00ae\u00b8\u00c1\u00c8\u00d0\u00d8\u00dc\u00e3"+
		"\u00e9\u00f1\u00f8\u00ff\u0109\u010f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}