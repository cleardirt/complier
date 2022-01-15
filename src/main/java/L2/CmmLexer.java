// Generated from D:/complier/src/main/java/L2\CmmLexer.g4 by ANTLR 4.9.2
package L2;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TYPE=1, STRUCT=2, RETURN=3, IF=4, ELSE=5, WHILE=6, FLOAT=7, OCC=8, HEX=9, 
		ID=10, INT=11, WS=12, SEMI=13, COMMA=14, ASSIGNOP=15, RELOP=16, PLUS=17, 
		MINUS=18, STAR=19, DIV=20, AND=21, OR=22, DOT=23, NOT=24, LP=25, RP=26, 
		LB=27, RB=28, LC=29, RC=30, SL_COMMENT=31, ML_COMMENT=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TYPE", "STRUCT", "RETURN", "IF", "ELSE", "WHILE", "FLOAT", "OCC", "HEX", 
			"ID", "INT", "WS", "SEMI", "COMMA", "ASSIGNOP", "RELOP", "PLUS", "MINUS", 
			"STAR", "DIV", "AND", "OR", "DOT", "NOT", "LP", "RP", "LB", "RB", "LC", 
			"RC", "SL_COMMENT", "ML_COMMENT", "DIGIT", "LETTER", "HEX_D", "WORD", 
			"NE", "PE", "E", "FLOAT_EXPONENT"
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


	public CmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CmmLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u013e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\5\2\\\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\6\b{\n\b\r\b\16\b|\3\b\3\b\6\b\u0081\n\b\r\b\16\b\u0082\3\b\3\b\6"+
		"\b\u0087\n\b\r\b\16\b\u0088\3\b\6\b\u008c\n\b\r\b\16\b\u008d\3\b\3\b\5"+
		"\b\u0092\n\b\3\b\3\b\3\b\6\b\u0097\n\b\r\b\16\b\u0098\3\b\3\b\6\b\u009d"+
		"\n\b\r\b\16\b\u009e\3\b\3\b\3\b\5\b\u00a4\n\b\3\t\3\t\6\t\u00a8\n\t\r"+
		"\t\16\t\u00a9\3\n\3\n\3\n\6\n\u00af\n\n\r\n\16\n\u00b0\3\13\3\13\5\13"+
		"\u00b5\n\13\3\13\7\13\u00b8\n\13\f\13\16\13\u00bb\13\13\3\f\3\f\3\f\7"+
		"\f\u00c0\n\f\f\f\16\f\u00c3\13\f\5\f\u00c5\n\f\3\r\6\r\u00c8\n\r\r\r\16"+
		"\r\u00c9\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u00dd\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3 \7 \u0101\n "+
		"\f \16 \u0104\13 \3 \3 \3 \3 \3!\3!\3!\3!\7!\u010e\n!\f!\16!\u0111\13"+
		"!\3!\3!\3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\7&\u0123\n&\f&\16"+
		"&\u0126\13&\3\'\3\'\5\'\u012a\n\'\3\'\7\'\u012d\n\'\f\'\16\'\u0130\13"+
		"\'\3(\3(\5(\u0134\n(\3)\3)\5)\u0138\n)\3)\6)\u013b\n)\r)\16)\u013c\4\u0102"+
		"\u010f\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C\2E\2G\2I\2K\2M\2O\2Q\2\3\2\16\3\2\629\4\2ZZzz\5\2"+
		"\62;CHch\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\4\2>>@@\4\2C\\c|\4\2CHch\6"+
		"\2\62;C\\aac|\4\2GGgg\4\2--//\2\u0153\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\3[\3\2\2\2\5]\3\2\2\2\7d\3\2\2\2\tk\3\2\2\2\13n\3\2\2\2\rs\3\2"+
		"\2\2\17\u00a3\3\2\2\2\21\u00a5\3\2\2\2\23\u00ab\3\2\2\2\25\u00b4\3\2\2"+
		"\2\27\u00c4\3\2\2\2\31\u00c7\3\2\2\2\33\u00cd\3\2\2\2\35\u00cf\3\2\2\2"+
		"\37\u00d1\3\2\2\2!\u00dc\3\2\2\2#\u00de\3\2\2\2%\u00e0\3\2\2\2\'\u00e2"+
		"\3\2\2\2)\u00e4\3\2\2\2+\u00e6\3\2\2\2-\u00e9\3\2\2\2/\u00ec\3\2\2\2\61"+
		"\u00ee\3\2\2\2\63\u00f0\3\2\2\2\65\u00f2\3\2\2\2\67\u00f4\3\2\2\29\u00f6"+
		"\3\2\2\2;\u00f8\3\2\2\2=\u00fa\3\2\2\2?\u00fc\3\2\2\2A\u0109\3\2\2\2C"+
		"\u0117\3\2\2\2E\u0119\3\2\2\2G\u011b\3\2\2\2I\u011d\3\2\2\2K\u011f\3\2"+
		"\2\2M\u0127\3\2\2\2O\u0133\3\2\2\2Q\u0135\3\2\2\2ST\7k\2\2TU\7p\2\2U\\"+
		"\7v\2\2VW\7h\2\2WX\7n\2\2XY\7q\2\2YZ\7c\2\2Z\\\7v\2\2[S\3\2\2\2[V\3\2"+
		"\2\2\\\4\3\2\2\2]^\7u\2\2^_\7v\2\2_`\7t\2\2`a\7w\2\2ab\7e\2\2bc\7v\2\2"+
		"c\6\3\2\2\2de\7t\2\2ef\7g\2\2fg\7v\2\2gh\7w\2\2hi\7t\2\2ij\7p\2\2j\b\3"+
		"\2\2\2kl\7k\2\2lm\7h\2\2m\n\3\2\2\2no\7g\2\2op\7n\2\2pq\7u\2\2qr\7g\2"+
		"\2r\f\3\2\2\2st\7y\2\2tu\7j\2\2uv\7k\2\2vw\7n\2\2wx\7g\2\2x\16\3\2\2\2"+
		"y{\5C\"\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\u0080\5/"+
		"\30\2\177\u0081\5C\"\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0092\3\2\2\2\u0084\u0086\5/\30\2\u0085"+
		"\u0087\5C\"\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2"+
		"\2\2\u0088\u0089\3\2\2\2\u0089\u0092\3\2\2\2\u008a\u008c\5C\"\2\u008b"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0090\5/\30\2\u0090\u0092\3\2\2\2\u0091"+
		"z\3\2\2\2\u0091\u0084\3\2\2\2\u0091\u008b\3\2\2\2\u0092\u0093\3\2\2\2"+
		"\u0093\u0094\5Q)\2\u0094\u00a4\3\2\2\2\u0095\u0097\5C\"\2\u0096\u0095"+
		"\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u009c\5/\30\2\u009b\u009d\5C\"\2\u009c\u009b\3\2"+
		"\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a4\3\2\2\2\u00a0\u00a1\5\27\f\2\u00a1\u00a2\5Q)\2\u00a2\u00a4\3\2"+
		"\2\2\u00a3\u0091\3\2\2\2\u00a3\u0096\3\2\2\2\u00a3\u00a0\3\2\2\2\u00a4"+
		"\20\3\2\2\2\u00a5\u00a7\7\62\2\2\u00a6\u00a8\t\2\2\2\u00a7\u00a6\3\2\2"+
		"\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\22"+
		"\3\2\2\2\u00ab\u00ac\7\62\2\2\u00ac\u00ae\t\3\2\2\u00ad\u00af\t\4\2\2"+
		"\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\24\3\2\2\2\u00b2\u00b5\5E#\2\u00b3\u00b5\7a\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b9\3\2\2\2\u00b6\u00b8\5I%\2\u00b7"+
		"\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\26\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00c5\7\62\2\2\u00bd\u00c1"+
		"\t\5\2\2\u00be\u00c0\t\6\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2"+
		"\2\2\u00c4\u00bc\3\2\2\2\u00c4\u00bd\3\2\2\2\u00c5\30\3\2\2\2\u00c6\u00c8"+
		"\t\7\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\b\r\2\2\u00cc\32\3\2\2"+
		"\2\u00cd\u00ce\7=\2\2\u00ce\34\3\2\2\2\u00cf\u00d0\7.\2\2\u00d0\36\3\2"+
		"\2\2\u00d1\u00d2\7?\2\2\u00d2 \3\2\2\2\u00d3\u00dd\t\b\2\2\u00d4\u00d5"+
		"\7@\2\2\u00d5\u00dd\7?\2\2\u00d6\u00d7\7>\2\2\u00d7\u00dd\7?\2\2\u00d8"+
		"\u00d9\7?\2\2\u00d9\u00dd\7?\2\2\u00da\u00db\7#\2\2\u00db\u00dd\7?\2\2"+
		"\u00dc\u00d3\3\2\2\2\u00dc\u00d4\3\2\2\2\u00dc\u00d6\3\2\2\2\u00dc\u00d8"+
		"\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\"\3\2\2\2\u00de\u00df\7-\2\2\u00df"+
		"$\3\2\2\2\u00e0\u00e1\7/\2\2\u00e1&\3\2\2\2\u00e2\u00e3\7,\2\2\u00e3("+
		"\3\2\2\2\u00e4\u00e5\7\61\2\2\u00e5*\3\2\2\2\u00e6\u00e7\7(\2\2\u00e7"+
		"\u00e8\7(\2\2\u00e8,\3\2\2\2\u00e9\u00ea\7~\2\2\u00ea\u00eb\7~\2\2\u00eb"+
		".\3\2\2\2\u00ec\u00ed\7\60\2\2\u00ed\60\3\2\2\2\u00ee\u00ef\7#\2\2\u00ef"+
		"\62\3\2\2\2\u00f0\u00f1\7*\2\2\u00f1\64\3\2\2\2\u00f2\u00f3\7+\2\2\u00f3"+
		"\66\3\2\2\2\u00f4\u00f5\7]\2\2\u00f58\3\2\2\2\u00f6\u00f7\7_\2\2\u00f7"+
		":\3\2\2\2\u00f8\u00f9\7}\2\2\u00f9<\3\2\2\2\u00fa\u00fb\7\177\2\2\u00fb"+
		">\3\2\2\2\u00fc\u00fd\7\61\2\2\u00fd\u00fe\7\61\2\2\u00fe\u0102\3\2\2"+
		"\2\u00ff\u0101\13\2\2\2\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0105\3\2\2\2\u0104\u0102\3\2"+
		"\2\2\u0105\u0106\7\f\2\2\u0106\u0107\3\2\2\2\u0107\u0108\b \2\2\u0108"+
		"@\3\2\2\2\u0109\u010a\7\61\2\2\u010a\u010b\7,\2\2\u010b\u010f\3\2\2\2"+
		"\u010c\u010e\13\2\2\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u0110"+
		"\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112"+
		"\u0113\7,\2\2\u0113\u0114\7\61\2\2\u0114\u0115\3\2\2\2\u0115\u0116\b!"+
		"\2\2\u0116B\3\2\2\2\u0117\u0118\t\6\2\2\u0118D\3\2\2\2\u0119\u011a\t\t"+
		"\2\2\u011aF\3\2\2\2\u011b\u011c\t\n\2\2\u011cH\3\2\2\2\u011d\u011e\t\13"+
		"\2\2\u011eJ\3\2\2\2\u011f\u0120\t\f\2\2\u0120\u0124\7/\2\2\u0121\u0123"+
		"\5C\"\2\u0122\u0121\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125L\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0129\t\f\2\2"+
		"\u0128\u012a\7-\2\2\u0129\u0128\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012e"+
		"\3\2\2\2\u012b\u012d\5C\"\2\u012c\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012fN\3\2\2\2\u0130\u012e\3\2\2\2"+
		"\u0131\u0134\5K&\2\u0132\u0134\5M\'\2\u0133\u0131\3\2\2\2\u0133\u0132"+
		"\3\2\2\2\u0134P\3\2\2\2\u0135\u0137\t\f\2\2\u0136\u0138\t\r\2\2\u0137"+
		"\u0136\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u013b\5C"+
		"\"\2\u013a\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013a\3\2\2\2\u013c"+
		"\u013d\3\2\2\2\u013dR\3\2\2\2\34\2[|\u0082\u0088\u008d\u0091\u0098\u009e"+
		"\u00a3\u00a9\u00b0\u00b4\u00b9\u00c1\u00c4\u00c9\u00dc\u0102\u010f\u0124"+
		"\u0129\u012e\u0133\u0137\u013c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}