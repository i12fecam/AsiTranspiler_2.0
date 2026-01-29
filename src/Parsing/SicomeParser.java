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
		T__24=25, T__25=26, T__26=27, MEMORYVALUE=28, DECNUMBER=29, FLAG=30, IDENTIFIER=31, 
		MICRO_INSTR=32, LINE_COMMENT=33, COMMENT=34, NEWLINE=35, WS=36;
	public static final int
		RULE_prog = 0, RULE_variablesBlock = 1, RULE_variableDeclaration = 2, 
		RULE_programBlock = 3, RULE_programLine = 4, RULE_instructionUseArgument = 5, 
		RULE_cableInstructionBlock = 6, RULE_cableInstruction = 7, RULE_fetchCableInstruction = 8, 
		RULE_cableStep = 9, RULE_conditionalCableStep = 10, RULE_microIntr = 11, 
		RULE_specialMicroIntr = 12, RULE_statusLogicBlock = 13, RULE_statusLogic = 14, 
		RULE_statusLogicOption = 15, RULE_microInstructionBlock = 16, RULE_fetchMicroInstruction = 17, 
		RULE_microInstruction = 18, RULE_microStep = 19, RULE_bifLogicArgument = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "variablesBlock", "variableDeclaration", "programBlock", "programLine", 
			"instructionUseArgument", "cableInstructionBlock", "cableInstruction", 
			"fetchCableInstruction", "cableStep", "conditionalCableStep", "microIntr", 
			"specialMicroIntr", "statusLogicBlock", "statusLogic", "statusLogicOption", 
			"microInstructionBlock", "fetchMicroInstruction", "microInstruction", 
			"microStep", "bifLogicArgument"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Variables'", "'{'", "'}'", "'='", "';'", "'('", "')'", "','", 
			"'Programa'", "'MARK'", "'@Cable'", "'Instrucciones'", "'Value'", "'Dir'", 
			"'Var'", "'Fetch'", "'|'", "':'", "'START'", "'L\\u00F3gica'", "'->'", 
			"'INCR'", "'BIF'", "'RTN'", "'DISABLE'", "'@Micro'", "'~'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "MEMORYVALUE", "DECNUMBER", "FLAG", "IDENTIFIER", 
			"MICRO_INSTR", "LINE_COMMENT", "COMMENT", "NEWLINE", "WS"
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
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new MicroProgramableLogicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				statusLogicBlock();
				}
				break;
			case 2:
				_localctx = new CableProgramContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				cableInstructionBlock();
				setState(50);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(44);
					variablesBlock();
					setState(45);
					programBlock();
					}
					break;
				case T__8:
					{
					setState(47);
					programBlock();
					setState(48);
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
				setState(58);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__19:
					{
					setState(52);
					statusLogicBlock();
					setState(53);
					microInstructionBlock();
					}
					break;
				case T__25:
					{
					setState(55);
					microInstructionBlock();
					setState(56);
					statusLogicBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(66);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(60);
					variablesBlock();
					setState(61);
					programBlock();
					}
					break;
				case T__8:
					{
					setState(63);
					programBlock();
					setState(64);
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
			setState(70);
			match(T__0);
			setState(71);
			match(T__1);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(72);
				variableDeclaration();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
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
		public TerminalNode MEMORYVALUE() { return getToken(SicomeParser.MEMORYVALUE, 0); }
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
		public Token MEMORYVALUE;
		public List<Token> value = new ArrayList<Token>();
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public TerminalNode DECNUMBER() { return getToken(SicomeParser.DECNUMBER, 0); }
		public List<TerminalNode> MEMORYVALUE() { return getTokens(SicomeParser.MEMORYVALUE); }
		public TerminalNode MEMORYVALUE(int i) {
			return getToken(SicomeParser.MEMORYVALUE, i);
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
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new SimpleVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				((SimpleVariableDeclarationContext)_localctx).id = match(IDENTIFIER);
				setState(81);
				match(T__3);
				setState(82);
				((SimpleVariableDeclarationContext)_localctx).value = match(MEMORYVALUE);
				setState(83);
				match(T__4);
				}
				break;
			case 2:
				_localctx = new VectorVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				((VectorVariableDeclarationContext)_localctx).id = match(IDENTIFIER);
				setState(85);
				match(T__5);
				setState(86);
				((VectorVariableDeclarationContext)_localctx).size = match(DECNUMBER);
				setState(87);
				match(T__6);
				setState(88);
				match(T__3);
				setState(89);
				match(T__1);
				setState(90);
				((VectorVariableDeclarationContext)_localctx).MEMORYVALUE = match(MEMORYVALUE);
				((VectorVariableDeclarationContext)_localctx).value.add(((VectorVariableDeclarationContext)_localctx).MEMORYVALUE);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(91);
					match(T__7);
					setState(92);
					((VectorVariableDeclarationContext)_localctx).MEMORYVALUE = match(MEMORYVALUE);
					((VectorVariableDeclarationContext)_localctx).value.add(((VectorVariableDeclarationContext)_localctx).MEMORYVALUE);
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(98);
				match(T__2);
				setState(99);
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
			setState(102);
			match(T__8);
			setState(103);
			match(T__1);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9 || _la==IDENTIFIER) {
				{
				{
				setState(104);
				programLine();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
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
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new InstructionUseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				((InstructionUseContext)_localctx).name = match(IDENTIFIER);
				setState(113);
				((InstructionUseContext)_localctx).arg = instructionUseArgument();
				setState(114);
				match(T__4);
				}
				break;
			case T__9:
				_localctx = new MarkUseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(T__9);
				setState(117);
				((MarkUseContext)_localctx).label = match(IDENTIFIER);
				setState(118);
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
		public TerminalNode DECNUMBER() { return getToken(SicomeParser.DECNUMBER, 0); }
		public TerminalNode MEMORYVALUE() { return getToken(SicomeParser.MEMORYVALUE, 0); }
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
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				((InstructionUseArgumentContext)_localctx).var = match(IDENTIFIER);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(122);
					match(T__5);
					setState(123);
					((InstructionUseArgumentContext)_localctx).offset = match(DECNUMBER);
					setState(124);
					match(T__6);
					}
				}

				}
				break;
			case MEMORYVALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				((InstructionUseArgumentContext)_localctx).num = match(MEMORYVALUE);
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
		public FetchCableInstructionContext fetchCableInstruction() {
			return getRuleContext(FetchCableInstructionContext.class,0);
		}
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
			setState(131);
			match(T__10);
			setState(132);
			match(T__11);
			setState(133);
			match(T__1);
			setState(134);
			fetchCableInstruction();
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(135);
				cableInstruction();
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(140);
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
			setState(142);
			match(IDENTIFIER);
			setState(143);
			match(T__5);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 57344L) != 0)) {
				{
				setState(144);
				((CableInstructionContext)_localctx).arg = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 57344L) != 0)) ) {
					((CableInstructionContext)_localctx).arg = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(147);
			match(T__6);
			setState(148);
			match(T__1);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==T__16) {
				{
				{
				setState(149);
				cableStep();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
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
	public static class FetchCableInstructionContext extends ParserRuleContext {
		public List<CableStepContext> cableStep() {
			return getRuleContexts(CableStepContext.class);
		}
		public CableStepContext cableStep(int i) {
			return getRuleContext(CableStepContext.class,i);
		}
		public FetchCableInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fetchCableInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterFetchCableInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitFetchCableInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitFetchCableInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FetchCableInstructionContext fetchCableInstruction() throws RecognitionException {
		FetchCableInstructionContext _localctx = new FetchCableInstructionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fetchCableInstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__15);
			setState(158);
			match(T__1);
			setState(160); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(159);
				cableStep();
				}
				}
				setState(162); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 || _la==T__16 );
			setState(164);
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
		public SpecialMicroIntrContext linstr;
		public MicroIntrContext microIntr;
		public List<MicroIntrContext> rinstr = new ArrayList<MicroIntrContext>();
		public SpecialMicroIntrContext specialMicroIntr() {
			return getRuleContext(SpecialMicroIntrContext.class,0);
		}
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
		enterRule(_localctx, 18, RULE_cableStep);
		int _la;
		try {
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				_localctx = new SimpleCableStepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(T__16);
				setState(167);
				((SimpleCableStepContext)_localctx).linstr = specialMicroIntr();
				setState(168);
				match(T__16);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MICRO_INSTR) {
					{
					{
					setState(169);
					((SimpleCableStepContext)_localctx).microIntr = microIntr();
					((SimpleCableStepContext)_localctx).rinstr.add(((SimpleCableStepContext)_localctx).microIntr);
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175);
				match(T__4);
				}
				break;
			case T__1:
				_localctx = new ConditionalCableStepBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(T__1);
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(178);
					conditionalCableStep();
					}
					}
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==FLAG );
				setState(183);
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
		public SpecialMicroIntrContext linstr;
		public MicroIntrContext microIntr;
		public List<MicroIntrContext> rinstr = new ArrayList<MicroIntrContext>();
		public List<TerminalNode> FLAG() { return getTokens(SicomeParser.FLAG); }
		public TerminalNode FLAG(int i) {
			return getToken(SicomeParser.FLAG, i);
		}
		public SpecialMicroIntrContext specialMicroIntr() {
			return getRuleContext(SpecialMicroIntrContext.class,0);
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
		enterRule(_localctx, 20, RULE_conditionalCableStep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			((ConditionalCableStepContext)_localctx).FLAG = match(FLAG);
			((ConditionalCableStepContext)_localctx).flags.add(((ConditionalCableStepContext)_localctx).FLAG);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(188);
				match(T__7);
				setState(189);
				((ConditionalCableStepContext)_localctx).FLAG = match(FLAG);
				((ConditionalCableStepContext)_localctx).flags.add(((ConditionalCableStepContext)_localctx).FLAG);
				}
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(195);
			match(T__17);
			setState(196);
			match(T__16);
			setState(197);
			((ConditionalCableStepContext)_localctx).linstr = specialMicroIntr();
			setState(198);
			match(T__16);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MICRO_INSTR) {
				{
				{
				setState(199);
				((ConditionalCableStepContext)_localctx).microIntr = microIntr();
				((ConditionalCableStepContext)_localctx).rinstr.add(((ConditionalCableStepContext)_localctx).microIntr);
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(205);
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
		public TerminalNode DECNUMBER() { return getToken(SicomeParser.DECNUMBER, 0); }
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
		enterRule(_localctx, 22, RULE_microIntr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(MICRO_INSTR);
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(208);
				match(T__5);
				setState(209);
				((MicroIntrContext)_localctx).arg = match(DECNUMBER);
				setState(210);
				match(T__6);
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
	public static class SpecialMicroIntrContext extends ParserRuleContext {
		public Token arg;
		public TerminalNode MICRO_INSTR() { return getToken(SicomeParser.MICRO_INSTR, 0); }
		public TerminalNode DECNUMBER() { return getToken(SicomeParser.DECNUMBER, 0); }
		public SpecialMicroIntrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialMicroIntr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterSpecialMicroIntr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitSpecialMicroIntr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitSpecialMicroIntr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialMicroIntrContext specialMicroIntr() throws RecognitionException {
		SpecialMicroIntrContext _localctx = new SpecialMicroIntrContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_specialMicroIntr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(MICRO_INSTR);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(214);
				match(T__5);
				setState(215);
				((SpecialMicroIntrContext)_localctx).arg = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__18 || _la==DECNUMBER) ) {
					((SpecialMicroIntrContext)_localctx).arg = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(216);
				match(T__6);
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
		enterRule(_localctx, 26, RULE_statusLogicBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(T__19);
			setState(220);
			match(T__1);
			setState(222); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(221);
				statusLogic();
				}
				}
				setState(224); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(226);
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
		enterRule(_localctx, 28, RULE_statusLogic);
		int _la;
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new SimpleStatusLogicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				((SimpleStatusLogicContext)_localctx).name = match(IDENTIFIER);
				setState(229);
				match(T__20);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 29360128L) != 0)) {
					{
					setState(230);
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
					}
				}

				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(233);
					((SimpleStatusLogicContext)_localctx).disable = match(T__24);
					}
				}

				}
				break;
			case 2:
				_localctx = new ComplexStatusLogicContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				((ComplexStatusLogicContext)_localctx).name = match(IDENTIFIER);
				setState(237);
				match(T__20);
				setState(238);
				match(T__1);
				setState(240); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(239);
					statusLogicOption();
					}
					}
					setState(242); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==FLAG );
				setState(244);
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
		enterRule(_localctx, 30, RULE_statusLogicOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			((StatusLogicOptionContext)_localctx).FLAG = match(FLAG);
			((StatusLogicOptionContext)_localctx).flags.add(((StatusLogicOptionContext)_localctx).FLAG);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(249);
				match(T__7);
				setState(250);
				((StatusLogicOptionContext)_localctx).FLAG = match(FLAG);
				((StatusLogicOptionContext)_localctx).flags.add(((StatusLogicOptionContext)_localctx).FLAG);
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256);
			match(T__17);
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 29360128L) != 0)) {
				{
				setState(257);
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
				}
			}

			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(260);
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
		public FetchMicroInstructionContext fetchMicroInstruction() {
			return getRuleContext(FetchMicroInstructionContext.class,0);
		}
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
		enterRule(_localctx, 32, RULE_microInstructionBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(T__25);
			setState(264);
			match(T__11);
			setState(265);
			match(T__1);
			setState(266);
			fetchMicroInstruction();
			setState(268); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(267);
				microInstruction();
				}
				}
				setState(270); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(272);
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
	public static class FetchMicroInstructionContext extends ParserRuleContext {
		public List<MicroStepContext> microStep() {
			return getRuleContexts(MicroStepContext.class);
		}
		public MicroStepContext microStep(int i) {
			return getRuleContext(MicroStepContext.class,i);
		}
		public FetchMicroInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fetchMicroInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterFetchMicroInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitFetchMicroInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitFetchMicroInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FetchMicroInstructionContext fetchMicroInstruction() throws RecognitionException {
		FetchMicroInstructionContext _localctx = new FetchMicroInstructionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_fetchMicroInstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(T__15);
			setState(275);
			match(T__1);
			setState(277); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(276);
				microStep();
				}
				}
				setState(279); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__16 );
			setState(281);
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
		enterRule(_localctx, 36, RULE_microInstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(IDENTIFIER);
			setState(284);
			match(T__5);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 57344L) != 0)) {
				{
				setState(285);
				((MicroInstructionContext)_localctx).arg = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 57344L) != 0)) ) {
					((MicroInstructionContext)_localctx).arg = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(288);
			match(T__6);
			setState(289);
			match(T__1);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(290);
				microStep();
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(296);
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
		public MicroIntrContext microIntr;
		public List<MicroIntrContext> instr = new ArrayList<MicroIntrContext>();
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public BifLogicArgumentContext bifLogicArgument() {
			return getRuleContext(BifLogicArgumentContext.class,0);
		}
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
		enterRule(_localctx, 38, RULE_microStep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(T__16);
			setState(299);
			((MicroStepContext)_localctx).biflogic = match(IDENTIFIER);
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(300);
				match(T__5);
				setState(301);
				bifLogicArgument();
				setState(302);
				match(T__6);
				}
			}

			setState(306);
			match(T__16);
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MICRO_INSTR) {
				{
				{
				setState(307);
				((MicroStepContext)_localctx).microIntr = microIntr();
				((MicroStepContext)_localctx).instr.add(((MicroStepContext)_localctx).microIntr);
				}
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(313);
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
	public static class BifLogicArgumentContext extends ParserRuleContext {
		public BifLogicArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bifLogicArgument; }
	 
		public BifLogicArgumentContext() { }
		public void copyFrom(BifLogicArgumentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstructionBifLogicArgumentContext extends BifLogicArgumentContext {
		public Token instr;
		public Token arg;
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public TerminalNode DECNUMBER() { return getToken(SicomeParser.DECNUMBER, 0); }
		public InstructionBifLogicArgumentContext(BifLogicArgumentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterInstructionBifLogicArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitInstructionBifLogicArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitInstructionBifLogicArgument(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StartBifLogicArgumentContext extends BifLogicArgumentContext {
		public TerminalNode DECNUMBER() { return getToken(SicomeParser.DECNUMBER, 0); }
		public StartBifLogicArgumentContext(BifLogicArgumentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterStartBifLogicArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitStartBifLogicArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SicomeVisitor ) return ((SicomeVisitor<? extends T>)visitor).visitStartBifLogicArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BifLogicArgumentContext bifLogicArgument() throws RecognitionException {
		BifLogicArgumentContext _localctx = new BifLogicArgumentContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_bifLogicArgument);
		try {
			setState(319);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new InstructionBifLogicArgumentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(315);
				((InstructionBifLogicArgumentContext)_localctx).instr = match(IDENTIFIER);
				setState(316);
				match(T__26);
				setState(317);
				((InstructionBifLogicArgumentContext)_localctx).arg = match(DECNUMBER);
				}
				break;
			case DECNUMBER:
				_localctx = new StartBifLogicArgumentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
				match(DECNUMBER);
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
		"\u0004\u0001$\u0142\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u00003\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u0000;\b\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000C\b\u0000"+
		"\u0003\u0000E\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"J\b\u0001\n\u0001\f\u0001M\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002^\b\u0002\n\u0002\f\u0002a\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002e\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"j\b\u0003\n\u0003\f\u0003m\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004x\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005~\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0082\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006"+
		"\u0089\b\u0006\u000b\u0006\f\u0006\u008a\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0092\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u0097\b\u0007\n\u0007\f\u0007\u009a\t\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0004\b\u00a1\b\b\u000b"+
		"\b\f\b\u00a2\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00ab"+
		"\b\t\n\t\f\t\u00ae\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u00b4\b"+
		"\t\u000b\t\f\t\u00b5\u0001\t\u0001\t\u0003\t\u00ba\b\t\u0001\n\u0001\n"+
		"\u0001\n\u0005\n\u00bf\b\n\n\n\f\n\u00c2\t\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u00c9\b\n\n\n\f\n\u00cc\t\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00d4\b\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u00da\b\f\u0001\r\u0001\r\u0001\r\u0004"+
		"\r\u00df\b\r\u000b\r\f\r\u00e0\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u00e8\b\u000e\u0001\u000e\u0003\u000e\u00eb\b"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u00f1"+
		"\b\u000e\u000b\u000e\f\u000e\u00f2\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u00f7\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00fc\b"+
		"\u000f\n\u000f\f\u000f\u00ff\t\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u0103\b\u000f\u0001\u000f\u0003\u000f\u0106\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0004\u0010\u010d\b\u0010\u000b"+
		"\u0010\f\u0010\u010e\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0004\u0011\u0116\b\u0011\u000b\u0011\f\u0011\u0117\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u011f\b\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0124\b\u0012\n\u0012"+
		"\f\u0012\u0127\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0131\b\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u0135\b\u0013\n\u0013\f\u0013\u0138"+
		"\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u0140\b\u0014\u0001\u0014\u0000\u0000\u0015\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(\u0000\u0003\u0001\u0000\r\u000f\u0002\u0000\u0013\u0013\u001d\u001d"+
		"\u0001\u0000\u0016\u0018\u0155\u0000D\u0001\u0000\u0000\u0000\u0002F\u0001"+
		"\u0000\u0000\u0000\u0004d\u0001\u0000\u0000\u0000\u0006f\u0001\u0000\u0000"+
		"\u0000\bw\u0001\u0000\u0000\u0000\n\u0081\u0001\u0000\u0000\u0000\f\u0083"+
		"\u0001\u0000\u0000\u0000\u000e\u008e\u0001\u0000\u0000\u0000\u0010\u009d"+
		"\u0001\u0000\u0000\u0000\u0012\u00b9\u0001\u0000\u0000\u0000\u0014\u00bb"+
		"\u0001\u0000\u0000\u0000\u0016\u00cf\u0001\u0000\u0000\u0000\u0018\u00d5"+
		"\u0001\u0000\u0000\u0000\u001a\u00db\u0001\u0000\u0000\u0000\u001c\u00f6"+
		"\u0001\u0000\u0000\u0000\u001e\u00f8\u0001\u0000\u0000\u0000 \u0107\u0001"+
		"\u0000\u0000\u0000\"\u0112\u0001\u0000\u0000\u0000$\u011b\u0001\u0000"+
		"\u0000\u0000&\u012a\u0001\u0000\u0000\u0000(\u013f\u0001\u0000\u0000\u0000"+
		"*E\u0003\u001a\r\u0000+2\u0003\f\u0006\u0000,-\u0003\u0002\u0001\u0000"+
		"-.\u0003\u0006\u0003\u0000.3\u0001\u0000\u0000\u0000/0\u0003\u0006\u0003"+
		"\u000001\u0003\u0002\u0001\u000013\u0001\u0000\u0000\u00002,\u0001\u0000"+
		"\u0000\u00002/\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u00003E\u0001"+
		"\u0000\u0000\u000045\u0003\u001a\r\u000056\u0003 \u0010\u00006;\u0001"+
		"\u0000\u0000\u000078\u0003 \u0010\u000089\u0003\u001a\r\u00009;\u0001"+
		"\u0000\u0000\u0000:4\u0001\u0000\u0000\u0000:7\u0001\u0000\u0000\u0000"+
		";B\u0001\u0000\u0000\u0000<=\u0003\u0002\u0001\u0000=>\u0003\u0006\u0003"+
		"\u0000>C\u0001\u0000\u0000\u0000?@\u0003\u0006\u0003\u0000@A\u0003\u0002"+
		"\u0001\u0000AC\u0001\u0000\u0000\u0000B<\u0001\u0000\u0000\u0000B?\u0001"+
		"\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CE\u0001\u0000\u0000\u0000"+
		"D*\u0001\u0000\u0000\u0000D+\u0001\u0000\u0000\u0000D:\u0001\u0000\u0000"+
		"\u0000E\u0001\u0001\u0000\u0000\u0000FG\u0005\u0001\u0000\u0000GK\u0005"+
		"\u0002\u0000\u0000HJ\u0003\u0004\u0002\u0000IH\u0001\u0000\u0000\u0000"+
		"JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000"+
		"\u0000LN\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NO\u0005\u0003"+
		"\u0000\u0000O\u0003\u0001\u0000\u0000\u0000PQ\u0005\u001f\u0000\u0000"+
		"QR\u0005\u0004\u0000\u0000RS\u0005\u001c\u0000\u0000Se\u0005\u0005\u0000"+
		"\u0000TU\u0005\u001f\u0000\u0000UV\u0005\u0006\u0000\u0000VW\u0005\u001d"+
		"\u0000\u0000WX\u0005\u0007\u0000\u0000XY\u0005\u0004\u0000\u0000YZ\u0005"+
		"\u0002\u0000\u0000Z_\u0005\u001c\u0000\u0000[\\\u0005\b\u0000\u0000\\"+
		"^\u0005\u001c\u0000\u0000][\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000"+
		"\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`b\u0001\u0000"+
		"\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0005\u0003\u0000\u0000ce\u0005"+
		"\u0005\u0000\u0000dP\u0001\u0000\u0000\u0000dT\u0001\u0000\u0000\u0000"+
		"e\u0005\u0001\u0000\u0000\u0000fg\u0005\t\u0000\u0000gk\u0005\u0002\u0000"+
		"\u0000hj\u0003\b\u0004\u0000ih\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000ln\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000no\u0005\u0003\u0000\u0000o\u0007"+
		"\u0001\u0000\u0000\u0000pq\u0005\u001f\u0000\u0000qr\u0003\n\u0005\u0000"+
		"rs\u0005\u0005\u0000\u0000sx\u0001\u0000\u0000\u0000tu\u0005\n\u0000\u0000"+
		"uv\u0005\u001f\u0000\u0000vx\u0005\u0005\u0000\u0000wp\u0001\u0000\u0000"+
		"\u0000wt\u0001\u0000\u0000\u0000x\t\u0001\u0000\u0000\u0000y}\u0005\u001f"+
		"\u0000\u0000z{\u0005\u0006\u0000\u0000{|\u0005\u001d\u0000\u0000|~\u0005"+
		"\u0007\u0000\u0000}z\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000"+
		"~\u0082\u0001\u0000\u0000\u0000\u007f\u0082\u0005\u001c\u0000\u0000\u0080"+
		"\u0082\u0001\u0000\u0000\u0000\u0081y\u0001\u0000\u0000\u0000\u0081\u007f"+
		"\u0001\u0000\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u000b"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u000b\u0000\u0000\u0084\u0085"+
		"\u0005\f\u0000\u0000\u0085\u0086\u0005\u0002\u0000\u0000\u0086\u0088\u0003"+
		"\u0010\b\u0000\u0087\u0089\u0003\u000e\u0007\u0000\u0088\u0087\u0001\u0000"+
		"\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000"+
		"\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0005\u0003\u0000\u0000\u008d\r\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0005\u001f\u0000\u0000\u008f\u0091\u0005\u0006\u0000"+
		"\u0000\u0090\u0092\u0007\u0000\u0000\u0000\u0091\u0090\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0005\u0007\u0000\u0000\u0094\u0098\u0005\u0002\u0000"+
		"\u0000\u0095\u0097\u0003\u0012\t\u0000\u0096\u0095\u0001\u0000\u0000\u0000"+
		"\u0097\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009b\u0001\u0000\u0000\u0000"+
		"\u009a\u0098\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u0003\u0000\u0000"+
		"\u009c\u000f\u0001\u0000\u0000\u0000\u009d\u009e\u0005\u0010\u0000\u0000"+
		"\u009e\u00a0\u0005\u0002\u0000\u0000\u009f\u00a1\u0003\u0012\t\u0000\u00a0"+
		"\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005\u0003\u0000\u0000\u00a5"+
		"\u0011\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u0011\u0000\u0000\u00a7"+
		"\u00a8\u0003\u0018\f\u0000\u00a8\u00ac\u0005\u0011\u0000\u0000\u00a9\u00ab"+
		"\u0003\u0016\u000b\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u0001\u0000\u0000\u0000\u00ad\u00af\u0001\u0000\u0000\u0000\u00ae\u00ac"+
		"\u0001\u0000\u0000\u0000\u00af\u00b0\u0005\u0005\u0000\u0000\u00b0\u00ba"+
		"\u0001\u0000\u0000\u0000\u00b1\u00b3\u0005\u0002\u0000\u0000\u00b2\u00b4"+
		"\u0003\u0014\n\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005"+
		"\u0003\u0000\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9\u00a6\u0001"+
		"\u0000\u0000\u0000\u00b9\u00b1\u0001\u0000\u0000\u0000\u00ba\u0013\u0001"+
		"\u0000\u0000\u0000\u00bb\u00c0\u0005\u001e\u0000\u0000\u00bc\u00bd\u0005"+
		"\b\u0000\u0000\u00bd\u00bf\u0005\u001e\u0000\u0000\u00be\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005\u0012"+
		"\u0000\u0000\u00c4\u00c5\u0005\u0011\u0000\u0000\u00c5\u00c6\u0003\u0018"+
		"\f\u0000\u00c6\u00ca\u0005\u0011\u0000\u0000\u00c7\u00c9\u0003\u0016\u000b"+
		"\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000"+
		"\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000"+
		"\u0000\u00cd\u00ce\u0005\u0005\u0000\u0000\u00ce\u0015\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d3\u0005 \u0000\u0000\u00d0\u00d1\u0005\u0006\u0000\u0000"+
		"\u00d1\u00d2\u0005\u001d\u0000\u0000\u00d2\u00d4\u0005\u0007\u0000\u0000"+
		"\u00d3\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d4\u0017\u0001\u0000\u0000\u0000\u00d5\u00d9\u0005 \u0000\u0000\u00d6"+
		"\u00d7\u0005\u0006\u0000\u0000\u00d7\u00d8\u0007\u0001\u0000\u0000\u00d8"+
		"\u00da\u0005\u0007\u0000\u0000\u00d9\u00d6\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\u0001\u0000\u0000\u0000\u00da\u0019\u0001\u0000\u0000\u0000\u00db"+
		"\u00dc\u0005\u0014\u0000\u0000\u00dc\u00de\u0005\u0002\u0000\u0000\u00dd"+
		"\u00df\u0003\u001c\u000e\u0000\u00de\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e3\u0005\u0003\u0000\u0000\u00e3\u001b\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e5\u0005\u001f\u0000\u0000\u00e5\u00e7\u0005\u0015\u0000\u0000\u00e6"+
		"\u00e8\u0007\u0002\u0000\u0000\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e8\u00ea\u0001\u0000\u0000\u0000\u00e9"+
		"\u00eb\u0005\u0019\u0000\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00ea"+
		"\u00eb\u0001\u0000\u0000\u0000\u00eb\u00f7\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ed\u0005\u001f\u0000\u0000\u00ed\u00ee\u0005\u0015\u0000\u0000\u00ee"+
		"\u00f0\u0005\u0002\u0000\u0000\u00ef\u00f1\u0003\u001e\u000f\u0000\u00f0"+
		"\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\u0003\u0000\u0000\u00f5"+
		"\u00f7\u0001\u0000\u0000\u0000\u00f6\u00e4\u0001\u0000\u0000\u0000\u00f6"+
		"\u00ec\u0001\u0000\u0000\u0000\u00f7\u001d\u0001\u0000\u0000\u0000\u00f8"+
		"\u00fd\u0005\u001e\u0000\u0000\u00f9\u00fa\u0005\b\u0000\u0000\u00fa\u00fc"+
		"\u0005\u001e\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u00ff"+
		"\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fe"+
		"\u0001\u0000\u0000\u0000\u00fe\u0100\u0001\u0000\u0000\u0000\u00ff\u00fd"+
		"\u0001\u0000\u0000\u0000\u0100\u0102\u0005\u0012\u0000\u0000\u0101\u0103"+
		"\u0007\u0002\u0000\u0000\u0102\u0101\u0001\u0000\u0000\u0000\u0102\u0103"+
		"\u0001\u0000\u0000\u0000\u0103\u0105\u0001\u0000\u0000\u0000\u0104\u0106"+
		"\u0005\u0019\u0000\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0105\u0106"+
		"\u0001\u0000\u0000\u0000\u0106\u001f\u0001\u0000\u0000\u0000\u0107\u0108"+
		"\u0005\u001a\u0000\u0000\u0108\u0109\u0005\f\u0000\u0000\u0109\u010a\u0005"+
		"\u0002\u0000\u0000\u010a\u010c\u0003\"\u0011\u0000\u010b\u010d\u0003$"+
		"\u0012\u0000\u010c\u010b\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000"+
		"\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000"+
		"\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0111\u0005\u0003"+
		"\u0000\u0000\u0111!\u0001\u0000\u0000\u0000\u0112\u0113\u0005\u0010\u0000"+
		"\u0000\u0113\u0115\u0005\u0002\u0000\u0000\u0114\u0116\u0003&\u0013\u0000"+
		"\u0115\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000"+
		"\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000"+
		"\u0118\u0119\u0001\u0000\u0000\u0000\u0119\u011a\u0005\u0003\u0000\u0000"+
		"\u011a#\u0001\u0000\u0000\u0000\u011b\u011c\u0005\u001f\u0000\u0000\u011c"+
		"\u011e\u0005\u0006\u0000\u0000\u011d\u011f\u0007\u0000\u0000\u0000\u011e"+
		"\u011d\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f"+
		"\u0120\u0001\u0000\u0000\u0000\u0120\u0121\u0005\u0007\u0000\u0000\u0121"+
		"\u0125\u0005\u0002\u0000\u0000\u0122\u0124\u0003&\u0013\u0000\u0123\u0122"+
		"\u0001\u0000\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000\u0125\u0123"+
		"\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0128"+
		"\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u0129"+
		"\u0005\u0003\u0000\u0000\u0129%\u0001\u0000\u0000\u0000\u012a\u012b\u0005"+
		"\u0011\u0000\u0000\u012b\u0130\u0005\u001f\u0000\u0000\u012c\u012d\u0005"+
		"\u0006\u0000\u0000\u012d\u012e\u0003(\u0014\u0000\u012e\u012f\u0005\u0007"+
		"\u0000\u0000\u012f\u0131\u0001\u0000\u0000\u0000\u0130\u012c\u0001\u0000"+
		"\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000"+
		"\u0000\u0000\u0132\u0136\u0005\u0011\u0000\u0000\u0133\u0135\u0003\u0016"+
		"\u000b\u0000\u0134\u0133\u0001\u0000\u0000\u0000\u0135\u0138\u0001\u0000"+
		"\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000"+
		"\u0000\u0000\u0137\u0139\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000"+
		"\u0000\u0000\u0139\u013a\u0005\u0005\u0000\u0000\u013a\'\u0001\u0000\u0000"+
		"\u0000\u013b\u013c\u0005\u001f\u0000\u0000\u013c\u013d\u0005\u001b\u0000"+
		"\u0000\u013d\u0140\u0005\u001d\u0000\u0000\u013e\u0140\u0005\u001d\u0000"+
		"\u0000\u013f\u013b\u0001\u0000\u0000\u0000\u013f\u013e\u0001\u0000\u0000"+
		"\u0000\u0140)\u0001\u0000\u0000\u0000%2:BDK_dkw}\u0081\u008a\u0091\u0098"+
		"\u00a2\u00ac\u00b5\u00b9\u00c0\u00ca\u00d3\u00d9\u00e0\u00e7\u00ea\u00f2"+
		"\u00f6\u00fd\u0102\u0105\u010e\u0117\u011e\u0125\u0130\u0136\u013f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}