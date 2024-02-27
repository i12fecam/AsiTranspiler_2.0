package Parsing;// Generated from Sicome.g4 by ANTLR 4.13.1
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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, IDENTIFIER=23, TEXT=24, 
		HEXNUMBER=25, NUMBER=26, LINE_COMMENT=27, COMMENT=28, NEWLINE=29, WS=30;
	public static final int
		RULE_prog = 0, RULE_cableInstructionBlock = 1, RULE_cableInstruction = 2, 
		RULE_cableStep = 3, RULE_conditionalCableStep = 4, RULE_cableFlowControl = 5, 
		RULE_micro_instr = 6, RULE_flag = 7, RULE_variablesBlock = 8, RULE_variableDeclaration = 9, 
		RULE_programBlock = 10, RULE_programLine = 11, RULE_instructionUseArgument = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "cableInstructionBlock", "cableInstruction", "cableStep", "conditionalCableStep", 
			"cableFlowControl", "micro_instr", "flag", "variablesBlock", "variableDeclaration", 
			"programBlock", "programLine", "instructionUseArgument"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@cableado'", "'instrucciones'", "'{'", "'}'", "'('", "'value'", 
			"'dir'", "')'", "'['", "']'", "';'", "','", "':'", "'LOAD_SC'", "'LOAD_SR'", 
			"'START'", "'SR+1->SR'", "'SC-1->SC'", "'variables'", "'='", "'programa'", 
			"'MARK'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "IDENTIFIER", 
			"TEXT", "HEXNUMBER", "NUMBER", "LINE_COMMENT", "COMMENT", "NEWLINE", 
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
		public CableInstructionBlockContext cableInstructionBlock() {
			return getRuleContext(CableInstructionBlockContext.class,0);
		}
		public VariablesBlockContext variablesBlock() {
			return getRuleContext(VariablesBlockContext.class,0);
		}
		public ProgramBlockContext programBlock() {
			return getRuleContext(ProgramBlockContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			cableInstructionBlock();
			setState(27);
			variablesBlock();
			setState(28);
			programBlock();
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
		enterRule(_localctx, 2, RULE_cableInstructionBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__0);
			setState(31);
			match(T__1);
			setState(32);
			match(T__2);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				cableInstruction();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(38);
			match(T__3);
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
		enterRule(_localctx, 4, RULE_cableInstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(IDENTIFIER);
			setState(41);
			match(T__4);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5 || _la==T__6) {
				{
				setState(42);
				((CableInstructionContext)_localctx).arg = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__5 || _la==T__6) ) {
					((CableInstructionContext)_localctx).arg = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(45);
			match(T__7);
			setState(46);
			match(T__2);
			setState(48); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(47);
				cableStep();
				}
				}
				setState(50); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__8 );
			setState(52);
			match(T__3);
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
		public List<CableFlowControlContext> cableFlowControl() {
			return getRuleContexts(CableFlowControlContext.class);
		}
		public CableFlowControlContext cableFlowControl(int i) {
			return getRuleContext(CableFlowControlContext.class,i);
		}
		public List<Micro_instrContext> micro_instr() {
			return getRuleContexts(Micro_instrContext.class);
		}
		public Micro_instrContext micro_instr(int i) {
			return getRuleContext(Micro_instrContext.class,i);
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
		enterRule(_localctx, 6, RULE_cableStep);
		int _la;
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new SimpleCableStepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(T__8);
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(55);
					cableFlowControl();
					}
					}
					setState(58); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 442368L) != 0) );
				setState(60);
				match(T__9);
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TEXT) {
					{
					{
					setState(61);
					micro_instr();
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(67);
				match(T__10);
				}
				break;
			case T__2:
				_localctx = new ConditionalCableStepBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(T__2);
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(70);
					conditionalCableStep();
					}
					}
					setState(73); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==TEXT );
				setState(75);
				match(T__3);
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
		public List<FlagContext> flag() {
			return getRuleContexts(FlagContext.class);
		}
		public FlagContext flag(int i) {
			return getRuleContext(FlagContext.class,i);
		}
		public List<CableFlowControlContext> cableFlowControl() {
			return getRuleContexts(CableFlowControlContext.class);
		}
		public CableFlowControlContext cableFlowControl(int i) {
			return getRuleContext(CableFlowControlContext.class,i);
		}
		public List<Micro_instrContext> micro_instr() {
			return getRuleContexts(Micro_instrContext.class);
		}
		public Micro_instrContext micro_instr(int i) {
			return getRuleContext(Micro_instrContext.class,i);
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
		enterRule(_localctx, 8, RULE_conditionalCableStep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			flag();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(80);
				match(T__11);
				setState(81);
				flag();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(T__12);
			setState(88);
			match(T__8);
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
				cableFlowControl();
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 442368L) != 0) );
			setState(94);
			match(T__9);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TEXT) {
				{
				{
				setState(95);
				micro_instr();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			match(T__10);
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
		enterRule(_localctx, 10, RULE_cableFlowControl);
		int _la;
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				((CableFlowControlContext)_localctx).type = match(T__13);
				setState(104);
				match(T__4);
				setState(105);
				((CableFlowControlContext)_localctx).value = match(NUMBER);
				setState(106);
				match(T__7);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				((CableFlowControlContext)_localctx).type = match(T__14);
				setState(108);
				match(T__4);
				setState(109);
				((CableFlowControlContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__15 || _la==NUMBER) ) {
					((CableFlowControlContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(110);
				match(T__7);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				((CableFlowControlContext)_localctx).type = match(T__16);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				((CableFlowControlContext)_localctx).type = match(T__17);
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
	public static class Micro_instrContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(SicomeParser.TEXT, 0); }
		public Micro_instrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_micro_instr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterMicro_instr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitMicro_instr(this);
		}
	}

	public final Micro_instrContext micro_instr() throws RecognitionException {
		Micro_instrContext _localctx = new Micro_instrContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_micro_instr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(TEXT);
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
	public static class FlagContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(SicomeParser.TEXT, 0); }
		public FlagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterFlag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitFlag(this);
		}
	}

	public final FlagContext flag() throws RecognitionException {
		FlagContext _localctx = new FlagContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_flag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(TEXT);
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
		enterRule(_localctx, 16, RULE_variablesBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__18);
			setState(120);
			match(T__2);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(121);
				variableDeclaration();
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(127);
			match(T__3);
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
		public TerminalNode HEXNUMBER() { return getToken(SicomeParser.HEXNUMBER, 0); }
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
		public Token HEXNUMBER;
		public List<Token> value = new ArrayList<Token>();
		public Token NUMBER;
		public Token _tset232;
		public Token _tset245;
		public TerminalNode IDENTIFIER() { return getToken(SicomeParser.IDENTIFIER, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(SicomeParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SicomeParser.NUMBER, i);
		}
		public List<TerminalNode> HEXNUMBER() { return getTokens(SicomeParser.HEXNUMBER); }
		public TerminalNode HEXNUMBER(int i) {
			return getToken(SicomeParser.HEXNUMBER, i);
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
		enterRule(_localctx, 18, RULE_variableDeclaration);
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new SimpleVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				((SimpleVariableDeclarationContext)_localctx).id = match(IDENTIFIER);
				setState(130);
				match(T__19);
				setState(131);
				((SimpleVariableDeclarationContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==HEXNUMBER || _la==NUMBER) ) {
					((SimpleVariableDeclarationContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(132);
				match(T__10);
				}
				break;
			case 2:
				_localctx = new VectorVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				((VectorVariableDeclarationContext)_localctx).id = match(IDENTIFIER);
				setState(134);
				match(T__8);
				setState(135);
				((VectorVariableDeclarationContext)_localctx).size = match(NUMBER);
				setState(136);
				match(T__9);
				setState(137);
				match(T__19);
				setState(138);
				match(T__2);
				setState(139);
				((VectorVariableDeclarationContext)_localctx)._tset232 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==HEXNUMBER || _la==NUMBER) ) {
					((VectorVariableDeclarationContext)_localctx)._tset232 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((VectorVariableDeclarationContext)_localctx).value.add(((VectorVariableDeclarationContext)_localctx)._tset232);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(140);
					match(T__11);
					setState(141);
					((VectorVariableDeclarationContext)_localctx)._tset245 = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==HEXNUMBER || _la==NUMBER) ) {
						((VectorVariableDeclarationContext)_localctx)._tset245 = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					((VectorVariableDeclarationContext)_localctx).value.add(((VectorVariableDeclarationContext)_localctx)._tset245);
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(147);
				match(T__3);
				setState(148);
				match(T__10);
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
		enterRule(_localctx, 20, RULE_programBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__20);
			setState(152);
			match(T__2);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21 || _la==IDENTIFIER) {
				{
				{
				setState(153);
				programLine();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
			match(T__3);
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
		enterRule(_localctx, 22, RULE_programLine);
		try {
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new InstructionUseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				((InstructionUseContext)_localctx).name = match(IDENTIFIER);
				setState(162);
				((InstructionUseContext)_localctx).arg = instructionUseArgument();
				setState(163);
				match(T__10);
				}
				break;
			case T__21:
				_localctx = new MarkUseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(T__21);
				setState(166);
				((MarkUseContext)_localctx).label = match(IDENTIFIER);
				setState(167);
				match(T__10);
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
		public TerminalNode HEXNUMBER() { return getToken(SicomeParser.HEXNUMBER, 0); }
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
		enterRule(_localctx, 24, RULE_instructionUseArgument);
		int _la;
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				((InstructionUseArgumentContext)_localctx).var = match(IDENTIFIER);
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(171);
					match(T__8);
					setState(172);
					((InstructionUseArgumentContext)_localctx).offset = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==HEXNUMBER || _la==NUMBER) ) {
						((InstructionUseArgumentContext)_localctx).offset = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(173);
					match(T__9);
					}
				}

				}
				break;
			case HEXNUMBER:
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				((InstructionUseArgumentContext)_localctx).num = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==HEXNUMBER || _la==NUMBER) ) {
					((InstructionUseArgumentContext)_localctx).num = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__10:
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

	public static final String _serializedATN =
		"\u0004\u0001\u001e\u00b5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001#\b\u0001\u000b"+
		"\u0001\f\u0001$\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002,\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004"+
		"\u00021\b\u0002\u000b\u0002\f\u00022\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0004\u00039\b\u0003\u000b\u0003\f\u0003:\u0001\u0003\u0001"+
		"\u0003\u0005\u0003?\b\u0003\n\u0003\f\u0003B\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0004\u0003H\b\u0003\u000b\u0003\f\u0003"+
		"I\u0001\u0003\u0001\u0003\u0003\u0003N\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004S\b\u0004\n\u0004\f\u0004V\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0004\u0004[\b\u0004\u000b\u0004\f\u0004\\\u0001"+
		"\u0004\u0001\u0004\u0005\u0004a\b\u0004\n\u0004\f\u0004d\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005r\b\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0005\b{\b\b\n\b\f\b~\t\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u008f\b\t\n\t\f\t\u0092\t\t\u0001\t\u0001\t"+
		"\u0003\t\u0096\b\t\u0001\n\u0001\n\u0001\n\u0005\n\u009b\b\n\n\n\f\n\u009e"+
		"\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00a9\b\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00af\b\f\u0001\f\u0001\f\u0003\f\u00b3\b\f"+
		"\u0001\f\u0000\u0000\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u0000\u0003\u0001\u0000\u0006\u0007\u0002\u0000\u0010"+
		"\u0010\u001a\u001a\u0001\u0000\u0019\u001a\u00bc\u0000\u001a\u0001\u0000"+
		"\u0000\u0000\u0002\u001e\u0001\u0000\u0000\u0000\u0004(\u0001\u0000\u0000"+
		"\u0000\u0006M\u0001\u0000\u0000\u0000\bO\u0001\u0000\u0000\u0000\nq\u0001"+
		"\u0000\u0000\u0000\fs\u0001\u0000\u0000\u0000\u000eu\u0001\u0000\u0000"+
		"\u0000\u0010w\u0001\u0000\u0000\u0000\u0012\u0095\u0001\u0000\u0000\u0000"+
		"\u0014\u0097\u0001\u0000\u0000\u0000\u0016\u00a8\u0001\u0000\u0000\u0000"+
		"\u0018\u00b2\u0001\u0000\u0000\u0000\u001a\u001b\u0003\u0002\u0001\u0000"+
		"\u001b\u001c\u0003\u0010\b\u0000\u001c\u001d\u0003\u0014\n\u0000\u001d"+
		"\u0001\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0001\u0000\u0000\u001f"+
		" \u0005\u0002\u0000\u0000 \"\u0005\u0003\u0000\u0000!#\u0003\u0004\u0002"+
		"\u0000\"!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$\"\u0001\u0000"+
		"\u0000\u0000$%\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&\'\u0005"+
		"\u0004\u0000\u0000\'\u0003\u0001\u0000\u0000\u0000()\u0005\u0017\u0000"+
		"\u0000)+\u0005\u0005\u0000\u0000*,\u0007\u0000\u0000\u0000+*\u0001\u0000"+
		"\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-.\u0005"+
		"\b\u0000\u0000.0\u0005\u0003\u0000\u0000/1\u0003\u0006\u0003\u00000/\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u0000"+
		"23\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0005\u0004\u0000"+
		"\u00005\u0005\u0001\u0000\u0000\u000068\u0005\t\u0000\u000079\u0003\n"+
		"\u0005\u000087\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:8\u0001"+
		"\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000"+
		"<@\u0005\n\u0000\u0000=?\u0003\f\u0006\u0000>=\u0001\u0000\u0000\u0000"+
		"?B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000"+
		"\u0000AC\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000CD\u0005\u000b"+
		"\u0000\u0000DN\u0001\u0000\u0000\u0000EG\u0005\u0003\u0000\u0000FH\u0003"+
		"\b\u0004\u0000GF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IG\u0001"+
		"\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000"+
		"KL\u0005\u0004\u0000\u0000LN\u0001\u0000\u0000\u0000M6\u0001\u0000\u0000"+
		"\u0000ME\u0001\u0000\u0000\u0000N\u0007\u0001\u0000\u0000\u0000OT\u0003"+
		"\u000e\u0007\u0000PQ\u0005\f\u0000\u0000QS\u0003\u000e\u0007\u0000RP\u0001"+
		"\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000"+
		"TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000"+
		"\u0000WX\u0005\r\u0000\u0000XZ\u0005\t\u0000\u0000Y[\u0003\n\u0005\u0000"+
		"ZY\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000"+
		"\u0000\\]\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^b\u0005\n"+
		"\u0000\u0000_a\u0003\f\u0006\u0000`_\u0001\u0000\u0000\u0000ad\u0001\u0000"+
		"\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ce\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000ef\u0005\u000b\u0000\u0000"+
		"f\t\u0001\u0000\u0000\u0000gh\u0005\u000e\u0000\u0000hi\u0005\u0005\u0000"+
		"\u0000ij\u0005\u001a\u0000\u0000jr\u0005\b\u0000\u0000kl\u0005\u000f\u0000"+
		"\u0000lm\u0005\u0005\u0000\u0000mn\u0007\u0001\u0000\u0000nr\u0005\b\u0000"+
		"\u0000or\u0005\u0011\u0000\u0000pr\u0005\u0012\u0000\u0000qg\u0001\u0000"+
		"\u0000\u0000qk\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qp\u0001"+
		"\u0000\u0000\u0000r\u000b\u0001\u0000\u0000\u0000st\u0005\u0018\u0000"+
		"\u0000t\r\u0001\u0000\u0000\u0000uv\u0005\u0018\u0000\u0000v\u000f\u0001"+
		"\u0000\u0000\u0000wx\u0005\u0013\u0000\u0000x|\u0005\u0003\u0000\u0000"+
		"y{\u0003\u0012\t\u0000zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000"+
		"|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u007f\u0001\u0000"+
		"\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u0004\u0000\u0000"+
		"\u0080\u0011\u0001\u0000\u0000\u0000\u0081\u0082\u0005\u0017\u0000\u0000"+
		"\u0082\u0083\u0005\u0014\u0000\u0000\u0083\u0084\u0007\u0002\u0000\u0000"+
		"\u0084\u0096\u0005\u000b\u0000\u0000\u0085\u0086\u0005\u0017\u0000\u0000"+
		"\u0086\u0087\u0005\t\u0000\u0000\u0087\u0088\u0005\u001a\u0000\u0000\u0088"+
		"\u0089\u0005\n\u0000\u0000\u0089\u008a\u0005\u0014\u0000\u0000\u008a\u008b"+
		"\u0005\u0003\u0000\u0000\u008b\u0090\u0007\u0002\u0000\u0000\u008c\u008d"+
		"\u0005\f\u0000\u0000\u008d\u008f\u0007\u0002\u0000\u0000\u008e\u008c\u0001"+
		"\u0000\u0000\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u008e\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0093\u0001"+
		"\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0094\u0005"+
		"\u0004\u0000\u0000\u0094\u0096\u0005\u000b\u0000\u0000\u0095\u0081\u0001"+
		"\u0000\u0000\u0000\u0095\u0085\u0001\u0000\u0000\u0000\u0096\u0013\u0001"+
		"\u0000\u0000\u0000\u0097\u0098\u0005\u0015\u0000\u0000\u0098\u009c\u0005"+
		"\u0003\u0000\u0000\u0099\u009b\u0003\u0016\u000b\u0000\u009a\u0099\u0001"+
		"\u0000\u0000\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009f\u0001"+
		"\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a0\u0005"+
		"\u0004\u0000\u0000\u00a0\u0015\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005"+
		"\u0017\u0000\u0000\u00a2\u00a3\u0003\u0018\f\u0000\u00a3\u00a4\u0005\u000b"+
		"\u0000\u0000\u00a4\u00a9\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u0016"+
		"\u0000\u0000\u00a6\u00a7\u0005\u0017\u0000\u0000\u00a7\u00a9\u0005\u000b"+
		"\u0000\u0000\u00a8\u00a1\u0001\u0000\u0000\u0000\u00a8\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a9\u0017\u0001\u0000\u0000\u0000\u00aa\u00ae\u0005\u0017"+
		"\u0000\u0000\u00ab\u00ac\u0005\t\u0000\u0000\u00ac\u00ad\u0007\u0002\u0000"+
		"\u0000\u00ad\u00af\u0005\n\u0000\u0000\u00ae\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b3\u0007\u0002\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b2\u00aa\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u0019\u0001\u0000\u0000\u0000"+
		"\u0012$+2:@IMT\\bq|\u0090\u0095\u009c\u00a8\u00ae\u00b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}