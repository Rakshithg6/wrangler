// Generated from io\cdap\wrangler\parser\Directives.g4 by ANTLR 4.9.3
package io.cdap.wrangler.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DirectivesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, BYTE_SIZE=2, TIME_DURATION=3, BYTE_UNIT=4, TIME_UNIT=5, COLUMN_NAME=6, 
		WS=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "BYTE_SIZE", "TIME_DURATION", "BYTE_UNIT", "TIME_UNIT", "COLUMN_NAME", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'aggregate-stats'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "BYTE_SIZE", "TIME_DURATION", "BYTE_UNIT", "TIME_UNIT", "COLUMN_NAME", 
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


	public DirectivesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Directives.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\tu\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3#\n\3\r\3\16\3$\3\3\3"+
		"\3\6\3)\n\3\r\3\16\3*\5\3-\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"8\n\3\3\4\6\4;\n\4\r\4\16\4<\3\4\3\4\6\4A\n\4\r\4\16\4B\5\4E\n\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4P\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5[\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6f\n\6\3\7\3\7\7"+
		"\7j\n\7\f\7\16\7m\13\7\3\b\6\bp\n\b\r\b\16\bq\3\b\3\b\2\2\t\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\3\2\7\3\2\62;\5\2jjoouu\5\2C\\aac|\6\2\62;C\\aac"+
		"|\5\2\13\f\17\17\"\"\2\u008c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5\"\3\2\2\2"+
		"\7:\3\2\2\2\tZ\3\2\2\2\13e\3\2\2\2\rg\3\2\2\2\17o\3\2\2\2\21\22\7c\2\2"+
		"\22\23\7i\2\2\23\24\7i\2\2\24\25\7t\2\2\25\26\7g\2\2\26\27\7i\2\2\27\30"+
		"\7c\2\2\30\31\7v\2\2\31\32\7g\2\2\32\33\7/\2\2\33\34\7u\2\2\34\35\7v\2"+
		"\2\35\36\7c\2\2\36\37\7v\2\2\37 \7u\2\2 \4\3\2\2\2!#\t\2\2\2\"!\3\2\2"+
		"\2#$\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%,\3\2\2\2&(\7\60\2\2\')\t\2\2\2(\'\3"+
		"\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,&\3\2\2\2,-\3\2\2\2-\67"+
		"\3\2\2\2.8\7D\2\2/\60\7M\2\2\608\7D\2\2\61\62\7O\2\2\628\7D\2\2\63\64"+
		"\7I\2\2\648\7D\2\2\65\66\7V\2\2\668\7D\2\2\67.\3\2\2\2\67/\3\2\2\2\67"+
		"\61\3\2\2\2\67\63\3\2\2\2\67\65\3\2\2\28\6\3\2\2\29;\t\2\2\2:9\3\2\2\2"+
		";<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=D\3\2\2\2>@\7\60\2\2?A\t\2\2\2@?\3\2\2"+
		"\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2D>\3\2\2\2DE\3\2\2\2EO\3\2\2"+
		"\2FG\7p\2\2GP\7u\2\2HI\7w\2\2IP\7u\2\2JK\7\u00b7\2\2KP\7u\2\2LM\7o\2\2"+
		"MP\7u\2\2NP\t\3\2\2OF\3\2\2\2OH\3\2\2\2OJ\3\2\2\2OL\3\2\2\2ON\3\2\2\2"+
		"P\b\3\2\2\2Q[\7D\2\2RS\7M\2\2S[\7D\2\2TU\7O\2\2U[\7D\2\2VW\7I\2\2W[\7"+
		"D\2\2XY\7V\2\2Y[\7D\2\2ZQ\3\2\2\2ZR\3\2\2\2ZT\3\2\2\2ZV\3\2\2\2ZX\3\2"+
		"\2\2[\n\3\2\2\2\\]\7p\2\2]f\7u\2\2^_\7w\2\2_f\7u\2\2`a\7\u00b7\2\2af\7"+
		"u\2\2bc\7o\2\2cf\7u\2\2df\t\3\2\2e\\\3\2\2\2e^\3\2\2\2e`\3\2\2\2eb\3\2"+
		"\2\2ed\3\2\2\2f\f\3\2\2\2gk\t\4\2\2hj\t\5\2\2ih\3\2\2\2jm\3\2\2\2ki\3"+
		"\2\2\2kl\3\2\2\2l\16\3\2\2\2mk\3\2\2\2np\t\6\2\2on\3\2\2\2pq\3\2\2\2q"+
		"o\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\b\b\2\2t\20\3\2\2\2\17\2$*,\67<BDOZek"+
		"q\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}