// Generated from /home/abi/Codigo/AsiTranspiler 2.0/grammar/Sicome.g4 by ANTLR 4.13.1
package Parsing;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SicomeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, MICRO_INSTR=31, 
		FLAG=32, NUMBER=33, IDENTIFIER=34, TEXT=35, HEXNUMBER=36, DECNUMBER=37, 
		LINE_COMMENT=38, COMMENT=39, NEWLINE=40, WS=41;
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
			"'dir'", "'var'", "')'", "':'", "'LOAD_SC'", "'LOAD_SR'", "'START'", 
			"'SR+1->SR'", "'SC-1->SC'", "'estados'", "'->'", "'INCR'", "'BIF'", "'RET'", 
			"'DISABLE'", "'@microinstruccion'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "MICRO_INSTR", "FLAG", "NUMBER", 
			"IDENTIFIER", "TEXT", "HEXNUMBER", "DECNUMBER", "LINE_COMMENT", "COMMENT", 
			"NEWLINE", "WS"
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MicroCableProgramContext extends ProgContext {
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
		public MicroCableProgramContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterMicroCableProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitMicroCableProgram(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				_localctx = new CableProgramContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				cableInstructionBlock();
				setState(37);
				variablesBlock();
				setState(38);
				programBlock();
				}
				break;
			case T__23:
				_localctx = new MicroCableProgramContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				statusLogicBlock();
				setState(41);
				microInstructionBlock();
				setState(42);
				variablesBlock();
				setState(43);
				programBlock();
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
	}

	public final VariablesBlockContext variablesBlock() throws RecognitionException {
		VariablesBlockContext _localctx = new VariablesBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variablesBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(T__0);
			setState(48);
			match(T__1);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(49);
				variableDeclaration();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
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
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variableDeclaration);
		int _la;
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new SimpleVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				((SimpleVariableDeclarationContext)_localctx).id = match(IDENTIFIER);
				setState(58);
				match(T__3);
				setState(59);
				((SimpleVariableDeclarationContext)_localctx).value = match(NUMBER);
				setState(60);
				match(T__4);
				}
				break;
			case 2:
				_localctx = new VectorVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				((VectorVariableDeclarationContext)_localctx).id = match(IDENTIFIER);
				setState(62);
				match(T__5);
				setState(63);
				((VectorVariableDeclarationContext)_localctx).size = match(NUMBER);
				setState(64);
				match(T__6);
				setState(65);
				match(T__3);
				setState(66);
				match(T__1);
				setState(67);
				((VectorVariableDeclarationContext)_localctx).NUMBER = match(NUMBER);
				((VectorVariableDeclarationContext)_localctx).value.add(((VectorVariableDeclarationContext)_localctx).NUMBER);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(68);
					match(T__7);
					setState(69);
					((VectorVariableDeclarationContext)_localctx).NUMBER = match(NUMBER);
					((VectorVariableDeclarationContext)_localctx).value.add(((VectorVariableDeclarationContext)_localctx).NUMBER);
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(75);
				match(T__2);
				setState(76);
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
	}

	public final ProgramBlockContext programBlock() throws RecognitionException {
		ProgramBlockContext _localctx = new ProgramBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_programBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__8);
			setState(80);
			match(T__1);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9 || _la==IDENTIFIER) {
				{
				{
				setState(81);
				programLine();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
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
	}

	public final ProgramLineContext programLine() throws RecognitionException {
		ProgramLineContext _localctx = new ProgramLineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_programLine);
		try {
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new InstructionUseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				((InstructionUseContext)_localctx).name = match(IDENTIFIER);
				setState(90);
				((InstructionUseContext)_localctx).arg = instructionUseArgument();
				setState(91);
				match(T__4);
				}
				break;
			case T__9:
				_localctx = new MarkUseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(T__9);
				setState(94);
				((MarkUseContext)_localctx).label = match(IDENTIFIER);
				setState(95);
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
	}

	public final InstructionUseArgumentContext instructionUseArgument() throws RecognitionException {
		InstructionUseArgumentContext _localctx = new InstructionUseArgumentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instructionUseArgument);
		int _la;
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				((InstructionUseArgumentContext)_localctx).var = match(IDENTIFIER);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(99);
					match(T__5);
					setState(100);
					((InstructionUseArgumentContext)_localctx).offset = match(NUMBER);
					setState(101);
					match(T__6);
					}
				}

				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
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
	}

	public final CableInstructionBlockContext cableInstructionBlock() throws RecognitionException {
		CableInstructionBlockContext _localctx = new CableInstructionBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cableInstructionBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__10);
			setState(109);
			match(T__11);
			setState(110);
			match(T__1);
			setState(112); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(111);
				cableInstruction();
				}
				}
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(116);
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
	}

	public final CableInstructionContext cableInstruction() throws RecognitionException {
		CableInstructionContext _localctx = new CableInstructionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cableInstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(IDENTIFIER);
			setState(119);
			match(T__12);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) {
				{
				setState(120);
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

			setState(123);
			match(T__16);
			setState(124);
			match(T__1);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==T__5) {
				{
				{
				setState(125);
				cableStep();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	}

	public final CableStepContext cableStep() throws RecognitionException {
		CableStepContext _localctx = new CableStepContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cableStep);
		int _la;
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new SimpleCableStepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				match(T__5);
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14155776L) != 0)) {
					{
					{
					setState(134);
					cableFlowControl();
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(140);
				match(T__6);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MICRO_INSTR) {
					{
					{
					setState(141);
					((SimpleCableStepContext)_localctx).MICRO_INSTR = match(MICRO_INSTR);
					((SimpleCableStepContext)_localctx).instr.add(((SimpleCableStepContext)_localctx).MICRO_INSTR);
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(147);
				match(T__4);
				}
				break;
			case T__1:
				_localctx = new ConditionalCableStepBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(T__1);
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(149);
					conditionalCableStep();
					}
					}
					setState(152); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==FLAG );
				setState(154);
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
	}

	public final ConditionalCableStepContext conditionalCableStep() throws RecognitionException {
		ConditionalCableStepContext _localctx = new ConditionalCableStepContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_conditionalCableStep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			((ConditionalCableStepContext)_localctx).FLAG = match(FLAG);
			((ConditionalCableStepContext)_localctx).flags.add(((ConditionalCableStepContext)_localctx).FLAG);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(159);
				match(T__7);
				setState(160);
				((ConditionalCableStepContext)_localctx).FLAG = match(FLAG);
				((ConditionalCableStepContext)_localctx).flags.add(((ConditionalCableStepContext)_localctx).FLAG);
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(166);
			match(T__17);
			setState(167);
			match(T__5);
			setState(169); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(168);
				cableFlowControl();
				}
				}
				setState(171); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 14155776L) != 0) );
			setState(173);
			match(T__6);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MICRO_INSTR) {
				{
				{
				setState(174);
				((ConditionalCableStepContext)_localctx).MICRO_INSTR = match(MICRO_INSTR);
				((ConditionalCableStepContext)_localctx).instr.add(((ConditionalCableStepContext)_localctx).MICRO_INSTR);
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(180);
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
		public TerminalNode NUMBER() { return getToken(SicomeParser.NUMBER, 0); }
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
	}

	public final CableFlowControlContext cableFlowControl() throws RecognitionException {
		CableFlowControlContext _localctx = new CableFlowControlContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cableFlowControl);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				((CableFlowControlContext)_localctx).type = match(T__18);
				setState(183);
				match(T__12);
				setState(184);
				((CableFlowControlContext)_localctx).value = match(NUMBER);
				setState(185);
				match(T__16);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				((CableFlowControlContext)_localctx).type = match(T__19);
				setState(187);
				match(T__12);
				setState(188);
				((CableFlowControlContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==NUMBER) ) {
					((CableFlowControlContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(189);
				match(T__16);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
				((CableFlowControlContext)_localctx).type = match(T__21);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 4);
				{
				setState(191);
				((CableFlowControlContext)_localctx).type = match(T__22);
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
	}

	public final StatusLogicBlockContext statusLogicBlock() throws RecognitionException {
		StatusLogicBlockContext _localctx = new StatusLogicBlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statusLogicBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(T__23);
			setState(195);
			match(T__1);
			setState(197); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(196);
				statusLogic();
				}
				}
				setState(199); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(201);
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
	}

	public final StatusLogicContext statusLogic() throws RecognitionException {
		StatusLogicContext _localctx = new StatusLogicContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statusLogic);
		int _la;
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new SimpleStatusLogicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				((SimpleStatusLogicContext)_localctx).name = match(IDENTIFIER);
				setState(204);
				match(T__24);
				setState(205);
				((SimpleStatusLogicContext)_localctx).option = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 469762048L) != 0)) ) {
					((SimpleStatusLogicContext)_localctx).option = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__28) {
					{
					setState(206);
					((SimpleStatusLogicContext)_localctx).disable = match(T__28);
					}
				}

				}
				break;
			case 2:
				_localctx = new ComplexStatusLogicContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				((ComplexStatusLogicContext)_localctx).name = match(IDENTIFIER);
				setState(210);
				match(T__24);
				setState(211);
				match(T__1);
				setState(213); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(212);
					statusLogicOption();
					}
					}
					setState(215); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==FLAG );
				setState(217);
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
	}

	public final StatusLogicOptionContext statusLogicOption() throws RecognitionException {
		StatusLogicOptionContext _localctx = new StatusLogicOptionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statusLogicOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			((StatusLogicOptionContext)_localctx).FLAG = match(FLAG);
			((StatusLogicOptionContext)_localctx).flags.add(((StatusLogicOptionContext)_localctx).FLAG);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(222);
				match(T__7);
				setState(223);
				((StatusLogicOptionContext)_localctx).FLAG = match(FLAG);
				((StatusLogicOptionContext)_localctx).flags.add(((StatusLogicOptionContext)_localctx).FLAG);
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(229);
			match(T__17);
			setState(230);
			((StatusLogicOptionContext)_localctx).option = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 469762048L) != 0)) ) {
				((StatusLogicOptionContext)_localctx).option = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(231);
				((StatusLogicOptionContext)_localctx).disable = match(T__28);
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
	}

	public final MicroInstructionBlockContext microInstructionBlock() throws RecognitionException {
		MicroInstructionBlockContext _localctx = new MicroInstructionBlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_microInstructionBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(T__29);
			setState(235);
			match(T__11);
			setState(236);
			match(T__1);
			setState(238); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(237);
				microInstruction();
				}
				}
				setState(240); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(242);
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
	}

	public final MicroInstructionContext microInstruction() throws RecognitionException {
		MicroInstructionContext _localctx = new MicroInstructionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_microInstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(IDENTIFIER);
			setState(245);
			match(T__12);
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) {
				{
				setState(246);
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

			setState(249);
			match(T__16);
			setState(250);
			match(T__1);
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(251);
				microStep();
				}
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(257);
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
	}

	public final MicroStepContext microStep() throws RecognitionException {
		MicroStepContext _localctx = new MicroStepContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_microStep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(T__5);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17188782080L) != 0)) {
				{
				{
				setState(260);
				((MicroStepContext)_localctx).microFlowControl = microFlowControl();
				((MicroStepContext)_localctx).flow.add(((MicroStepContext)_localctx).microFlowControl);
				}
				}
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(266);
			match(T__6);
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MICRO_INSTR) {
				{
				{
				setState(267);
				((MicroStepContext)_localctx).MICRO_INSTR = match(MICRO_INSTR);
				((MicroStepContext)_localctx).instr.add(((MicroStepContext)_localctx).MICRO_INSTR);
				}
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(273);
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
		public TerminalNode NUMBER() { return getToken(SicomeParser.NUMBER, 0); }
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
	}

	public final MicroFlowControlContext microFlowControl() throws RecognitionException {
		MicroFlowControlContext _localctx = new MicroFlowControlContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_microFlowControl);
		int _la;
		try {
			setState(286);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				((MicroFlowControlContext)_localctx).action = match(T__18);
				setState(276);
				match(T__12);
				setState(277);
				((MicroFlowControlContext)_localctx).value = match(NUMBER);
				setState(278);
				match(T__16);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				((MicroFlowControlContext)_localctx).action = match(T__22);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(280);
				((MicroFlowControlContext)_localctx).action = match(IDENTIFIER);
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(281);
					match(T__12);
					setState(282);
					((MicroFlowControlContext)_localctx).value = match(NUMBER);
					setState(283);
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
		"\u0004\u0001)\u0121\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0003\u0000.\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u00013\b\u0001\n\u0001\f\u00016\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002G\b\u0002\n\u0002\f\u0002J\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002N\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003S\b\u0003\n\u0003\f\u0003V\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004a\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005g\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"k\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006"+
		"q\b\u0006\u000b\u0006\f\u0006r\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007z\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007\u007f\b\u0007\n\u0007\f\u0007\u0082\t\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0005\b\u0088\b\b\n\b\f\b\u008b\t\b\u0001"+
		"\b\u0001\b\u0005\b\u008f\b\b\n\b\f\b\u0092\t\b\u0001\b\u0001\b\u0001\b"+
		"\u0004\b\u0097\b\b\u000b\b\f\b\u0098\u0001\b\u0001\b\u0003\b\u009d\b\b"+
		"\u0001\t\u0001\t\u0001\t\u0005\t\u00a2\b\t\n\t\f\t\u00a5\t\t\u0001\t\u0001"+
		"\t\u0001\t\u0004\t\u00aa\b\t\u000b\t\f\t\u00ab\u0001\t\u0001\t\u0005\t"+
		"\u00b0\b\t\n\t\f\t\u00b3\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00c1\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u00c6\b\u000b\u000b\u000b\f"+
		"\u000b\u00c7\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00d0\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0004\f\u00d6\b\f\u000b\f"+
		"\f\f\u00d7\u0001\f\u0001\f\u0003\f\u00dc\b\f\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u00e1\b\r\n\r\f\r\u00e4\t\r\u0001\r\u0001\r\u0001\r\u0003\r\u00e9\b"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u00ef\b"+
		"\u000e\u000b\u000e\f\u000e\u00f0\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u00f8\b\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u00fd\b\u000f\n\u000f\f\u000f\u0100\t\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u0106\b\u0010\n\u0010"+
		"\f\u0010\u0109\t\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u010d\b\u0010"+
		"\n\u0010\f\u0010\u0110\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u011d\b\u0011\u0003\u0011\u011f\b\u0011"+
		"\u0001\u0011\u0000\u0000\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000\u0003\u0001\u0000"+
		"\u000e\u0010\u0002\u0000\u0015\u0015!!\u0001\u0000\u001a\u001c\u0132\u0000"+
		"-\u0001\u0000\u0000\u0000\u0002/\u0001\u0000\u0000\u0000\u0004M\u0001"+
		"\u0000\u0000\u0000\u0006O\u0001\u0000\u0000\u0000\b`\u0001\u0000\u0000"+
		"\u0000\nj\u0001\u0000\u0000\u0000\fl\u0001\u0000\u0000\u0000\u000ev\u0001"+
		"\u0000\u0000\u0000\u0010\u009c\u0001\u0000\u0000\u0000\u0012\u009e\u0001"+
		"\u0000\u0000\u0000\u0014\u00c0\u0001\u0000\u0000\u0000\u0016\u00c2\u0001"+
		"\u0000\u0000\u0000\u0018\u00db\u0001\u0000\u0000\u0000\u001a\u00dd\u0001"+
		"\u0000\u0000\u0000\u001c\u00ea\u0001\u0000\u0000\u0000\u001e\u00f4\u0001"+
		"\u0000\u0000\u0000 \u0103\u0001\u0000\u0000\u0000\"\u011e\u0001\u0000"+
		"\u0000\u0000$%\u0003\f\u0006\u0000%&\u0003\u0002\u0001\u0000&\'\u0003"+
		"\u0006\u0003\u0000\'.\u0001\u0000\u0000\u0000()\u0003\u0016\u000b\u0000"+
		")*\u0003\u001c\u000e\u0000*+\u0003\u0002\u0001\u0000+,\u0003\u0006\u0003"+
		"\u0000,.\u0001\u0000\u0000\u0000-$\u0001\u0000\u0000\u0000-(\u0001\u0000"+
		"\u0000\u0000.\u0001\u0001\u0000\u0000\u0000/0\u0005\u0001\u0000\u0000"+
		"04\u0005\u0002\u0000\u000013\u0003\u0004\u0002\u000021\u0001\u0000\u0000"+
		"\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000"+
		"\u0000\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000078\u0005"+
		"\u0003\u0000\u00008\u0003\u0001\u0000\u0000\u00009:\u0005\"\u0000\u0000"+
		":;\u0005\u0004\u0000\u0000;<\u0005!\u0000\u0000<N\u0005\u0005\u0000\u0000"+
		"=>\u0005\"\u0000\u0000>?\u0005\u0006\u0000\u0000?@\u0005!\u0000\u0000"+
		"@A\u0005\u0007\u0000\u0000AB\u0005\u0004\u0000\u0000BC\u0005\u0002\u0000"+
		"\u0000CH\u0005!\u0000\u0000DE\u0005\b\u0000\u0000EG\u0005!\u0000\u0000"+
		"FD\u0001\u0000\u0000\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000"+
		"\u0000HI\u0001\u0000\u0000\u0000IK\u0001\u0000\u0000\u0000JH\u0001\u0000"+
		"\u0000\u0000KL\u0005\u0003\u0000\u0000LN\u0005\u0005\u0000\u0000M9\u0001"+
		"\u0000\u0000\u0000M=\u0001\u0000\u0000\u0000N\u0005\u0001\u0000\u0000"+
		"\u0000OP\u0005\t\u0000\u0000PT\u0005\u0002\u0000\u0000QS\u0003\b\u0004"+
		"\u0000RQ\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001"+
		"\u0000\u0000\u0000WX\u0005\u0003\u0000\u0000X\u0007\u0001\u0000\u0000"+
		"\u0000YZ\u0005\"\u0000\u0000Z[\u0003\n\u0005\u0000[\\\u0005\u0005\u0000"+
		"\u0000\\a\u0001\u0000\u0000\u0000]^\u0005\n\u0000\u0000^_\u0005\"\u0000"+
		"\u0000_a\u0005\u0005\u0000\u0000`Y\u0001\u0000\u0000\u0000`]\u0001\u0000"+
		"\u0000\u0000a\t\u0001\u0000\u0000\u0000bf\u0005\"\u0000\u0000cd\u0005"+
		"\u0006\u0000\u0000de\u0005!\u0000\u0000eg\u0005\u0007\u0000\u0000fc\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gk\u0001\u0000\u0000\u0000"+
		"hk\u0005!\u0000\u0000ik\u0001\u0000\u0000\u0000jb\u0001\u0000\u0000\u0000"+
		"jh\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000k\u000b\u0001\u0000"+
		"\u0000\u0000lm\u0005\u000b\u0000\u0000mn\u0005\f\u0000\u0000np\u0005\u0002"+
		"\u0000\u0000oq\u0003\u000e\u0007\u0000po\u0001\u0000\u0000\u0000qr\u0001"+
		"\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000"+
		"st\u0001\u0000\u0000\u0000tu\u0005\u0003\u0000\u0000u\r\u0001\u0000\u0000"+
		"\u0000vw\u0005\"\u0000\u0000wy\u0005\r\u0000\u0000xz\u0007\u0000\u0000"+
		"\u0000yx\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{|\u0005\u0011\u0000\u0000|\u0080\u0005\u0002\u0000\u0000"+
		"}\u007f\u0003\u0010\b\u0000~}\u0001\u0000\u0000\u0000\u007f\u0082\u0001"+
		"\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000"+
		"\u0000\u0000\u0081\u0083\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0005\u0003\u0000\u0000\u0084\u000f\u0001\u0000"+
		"\u0000\u0000\u0085\u0089\u0005\u0006\u0000\u0000\u0086\u0088\u0003\u0014"+
		"\n\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088\u008b\u0001\u0000\u0000"+
		"\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000"+
		"\u0000\u008a\u008c\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000"+
		"\u0000\u008c\u0090\u0005\u0007\u0000\u0000\u008d\u008f\u0005\u001f\u0000"+
		"\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008f\u0092\u0001\u0000\u0000"+
		"\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000"+
		"\u0000\u0091\u0093\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000"+
		"\u0000\u0093\u009d\u0005\u0005\u0000\u0000\u0094\u0096\u0005\u0002\u0000"+
		"\u0000\u0095\u0097\u0003\u0012\t\u0000\u0096\u0095\u0001\u0000\u0000\u0000"+
		"\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0005\u0003\u0000\u0000\u009b\u009d\u0001\u0000\u0000\u0000"+
		"\u009c\u0085\u0001\u0000\u0000\u0000\u009c\u0094\u0001\u0000\u0000\u0000"+
		"\u009d\u0011\u0001\u0000\u0000\u0000\u009e\u00a3\u0005 \u0000\u0000\u009f"+
		"\u00a0\u0005\b\u0000\u0000\u00a0\u00a2\u0005 \u0000\u0000\u00a1\u009f"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0005\u0012\u0000\u0000\u00a7\u00a9\u0005\u0006\u0000\u0000\u00a8\u00aa"+
		"\u0003\u0014\n\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00b1\u0005"+
		"\u0007\u0000\u0000\u00ae\u00b0\u0005\u001f\u0000\u0000\u00af\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b3\u0001\u0000\u0000\u0000\u00b1\u00af\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005"+
		"\u0005\u0000\u0000\u00b5\u0013\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005"+
		"\u0013\u0000\u0000\u00b7\u00b8\u0005\r\u0000\u0000\u00b8\u00b9\u0005!"+
		"\u0000\u0000\u00b9\u00c1\u0005\u0011\u0000\u0000\u00ba\u00bb\u0005\u0014"+
		"\u0000\u0000\u00bb\u00bc\u0005\r\u0000\u0000\u00bc\u00bd\u0007\u0001\u0000"+
		"\u0000\u00bd\u00c1\u0005\u0011\u0000\u0000\u00be\u00c1\u0005\u0016\u0000"+
		"\u0000\u00bf\u00c1\u0005\u0017\u0000\u0000\u00c0\u00b6\u0001\u0000\u0000"+
		"\u0000\u00c0\u00ba\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000"+
		"\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1\u0015\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0005\u0018\u0000\u0000\u00c3\u00c5\u0005\u0002\u0000"+
		"\u0000\u00c4\u00c6\u0003\u0018\f\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000"+
		"\u00c9\u00ca\u0005\u0003\u0000\u0000\u00ca\u0017\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0005\"\u0000\u0000\u00cc\u00cd\u0005\u0019\u0000\u0000\u00cd"+
		"\u00cf\u0007\u0002\u0000\u0000\u00ce\u00d0\u0005\u001d\u0000\u0000\u00cf"+
		"\u00ce\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0"+
		"\u00dc\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005\"\u0000\u0000\u00d2\u00d3"+
		"\u0005\u0019\u0000\u0000\u00d3\u00d5\u0005\u0002\u0000\u0000\u00d4\u00d6"+
		"\u0003\u001a\r\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da\u0005"+
		"\u0003\u0000\u0000\u00da\u00dc\u0001\u0000\u0000\u0000\u00db\u00cb\u0001"+
		"\u0000\u0000\u0000\u00db\u00d1\u0001\u0000\u0000\u0000\u00dc\u0019\u0001"+
		"\u0000\u0000\u0000\u00dd\u00e2\u0005 \u0000\u0000\u00de\u00df\u0005\b"+
		"\u0000\u0000\u00df\u00e1\u0005 \u0000\u0000\u00e0\u00de\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005\u0012\u0000"+
		"\u0000\u00e6\u00e8\u0007\u0002\u0000\u0000\u00e7\u00e9\u0005\u001d\u0000"+
		"\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000"+
		"\u0000\u00e9\u001b\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005\u001e\u0000"+
		"\u0000\u00eb\u00ec\u0005\f\u0000\u0000\u00ec\u00ee\u0005\u0002\u0000\u0000"+
		"\u00ed\u00ef\u0003\u001e\u000f\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f2\u00f3\u0005\u0003\u0000\u0000\u00f3\u001d\u0001\u0000\u0000\u0000"+
		"\u00f4\u00f5\u0005\"\u0000\u0000\u00f5\u00f7\u0005\r\u0000\u0000\u00f6"+
		"\u00f8\u0007\u0000\u0000\u0000\u00f7\u00f6\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f8\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fa\u0005\u0011\u0000\u0000\u00fa\u00fe\u0005\u0002\u0000\u0000\u00fb"+
		"\u00fd\u0003 \u0010\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fd\u0100"+
		"\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe\u00ff"+
		"\u0001\u0000\u0000\u0000\u00ff\u0101\u0001\u0000\u0000\u0000\u0100\u00fe"+
		"\u0001\u0000\u0000\u0000\u0101\u0102\u0005\u0003\u0000\u0000\u0102\u001f"+
		"\u0001\u0000\u0000\u0000\u0103\u0107\u0005\u0006\u0000\u0000\u0104\u0106"+
		"\u0003\"\u0011\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0106\u0109\u0001"+
		"\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0107\u0108\u0001"+
		"\u0000\u0000\u0000\u0108\u010a\u0001\u0000\u0000\u0000\u0109\u0107\u0001"+
		"\u0000\u0000\u0000\u010a\u010e\u0005\u0007\u0000\u0000\u010b\u010d\u0005"+
		"\u001f\u0000\u0000\u010c\u010b\u0001\u0000\u0000\u0000\u010d\u0110\u0001"+
		"\u0000\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010f\u0001"+
		"\u0000\u0000\u0000\u010f\u0111\u0001\u0000\u0000\u0000\u0110\u010e\u0001"+
		"\u0000\u0000\u0000\u0111\u0112\u0005\u0005\u0000\u0000\u0112!\u0001\u0000"+
		"\u0000\u0000\u0113\u0114\u0005\u0013\u0000\u0000\u0114\u0115\u0005\r\u0000"+
		"\u0000\u0115\u0116\u0005!\u0000\u0000\u0116\u011f\u0005\u0011\u0000\u0000"+
		"\u0117\u011f\u0005\u0017\u0000\u0000\u0118\u011c\u0005\"\u0000\u0000\u0119"+
		"\u011a\u0005\r\u0000\u0000\u011a\u011b\u0005!\u0000\u0000\u011b\u011d"+
		"\u0005\u0011\u0000\u0000\u011c\u0119\u0001\u0000\u0000\u0000\u011c\u011d"+
		"\u0001\u0000\u0000\u0000\u011d\u011f\u0001\u0000\u0000\u0000\u011e\u0113"+
		"\u0001\u0000\u0000\u0000\u011e\u0117\u0001\u0000\u0000\u0000\u011e\u0118"+
		"\u0001\u0000\u0000\u0000\u011f#\u0001\u0000\u0000\u0000 -4HMT`fjry\u0080"+
		"\u0089\u0090\u0098\u009c\u00a3\u00ab\u00b1\u00c0\u00c7\u00cf\u00d7\u00db"+
		"\u00e2\u00e8\u00f0\u00f7\u00fe\u0107\u010e\u011c\u011e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}