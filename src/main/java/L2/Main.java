package L2;
import L2.CmmLexer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;

public class Main {
    static boolean isNormal=true;
    public static void main(String[] args) throws IOException {
        isNormal=true;
        InputStream is = System.in;
        String file;
        if(args.length>0){
            file = args[0];
            is = new FileInputStream(file);
        }
        else
            is = new FileInputStream("D:\\complier\\src\\main\\java\\L1\\test.cmm");
        CharStream input = CharStreams.fromStream(is);
        CmmLexer lexer = new CmmLexer(input);
        HashSet<Integer> errLines=new HashSet<>();
        CmmParser parser = new CmmParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        ANTLRErrorListener myListener=new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int line, int charPositionInLine, String msg, RecognitionException e) {
                isNormal=false;
                if (errLines.add(line)){
                    if(msg.startsWith("array size must be ")){
                        //todo Other Method?
                        CommonToken commonToken = (CommonToken)o;
                        CommonTokenStream commonTokenStream = (CommonTokenStream) recognizer.getInputStream();
                        Token beforeToken =  commonTokenStream.getTokens().get(commonToken.getTokenIndex()-1);

                        line = beforeToken.getLine();
                        if(beforeToken.getType()==CmmLexer.FLOAT){
                            System.err.println(msg+ Double.parseDouble(beforeToken.getText()));
                        }else if(beforeToken.getType()==CmmLexer.ID){
                            System.err.println(msg+beforeToken.getText());
                        } //Error

                    }
                }
            }

            @Override
            public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {

            }

            @Override
            public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {

            }

            @Override
            public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {

            }
        };
        parser.addErrorListener(myListener);
        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        // 类名请更换为你自己实现的Listener
        CmmParserListener listener = new CmmParserListener() {
            @Override
            public void visitTerminal(TerminalNode terminalNode) {
                int n = 0;
                ParseTree t=terminalNode;
                while (t.getParent()!=null){
                    t= t.getParent();
                    n++;
                }
                for (int i = 0; i < n; i++) {
                    System.err.print("  ");
                }
                String type=lexer.getVocabulary().getSymbolicName(terminalNode.getSymbol().getType());
                switch (type){
                    case "ID":
                        System.err.println(type+": "+terminalNode.getText());
                        break;
                    case "TYPE":
                        System.err.println(type+": "+terminalNode.getText());
                        break;
                    case "INT":
                        System.err.println(type+": "+(Integer.parseInt(terminalNode.getText())));
                        break;
                    case "OCC":
                        System.err.println("INT"+": "+(Integer.parseInt(terminalNode.getText().substring(1),8)));
                        break;
                    case "HEX":
                        System.err.println("INT"+": "+(Integer.parseInt(terminalNode.getText().substring(2),16)));
                        break;
                    case "FLOAT":
                        System.err.println(type+": "+(String.format("%.6f", Double.parseDouble(terminalNode.getText()))));
                        break;
                    case "EOF":
                        return;
                    default:
                        System.err.println(type);
                }
            }

            @Override
            public void visitErrorNode(ErrorNode errorNode) {

            }

            @Override
            public void enterEveryRule(ParserRuleContext parserRuleContext) {

            }

            @Override
            public void exitEveryRule(ParserRuleContext parserRuleContext) {

            }

            @Override
            public void enterProgram(CmmParser.ProgramContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("Program (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitProgram(CmmParser.ProgramContext ctx) {

            }

            @Override
            public void enterExtDef(CmmParser.ExtDefContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("ExtDef (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitExtDef(CmmParser.ExtDefContext ctx) {

            }

            @Override
            public void enterExtDecList(CmmParser.ExtDecListContext ctx) {
                if (ctx.getChildCount()!=0) {

                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("ExtDecList (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitExtDecList(CmmParser.ExtDecListContext ctx) {

            }

            @Override
            public void enterVarDec(CmmParser.VarDecContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("VarDec (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitVarDec(CmmParser.VarDecContext ctx) {

            }

            @Override
            public void enterCompSt(CmmParser.CompStContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("CompSt (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitCompSt(CmmParser.CompStContext ctx) {

            }

            @Override
            public void enterStmtList(CmmParser.StmtListContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("StmtList (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitStmtList(CmmParser.StmtListContext ctx) {

            }

            @Override
            public void enterStmt(CmmParser.StmtContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("Stmt (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitStmt(CmmParser.StmtContext ctx) {

            }

            @Override
            public void enterExp(CmmParser.ExpContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("Exp (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitExp(CmmParser.ExpContext ctx) {

            }

            @Override
            public void enterArgs(CmmParser.ArgsContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("Args (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitArgs(CmmParser.ArgsContext ctx) {

            }

            @Override
            public void enterDefList(CmmParser.DefListContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("DefList (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitDefList(CmmParser.DefListContext ctx) {

            }

            @Override
            public void enterDef(CmmParser.DefContext ctx) {
                if (ctx.getChildCount()!=0) {

                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("Def (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitDef(CmmParser.DefContext ctx) {

            }

            @Override
            public void enterDecList(CmmParser.DecListContext ctx) {
                if (ctx.getChildCount()!=0) {

                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("DecList (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitDecList(CmmParser.DecListContext ctx) {

            }

            @Override
            public void enterDec(CmmParser.DecContext ctx) {
                if (ctx.getChildCount()!=0) {

                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("Dec (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitDec(CmmParser.DecContext ctx) {

            }

            @Override
            public void enterFunDec(CmmParser.FunDecContext ctx) {
                if (ctx.getChildCount()!=0) {

                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("FunDec (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitFunDec(CmmParser.FunDecContext ctx) {

            }

            @Override
            public void enterVarList(CmmParser.VarListContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("VarList (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitVarList(CmmParser.VarListContext ctx) {

            }

            @Override
            public void enterParamDec(CmmParser.ParamDecContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("ParamDec (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitParamDec(CmmParser.ParamDecContext ctx) {

            }

            @Override
            public void enterSpecifier(CmmParser.SpecifierContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("Specifier (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitSpecifier(CmmParser.SpecifierContext ctx) {

            }

            @Override
            public void enterStructSpecifier(CmmParser.StructSpecifierContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("StructSpecifier (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitStructSpecifier(CmmParser.StructSpecifierContext ctx) {

            }
            @Override
            public void enterOptTag(CmmParser.OptTagContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("OptTag (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitOptTag(CmmParser.OptTagContext ctx) {

            }

            @Override
            public void enterTag(CmmParser.TagContext ctx) {
                if (ctx.getChildCount()!=0) {
                    for (int i = 0; i < ctx.depth() - 1; i++) {
                        System.err.print("  ");
                    }
                    System.err.println("Tag (" + ctx.getStart().getLine() + ")");
                }
            }

            @Override
            public void exitTag(CmmParser.TagContext ctx) {

            }
        };
        if (isNormal)
            walker.walk(listener, tree);
    }
}
