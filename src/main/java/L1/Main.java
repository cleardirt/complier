package L1;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.Utils;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.List;

public class Main {
    static boolean isNormal=true;
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        String file;
        if(args.length>0){
            file = args[0];
            is = new FileInputStream(file);
        }
        else
            is = new FileInputStream("D:\\complier\\src\\main\\java\\L1\\test.cmm");
        CharStream input = CharStreams.fromStream(is);
        CmmLexer lexer = new CmmLexer(input){
            @Override
            public void notifyListeners(LexerNoViableAltException e) {
                String text = this._input.getText(Interval.of(this._tokenStartCharIndex, this._input.index()));
                String msg = "Error type A at Line "+this._tokenStartLine+":"+" Mysterious character '" + this.getErrorDisplay(text) + "'.";
                System.err.println(msg);
                Main.isNormal=false;
                //throw E
            }
        };
        List<? extends Token> tokenList = lexer.getAllTokens();
        if (isNormal) {
            for (Token t :
                    tokenList) {
                boolean isF = false;
                int i;
                double d;
                switch (lexer.getVocabulary().getSymbolicName(t.getType())) {
                    case "OCC":
                        i = Integer.parseInt(t.getText().substring(1), 8);
                        System.err.println("INT " + i + " at Line " + t.getLine() + ".");
                        break;
                    case "HEX":
                        i = Integer.parseInt(t.getText().substring(2), 16);
                        System.err.println("INT " + i + " at Line " + t.getLine() + ".");
                        break;
                    case "INT":
                        i = Integer.parseInt(t.getText());
                        System.err.println("INT " + i + " at Line " + t.getLine() + ".");
                        break;
                    case "FLOAT":
                        d = Double.parseDouble(t.getText());
                        System.err.println("FLOAT " + String.format("%.6f", d) + " at Line " + t.getLine() + ".");
                        break;
                    default:
                        System.err.println(lexer.getVocabulary().getSymbolicName(t.getType()) + " " +
                                input.getText(new Interval(t.getStartIndex(), t.getStopIndex())) +
                                " at Line " + t.getLine() + ".");
                }
            }
        }
    }
}
