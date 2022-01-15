// Generated from D:/complier/src/main/java/L2\CmmParser.g4 by ANTLR 4.9.2
package L2;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TYPE=1, STRUCT=2, RETURN=3, IF=4, ELSE=5, WHILE=6, FLOAT=7, OCC=8, HEX=9, 
		ID=10, INT=11, WS=12, SEMI=13, COMMA=14, ASSIGNOP=15, RELOP=16, PLUS=17, 
		MINUS=18, STAR=19, DIV=20, AND=21, OR=22, DOT=23, NOT=24, LP=25, RP=26, 
		LB=27, RB=28, LC=29, RC=30, SL_COMMENT=31, ML_COMMENT=32;
	public static final int
		RULE_program = 0, RULE_extDef = 1, RULE_extDecList = 2, RULE_varDec = 3, 
		RULE_compSt = 4, RULE_stmtList = 5, RULE_stmt = 6, RULE_exp = 7, RULE_args = 8, 
		RULE_defList = 9, RULE_def = 10, RULE_decList = 11, RULE_dec = 12, RULE_funDec = 13, 
		RULE_varList = 14, RULE_paramDec = 15, RULE_specifier = 16, RULE_structSpecifier = 17, 
		RULE_optTag = 18, RULE_tag = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "extDef", "extDecList", "varDec", "compSt", "stmtList", "stmt", 
			"exp", "args", "defList", "def", "decList", "dec", "funDec", "varList", 
			"paramDec", "specifier", "structSpecifier", "optTag", "tag"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'struct'", "'return'", "'if'", "'else'", "'while'", null, 
			null, null, null, null, null, "';'", "','", "'='", null, "'+'", "'-'", 
			"'*'", "'/'", "'&&'", "'||'", "'.'", "'!'", "'('", "')'", "'['", "']'", 
			"'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TYPE", "STRUCT", "RETURN", "IF", "ELSE", "WHILE", "FLOAT", "OCC", 
			"HEX", "ID", "INT", "WS", "SEMI", "COMMA", "ASSIGNOP", "RELOP", "PLUS", 
			"MINUS", "STAR", "DIV", "AND", "OR", "DOT", "NOT", "LP", "RP", "LB", 
			"RB", "LC", "RC", "SL_COMMENT", "ML_COMMENT"
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
	public String getGrammarFileName() { return "CmmParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public List<ExtDefContext> extDef() {
			return getRuleContexts(ExtDefContext.class);
		}
		public ExtDefContext extDef(int i) {
			return getRuleContext(ExtDefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE || _la==STRUCT) {
				{
				{
				setState(40);
				extDef();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(EOF);
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

	public static class ExtDefContext extends ParserRuleContext {
		public SpecifierContext specifier() {
			return getRuleContext(SpecifierContext.class,0);
		}
		public ExtDecListContext extDecList() {
			return getRuleContext(ExtDecListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CmmParser.SEMI, 0); }
		public FunDecContext funDec() {
			return getRuleContext(FunDecContext.class,0);
		}
		public CompStContext compSt() {
			return getRuleContext(CompStContext.class,0);
		}
		public ExtDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExtDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExtDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExtDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtDefContext extDef() throws RecognitionException {
		ExtDefContext _localctx = new ExtDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_extDef);
		try {
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				specifier();
				setState(49);
				extDecList();
				setState(50);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				specifier();
				setState(53);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				specifier();
				setState(56);
				funDec();
				setState(57);
				compSt();
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

	public static class ExtDecListContext extends ParserRuleContext {
		public List<VarDecContext> varDec() {
			return getRuleContexts(VarDecContext.class);
		}
		public VarDecContext varDec(int i) {
			return getRuleContext(VarDecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public ExtDecListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extDecList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExtDecList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExtDecList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExtDecList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtDecListContext extDecList() throws RecognitionException {
		ExtDecListContext _localctx = new ExtDecListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_extDecList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			varDec();
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(62);
				match(COMMA);
				setState(63);
				varDec();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class VarDecContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public List<TerminalNode> LB() { return getTokens(CmmParser.LB); }
		public TerminalNode LB(int i) {
			return getToken(CmmParser.LB, i);
		}
		public List<TerminalNode> RB() { return getTokens(CmmParser.RB); }
		public TerminalNode RB(int i) {
			return getToken(CmmParser.RB, i);
		}
		public List<TerminalNode> FLOAT() { return getTokens(CmmParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(CmmParser.FLOAT, i);
		}
		public List<TerminalNode> INT() { return getTokens(CmmParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(CmmParser.INT, i);
		}
		public VarDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterVarDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitVarDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitVarDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecContext varDec() throws RecognitionException {
		VarDecContext _localctx = new VarDecContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(ID);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LB) {
				{
				{
				setState(70);
				match(LB);
				setState(76);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FLOAT:
					{
					setState(71);
					match(FLOAT);
					notifyErrorListeners("array size must be an integer constant,not ");
					}
					break;
				case ID:
					{
					setState(73);
					match(ID);
					notifyErrorListeners("array size must be an integer constant,not ");
					}
					break;
				case INT:
					{
					setState(75);
					match(INT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(78);
				match(RB);
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class CompStContext extends ParserRuleContext {
		public TerminalNode LC() { return getToken(CmmParser.LC, 0); }
		public DefListContext defList() {
			return getRuleContext(DefListContext.class,0);
		}
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public TerminalNode RC() { return getToken(CmmParser.RC, 0); }
		public CompStContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compSt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterCompSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitCompSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitCompSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompStContext compSt() throws RecognitionException {
		CompStContext _localctx = new CompStContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_compSt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(LC);
			setState(85);
			defList();
			setState(86);
			stmtList();
			setState(87);
			match(RC);
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

	public static class StmtListContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterStmtList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitStmtList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitStmtList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtListContext stmtList() throws RecognitionException {
		StmtListContext _localctx = new StmtListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stmtList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << FLOAT) | (1L << OCC) | (1L << HEX) | (1L << ID) | (1L << INT) | (1L << MINUS) | (1L << NOT) | (1L << LP) | (1L << LC))) != 0)) {
				{
				{
				setState(89);
				stmt();
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class StmtContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CmmParser.SEMI, 0); }
		public CompStContext compSt() {
			return getRuleContext(CompStContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(CmmParser.RETURN, 0); }
		public TerminalNode IF() { return getToken(CmmParser.IF, 0); }
		public TerminalNode LP() { return getToken(CmmParser.LP, 0); }
		public TerminalNode RP() { return getToken(CmmParser.RP, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(CmmParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(CmmParser.WHILE, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stmt);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				exp(0);
				setState(96);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				compSt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				match(RETURN);
				setState(100);
				exp(0);
				setState(101);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(103);
				match(IF);
				setState(104);
				match(LP);
				setState(105);
				exp(0);
				setState(106);
				match(RP);
				setState(107);
				stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(109);
				match(IF);
				setState(110);
				match(LP);
				setState(111);
				exp(0);
				setState(112);
				match(RP);
				setState(113);
				stmt();
				setState(114);
				match(ELSE);
				setState(115);
				stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(117);
				match(WHILE);
				setState(118);
				match(LP);
				setState(119);
				exp(0);
				setState(120);
				match(RP);
				setState(121);
				stmt();
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

	public static class ExpContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode LP() { return getToken(CmmParser.LP, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode RP() { return getToken(CmmParser.RP, 0); }
		public TerminalNode MINUS() { return getToken(CmmParser.MINUS, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode NOT() { return getToken(CmmParser.NOT, 0); }
		public TerminalNode FLOAT() { return getToken(CmmParser.FLOAT, 0); }
		public TerminalNode OCC() { return getToken(CmmParser.OCC, 0); }
		public TerminalNode HEX() { return getToken(CmmParser.HEX, 0); }
		public TerminalNode INT() { return getToken(CmmParser.INT, 0); }
		public TerminalNode DIV() { return getToken(CmmParser.DIV, 0); }
		public TerminalNode STAR() { return getToken(CmmParser.STAR, 0); }
		public TerminalNode PLUS() { return getToken(CmmParser.PLUS, 0); }
		public TerminalNode RELOP() { return getToken(CmmParser.RELOP, 0); }
		public TerminalNode AND() { return getToken(CmmParser.AND, 0); }
		public TerminalNode OR() { return getToken(CmmParser.OR, 0); }
		public TerminalNode ASSIGNOP() { return getToken(CmmParser.ASSIGNOP, 0); }
		public TerminalNode LB() { return getToken(CmmParser.LB, 0); }
		public TerminalNode RB() { return getToken(CmmParser.RB, 0); }
		public TerminalNode DOT() { return getToken(CmmParser.DOT, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(126);
				match(ID);
				setState(127);
				match(LP);
				setState(128);
				args();
				setState(129);
				match(RP);
				}
				break;
			case 2:
				{
				setState(131);
				match(ID);
				setState(132);
				match(LP);
				setState(133);
				match(RP);
				}
				break;
			case 3:
				{
				setState(134);
				match(MINUS);
				setState(135);
				exp(14);
				}
				break;
			case 4:
				{
				setState(136);
				match(NOT);
				setState(137);
				exp(13);
				}
				break;
			case 5:
				{
				setState(138);
				match(LP);
				setState(139);
				exp(0);
				setState(140);
				match(RP);
				}
				break;
			case 6:
				{
				setState(142);
				match(FLOAT);
				}
				break;
			case 7:
				{
				setState(143);
				match(OCC);
				}
				break;
			case 8:
				{
				setState(144);
				match(HEX);
				}
				break;
			case 9:
				{
				setState(145);
				match(INT);
				}
				break;
			case 10:
				{
				setState(146);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(177);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(175);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(149);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(150);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(151);
						exp(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(152);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(153);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(154);
						exp(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(155);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(156);
						match(RELOP);
						setState(157);
						exp(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(158);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(159);
						match(AND);
						setState(160);
						exp(10);
						}
						break;
					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(161);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(162);
						match(OR);
						setState(163);
						exp(9);
						}
						break;
					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(164);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(165);
						match(ASSIGNOP);
						setState(166);
						exp(7);
						}
						break;
					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(167);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(168);
						match(LB);
						setState(169);
						exp(0);
						setState(170);
						match(RB);
						}
						break;
					case 8:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(172);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(173);
						match(DOT);
						setState(174);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(179);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			exp(0);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(181);
				match(COMMA);
				setState(182);
				exp(0);
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class DefListContext extends ParserRuleContext {
		public List<DefContext> def() {
			return getRuleContexts(DefContext.class);
		}
		public DefContext def(int i) {
			return getRuleContext(DefContext.class,i);
		}
		public DefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterDefList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitDefList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitDefList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefListContext defList() throws RecognitionException {
		DefListContext _localctx = new DefListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_defList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE || _la==STRUCT) {
				{
				{
				setState(188);
				def();
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class DefContext extends ParserRuleContext {
		public SpecifierContext specifier() {
			return getRuleContext(SpecifierContext.class,0);
		}
		public DecListContext decList() {
			return getRuleContext(DecListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CmmParser.SEMI, 0); }
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			specifier();
			setState(195);
			decList();
			setState(196);
			match(SEMI);
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

	public static class DecListContext extends ParserRuleContext {
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public DecListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterDecList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitDecList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitDecList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecListContext decList() throws RecognitionException {
		DecListContext _localctx = new DecListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_decList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			dec();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(199);
				match(COMMA);
				setState(200);
				dec();
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class DecContext extends ParserRuleContext {
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public TerminalNode ASSIGNOP() { return getToken(CmmParser.ASSIGNOP, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dec);
		try {
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(206);
				varDec();
				setState(207);
				match(ASSIGNOP);
				setState(208);
				exp(0);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				varDec();
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

	public static class FunDecContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode LP() { return getToken(CmmParser.LP, 0); }
		public TerminalNode RP() { return getToken(CmmParser.RP, 0); }
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public FunDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterFunDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitFunDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitFunDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunDecContext funDec() throws RecognitionException {
		FunDecContext _localctx = new FunDecContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_funDec);
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				match(ID);
				setState(214);
				match(LP);
				{
				setState(215);
				varList();
				}
				setState(216);
				match(RP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				match(ID);
				setState(219);
				match(LP);
				setState(220);
				match(RP);
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

	public static class VarListContext extends ParserRuleContext {
		public List<ParamDecContext> paramDec() {
			return getRuleContexts(ParamDecContext.class);
		}
		public ParamDecContext paramDec(int i) {
			return getRuleContext(ParamDecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public VarListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterVarList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitVarList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitVarList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarListContext varList() throws RecognitionException {
		VarListContext _localctx = new VarListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_varList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			paramDec();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(224);
				match(COMMA);
				setState(225);
				paramDec();
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ParamDecContext extends ParserRuleContext {
		public SpecifierContext specifier() {
			return getRuleContext(SpecifierContext.class,0);
		}
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public ParamDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterParamDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitParamDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitParamDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamDecContext paramDec() throws RecognitionException {
		ParamDecContext _localctx = new ParamDecContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_paramDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			specifier();
			setState(232);
			varDec();
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

	public static class SpecifierContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(CmmParser.TYPE, 0); }
		public StructSpecifierContext structSpecifier() {
			return getRuleContext(StructSpecifierContext.class,0);
		}
		public SpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecifierContext specifier() throws RecognitionException {
		SpecifierContext _localctx = new SpecifierContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_specifier);
		try {
			setState(236);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(TYPE);
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				structSpecifier();
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

	public static class StructSpecifierContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
		public OptTagContext optTag() {
			return getRuleContext(OptTagContext.class,0);
		}
		public TerminalNode LC() { return getToken(CmmParser.LC, 0); }
		public DefListContext defList() {
			return getRuleContext(DefListContext.class,0);
		}
		public TerminalNode RC() { return getToken(CmmParser.RC, 0); }
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public StructSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterStructSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitStructSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitStructSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructSpecifierContext structSpecifier() throws RecognitionException {
		StructSpecifierContext _localctx = new StructSpecifierContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_structSpecifier);
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				match(STRUCT);
				setState(239);
				optTag();
				setState(240);
				match(LC);
				setState(241);
				defList();
				setState(242);
				match(RC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				match(STRUCT);
				setState(245);
				tag();
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

	public static class OptTagContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public OptTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterOptTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitOptTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitOptTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptTagContext optTag() throws RecognitionException {
		OptTagContext _localctx = new OptTagContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_optTag);
		try {
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				match(ID);
				}
				break;
			case LC:
				enterOuterAlt(_localctx, 2);
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

	public static class TagContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_tag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(ID);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 16);
		case 7:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u0101\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3>\n\3\3\4\3\4\3\4\7\4C\n\4"+
		"\f\4\16\4F\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5O\n\5\3\5\7\5R\n\5\f\5"+
		"\16\5U\13\5\3\6\3\6\3\6\3\6\3\6\3\7\7\7]\n\7\f\7\16\7`\13\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b~\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0096"+
		"\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00b2\n\t\f\t\16\t\u00b5\13"+
		"\t\3\n\3\n\3\n\7\n\u00ba\n\n\f\n\16\n\u00bd\13\n\3\13\7\13\u00c0\n\13"+
		"\f\13\16\13\u00c3\13\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u00cc\n\r\f\r"+
		"\16\r\u00cf\13\r\3\16\3\16\3\16\3\16\3\16\5\16\u00d6\n\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\5\17\u00e0\n\17\3\20\3\20\3\20\7\20\u00e5"+
		"\n\20\f\20\16\20\u00e8\13\20\3\21\3\21\3\21\3\22\3\22\5\22\u00ef\n\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00f9\n\23\3\24\3\24\5\24"+
		"\u00fd\n\24\3\25\3\25\3\25\2\3\20\26\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(\2\4\3\2\25\26\3\2\23\24\2\u0113\2-\3\2\2\2\4=\3\2\2\2\6?"+
		"\3\2\2\2\bG\3\2\2\2\nV\3\2\2\2\f^\3\2\2\2\16}\3\2\2\2\20\u0095\3\2\2\2"+
		"\22\u00b6\3\2\2\2\24\u00c1\3\2\2\2\26\u00c4\3\2\2\2\30\u00c8\3\2\2\2\32"+
		"\u00d5\3\2\2\2\34\u00df\3\2\2\2\36\u00e1\3\2\2\2 \u00e9\3\2\2\2\"\u00ee"+
		"\3\2\2\2$\u00f8\3\2\2\2&\u00fc\3\2\2\2(\u00fe\3\2\2\2*,\5\4\3\2+*\3\2"+
		"\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\7\2\2\3"+
		"\61\3\3\2\2\2\62\63\5\"\22\2\63\64\5\6\4\2\64\65\7\17\2\2\65>\3\2\2\2"+
		"\66\67\5\"\22\2\678\7\17\2\28>\3\2\2\29:\5\"\22\2:;\5\34\17\2;<\5\n\6"+
		"\2<>\3\2\2\2=\62\3\2\2\2=\66\3\2\2\2=9\3\2\2\2>\5\3\2\2\2?D\5\b\5\2@A"+
		"\7\20\2\2AC\5\b\5\2B@\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\7\3\2\2\2"+
		"FD\3\2\2\2GS\7\f\2\2HN\7\35\2\2IJ\7\t\2\2JO\b\5\1\2KL\7\f\2\2LO\b\5\1"+
		"\2MO\7\r\2\2NI\3\2\2\2NK\3\2\2\2NM\3\2\2\2OP\3\2\2\2PR\7\36\2\2QH\3\2"+
		"\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\t\3\2\2\2US\3\2\2\2VW\7\37\2\2WX\5"+
		"\24\13\2XY\5\f\7\2YZ\7 \2\2Z\13\3\2\2\2[]\5\16\b\2\\[\3\2\2\2]`\3\2\2"+
		"\2^\\\3\2\2\2^_\3\2\2\2_\r\3\2\2\2`^\3\2\2\2ab\5\20\t\2bc\7\17\2\2c~\3"+
		"\2\2\2d~\5\n\6\2ef\7\5\2\2fg\5\20\t\2gh\7\17\2\2h~\3\2\2\2ij\7\6\2\2j"+
		"k\7\33\2\2kl\5\20\t\2lm\7\34\2\2mn\5\16\b\2n~\3\2\2\2op\7\6\2\2pq\7\33"+
		"\2\2qr\5\20\t\2rs\7\34\2\2st\5\16\b\2tu\7\7\2\2uv\5\16\b\2v~\3\2\2\2w"+
		"x\7\b\2\2xy\7\33\2\2yz\5\20\t\2z{\7\34\2\2{|\5\16\b\2|~\3\2\2\2}a\3\2"+
		"\2\2}d\3\2\2\2}e\3\2\2\2}i\3\2\2\2}o\3\2\2\2}w\3\2\2\2~\17\3\2\2\2\177"+
		"\u0080\b\t\1\2\u0080\u0081\7\f\2\2\u0081\u0082\7\33\2\2\u0082\u0083\5"+
		"\22\n\2\u0083\u0084\7\34\2\2\u0084\u0096\3\2\2\2\u0085\u0086\7\f\2\2\u0086"+
		"\u0087\7\33\2\2\u0087\u0096\7\34\2\2\u0088\u0089\7\24\2\2\u0089\u0096"+
		"\5\20\t\20\u008a\u008b\7\32\2\2\u008b\u0096\5\20\t\17\u008c\u008d\7\33"+
		"\2\2\u008d\u008e\5\20\t\2\u008e\u008f\7\34\2\2\u008f\u0096\3\2\2\2\u0090"+
		"\u0096\7\t\2\2\u0091\u0096\7\n\2\2\u0092\u0096\7\13\2\2\u0093\u0096\7"+
		"\r\2\2\u0094\u0096\7\f\2\2\u0095\177\3\2\2\2\u0095\u0085\3\2\2\2\u0095"+
		"\u0088\3\2\2\2\u0095\u008a\3\2\2\2\u0095\u008c\3\2\2\2\u0095\u0090\3\2"+
		"\2\2\u0095\u0091\3\2\2\2\u0095\u0092\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0094\3\2\2\2\u0096\u00b3\3\2\2\2\u0097\u0098\f\16\2\2\u0098\u0099\t"+
		"\2\2\2\u0099\u00b2\5\20\t\17\u009a\u009b\f\r\2\2\u009b\u009c\t\3\2\2\u009c"+
		"\u00b2\5\20\t\16\u009d\u009e\f\f\2\2\u009e\u009f\7\22\2\2\u009f\u00b2"+
		"\5\20\t\r\u00a0\u00a1\f\13\2\2\u00a1\u00a2\7\27\2\2\u00a2\u00b2\5\20\t"+
		"\f\u00a3\u00a4\f\n\2\2\u00a4\u00a5\7\30\2\2\u00a5\u00b2\5\20\t\13\u00a6"+
		"\u00a7\f\t\2\2\u00a7\u00a8\7\21\2\2\u00a8\u00b2\5\20\t\t\u00a9\u00aa\f"+
		"\22\2\2\u00aa\u00ab\7\35\2\2\u00ab\u00ac\5\20\t\2\u00ac\u00ad\7\36\2\2"+
		"\u00ad\u00b2\3\2\2\2\u00ae\u00af\f\21\2\2\u00af\u00b0\7\31\2\2\u00b0\u00b2"+
		"\7\f\2\2\u00b1\u0097\3\2\2\2\u00b1\u009a\3\2\2\2\u00b1\u009d\3\2\2\2\u00b1"+
		"\u00a0\3\2\2\2\u00b1\u00a3\3\2\2\2\u00b1\u00a6\3\2\2\2\u00b1\u00a9\3\2"+
		"\2\2\u00b1\u00ae\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\21\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00bb\5\20\t"+
		"\2\u00b7\u00b8\7\20\2\2\u00b8\u00ba\5\20\t\2\u00b9\u00b7\3\2\2\2\u00ba"+
		"\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\23\3\2\2"+
		"\2\u00bd\u00bb\3\2\2\2\u00be\u00c0\5\26\f\2\u00bf\u00be\3\2\2\2\u00c0"+
		"\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\25\3\2\2"+
		"\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\5\"\22\2\u00c5\u00c6\5\30\r\2\u00c6"+
		"\u00c7\7\17\2\2\u00c7\27\3\2\2\2\u00c8\u00cd\5\32\16\2\u00c9\u00ca\7\20"+
		"\2\2\u00ca\u00cc\5\32\16\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\31\3\2\2\2\u00cf\u00cd\3\2\2"+
		"\2\u00d0\u00d1\5\b\5\2\u00d1\u00d2\7\21\2\2\u00d2\u00d3\5\20\t\2\u00d3"+
		"\u00d6\3\2\2\2\u00d4\u00d6\5\b\5\2\u00d5\u00d0\3\2\2\2\u00d5\u00d4\3\2"+
		"\2\2\u00d6\33\3\2\2\2\u00d7\u00d8\7\f\2\2\u00d8\u00d9\7\33\2\2\u00d9\u00da"+
		"\5\36\20\2\u00da\u00db\7\34\2\2\u00db\u00e0\3\2\2\2\u00dc\u00dd\7\f\2"+
		"\2\u00dd\u00de\7\33\2\2\u00de\u00e0\7\34\2\2\u00df\u00d7\3\2\2\2\u00df"+
		"\u00dc\3\2\2\2\u00e0\35\3\2\2\2\u00e1\u00e6\5 \21\2\u00e2\u00e3\7\20\2"+
		"\2\u00e3\u00e5\5 \21\2\u00e4\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4"+
		"\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\37\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9"+
		"\u00ea\5\"\22\2\u00ea\u00eb\5\b\5\2\u00eb!\3\2\2\2\u00ec\u00ef\7\3\2\2"+
		"\u00ed\u00ef\5$\23\2\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef#\3"+
		"\2\2\2\u00f0\u00f1\7\4\2\2\u00f1\u00f2\5&\24\2\u00f2\u00f3\7\37\2\2\u00f3"+
		"\u00f4\5\24\13\2\u00f4\u00f5\7 \2\2\u00f5\u00f9\3\2\2\2\u00f6\u00f7\7"+
		"\4\2\2\u00f7\u00f9\5(\25\2\u00f8\u00f0\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9"+
		"%\3\2\2\2\u00fa\u00fd\7\f\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2"+
		"\u00fc\u00fb\3\2\2\2\u00fd\'\3\2\2\2\u00fe\u00ff\7\f\2\2\u00ff)\3\2\2"+
		"\2\25-=DNS^}\u0095\u00b1\u00b3\u00bb\u00c1\u00cd\u00d5\u00df\u00e6\u00ee"+
		"\u00f8\u00fc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}