// Generated from D:/complier/src/main/java/L3\CmmParser.g4 by ANTLR 4.9.2
package L3;
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
		TYPE=1, STRUCT=2, RETURN=3, IF=4, ELSE=5, WHILE=6, FLOAT=7, ID=8, INT=9, 
		WS=10, SEMI=11, COMMA=12, ASSIGNOP=13, RELOP=14, PLUS=15, MINUS=16, STAR=17, 
		DIV=18, AND=19, OR=20, DOT=21, NOT=22, LP=23, RP=24, LB=25, RB=26, LC=27, 
		RC=28, SL_COMMENT=29, ML_COMMENT=30;
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
			null, null, null, "';'", "','", "'='", null, "'+'", "'-'", "'*'", "'/'", 
			"'&&'", "'||'", "'.'", "'!'", "'('", "')'", "'['", "']'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TYPE", "STRUCT", "RETURN", "IF", "ELSE", "WHILE", "FLOAT", "ID", 
			"INT", "WS", "SEMI", "COMMA", "ASSIGNOP", "RELOP", "PLUS", "MINUS", "STAR", 
			"DIV", "AND", "OR", "DOT", "NOT", "LP", "RP", "LB", "RB", "LC", "RC", 
			"SL_COMMENT", "ML_COMMENT"
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
		public ExtDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extDef; }
	 
		public ExtDefContext() { }
		public void copyFrom(ExtDefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExtDefForVarContext extends ExtDefContext {
		public SpecifierContext specifier() {
			return getRuleContext(SpecifierContext.class,0);
		}
		public ExtDecListContext extDecList() {
			return getRuleContext(ExtDecListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CmmParser.SEMI, 0); }
		public ExtDefForVarContext(ExtDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExtDefForVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExtDefForVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExtDefForVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExtDefForStructContext extends ExtDefContext {
		public SpecifierContext specifier() {
			return getRuleContext(SpecifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CmmParser.SEMI, 0); }
		public ExtDefForStructContext(ExtDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExtDefForStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExtDefForStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExtDefForStruct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExtDefForFucContext extends ExtDefContext {
		public SpecifierContext specifier() {
			return getRuleContext(SpecifierContext.class,0);
		}
		public FunDecContext funDec() {
			return getRuleContext(FunDecContext.class,0);
		}
		public CompStContext compSt() {
			return getRuleContext(CompStContext.class,0);
		}
		public ExtDefForFucContext(ExtDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExtDefForFuc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExtDefForFuc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExtDefForFuc(this);
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
				_localctx = new ExtDefForVarContext(_localctx);
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
				_localctx = new ExtDefForStructContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				specifier();
				setState(53);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new ExtDefForFucContext(_localctx);
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
		public VarDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDec; }
	 
		public VarDecContext() { }
		public void copyFrom(VarDecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarDecNormalContext extends VarDecContext {
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public VarDecNormalContext(VarDecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterVarDecNormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitVarDecNormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitVarDecNormal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDecForArrayContext extends VarDecContext {
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
		public VarDecForArrayContext(VarDecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterVarDecForArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitVarDecForArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitVarDecForArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecContext varDec() throws RecognitionException {
		VarDecContext _localctx = new VarDecContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDec);
		int _la;
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new VarDecNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(ID);
				}
				break;
			case 2:
				_localctx = new VarDecForArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(ID);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LB) {
					{
					{
					setState(71);
					match(LB);
					setState(77);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case FLOAT:
						{
						setState(72);
						match(FLOAT);
						notifyErrorListeners("array size must be an integer constant,not ");
						}
						break;
					case ID:
						{
						setState(74);
						match(ID);
						notifyErrorListeners("array size must be an integer constant,not ");
						}
						break;
					case INT:
						{
						setState(76);
						match(INT);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(79);
					match(RB);
					}
					}
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
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
			setState(87);
			match(LC);
			setState(88);
			defList();
			setState(89);
			stmtList();
			setState(90);
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
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << FLOAT) | (1L << ID) | (1L << INT) | (1L << MINUS) | (1L << NOT) | (1L << LP) | (1L << LC))) != 0)) {
				{
				{
				setState(92);
				stmt();
				}
				}
				setState(97);
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
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StmtexpContext extends StmtContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CmmParser.SEMI, 0); }
		public StmtexpContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterStmtexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitStmtexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitStmtexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompStStmtContext extends StmtContext {
		public CompStContext compSt() {
			return getRuleContext(CompStContext.class,0);
		}
		public CompStStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterCompStStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitCompStStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitCompStStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfelseStmtContext extends StmtContext {
		public TerminalNode IF() { return getToken(CmmParser.IF, 0); }
		public TerminalNode LP() { return getToken(CmmParser.LP, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RP() { return getToken(CmmParser.RP, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(CmmParser.ELSE, 0); }
		public IfelseStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterIfelseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitIfelseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitIfelseStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStmtContext extends StmtContext {
		public TerminalNode WHILE() { return getToken(CmmParser.WHILE, 0); }
		public TerminalNode LP() { return getToken(CmmParser.LP, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RP() { return getToken(CmmParser.RP, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStmtContext extends StmtContext {
		public TerminalNode IF() { return getToken(CmmParser.IF, 0); }
		public TerminalNode LP() { return getToken(CmmParser.LP, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RP() { return getToken(CmmParser.RP, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStmtContext extends StmtContext {
		public TerminalNode RETURN() { return getToken(CmmParser.RETURN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CmmParser.SEMI, 0); }
		public ReturnStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stmt);
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new StmtexpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				exp(0);
				setState(99);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new CompStStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				compSt();
				}
				break;
			case 3:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				match(RETURN);
				setState(103);
				exp(0);
				setState(104);
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				match(IF);
				setState(107);
				match(LP);
				setState(108);
				exp(0);
				setState(109);
				match(RP);
				setState(110);
				stmt();
				}
				break;
			case 5:
				_localctx = new IfelseStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(112);
				match(IF);
				setState(113);
				match(LP);
				setState(114);
				exp(0);
				setState(115);
				match(RP);
				setState(116);
				stmt();
				setState(117);
				match(ELSE);
				setState(118);
				stmt();
				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(120);
				match(WHILE);
				setState(121);
				match(LP);
				setState(122);
				exp(0);
				setState(123);
				match(RP);
				setState(124);
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
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpOrContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode OR() { return getToken(CmmParser.OR, 0); }
		public ExpOrContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpWithFucNoParametersContext extends ExpContext {
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode LP() { return getToken(CmmParser.LP, 0); }
		public TerminalNode RP() { return getToken(CmmParser.RP, 0); }
		public ExpWithFucNoParametersContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpWithFucNoParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpWithFucNoParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpWithFucNoParameters(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpNegativeContext extends ExpContext {
		public TerminalNode MINUS() { return getToken(CmmParser.MINUS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpNegativeContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpNegative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpNegative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpNegative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpWithArrayContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode LB() { return getToken(CmmParser.LB, 0); }
		public TerminalNode RB() { return getToken(CmmParser.RB, 0); }
		public ExpWithArrayContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpWithArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpWithArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpWithArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpWithStructContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode DOT() { return getToken(CmmParser.DOT, 0); }
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ExpWithStructContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpWithStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpWithStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpWithStruct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpAssignContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode ASSIGNOP() { return getToken(CmmParser.ASSIGNOP, 0); }
		public ExpAssignContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpFloatContext extends ExpContext {
		public TerminalNode FLOAT() { return getToken(CmmParser.FLOAT, 0); }
		public ExpFloatContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpAndContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode AND() { return getToken(CmmParser.AND, 0); }
		public ExpAndContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpDivOrStarContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode DIV() { return getToken(CmmParser.DIV, 0); }
		public TerminalNode STAR() { return getToken(CmmParser.STAR, 0); }
		public ExpDivOrStarContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpDivOrStar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpDivOrStar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpDivOrStar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpCompareContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(CmmParser.RELOP, 0); }
		public ExpCompareContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpCompare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIntContext extends ExpContext {
		public TerminalNode INT() { return getToken(CmmParser.INT, 0); }
		public ExpIntContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpWithFucContext extends ExpContext {
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode LP() { return getToken(CmmParser.LP, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode RP() { return getToken(CmmParser.RP, 0); }
		public ExpWithFucContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpWithFuc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpWithFuc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpWithFuc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpPlusOrMinusContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(CmmParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(CmmParser.PLUS, 0); }
		public ExpPlusOrMinusContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpPlusOrMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpPlusOrMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpPlusOrMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpNegateContext extends ExpContext {
		public TerminalNode NOT() { return getToken(CmmParser.NOT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpNegateContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpNegate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpNegate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpNegate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpBracketsContext extends ExpContext {
		public TerminalNode LP() { return getToken(CmmParser.LP, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RP() { return getToken(CmmParser.RP, 0); }
		public ExpBracketsContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpBrackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpBrackets(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpBrackets(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIdContext extends ExpContext {
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ExpIdContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExpId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExpId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitExpId(this);
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
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new ExpWithFucContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(129);
				match(ID);
				setState(130);
				match(LP);
				setState(131);
				args();
				setState(132);
				match(RP);
				}
				break;
			case 2:
				{
				_localctx = new ExpWithFucNoParametersContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				match(ID);
				setState(135);
				match(LP);
				setState(136);
				match(RP);
				}
				break;
			case 3:
				{
				_localctx = new ExpNegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				match(MINUS);
				setState(138);
				exp(12);
				}
				break;
			case 4:
				{
				_localctx = new ExpNegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(NOT);
				setState(140);
				exp(11);
				}
				break;
			case 5:
				{
				_localctx = new ExpBracketsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(LP);
				setState(142);
				exp(0);
				setState(143);
				match(RP);
				}
				break;
			case 6:
				{
				_localctx = new ExpFloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(FLOAT);
				}
				break;
			case 7:
				{
				_localctx = new ExpIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(INT);
				}
				break;
			case 8:
				{
				_localctx = new ExpIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(176);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExpDivOrStarContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(150);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(151);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(152);
						exp(11);
						}
						break;
					case 2:
						{
						_localctx = new ExpPlusOrMinusContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(153);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(154);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(155);
						exp(10);
						}
						break;
					case 3:
						{
						_localctx = new ExpCompareContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(156);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(157);
						match(RELOP);
						setState(158);
						exp(9);
						}
						break;
					case 4:
						{
						_localctx = new ExpAndContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(159);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(160);
						match(AND);
						setState(161);
						exp(8);
						}
						break;
					case 5:
						{
						_localctx = new ExpOrContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(162);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(163);
						match(OR);
						setState(164);
						exp(7);
						}
						break;
					case 6:
						{
						_localctx = new ExpAssignContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(165);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(166);
						match(ASSIGNOP);
						setState(167);
						exp(5);
						}
						break;
					case 7:
						{
						_localctx = new ExpWithArrayContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(168);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(169);
						match(LB);
						setState(170);
						exp(0);
						setState(171);
						match(RB);
						}
						break;
					case 8:
						{
						_localctx = new ExpWithStructContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(173);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(174);
						match(DOT);
						setState(175);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
			setState(181);
			exp(0);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(182);
				match(COMMA);
				setState(183);
				exp(0);
				}
				}
				setState(188);
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
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE || _la==STRUCT) {
				{
				{
				setState(189);
				def();
				}
				}
				setState(194);
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
			setState(195);
			specifier();
			setState(196);
			decList();
			setState(197);
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
			setState(199);
			dec();
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(200);
				match(COMMA);
				setState(201);
				dec();
				}
				}
				setState(206);
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
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
	 
		public DecContext() { }
		public void copyFrom(DecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecWithInitContext extends DecContext {
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public TerminalNode ASSIGNOP() { return getToken(CmmParser.ASSIGNOP, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public DecWithInitContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterDecWithInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitDecWithInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitDecWithInit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecWithoutInitContext extends DecContext {
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public DecWithoutInitContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterDecWithoutInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitDecWithoutInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitDecWithoutInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dec);
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new DecWithInitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(207);
				varDec();
				setState(208);
				match(ASSIGNOP);
				setState(209);
				exp(0);
				}
				}
				break;
			case 2:
				_localctx = new DecWithoutInitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
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
		public FunDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDec; }
	 
		public FunDecContext() { }
		public void copyFrom(FunDecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunDecWithVarContext extends FunDecContext {
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode LP() { return getToken(CmmParser.LP, 0); }
		public TerminalNode RP() { return getToken(CmmParser.RP, 0); }
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public FunDecWithVarContext(FunDecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterFunDecWithVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitFunDecWithVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitFunDecWithVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunDecWithoutVarContext extends FunDecContext {
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode LP() { return getToken(CmmParser.LP, 0); }
		public TerminalNode RP() { return getToken(CmmParser.RP, 0); }
		public FunDecWithoutVarContext(FunDecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterFunDecWithoutVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitFunDecWithoutVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitFunDecWithoutVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunDecContext funDec() throws RecognitionException {
		FunDecContext _localctx = new FunDecContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_funDec);
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new FunDecWithVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(ID);
				setState(215);
				match(LP);
				{
				setState(216);
				varList();
				}
				setState(217);
				match(RP);
				}
				break;
			case 2:
				_localctx = new FunDecWithoutVarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				match(ID);
				setState(220);
				match(LP);
				setState(221);
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
			setState(224);
			paramDec();
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(225);
				match(COMMA);
				setState(226);
				paramDec();
				}
				}
				setState(231);
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
			setState(232);
			specifier();
			setState(233);
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
		public SpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifier; }
	 
		public SpecifierContext() { }
		public void copyFrom(SpecifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SpecifierForStructContext extends SpecifierContext {
		public StructSpecifierContext structSpecifier() {
			return getRuleContext(StructSpecifierContext.class,0);
		}
		public SpecifierForStructContext(SpecifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterSpecifierForStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitSpecifierForStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitSpecifierForStruct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SpecifierForVarContext extends SpecifierContext {
		public TerminalNode TYPE() { return getToken(CmmParser.TYPE, 0); }
		public SpecifierForVarContext(SpecifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterSpecifierForVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitSpecifierForVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitSpecifierForVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecifierContext specifier() throws RecognitionException {
		SpecifierContext _localctx = new SpecifierContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_specifier);
		try {
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				_localctx = new SpecifierForVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				match(TYPE);
				}
				break;
			case STRUCT:
				_localctx = new SpecifierForStructContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
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
		public StructSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structSpecifier; }
	 
		public StructSpecifierContext() { }
		public void copyFrom(StructSpecifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StructContext extends StructSpecifierContext {
		public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
		public OptTagContext optTag() {
			return getRuleContext(OptTagContext.class,0);
		}
		public TerminalNode LC() { return getToken(CmmParser.LC, 0); }
		public DefListContext defList() {
			return getRuleContext(DefListContext.class,0);
		}
		public TerminalNode RC() { return getToken(CmmParser.RC, 0); }
		public StructContext(StructSpecifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitStruct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReuseStructContext extends StructSpecifierContext {
		public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public ReuseStructContext(StructSpecifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterReuseStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitReuseStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitReuseStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructSpecifierContext structSpecifier() throws RecognitionException {
		StructSpecifierContext _localctx = new StructSpecifierContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_structSpecifier);
		try {
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new StructContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				match(STRUCT);
				setState(240);
				optTag();
				setState(241);
				match(LC);
				setState(242);
				defList();
				setState(243);
				match(RC);
				}
				break;
			case 2:
				_localctx = new ReuseStructContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				match(STRUCT);
				setState(246);
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
		public OptTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optTag; }
	 
		public OptTagContext() { }
		public void copyFrom(OptTagContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OptWithNameContext extends OptTagContext {
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public OptWithNameContext(OptTagContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterOptWithName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitOptWithName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitOptWithName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OptWithNoNameContext extends OptTagContext {
		public OptWithNoNameContext(OptTagContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterOptWithNoName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitOptWithNoName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmParserVisitor ) return ((CmmParserVisitor<? extends T>)visitor).visitOptWithNoName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptTagContext optTag() throws RecognitionException {
		OptTagContext _localctx = new OptTagContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_optTag);
		try {
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new OptWithNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				match(ID);
				}
				break;
			case LC:
				_localctx = new OptWithNoNameContext(_localctx);
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
			setState(253);
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
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u0102\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3>\n\3\3\4\3\4\3\4\7\4C\n\4"+
		"\f\4\16\4F\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5P\n\5\3\5\7\5S\n\5"+
		"\f\5\16\5V\13\5\5\5X\n\5\3\6\3\6\3\6\3\6\3\6\3\7\7\7`\n\7\f\7\16\7c\13"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0081\n\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\t\u0097\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00b3\n\t\f\t\16\t"+
		"\u00b6\13\t\3\n\3\n\3\n\7\n\u00bb\n\n\f\n\16\n\u00be\13\n\3\13\7\13\u00c1"+
		"\n\13\f\13\16\13\u00c4\13\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u00cd\n\r"+
		"\f\r\16\r\u00d0\13\r\3\16\3\16\3\16\3\16\3\16\5\16\u00d7\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00e1\n\17\3\20\3\20\3\20\7\20\u00e6"+
		"\n\20\f\20\16\20\u00e9\13\20\3\21\3\21\3\21\3\22\3\22\5\22\u00f0\n\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00fa\n\23\3\24\3\24\5\24"+
		"\u00fe\n\24\3\25\3\25\3\25\2\3\20\26\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(\2\4\3\2\23\24\3\2\21\22\2\u0113\2-\3\2\2\2\4=\3\2\2\2\6?"+
		"\3\2\2\2\bW\3\2\2\2\nY\3\2\2\2\fa\3\2\2\2\16\u0080\3\2\2\2\20\u0096\3"+
		"\2\2\2\22\u00b7\3\2\2\2\24\u00c2\3\2\2\2\26\u00c5\3\2\2\2\30\u00c9\3\2"+
		"\2\2\32\u00d6\3\2\2\2\34\u00e0\3\2\2\2\36\u00e2\3\2\2\2 \u00ea\3\2\2\2"+
		"\"\u00ef\3\2\2\2$\u00f9\3\2\2\2&\u00fd\3\2\2\2(\u00ff\3\2\2\2*,\5\4\3"+
		"\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\61"+
		"\7\2\2\3\61\3\3\2\2\2\62\63\5\"\22\2\63\64\5\6\4\2\64\65\7\r\2\2\65>\3"+
		"\2\2\2\66\67\5\"\22\2\678\7\r\2\28>\3\2\2\29:\5\"\22\2:;\5\34\17\2;<\5"+
		"\n\6\2<>\3\2\2\2=\62\3\2\2\2=\66\3\2\2\2=9\3\2\2\2>\5\3\2\2\2?D\5\b\5"+
		"\2@A\7\16\2\2AC\5\b\5\2B@\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\7\3\2"+
		"\2\2FD\3\2\2\2GX\7\n\2\2HT\7\n\2\2IO\7\33\2\2JK\7\t\2\2KP\b\5\1\2LM\7"+
		"\n\2\2MP\b\5\1\2NP\7\13\2\2OJ\3\2\2\2OL\3\2\2\2ON\3\2\2\2PQ\3\2\2\2QS"+
		"\7\34\2\2RI\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UX\3\2\2\2VT\3\2\2\2"+
		"WG\3\2\2\2WH\3\2\2\2X\t\3\2\2\2YZ\7\35\2\2Z[\5\24\13\2[\\\5\f\7\2\\]\7"+
		"\36\2\2]\13\3\2\2\2^`\5\16\b\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2"+
		"b\r\3\2\2\2ca\3\2\2\2de\5\20\t\2ef\7\r\2\2f\u0081\3\2\2\2g\u0081\5\n\6"+
		"\2hi\7\5\2\2ij\5\20\t\2jk\7\r\2\2k\u0081\3\2\2\2lm\7\6\2\2mn\7\31\2\2"+
		"no\5\20\t\2op\7\32\2\2pq\5\16\b\2q\u0081\3\2\2\2rs\7\6\2\2st\7\31\2\2"+
		"tu\5\20\t\2uv\7\32\2\2vw\5\16\b\2wx\7\7\2\2xy\5\16\b\2y\u0081\3\2\2\2"+
		"z{\7\b\2\2{|\7\31\2\2|}\5\20\t\2}~\7\32\2\2~\177\5\16\b\2\177\u0081\3"+
		"\2\2\2\u0080d\3\2\2\2\u0080g\3\2\2\2\u0080h\3\2\2\2\u0080l\3\2\2\2\u0080"+
		"r\3\2\2\2\u0080z\3\2\2\2\u0081\17\3\2\2\2\u0082\u0083\b\t\1\2\u0083\u0084"+
		"\7\n\2\2\u0084\u0085\7\31\2\2\u0085\u0086\5\22\n\2\u0086\u0087\7\32\2"+
		"\2\u0087\u0097\3\2\2\2\u0088\u0089\7\n\2\2\u0089\u008a\7\31\2\2\u008a"+
		"\u0097\7\32\2\2\u008b\u008c\7\22\2\2\u008c\u0097\5\20\t\16\u008d\u008e"+
		"\7\30\2\2\u008e\u0097\5\20\t\r\u008f\u0090\7\31\2\2\u0090\u0091\5\20\t"+
		"\2\u0091\u0092\7\32\2\2\u0092\u0097\3\2\2\2\u0093\u0097\7\t\2\2\u0094"+
		"\u0097\7\13\2\2\u0095\u0097\7\n\2\2\u0096\u0082\3\2\2\2\u0096\u0088\3"+
		"\2\2\2\u0096\u008b\3\2\2\2\u0096\u008d\3\2\2\2\u0096\u008f\3\2\2\2\u0096"+
		"\u0093\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097\u00b4\3\2"+
		"\2\2\u0098\u0099\f\f\2\2\u0099\u009a\t\2\2\2\u009a\u00b3\5\20\t\r\u009b"+
		"\u009c\f\13\2\2\u009c\u009d\t\3\2\2\u009d\u00b3\5\20\t\f\u009e\u009f\f"+
		"\n\2\2\u009f\u00a0\7\20\2\2\u00a0\u00b3\5\20\t\13\u00a1\u00a2\f\t\2\2"+
		"\u00a2\u00a3\7\25\2\2\u00a3\u00b3\5\20\t\n\u00a4\u00a5\f\b\2\2\u00a5\u00a6"+
		"\7\26\2\2\u00a6\u00b3\5\20\t\t\u00a7\u00a8\f\7\2\2\u00a8\u00a9\7\17\2"+
		"\2\u00a9\u00b3\5\20\t\7\u00aa\u00ab\f\20\2\2\u00ab\u00ac\7\33\2\2\u00ac"+
		"\u00ad\5\20\t\2\u00ad\u00ae\7\34\2\2\u00ae\u00b3\3\2\2\2\u00af\u00b0\f"+
		"\17\2\2\u00b0\u00b1\7\27\2\2\u00b1\u00b3\7\n\2\2\u00b2\u0098\3\2\2\2\u00b2"+
		"\u009b\3\2\2\2\u00b2\u009e\3\2\2\2\u00b2\u00a1\3\2\2\2\u00b2\u00a4\3\2"+
		"\2\2\u00b2\u00a7\3\2\2\2\u00b2\u00aa\3\2\2\2\u00b2\u00af\3\2\2\2\u00b3"+
		"\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\21\3\2\2"+
		"\2\u00b6\u00b4\3\2\2\2\u00b7\u00bc\5\20\t\2\u00b8\u00b9\7\16\2\2\u00b9"+
		"\u00bb\5\20\t\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3"+
		"\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\23\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00c1\5\26\f\2\u00c0\u00bf\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3"+
		"\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\25\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5"+
		"\u00c6\5\"\22\2\u00c6\u00c7\5\30\r\2\u00c7\u00c8\7\r\2\2\u00c8\27\3\2"+
		"\2\2\u00c9\u00ce\5\32\16\2\u00ca\u00cb\7\16\2\2\u00cb\u00cd\5\32\16\2"+
		"\u00cc\u00ca\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf"+
		"\3\2\2\2\u00cf\31\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\5\b\5\2\u00d2"+
		"\u00d3\7\17\2\2\u00d3\u00d4\5\20\t\2\u00d4\u00d7\3\2\2\2\u00d5\u00d7\5"+
		"\b\5\2\u00d6\u00d1\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\33\3\2\2\2\u00d8"+
		"\u00d9\7\n\2\2\u00d9\u00da\7\31\2\2\u00da\u00db\5\36\20\2\u00db\u00dc"+
		"\7\32\2\2\u00dc\u00e1\3\2\2\2\u00dd\u00de\7\n\2\2\u00de\u00df\7\31\2\2"+
		"\u00df\u00e1\7\32\2\2\u00e0\u00d8\3\2\2\2\u00e0\u00dd\3\2\2\2\u00e1\35"+
		"\3\2\2\2\u00e2\u00e7\5 \21\2\u00e3\u00e4\7\16\2\2\u00e4\u00e6\5 \21\2"+
		"\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8"+
		"\3\2\2\2\u00e8\37\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\5\"\22\2\u00eb"+
		"\u00ec\5\b\5\2\u00ec!\3\2\2\2\u00ed\u00f0\7\3\2\2\u00ee\u00f0\5$\23\2"+
		"\u00ef\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0#\3\2\2\2\u00f1\u00f2\7"+
		"\4\2\2\u00f2\u00f3\5&\24\2\u00f3\u00f4\7\35\2\2\u00f4\u00f5\5\24\13\2"+
		"\u00f5\u00f6\7\36\2\2\u00f6\u00fa\3\2\2\2\u00f7\u00f8\7\4\2\2\u00f8\u00fa"+
		"\5(\25\2\u00f9\u00f1\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa%\3\2\2\2\u00fb"+
		"\u00fe\7\n\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2"+
		"\2\2\u00fe\'\3\2\2\2\u00ff\u0100\7\n\2\2\u0100)\3\2\2\2\26-=DOTWa\u0080"+
		"\u0096\u00b2\u00b4\u00bc\u00c2\u00ce\u00d6\u00e0\u00e7\u00ef\u00f9\u00fd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}