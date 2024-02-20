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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, DECN=17, 
		IDNT=18, MICRO_INSTR=19, BIT_ESTATUS=20, LINE_COMMENT=21, COMMENT=22, 
		NEWLINE=23, WS=24;
	public static final int
		RULE_prog = 0, RULE_instrucciones_C = 1, RULE_instruccion_C = 2, RULE_instr_arg = 3, 
		RULE_step = 4, RULE_cond_step = 5, RULE_flow_control_C = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "instrucciones_C", "instruccion_C", "instr_arg", "step", "cond_step", 
			"flow_control_C"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@cableado'", "'instrucciones'", "'{'", "'}'", "'('", "')'", "'value'", 
			"'dir'", "'['", "']'", "';'", "':'", "'LOAD_SC'", "'LOAD_SR'", "'SR+1->SR'", 
			"'SC-1->SC'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "DECN", "IDNT", "MICRO_INSTR", "BIT_ESTATUS", 
			"LINE_COMMENT", "COMMENT", "NEWLINE", "WS"
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
		public Instrucciones_CContext instrucciones_C() {
			return getRuleContext(Instrucciones_CContext.class,0);
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
			setState(14);
			instrucciones_C();
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
	public static class Instrucciones_CContext extends ParserRuleContext {
		public List<Instruccion_CContext> instruccion_C() {
			return getRuleContexts(Instruccion_CContext.class);
		}
		public Instruccion_CContext instruccion_C(int i) {
			return getRuleContext(Instruccion_CContext.class,i);
		}
		public Instrucciones_CContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucciones_C; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterInstrucciones_C(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitInstrucciones_C(this);
		}
	}

	public final Instrucciones_CContext instrucciones_C() throws RecognitionException {
		Instrucciones_CContext _localctx = new Instrucciones_CContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instrucciones_C);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(T__0);
			setState(17);
			match(T__1);
			setState(18);
			match(T__2);
			setState(20); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(19);
				instruccion_C();
				}
				}
				setState(22); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDNT );
			setState(24);
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
	public static class Instruccion_CContext extends ParserRuleContext {
		public TerminalNode IDNT() { return getToken(SicomeParser.IDNT, 0); }
		public Instr_argContext instr_arg() {
			return getRuleContext(Instr_argContext.class,0);
		}
		public List<StepContext> step() {
			return getRuleContexts(StepContext.class);
		}
		public StepContext step(int i) {
			return getRuleContext(StepContext.class,i);
		}
		public Instruccion_CContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion_C; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterInstruccion_C(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitInstruccion_C(this);
		}
	}

	public final Instruccion_CContext instruccion_C() throws RecognitionException {
		Instruccion_CContext _localctx = new Instruccion_CContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruccion_C);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(IDNT);
			setState(27);
			match(T__4);
			setState(28);
			instr_arg();
			setState(29);
			match(T__5);
			setState(30);
			match(T__2);
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
				step();
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__8 );
			setState(36);
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
	public static class Instr_argContext extends ParserRuleContext {
		public Instr_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterInstr_arg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitInstr_arg(this);
		}
	}

	public final Instr_argContext instr_arg() throws RecognitionException {
		Instr_argContext _localctx = new Instr_argContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instr_arg);
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(T__6);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				match(T__7);
				}
				break;
			case T__5:
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
	public static class StepContext extends ParserRuleContext {
		public StepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_step; }
	 
		public StepContext() { }
		public void copyFrom(StepContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleStepContext extends StepContext {
		public List<Flow_control_CContext> flow_control_C() {
			return getRuleContexts(Flow_control_CContext.class);
		}
		public Flow_control_CContext flow_control_C(int i) {
			return getRuleContext(Flow_control_CContext.class,i);
		}
		public List<TerminalNode> MICRO_INSTR() { return getTokens(SicomeParser.MICRO_INSTR); }
		public TerminalNode MICRO_INSTR(int i) {
			return getToken(SicomeParser.MICRO_INSTR, i);
		}
		public SimpleStepContext(StepContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterSimpleStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitSimpleStep(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalStepContext extends StepContext {
		public List<Cond_stepContext> cond_step() {
			return getRuleContexts(Cond_stepContext.class);
		}
		public Cond_stepContext cond_step(int i) {
			return getRuleContext(Cond_stepContext.class,i);
		}
		public ConditionalStepContext(StepContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterConditionalStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitConditionalStep(this);
		}
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_step);
		int _la;
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new SimpleStepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				match(T__8);
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(44);
					flow_control_C();
					}
					}
					setState(47); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 122880L) != 0) );
				setState(49);
				match(T__9);
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MICRO_INSTR) {
					{
					{
					setState(50);
					match(MICRO_INSTR);
					}
					}
					setState(55);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(56);
				match(T__10);
				}
				break;
			case T__2:
				_localctx = new ConditionalStepContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(T__2);
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(59);
					cond_step();
					}
					}
					setState(62); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==BIT_ESTATUS );
				setState(64);
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
	public static class Cond_stepContext extends ParserRuleContext {
		public List<TerminalNode> BIT_ESTATUS() { return getTokens(SicomeParser.BIT_ESTATUS); }
		public TerminalNode BIT_ESTATUS(int i) {
			return getToken(SicomeParser.BIT_ESTATUS, i);
		}
		public List<Flow_control_CContext> flow_control_C() {
			return getRuleContexts(Flow_control_CContext.class);
		}
		public Flow_control_CContext flow_control_C(int i) {
			return getRuleContext(Flow_control_CContext.class,i);
		}
		public List<TerminalNode> MICRO_INSTR() { return getTokens(SicomeParser.MICRO_INSTR); }
		public TerminalNode MICRO_INSTR(int i) {
			return getToken(SicomeParser.MICRO_INSTR, i);
		}
		public Cond_stepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_step; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterCond_step(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitCond_step(this);
		}
	}

	public final Cond_stepContext cond_step() throws RecognitionException {
		Cond_stepContext _localctx = new Cond_stepContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cond_step);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				match(BIT_ESTATUS);
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==BIT_ESTATUS );
			setState(73);
			match(T__11);
			setState(74);
			match(T__8);
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				flow_control_C();
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 122880L) != 0) );
			setState(80);
			match(T__9);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MICRO_INSTR) {
				{
				{
				setState(81);
				match(MICRO_INSTR);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
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
	public static class Flow_control_CContext extends ParserRuleContext {
		public Flow_control_CContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flow_control_C; }
	 
		public Flow_control_CContext() { }
		public void copyFrom(Flow_control_CContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleFlowControlContext extends Flow_control_CContext {
		public SimpleFlowControlContext(Flow_control_CContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterSimpleFlowControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitSimpleFlowControl(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComplexFlowControlContext extends Flow_control_CContext {
		public TerminalNode DECN() { return getToken(SicomeParser.DECN, 0); }
		public ComplexFlowControlContext(Flow_control_CContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).enterComplexFlowControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SicomeListener ) ((SicomeListener)listener).exitComplexFlowControl(this);
		}
	}

	public final Flow_control_CContext flow_control_C() throws RecognitionException {
		Flow_control_CContext _localctx = new Flow_control_CContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_flow_control_C);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				_localctx = new ComplexFlowControlContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(T__12);
				setState(90);
				match(T__4);
				setState(91);
				match(DECN);
				setState(92);
				match(T__5);
				}
				break;
			case T__13:
				_localctx = new ComplexFlowControlContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(T__13);
				setState(94);
				match(T__4);
				setState(95);
				match(DECN);
				setState(96);
				match(T__5);
				}
				break;
			case T__14:
				_localctx = new SimpleFlowControlContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(T__14);
				}
				break;
			case T__15:
				_localctx = new SimpleFlowControlContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(98);
				match(T__15);
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
		"\u0004\u0001\u0018f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001\u0015\b\u0001\u000b"+
		"\u0001\f\u0001\u0016\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002!\b\u0002\u000b"+
		"\u0002\f\u0002\"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003*\b\u0003\u0001\u0004\u0001\u0004\u0004\u0004.\b\u0004"+
		"\u000b\u0004\f\u0004/\u0001\u0004\u0001\u0004\u0005\u00044\b\u0004\n\u0004"+
		"\f\u00047\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004"+
		"\u0004=\b\u0004\u000b\u0004\f\u0004>\u0001\u0004\u0001\u0004\u0003\u0004"+
		"C\b\u0004\u0001\u0005\u0004\u0005F\b\u0005\u000b\u0005\f\u0005G\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0004\u0005M\b\u0005\u000b\u0005\f\u0005"+
		"N\u0001\u0005\u0001\u0005\u0005\u0005S\b\u0005\n\u0005\f\u0005V\t\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006d\b\u0006\u0001\u0006\u0000\u0000\u0007\u0000\u0002\u0004"+
		"\u0006\b\n\f\u0000\u0000l\u0000\u000e\u0001\u0000\u0000\u0000\u0002\u0010"+
		"\u0001\u0000\u0000\u0000\u0004\u001a\u0001\u0000\u0000\u0000\u0006)\u0001"+
		"\u0000\u0000\u0000\bB\u0001\u0000\u0000\u0000\nE\u0001\u0000\u0000\u0000"+
		"\fc\u0001\u0000\u0000\u0000\u000e\u000f\u0003\u0002\u0001\u0000\u000f"+
		"\u0001\u0001\u0000\u0000\u0000\u0010\u0011\u0005\u0001\u0000\u0000\u0011"+
		"\u0012\u0005\u0002\u0000\u0000\u0012\u0014\u0005\u0003\u0000\u0000\u0013"+
		"\u0015\u0003\u0004\u0002\u0000\u0014\u0013\u0001\u0000\u0000\u0000\u0015"+
		"\u0016\u0001\u0000\u0000\u0000\u0016\u0014\u0001\u0000\u0000\u0000\u0016"+
		"\u0017\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018"+
		"\u0019\u0005\u0004\u0000\u0000\u0019\u0003\u0001\u0000\u0000\u0000\u001a"+
		"\u001b\u0005\u0012\u0000\u0000\u001b\u001c\u0005\u0005\u0000\u0000\u001c"+
		"\u001d\u0003\u0006\u0003\u0000\u001d\u001e\u0005\u0006\u0000\u0000\u001e"+
		" \u0005\u0003\u0000\u0000\u001f!\u0003\b\u0004\u0000 \u001f\u0001\u0000"+
		"\u0000\u0000!\"\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#"+
		"\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0005\u0004\u0000"+
		"\u0000%\u0005\u0001\u0000\u0000\u0000&*\u0005\u0007\u0000\u0000\'*\u0005"+
		"\b\u0000\u0000(*\u0001\u0000\u0000\u0000)&\u0001\u0000\u0000\u0000)\'"+
		"\u0001\u0000\u0000\u0000)(\u0001\u0000\u0000\u0000*\u0007\u0001\u0000"+
		"\u0000\u0000+-\u0005\t\u0000\u0000,.\u0003\f\u0006\u0000-,\u0001\u0000"+
		"\u0000\u0000./\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/0\u0001"+
		"\u0000\u0000\u000001\u0001\u0000\u0000\u000015\u0005\n\u0000\u000024\u0005"+
		"\u0013\u0000\u000032\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u0000"+
		"53\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000068\u0001\u0000\u0000"+
		"\u000075\u0001\u0000\u0000\u000089\u0005\u000b\u0000\u00009C\u0001\u0000"+
		"\u0000\u0000:<\u0005\u0003\u0000\u0000;=\u0003\n\u0005\u0000<;\u0001\u0000"+
		"\u0000\u0000=>\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0005\u0004\u0000\u0000"+
		"AC\u0001\u0000\u0000\u0000B+\u0001\u0000\u0000\u0000B:\u0001\u0000\u0000"+
		"\u0000C\t\u0001\u0000\u0000\u0000DF\u0005\u0014\u0000\u0000ED\u0001\u0000"+
		"\u0000\u0000FG\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001"+
		"\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0005\f\u0000\u0000JL\u0005"+
		"\t\u0000\u0000KM\u0003\f\u0006\u0000LK\u0001\u0000\u0000\u0000MN\u0001"+
		"\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000PT\u0005\n\u0000\u0000QS\u0005\u0013\u0000\u0000"+
		"RQ\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001\u0000"+
		"\u0000\u0000WX\u0005\u000b\u0000\u0000X\u000b\u0001\u0000\u0000\u0000"+
		"YZ\u0005\r\u0000\u0000Z[\u0005\u0005\u0000\u0000[\\\u0005\u0011\u0000"+
		"\u0000\\d\u0005\u0006\u0000\u0000]^\u0005\u000e\u0000\u0000^_\u0005\u0005"+
		"\u0000\u0000_`\u0005\u0011\u0000\u0000`d\u0005\u0006\u0000\u0000ad\u0005"+
		"\u000f\u0000\u0000bd\u0005\u0010\u0000\u0000cY\u0001\u0000\u0000\u0000"+
		"c]\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cb\u0001\u0000\u0000"+
		"\u0000d\r\u0001\u0000\u0000\u0000\u000b\u0016\")/5>BGNTc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}