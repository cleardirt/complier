package L3;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.*;

public class Main {
    static boolean isNormal=true;
    static boolean varDefine=false;
    public enum Kind {
        INT,
        FLOAT,
        ARRAY,
        STRUCTURE,
        FUNCTION
    }
    public static class symbolTable{
        symbolTable next;
        String name;
        Type type;
    }


    public  static class Type{
        public boolean invalid =false;
        public boolean cal =false;
        public boolean initialization=false;
        public String name;
        public Kind type;
    }
    public static class Int extends Type {
        int num;
    }
    public static class Float extends Type {
        double num;
    }
    public static class Function extends Type {
        private Type returnType;
        private FieldList paramList;
    }
    public static class Structure extends Type {
        private boolean isVar=false;
        private String structType;
        private FieldList memberList;
    }
    public static class Array extends Type {
        private boolean inside=false;
        private int layers;
        private Type ArrayType;
        private ArrayList<Type> typeArrayList=new ArrayList<Type>();
    }
    public static class FieldList {
        private String name;
        private Type type;
        private FieldList next;
    }
    static symbolTable first = new symbolTable(); //假链表头
    static ArrayList<String> name=new ArrayList<>();
    public static String findSymbol(String VarName){
        for (String n:
             name) {
            if (n!=null&&n.equals(VarName))
                return n;
        }
        return null;
    }
    public static Type findSymbol(Type Var){
        symbolTable table=first;
        while (table.next.next!=null){
            if(table.next.name!=null) {
                if (table.next.name.equals(Var.name))
                    return table.next.type;
            }
            table=table.next;
        }
        return null;
    }

    public static FieldList findInMem(String name,FieldList mem){
        while (mem!=null&&mem.name!=null){
//            if (mem.type.type==Kind.STRUCTURE){
//                if (findInMem(name,((Structure)mem.type).memberList)!=null)
//                    return findInMem(name,((Structure)mem.type).memberList);
//            }
            if (mem.name.equals(name))
                return mem;
            mem=mem.next;
        }
        return null;
    }

    public static void deleteSymbol(String t){
        symbolTable table=first;

        for (int i = 0; i < name.size(); i++) {
            if (t.equals(name.get(i)))
                name.set(i,"");
        }
        while (table.next.next!=null){
            if (table.next.name!=null) {
                if (table.next.name.equals(t)) {
                    table.next = table.next.next;
                    return;
                }
            }
            table=table.next;
        }
    }

    public static void deleteBeginSymbol(String t){
        symbolTable table=first;

        for (int i = 0; i < name.size(); i++) {
            if (t.equals(name.get(i)))
                name.set(i,"");
        }
        while (table.next.next!=null){
            if (table.next.name!=null&&table.type!=null) {
                if (table.next.name.equals(t)&&table.next.type.type==null) {
                    table.next = table.next.next;
                    return;
                }
            }
            table=table.next;
        }
    }


    public static void deleteTempSymbol(String t){
        boolean f=true;
        symbolTable table=first;
        name.removeIf(s -> s.equals(t));
        while (table.next.next!=null){
            if (table.next.name.equals(t)&&!f) {
                table.next = table.next.next;
                return;
            }
            else if (table.next.name.equals(t))
                f=false;
            table=table.next;
        }
//        table.next.next=new symbolTable();
    }

    public static void removeError(int type,int line){
        int t_type=0,t_line = 0;
        for (String s : errList) {
            for (int i = 0; i < s.length()-4; i++) {
                if (s.substring(i,i+4).equals("type")) {
                    int n=i+5;
                    while (s.charAt(n)!=' ')
                        n++;

                    t_type = Integer.parseInt(s.substring(i + 5, n));
                }
                if (s.substring(i,i+4).equals("Line")){
                    int j=i+5;
                    while (s.charAt(j)!=':')
                        j++;
                    String test=s.substring(i + 5, j);
                    t_line=Integer.parseInt(s.substring(i+5,j));
                }
                if (t_type==type&&t_line==line) {
                    errList.remove(s);
                    return;
                }
            }
        }
    }

    public static int getLine(String s){
        int t_line = 0;
        for (int i = 0; i < s.length()-4; i++) {
        if (s.substring(i,i+4).equals("Line")){
            int j=i+5;
            while (s.charAt(j)!=':')
                j++;
            String test=s.substring(i + 5, j);
            t_line=Integer.parseInt(s.substring(i+5,j));
            return t_line;
        }
        }
        return t_line;
    }

    public static int getlayer(String s){
        int t_line = 0;
        for (int i = 0; i < s.length()-5; i++) {
            if (s.substring(i,i+5).equals("Error")){
                for (int j = 0; j < i; j++) {
                    if (s.charAt(j)=='l') {
//                        String s_line=s.substring(0), j;
                        t_line=Integer.parseInt(s.substring(0,j-1));
                        return t_line;
                    }
                }
            }
        }
        return t_line;
    }

    public static ArrayList<Type> setArrayType(ArrayList<Type> arr,Type type){
        for (Type a :
                arr) {
            if (((Array) a).typeArrayList.size() > 0)
                ((Array) a).typeArrayList=setArrayType(((Array) a).typeArrayList,type);
            ((Array) a).ArrayType=type;
        }
        return arr;
    }


    public static boolean StructEquivalence(Structure s1,Structure s2){
        FieldList s1List=s1.memberList;
        FieldList s2List= s2.memberList;

        while (s1List.type!=null&&s2List.type!=null){
            if (s1List.type.type==s2List.type.type&&s1List.type.type==Kind.ARRAY) {
                if (!ArrayEquivalence((Array) s1List.type,(Array) s2List.type))
                    return false;
            }
            else if (s1List.type.type==s2List.type.type&&s1List.type.type==Kind.STRUCTURE) {
                if (!StructEquivalence((Structure) s1List.type, (Structure) s2List.type))
                    return false;
            }
            else if (s1List.type.type!=s2List.type.type)
                return false;
            s1List=s1List.next;
            s2List=s2List.next;
        }
        boolean re=s1List.type == null && s2List.type == null;
        return re;
    }

    public static boolean ArrayEquivalence(Array a1,Array a2){
        if (a1.layers!= a2.layers)
            return false;
        return a1.ArrayType.type == a2.ArrayType.type;
    }

    public static void setSymbol(Type t){
        symbol.type=t;
        symbol.name=t.name;
        name.add(symbol.name);
        symbol.next=new symbolTable();
        symbol=symbol.next;
        symbolCount++;
    }
    public static void setSymbol_temp(Type t){
        symbol.type=t;
        symbol.name=t.name;
        symbol.next=new symbolTable();
        symbol=symbol.next;
        symbolCount++;
    }
    public static Type Specifier=new Type();
    public static String ID;
    static int INT;
    static double Float;
    static symbolTable symbol=new symbolTable(); //当前节点
    static symbolTable origenSymbol=new symbolTable();
    static int symbolCount=0; //符号数目
    static int vardecCount=0;
    static int decCount=0;
    static boolean sameName=false;//判断是否重名
    static ArrayList<String> errList=new ArrayList<>();
    static ArrayList<Integer> neglectLines=new ArrayList<>();
    static ArrayList<Type> returnTempTypeList=new ArrayList<Type>();
    static ArrayList<Integer> returnLineList=new ArrayList<Integer>();
    static ArrayList<Integer> returnLayerList=new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {

        first.next=symbol;
        ParseTreeProperty<Type> values = new ParseTreeProperty<>();
        ParseTreeProperty<ArrayList<Type>> valueList = new ParseTreeProperty<>();
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
                String type=lexer.getVocabulary().getSymbolicName(terminalNode.getSymbol().getType());
                switch (type){
                    case "ID":
                        Type t=new Type();
                        t.name=terminalNode.getText();
                        values.put(terminalNode,t);
                        break;
                    case "TYPE":
                        if (terminalNode.getText().equals("int")) {
                            Specifier=new Int();
                            Specifier.type = Kind.INT;
                        }
                        else if (terminalNode.getText().equals("float")) {
                            Specifier=new Float();
                            Specifier.type = Kind.FLOAT;
                        }
                        break;
                    case "INT":
                        Int anInt=new Int();
                        anInt.type=Kind.INT;
                        anInt.num=Integer.parseInt(terminalNode.getText());
                        values.put(terminalNode,anInt);
                        break;
                    case "FLOAT":
                        Float f=new Float();
                        f.type=Kind.FLOAT;
                        f.num=Double.parseDouble(terminalNode.getText());
                        values.put(terminalNode,f);
                        break;
                    case "EOF":
                        return;
                    default:

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

            }

            @Override
            public void exitProgram(CmmParser.ProgramContext ctx) {

            }

            @Override
            public void enterExtDefForVar(CmmParser.ExtDefForVarContext ctx) {

            }

            @Override
            public void exitExtDefForVar(CmmParser.ExtDefForVarContext ctx) {
                Type specifier=values.get(ctx.specifier());
                if (specifier!=null) {
                    for (CmmParser.VarDecContext d : ctx.extDecList().varDec()) {
                        if (!values.get(d).invalid) {
                            specifier.name = values.get(d).name;
                            if (specifier.type == Kind.INT && values.get(d).type != Kind.ARRAY) {//int类型的赋值，深拷贝的暴力方式
                                Int temp = new Int();
                                //temp.num = ((Int) values.get(d)).num; //不同的变量名   全局变量不能赋值
                                temp.name = values.get(d).name; //不同的变量名
                                temp.type = Kind.INT;
                                deleteSymbol(temp.name);
                                    setSymbol(temp);
//                                }
                            } else if (specifier.type == Kind.FLOAT && values.get(d).type != Kind.ARRAY) {
                                Float temp = new Float();
                                //temp.num = ((Float) values.get(d)).num; //不同的变量名   全局变量不能赋值
                                temp.name = values.get(d).name;
                                temp.type = Kind.FLOAT;
                                deleteSymbol(temp.name);
                                    setSymbol(temp);
//                                }
                            } else if (values.get(d).type == Kind.ARRAY) {
                                Array temp = new Array();
                                temp.layers = ((Array) values.get(d)).layers; //不同的变量名
                                temp.name = values.get(d).name;
                                temp.type = Kind.ARRAY;
                                temp.typeArrayList = ((Array) values.get(d)).typeArrayList;
                                temp.ArrayType=specifier;
                                setArrayType(temp.typeArrayList, specifier);
                                deleteSymbol(temp.name);
                                    setSymbol(temp);
//                                }
                            } else {
                                if (specifier.type!=null) {
                                    Structure temp = new Structure();
                                    temp.name = values.get(d).name;
                                    temp.type = Kind.STRUCTURE;
                                    temp.isVar = true;
                                    if (specifier.name != null)
                                        temp.structType = specifier.name;
                                    temp.memberList = ((Structure) specifier).memberList;
                                    deleteSymbol(temp.name);
                                    setSymbol(temp);
                                }
//                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void enterExtDefForStruct(CmmParser.ExtDefForStructContext ctx) {

            }

            @Override
            public void exitExtDefForStruct(CmmParser.ExtDefForStructContext ctx) {

            }

            @Override
            public void enterExtDefForFuc(CmmParser.ExtDefForFucContext ctx) {

            }

            @Override
            public void exitExtDefForFuc(CmmParser.ExtDefForFucContext ctx) {
                Function function=new Function();
                function.name=values.get(ctx.funDec()).name;
                if (findSymbol(function.name)==null) {
                    deleteSymbol(function.name);
                    function.type = Kind.FUNCTION;
                    function.returnType = values.get(ctx.specifier());
                    function.paramList = new FieldList();
                    FieldList list = new FieldList();
                    function.paramList.next = list;
                    for (Type t : valueList.get(ctx.funDec())) {
                        list.type = t;
                        list.name = list.type.name;
                        list.next = new FieldList();
                        list = list.next;
                    }
                    function.paramList=function.paramList.next;
                    //todo 结构体等价
                    boolean flag=true;
                    for (int i=0;i<returnTempTypeList.size();i++) {
                    {
                        Type returnTempType=returnTempTypeList.get(i);
                        if (returnTempType.name != null) {
                            if (returnTempType.type == Kind.ARRAY) {
                                int lay = ((Array) returnTempType).layers;
                                returnTempType = findSymbol(returnTempType);
                                if (returnTempType != null) {
                                    while (((Array) returnTempType).layers != lay)
                                        returnTempType = ((Array) returnTempType).typeArrayList.get(0);
                                } else {
                                    flag = false;
                                }
                            } else {
                                returnTempType = findSymbol(returnTempType);
                            }
                            if (flag && returnTempType != null) {
                                if (returnTempType.type != Kind.ARRAY && function.returnType.type != returnTempType.type)
                                    errList.add(returnLayerList.get(i) + ":layer" + "Error type 8 at Line " + returnLineList.get(i) + ": Type mismatched for return.");
                                else if (returnTempType.type == Kind.ARRAY) {
                                    if (((Array) returnTempType).layers != 0 || ((Array) returnTempType).ArrayType.type != function.returnType.type)
                                        errList.add(returnLayerList.get(i)+ ":layer" + "Error type 8 at Line " + returnLineList.get(i) + ": Type mismatched for return.");
                                }
                                else if (returnTempType.type==Kind.STRUCTURE){
                                    if (!StructEquivalence((Structure)returnTempType,(Structure) function.returnType))
                                        errList.add(returnLayerList.get(i)+ ":layer" + "Error type 8 at Line " + returnLineList.get(i) + ": Type mismatched for return.");
                                }
                            }
                        } else {
                            if (returnTempType.type != null && returnTempType.type != function.returnType.type)
                                errList.add(returnLayerList.get(i)+ ":layer" + "Error type 8 at Line " +returnLineList.get(i)+ ": Type mismatched for return.");
                        }
                    }
                    }

                    setSymbol(function);
                    name.add(function.name);
                }
                else {
                    deleteTempSymbol(function.name);
                    symbol=origenSymbol;
                    symbol.next=new symbolTable();
                    int line;
//                    if (ctx.compSt().stmtList().stmt()!=null&&ctx.compSt().stmtList().stmt().size()==0) {
//                        if (ctx.compSt().defList().def() != null)
//                            line = ctx.compSt().defList().def(ctx.compSt().defList().def().size() - 1).SEMI().getSymbol().getLine();
//                        else
//                            line=ctx.compSt().getStop().getLine();
//                    }
//                    else if (ctx.compSt().stmtList().stmt()!=null)
//                        line=ctx.compSt().stmtList().stmt(ctx.compSt().stmtList().stmt().size()-1).stop.getLine();
//                    else
                        line=ctx.compSt().getStop().getLine();
                    errList.add( ctx.depth()+":layer"+"Error type 4 at Line " + ctx.getStart().getLine() + ": redefine funcname \"" + function.name + "\"");
                    for (int i =ctx.getStart().getLine()+1 ; i <= line; i++) { //从后面一行到最后一行
                        neglectLines.add(i);
                    }
                }
                returnTempTypeList=new ArrayList<>();
                returnLineList=new ArrayList<>();
                returnLayerList=new ArrayList<>();
            }


            @Override
            public void enterExtDecList(CmmParser.ExtDecListContext ctx) {

            }

            @Override
            public void exitExtDecList(CmmParser.ExtDecListContext ctx) {

            }

            @Override
            public void enterVarDecNormal(CmmParser.VarDecNormalContext ctx) {

            }

            @Override
            public void exitVarDecNormal(CmmParser.VarDecNormalContext ctx) {
                Type t=new Type();
                t.name=values.get(ctx.ID()).name;
                if (findSymbol(t)==null) {
                    setSymbol(t);
                    values.put(ctx, t);
                }
                else //todo 报错变量重名
                     {
                     t.invalid =true;
                     values.put(ctx, t);
                    errList.add(ctx.depth()+":layer"+"Error type 3 at Line " + ctx.getStart().getLine() + ": redefine var \"" + t.name + "\""); }
                vardecCount++;
            }

            @Override
            public void enterVarDecForArray(CmmParser.VarDecForArrayContext ctx) {

            }

            @Override
            public void exitVarDecForArray(CmmParser.VarDecForArrayContext ctx) {
                    Array array=new Array();
                    array.type=Kind.ARRAY;
                    array.name=values.get(ctx.ID(0)).name;
                    if (ctx.ID().size()>1) {
                            errList.add(ctx.depth()+":layer:"+"Error type 12 at Line " + ctx.getStart().getLine() + ": array size must be an integer constant");
                    }//todo 确定正确行数？
                    else if (ctx.FLOAT().size()>0) {

                            errList.add(ctx.depth()+":layer:"+"Error type 12 at Line " + ctx.getStart().getLine() + ": array size must be an integer constant");
                    }
                    else{
                        if (findSymbol(array)==null) {
                            array.layers=ctx.INT().size();
                            array=setArray(array,ctx,0);
                            setSymbol(array);
                            values.put(ctx, array);
                        }
                        else //todo 报错变量重名
                        {
                            array.invalid =true;
                            values.put(ctx, array);
                            errList.add(ctx.depth()+":layer"+"Error type 3 at Line " + ctx.getStart().getLine() + ": redefine var \"" + array.name + "\"");
                        }
                    }
            }
            public Array setArray(Array array, CmmParser.VarDecForArrayContext ctx,int i){
                Array re=new Array();
                re.type=Kind.ARRAY;
                re.layers=array.layers;
                if (array.name!=null)
                    re.name= array.name;
                if (i==ctx.INT().size())
                    return re;
                Int t= (Int) values.get(ctx.INT(i));
                for (int j = 0; j < t.num; j++) {
                    Array temp=new Array();
                    temp.type=Kind.ARRAY;
                    temp.layers=re.layers-1;
                    temp.name= array.name;
                    temp.ArrayType=array.ArrayType;
                    temp=setArray(temp,ctx,i+1);
                    re.typeArrayList.add(temp);
                }
                return re;
            }
            @Override
            public void enterCompSt(CmmParser.CompStContext ctx) {

            }

            @Override
            public void exitCompSt(CmmParser.CompStContext ctx) {

            }

            @Override
            public void enterStmtList(CmmParser.StmtListContext ctx) {

            }

            @Override
            public void exitStmtList(CmmParser.StmtListContext ctx) {

            }

            @Override
            public void enterStmtexp(CmmParser.StmtexpContext ctx) {

            }

            @Override
            public void exitStmtexp(CmmParser.StmtexpContext ctx) {

            }

            @Override
            public void enterCompStStmt(CmmParser.CompStStmtContext ctx) {

            }

            @Override
            public void exitCompStStmt(CmmParser.CompStStmtContext ctx) {

            }

            @Override
            public void enterReturnStmt(CmmParser.ReturnStmtContext ctx) {

            }

            @Override
            public void exitReturnStmt(CmmParser.ReturnStmtContext ctx) {
                if (!values.get(ctx.exp()).invalid) {
                    returnTempTypeList.add(values.get(ctx.exp()));
                    returnLineList.add(ctx.getStart().getLine());
                    returnLayerList.add(ctx.depth());
                }
            }

            @Override
            public void enterIfStmt(CmmParser.IfStmtContext ctx) {

            }

            @Override
            public void exitIfStmt(CmmParser.IfStmtContext ctx) {
                Type c= values.get(ctx.exp());
                if (values.get(ctx.exp()).name!=null){
                    c=findSymbol(values.get(ctx.exp()));
                }
                if (c == null){ //找不到ID的变量
                    errList.add(ctx.depth()+":layer"+"Error type 1 at Line " + ctx.exp().getStart().getLine() + ": undefine var \"" + "\"");
                }
                else if (c.type!=Kind.ARRAY&&c.type!=Kind.INT){
                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                }
                else {
                    if (c.type==Kind.ARRAY&&((Array)c).ArrayType.type!=Kind.INT)
                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                    else if (c.type==Kind.ARRAY&&((Array)c).ArrayType.type==Kind.INT&&((Array)c).layers>0)
                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                }
                values.put(ctx,c);
            }

            @Override
            public void enterIfelseStmt(CmmParser.IfelseStmtContext ctx) {

            }

            @Override
            public void exitIfelseStmt(CmmParser.IfelseStmtContext ctx) {
                Type c= values.get(ctx.exp());
                if (values.get(ctx.exp()).name!=null){
                    c=findSymbol(values.get(ctx.exp()));
                }
                if (c == null){ //找不到ID的变量
                    errList.add(ctx.depth()+":layer"+"Error type 1 at Line " + ctx.exp().getStart().getLine() + ": undefine var \"" + "\"");
                }
                else if (c.type!=Kind.ARRAY&&c.type!=Kind.INT){
                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                }
                else {
                    if (c.type==Kind.ARRAY&&((Array)c).ArrayType.type!=Kind.INT)
                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                    else if (c.type==Kind.ARRAY&&((Array)c).ArrayType.type==Kind.INT&&((Array)c).layers>0)
                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                }
                values.put(ctx,c);
            }

            @Override
            public void enterWhileStmt(CmmParser.WhileStmtContext ctx) {

            }

            @Override
            public void exitWhileStmt(CmmParser.WhileStmtContext ctx) {
                Type c= values.get(ctx.exp());
                if (values.get(ctx.exp()).name!=null){
                    c=findSymbol(values.get(ctx.exp()));
                }
                if (c == null){ //找不到ID的变量
                    errList.add(ctx.depth()+":layer"+"Error type 1 at Line " + ctx.exp().getStart().getLine() + ": undefine var \"" + "\"");
                }
                else if (c.type!=Kind.ARRAY&&c.type!=Kind.INT){
                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                }
                else {
                    if (c.type==Kind.ARRAY&&((Array)c).ArrayType.type!=Kind.INT)
                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                    else if (c.type==Kind.ARRAY&&((Array)c).ArrayType.type==Kind.INT&&((Array)c).layers>0)
                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                }
                values.put(ctx,c);
            }


            @Override
            public void enterExpOr(CmmParser.ExpOrContext ctx) {

            }

            @Override
            public void exitExpOr(CmmParser.ExpOrContext ctx) {
                Type c= values.get(ctx.exp(0));
                if (values.get(ctx.exp(0)).name!=null){
                    if (!(c.type==Kind.ARRAY&&((Array)c).inside))
                        c=findSymbol(values.get(ctx.exp(0)));
//                    values.put(ctx.exp(0),v);
                }
                if (c == null){ //找不到ID的变量
                    errList.add(ctx.depth()+":layer"+"Error type 1 at Line " + ctx.exp(0).getStart().getLine() + ": undefine var \"" + "\"");
                }
                else if (c.type!=Kind.ARRAY&&c.type!=Kind.INT){
                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                }
                else {
                    Kind expF;
                    expF = Kind.INT;
                    if ((c.type==Kind.ARRAY&&((Array)c).layers>0&&((Array) c).ArrayType.type==Kind.INT)||c.type==Kind.INT) {
                        int lay=0;
                        for (int i = 1; i < ctx.exp().size(); i++) {
                            Type exp=values.get(ctx.exp(i));
                            c = findSymbol(exp);
                            if (c == null) { //后面有变量找不到
                                if (values.get(ctx.exp(i)).name != null) //变量名不为空
                                    errList.add(ctx.depth() + ":layer" + "Error type 1 at Line " + ctx.exp(i).getStart().getLine() + ": undefine var \"" + values.get(ctx.exp(i)).name + "\"");
                                else if (values.get(ctx.exp(i)).type!=Kind.INT){
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                }
                            }
                            else {
                                if (c.type!=Kind.ARRAY&&c.type!=Kind.INT)
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                else {
                                    if (c.type==Kind.ARRAY && (((Array)c).layers!=lay ||((Array)c).ArrayType.type!=expF)){
                                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                    }
                                }
                            }
                        }
                    }
                    else {
                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                    }
                }
                Int re=new Int();
                re.type=Kind.INT;
                values.put(ctx,re);
            }

            @Override
            public void enterExpWithFucNoParameters(CmmParser.ExpWithFucNoParametersContext ctx) {

            }

            @Override
            public void exitExpWithFucNoParameters(CmmParser.ExpWithFucNoParametersContext ctx) {
                Type func=findSymbol(values.get(ctx.ID()));
                boolean isWrong=false;
                if (func==null){ //函数为空
                    errList.add(ctx.depth()+":layer"+"Error type 2 at Line " + ctx.getStart().getLine() + ":undefined function \"" + values.get(ctx.ID()).name + "\"");
                    values.put(ctx,values.get(ctx.ID()));
                    isWrong=true;
                }
                else if (func.type!=Kind.FUNCTION) { //变量被当函数调用
                    errList.add(ctx.depth()+":layer"+"Error type 11 at Line " + ctx.getStart().getLine() + ": \"" + func.name + "\"is not a function");
                    values.put(ctx,func);
                    isWrong=true;
                }
                else if (((Function)func).paramList.next!=null)
                    errList.add(ctx.depth()+":layer"+"Error type 9 at Line " + ctx.getStart().getLine() + ": Function arguments wrong");
                if (func==null)
                    values.put(ctx,values.get(ctx.ID()));
                else if (!isWrong){
                    values.put(ctx,((Function)func).returnType);
                }
            }

            @Override
            public void enterExpNegative(CmmParser.ExpNegativeContext ctx) {

            }

            @Override
            public void exitExpNegative(CmmParser.ExpNegativeContext ctx) {
                Type re=values.get(ctx.exp());
                if (re.name!=null){
                    re=findSymbol(re);
                    if (re==null)
                        errList.add(ctx.exp().depth()+":layer"+"Error type 1 at Line "+ctx.exp().getStart().getLine()+": Undefined variable  \""+values.get(ctx.exp()).name+"\"");
                    else if (re.type==Kind.ARRAY){
                        if (!(((Array)re).layers==0&&(((Array)re).ArrayType.type==Kind.INT||((Array)re).ArrayType.type==Kind.FLOAT)))
                            errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                    }
                    else
                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                }
                values.put(ctx,re);
            }

            @Override
            public void enterExpWithArray(CmmParser.ExpWithArrayContext ctx) {

            }

            @Override
            public void exitExpWithArray(CmmParser.ExpWithArrayContext ctx) {
                Type array=values.get(ctx.exp(0));
                if (!(array.type==Kind.ARRAY&&((Array)array).inside))
                array=findSymbol(array);
                if (array==null){
                    errList.add(ctx.exp(0).depth()+":layer"+"Error type 1 at Line "+ctx.exp(0).getStart().getLine()+": Undefined variable  \""+values.get(ctx.exp(0)).name+"\"");
                    values.put(ctx,values.get(ctx.exp(0)));
                }
                else if (array.type!=Kind.ARRAY){
                    errList.add(ctx.exp(0).depth()+":layer"+"Error type 10 at Line "+ctx.exp(0).getStart().getLine()+": \""+values.get(ctx.exp(0)).name+"\" is not an array.");
                    values.put(ctx,values.get(ctx.exp(0)));
                }
                else if (values.get(ctx.exp(1)).name!=null){
                    Type find=findSymbol(values.get(ctx.exp(1)));
                    if (find==null) {
                        errList.add(ctx.depth() + ":layer" + "Error type 1 at Line " + ctx.exp(1).getStart().getLine() + ": undefine var \"" + values.get(ctx.exp(1)).name + "\"");
                        values.put(ctx, values.get(ctx.exp(0)));
                    }
                    else if (find.type!=Kind.INT) {
                        errList.add(ctx.depth() + ":layer" + "Error type 12 at Line " + ctx.exp(1).getStart().getLine() + ": not an integer.");
                        values.put(ctx, values.get(ctx.exp(0)));
                    }
                    else {
                        if (((Array)array).layers<=0) {
                            errList.add(ctx.exp(0).depth() + ":layer" + "Error type 10 at Line " + ctx.exp(0).getStart().getLine() + ": \"" + values.get(ctx.exp(0)).name + "\" is not an array.");
                            values.put(ctx,((Array)array));
                        }
                        else{
                            Array next= (Array) ((Array)array).typeArrayList.get(0);
                            next.inside=true;
                            values.put(ctx,next);
                        }
                    }
                }
                else {
                    if (values.get(ctx.exp(1)).type!=Kind.INT) {
                        errList.add(ctx.depth() + ":layer" + "Error type 12 at Line " + ctx.exp(1).getStart().getLine() + ": not an integer.");
                        values.put(ctx, values.get(ctx.exp(0)));
                    }
                    else if (((Array)array).layers<=0) {
                        errList.add(ctx.exp(0).depth() + ":layer" + "Error type 10 at Line " + ctx.exp(0).getStart().getLine() + ": \"" + values.get(ctx.exp(0)).name + "\" is not an array.");
                        values.put(ctx,((Array)array));
                    }
                    else{
                        Array next= (Array) ((Array)array).typeArrayList.get(0);
                        next.inside=true;
                        values.put(ctx,next);
                    }
                }
            }

            @Override
            public void enterExpWithStruct(CmmParser.ExpWithStructContext ctx) {

            }

            @Override
            public void exitExpWithStruct(CmmParser.ExpWithStructContext ctx) {
                Type structure= values.get(ctx.exp());
                if (!(structure.type==Kind.ARRAY&&((Array)structure).inside))
                    structure= (findSymbol(structure));
                if (structure==null){
                    errList.add(ctx.exp().depth()+":layer"+"Error type 1 at Line "+ctx.exp().getStart().getLine()+": Undefined structure \""+values.get(ctx.exp()).name+"\"");
                    values.put(ctx,values.get(ctx.exp()));
                }
                else if (structure.type==Kind.ARRAY){
                    if (((Array)structure).layers>0){
                        errList.add(ctx.exp().depth()+":layer"+"Error type 13 at Line "+ctx.getStart().getLine()+": \""+values.get(ctx.exp()).name+"\"is not a structure");
                        values.put(ctx,((Array)structure));
                    }
                    else {
                        if (((Array)structure).ArrayType.type!=Kind.STRUCTURE){
                            errList.add(ctx.exp().depth()+":layer"+"Error type 13 at Line "+ctx.getStart().getLine()+": \""+values.get(ctx.exp()).name+"\"is not a structure");
                            values.put(ctx,values.get(ctx.exp()));
                        }
                        else {
                            if (findInMem(values.get(ctx.ID()).name, ((Structure)((Array) structure).ArrayType).memberList)==null){
                                errList.add(ctx.depth()+":layer"+"Error type 14 at Line "+ctx.getStart().getLine()+": Non-existent field \""+values.get(ctx.ID()).name+"\"");
                                values.put(ctx,values.get(ctx.exp()));
                            }
                            else if (findInMem(values.get(ctx.ID()).name, ((Structure)((Array) structure).ArrayType).memberList)!=null){
                                Type stru=findInMem(values.get(ctx.ID()).name, ((Structure)((Array) structure).ArrayType).memberList).type;
                                values.put(ctx,findInMem(values.get(ctx.ID()).name, ((Structure)((Array) structure).ArrayType).memberList).type);
                            }
                        }
                    }

                }
                else if (structure.type!=Kind.STRUCTURE){
                    errList.add(ctx.exp().depth()+":layer"+"Error type 13 at Line "+ctx.getStart().getLine()+": \""+values.get(ctx.exp()).name+"\"is not a structure");
                    values.put(ctx,values.get(ctx.exp()));
                }
                else if (findInMem(values.get(ctx.ID()).name, ((Structure) structure).memberList)==null){
                    errList.add(ctx.depth()+":layer"+"Error type 14 at Line "+ctx.getStart().getLine()+": Non-existent field \""+values.get(ctx.ID()).name+"\"");
                    values.put(ctx,values.get(ctx.exp()));
                }
                else if (findInMem(values.get(ctx.ID()).name, ((Structure) structure).memberList)!=null){
                    Type id=values.get(ctx.ID());
                    Type re=findInMem(values.get(ctx.ID()).name, ((Structure) structure).memberList).type;
                    values.put(ctx,findInMem(values.get(ctx.ID()).name, ((Structure) structure).memberList).type);
                }
            }

            @Override
            public void enterExpAssign(CmmParser.ExpAssignContext ctx) {

            }

            @Override
            public void exitExpAssign(CmmParser.ExpAssignContext ctx) {
                Type tempName=values.get(ctx.exp(0));
                Type tempName2=values.get(ctx.exp(1));
                Type c=tempName;
                if (tempName.name!=null){
                    if (!(tempName.type==Kind.ARRAY&&((Array)tempName).inside))
                        c=findSymbol(values.get(ctx.exp(0)));
                }
                if (tempName.name==null&&tempName.type!=Kind.ARRAY){ //左值不是ID
                        errList.add(ctx.depth()+":layer"+"Error type 6 at Line " + ctx.getStart().getLine() + ":The left-hand side of an assignment must be a variable.");
                }
                else if (c == null||  (c.type==Kind.STRUCTURE && !((Structure)c).isVar)){ //找不到ID的变量
                        errList.add(ctx.depth()+":layer"+"Error type 1 at Line " + ctx.exp(0).getStart().getLine() + ": undefine var \"" + tempName.name + "\"");
                }
                else if (c.type == Kind.FUNCTION){ //找到了，但是是函数
                        errList.add(ctx.depth()+":layer"+"Error type 6 at Line " + ctx.getStart().getLine() + ":The left-hand side of an assignment must be a variable.");
                }
                else {
                Kind expF;
                expF = c.type;
                if (c.type==Kind.ARRAY&&((Array)c).layers>0) {
                    int lay=((Array) c).layers;
                    expF = ((Array) c).ArrayType.type;
                    for (int i = 1; i < ctx.exp().size(); i++) {
                        Type exp=values.get(ctx.exp(i));
                        Type find;
                        if (!(exp.type==Kind.ARRAY&&((Array)exp).inside))
                            find=findSymbol(exp);
                        else
                            find=exp;
                        if (find == null) { //后面有变量找不到
                            if (values.get(ctx.exp(i)).name != null) //变量名不为空
                                errList.add(ctx.depth() + ":layer" + "Error type 1 at Line " + ctx.exp(i).getStart().getLine() + ": undefine var \"" + values.get(ctx.exp(i)).name + "\"");
                            else {
                                    errList.add(ctx.depth() + ":layer" + "Error type 5 at Line " + ctx.getStart().getLine() + ": different type in ASSIGNOP two sides");
                            }
                        }
                        else {
                            if (find.type!=Kind.ARRAY)
                                errList.add(ctx.depth() + ":layer" + "Error type 5 at Line " + ctx.getStart().getLine() + ": different type in ASSIGNOP two sides");
                            else {
                                if (((Array)find).layers!=lay||((Array)find).ArrayType.type!=expF){
                                    errList.add(ctx.depth() + ":layer" + "Error type 5 at Line " + ctx.getStart().getLine() + ": different type in ASSIGNOP two sides");
                                }
                            }
                        }
                    }
                }
                else if (c.type!=Kind.STRUCTURE){
                    if (c.type==Kind.ARRAY)
                        expF = ((Array) c).ArrayType.type;
                    for (int i = 1; i < ctx.exp().size(); i++) {
                        Type exp=values.get(ctx.exp(i));
                        Type find;
                        if (!(exp.type==Kind.ARRAY&&((Array)exp).inside))
                            find=findSymbol(exp);
                        else
                            find=exp;
                            if (find == null) { //后面有变量找不到
                                if (values.get(ctx.exp(i)).name != null) //变量名不为空
                                    errList.add(ctx.depth() + ":layer" + "Error type 1 at Line " + ctx.exp(i).getStart().getLine() + ": undefine var \"" + values.get(ctx.exp(i)).name + "\"");
                                else {
                                    if (expF != values.get(ctx.exp(i)).type) { //直接数字
                                        errList.add(ctx.depth() + ":layer" + "Error type 5 at Line " + ctx.getStart().getLine() + ": different type in ASSIGNOP two sides");
                                    }
                                }
                            }
                            else if (find.type!=Kind.ARRAY&&expF != find.type && values.get(ctx.exp(i)).name != null) { //变量类型和第一个不一样
                                errList.add(ctx.depth() + ":layer" + "Error type 5 at Line " + ctx.getStart().getLine() + ": different type in ASSIGNOP two sides");
                            }
                            else if (find.type==Kind.ARRAY){
                                if (((Array)find).layers>0) //数组层数不是0（因为左值一定是基本数据类型）
                                    errList.add(ctx.depth() + ":layer" + "Error type 5 at Line " + ctx.getStart().getLine() + ": different type in ASSIGNOP two sides");
                                else if (((Array)find).ArrayType.type!=expF) //数组类型和第一个不一致
                                    errList.add(ctx.depth() + ":layer" + "Error type 5 at Line " + ctx.getStart().getLine() + ": different type in ASSIGNOP two sides");
                            }
                    }
                    }
                else { //结构体
                    for (int i = 1; i < ctx.exp().size(); i++) {
                        Type exp=values.get(ctx.exp(i));
                        Type find = findSymbol(exp);
                        if(find==null){
                            if (values.get(ctx.exp(i)).name != null) //变量名不为空
                                errList.add(ctx.depth() + ":layer" + "Error type 1 at Line " + ctx.exp(i).getStart().getLine() + ": undefine var \"" + values.get(ctx.exp(i)).name + "\"");
                            else { //数字
                                errList.add(ctx.depth() + ":layer" + "Error type 5 at Line " + ctx.getStart().getLine() + ": different type in ASSIGNOP two sides");
                            }
                        }
                        else if (find.type!=Kind.STRUCTURE||!((Structure)find).isVar){ //不是结构体变量
                            errList.add(ctx.depth() + ":layer" + "Error type 5 at Line " + ctx.getStart().getLine() + ": different type in ASSIGNOP two sides");
                        }
                        else {
                            if (!StructEquivalence((Structure) c,(Structure) find))
                                errList.add(ctx.depth() + ":layer" + "Error type 5 at Line " + ctx.getStart().getLine() + ": different type in ASSIGNOP two sides");
                        }
                    }
                }
                }
                values.put(ctx,c);
            }

            @Override
            public void enterExpFloat(CmmParser.ExpFloatContext ctx) {

            }

            @Override
            public void exitExpFloat(CmmParser.ExpFloatContext ctx) {
                values.put(ctx,values.get(ctx.FLOAT()));
            }

            @Override
            public void enterExpAnd(CmmParser.ExpAndContext ctx) {

            }

            @Override
            public void exitExpAnd(CmmParser.ExpAndContext ctx) {
                Type c= values.get(ctx.exp(0));
                if (values.get(ctx.exp(0)).name!=null){
                    if (!(c.type==Kind.ARRAY&&((Array)c).inside))
                        c=findSymbol(values.get(ctx.exp(0)));
//                    values.put(ctx.exp(0),v);
                }
                if (c == null){ //找不到ID的变量
                    errList.add(ctx.depth()+":layer"+"Error type 1 at Line " + ctx.exp(0).getStart().getLine() + ": undefine var \"" + "\"");
                }
                else if (c.type!=Kind.ARRAY&&c.type!=Kind.INT){
                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                }
                else {
                    Kind expF;
                    expF = Kind.INT;
                    if ((c.type==Kind.ARRAY&&((Array)c).layers>0&&((Array) c).ArrayType.type==Kind.INT)||c.type==Kind.INT) {
                        int lay=0;
                        for (int i = 1; i < ctx.exp().size(); i++) {
                            Type exp=values.get(ctx.exp(i));
                            c = findSymbol(exp);
                            if (c == null) { //后面有变量找不到
                                if (values.get(ctx.exp(i)).name != null) //变量名不为空
                                    errList.add(ctx.depth() + ":layer" + "Error type 1 at Line " + ctx.exp(i).getStart().getLine() + ": undefine var \"" + values.get(ctx.exp(i)).name + "\"");
                                else if (values.get(ctx.exp(i)).type!=Kind.INT){
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                }
                            }
                            else {
                                if (c.type!=Kind.ARRAY&&c.type!=Kind.INT)
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                else {
                                    if (c.type==Kind.ARRAY && (((Array)c).layers!=lay ||((Array)c).ArrayType.type!=expF)){
                                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                    }
                                }
                            }
                        }
                    }
                    else {
                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                    }
                }
                Int re=new Int();
                re.type=Kind.INT;
                values.put(ctx,re);
            }

            @Override
            public void enterExpDivOrStar(CmmParser.ExpDivOrStarContext ctx) {

            }

            @Override
            public void exitExpDivOrStar(CmmParser.ExpDivOrStarContext ctx) {
                Type c= values.get(ctx.exp(0));
                if (values.get(ctx.exp(0)).name!=null){
                    if (!(c.type==Kind.ARRAY&&((Array)c).inside))
                        c=findSymbol(values.get(ctx.exp(0)));
                }
                if (c == null){ //找不到ID的变量
                    errList.add(ctx.depth()+":layer"+"Error type 1 at Line " + ctx.exp(0).getStart().getLine() + ": undefine var \"" + "\"");
                }

                else {
                    Kind expF;
                    expF = c.type;
                    if (c.type==Kind.ARRAY&&((Array)c).layers>0) {
                        int lay=((Array) c).layers;
                        expF = ((Array) c).ArrayType.type;
                        for (int i = 1; i < ctx.exp().size(); i++) {
                            Type exp=values.get(ctx.exp(i));
                            Type find;
                            if (!(exp.type==Kind.ARRAY&&((Array)exp).inside))
                                find=findSymbol(exp);
                            else
                                find=exp;
                            if (find == null) { //后面有变量找不到
                                if (values.get(ctx.exp(i)).name != null) //变量名不为空
                                    errList.add(ctx.depth() + ":layer" + "Error type 1 at Line " + ctx.exp(i).getStart().getLine() + ": undefine var \"" + values.get(ctx.exp(i)).name + "\"");
                                else {
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                }
                            }
                            else {
                                if (find.type!=Kind.ARRAY)
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                else {
                                    if (((Array)find).layers!=lay||((Array)find).ArrayType.type!=expF){
                                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                    }
                                }
                            }
                        }
                    }
                    else {
                        if (c.type==Kind.ARRAY)
                            expF = ((Array) c).ArrayType.type;
                        for (int i = 1; i < ctx.exp().size(); i++) {
                            Type exp=values.get(ctx.exp(i));
                            Type find;
                            if (!(exp.type==Kind.ARRAY&&((Array)exp).inside))
                                find=findSymbol(exp);
                            else
                                find=exp;
                            if (find == null) { //后面有变量找不到
                                if (values.get(ctx.exp(i)).name != null) //变量名不为空
                                    errList.add(ctx.depth() + ":layer" + "Error type 1 at Line " + ctx.exp(i).getStart().getLine() + ": undefine var \"" + values.get(ctx.exp(i)).name + "\"");
                                else {
                                    if (expF != values.get(ctx.exp(i)).type) { //直接数字
                                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                    }
                                }
                            }
                            else if (find.type==Kind.FUNCTION){
                                if (((Function)find).returnType.type!=expF)
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                            }
                            else if (find.type!=Kind.ARRAY&&expF != find.type && values.get(ctx.exp(i)).name != null) { //变量类型和第一个不一样
                                errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                            }
                            else if (find.type==Kind.ARRAY){
                                if (((Array)find).layers>0) //数组层数不是0（因为左值一定是基本数据类型）
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                else if (((Array)find).ArrayType.type!=expF) //数组类型和第一个不一致
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                            }
                        }
                    }
                }
                if (c==null) {
                    c= values.get(ctx.exp(0));
                    c.cal=true;
                    values.put(ctx, c);
                }
                else {
                    c.cal=true;
                    values.put(ctx, c);
                }
            }

            @Override
            public void enterExpCompare(CmmParser.ExpCompareContext ctx) {

            }

            @Override
            public void exitExpCompare(CmmParser.ExpCompareContext ctx) {
                Type c= values.get(ctx.exp(0));
                if (values.get(ctx.exp(0)).name!=null){
                    if (!(c.type==Kind.ARRAY&&((Array)c).inside))
                        c=findSymbol(values.get(ctx.exp(0)));
//                    values.put(ctx.exp(0),v);
                }
                if (c == null){ //找不到ID的变量
                    errList.add(ctx.depth()+":layer"+"Error type 1 at Line " + ctx.exp(0).getStart().getLine() + ": undefine var \"" + "\"");
                }
                else {
                    Kind expF;
                    expF = c.type;
                    if (c.type==Kind.ARRAY&&((Array)c).layers>0) {
                        int lay=((Array) c).layers;
                        expF = ((Array) c).ArrayType.type;
                        for (int i = 1; i < ctx.exp().size(); i++) {
                            Type exp=values.get(ctx.exp(i));
                            Type find = findSymbol(exp);
                            if (find == null) { //后面有变量找不到
                                if (values.get(ctx.exp(i)).name != null) //变量名不为空
                                    errList.add(ctx.depth() + ":layer" + "Error type 1 at Line " + ctx.exp(i).getStart().getLine() + ": undefine var \"" + values.get(ctx.exp(i)).name + "\"");
                                else {
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                }
                            }
                            else {
                                if (find.type!=Kind.ARRAY)
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                else {
                                    if (((Array)find).layers!=lay||((Array)find).ArrayType.type!=expF){
                                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                    }
                                }
                            }
                        }
                    }
                    else {
                        if (c.type==Kind.ARRAY)
                            expF = ((Array) c).ArrayType.type;
                        for (int i = 1; i < ctx.exp().size(); i++) {
                            Type exp=values.get(ctx.exp(i));
                            Type find=findSymbol(exp);
                            if (find == null) { //后面有变量找不到
                                if (values.get(ctx.exp(i)).name != null) //变量名不为空
                                    errList.add(ctx.depth() + ":layer" + "Error type 1 at Line " + ctx.exp(i).getStart().getLine() + ": undefine var \"" + values.get(ctx.exp(i)).name + "\"");
                                else {
                                    if (expF != values.get(ctx.exp(i)).type) { //直接数字
                                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                    }
                                }
                            }
                            else if (find.type==Kind.FUNCTION){
                                if (((Function)find).returnType.type!=expF)
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                            }
                            else if (find.type!=Kind.ARRAY&&expF != find.type && values.get(ctx.exp(i)).name != null) { //变量类型和第一个不一样
                                errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                            }
                            else if (find.type==Kind.ARRAY){
                                if (((Array)find).layers>0) //数组层数不是0（因为左值一定是基本数据类型）
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                else if (((Array)find).ArrayType.type!=expF) //数组类型和第一个不一致
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                            }
                        }
                    }
                }
                Int re=new Int();
                re.type=Kind.INT;
                values.put(ctx,re);
            }

            @Override
            public void enterExpInt(CmmParser.ExpIntContext ctx) {

            }

            @Override
            public void exitExpInt(CmmParser.ExpIntContext ctx) {
                values.put(ctx,values.get(ctx.INT()));
            }

            @Override
            public void enterExpWithFuc(CmmParser.ExpWithFucContext ctx) {

            }

            @Override
            public void exitExpWithFuc(CmmParser.ExpWithFucContext ctx) {
                Type func=findSymbol(values.get(ctx.ID()));
                boolean isWrong=false;
                if (func==null){ //函数为空
                    errList.add(ctx.depth()+":layer"+"Error type 2 at Line " + ctx.getStart().getLine() + ":undefined function \"" + values.get(ctx.ID()).name + "\"");
                    isWrong=true;
                }
                else if (func.type!=Kind.FUNCTION) { //变量被当函数调用
                    errList.add(ctx.depth()+":layer"+"Error type 11 at Line " + ctx.getStart().getLine() + ": \"" + func.name + "\"is not a function");
                    isWrong=true;
                    values.put(ctx,func);
                }
                else {
                    FieldList param = ((Function)func).paramList;
                    boolean flag=true;//发现有错的就退出
                    for (int i = 0; i < ctx.args().exp().size()&&flag; i++) { //就当先报错变量未定义吧
                        Type exp=values.get(ctx.args().exp(i));
                        Type find=findSymbol(exp);
                        if(exp.name!=null){
                            if (find==null){ //变量找不到
                                errList.add(ctx.args().exp(i).depth()+":layer"+"Error type 1 at Line " + ctx.args().exp(i).getStart().getLine() + ": undefine var \"" + values.get(ctx.args().exp(i)).name + "\"");
                                flag=false;
                            }
                            else if (param.type==null){ //参数多了
                                errList.add(ctx.args().exp(i).depth()+":layer"+"Error type 9 at Line " + ctx.args().exp(i).getStart().getLine() + ": Function arguments wrong");
                                flag=false;
                            }
                            else if (find.type!=param.type.type&&param.type.type!=Kind.STRUCTURE){ //参数类型不一致
                                errList.add(ctx.args().exp(i).depth()+":layer"+"Error type 9 at Line " + ctx.args().exp(i).getStart().getLine() + ": Function arguments wrong");
                                flag=false;
                            }
                            else if (param.type.type==Kind.STRUCTURE){
                                if (find.type!=Kind.STRUCTURE) {
                                    errList.add(ctx.args().exp(i).depth()+":layer"+"Error type 9 at Line " + ctx.args().exp(i).getStart().getLine() + ": Function arguments wrong");
                                    flag=false;
                                }
                                else if (!StructEquivalence((Structure)find,(Structure) param.type)){
                                    errList.add(ctx.args().exp(i).depth()+":layer"+"Error type 9 at Line " + ctx.args().exp(i).getStart().getLine() + ": Function arguments wrong");
                                    flag=false;
                                }
                            }
                        }
                        else{
                            if (param.type==null){ //参数多了(直接用数字的情况)
                                errList.add(ctx.args().exp(i).depth()+":layer"+"Error type 9 at Line " + ctx.args().exp(i).getStart().getLine() + ": Function arguments wrong");
                                flag=false;
                            }
                            else if (exp.type!=param.type.type){ //参数类型不一致(直接用数字的情况)
                                errList.add(ctx.args().exp(i).depth()+":layer"+"Error type 9 at Line " + ctx.args().exp(i).getStart().getLine() + ": Function arguments wrong");
                                flag=false;
                            }

                        }
                        param=param.next;

                    }
                    if (flag&&param.type!=null){ //参数少了
                        errList.add(ctx.args().depth()+":layer"+"Error type 9 at Line " + ctx.args().getStart().getLine() + ": Function arguments wrong");
                    }
                }
                if (func==null)
                    values.put(ctx,values.get(ctx.ID()));
                else if (!isWrong){
                    values.put(ctx,((Function)func).returnType);
                }
            }

            @Override
            public void enterExpPlusOrMinus(CmmParser.ExpPlusOrMinusContext ctx) {

            }

            @Override
            public void exitExpPlusOrMinus(CmmParser.ExpPlusOrMinusContext ctx) {
                Type c= values.get(ctx.exp(0));
                if (values.get(ctx.exp(0)).name!=null){
                    if (!(c.type==Kind.ARRAY&&((Array)c).inside))
                        c=findSymbol(values.get(ctx.exp(0)));
                }
                if (c == null){ //找不到ID的变量
                    errList.add(ctx.depth()+":layer"+"Error type 1 at Line " + ctx.exp(0).getStart().getLine() + ": undefine var \"" + "\"");
                }

                else {
                    Kind expF;
                    expF = c.type;
                    if (c.type==Kind.ARRAY&&((Array)c).layers>0) {
                        int lay=((Array) c).layers;
                        expF = ((Array) c).ArrayType.type;
                        for (int i = 1; i < ctx.exp().size(); i++) {
                            Type exp=values.get(ctx.exp(i));
                            Type find;
                            if (!(exp.type==Kind.ARRAY&&((Array)exp).inside))
                                find=findSymbol(exp);
                            else
                                find=exp;
                            if (find == null) { //后面有变量找不到
                                if (values.get(ctx.exp(i)).name != null) //变量名不为空
                                    errList.add(ctx.depth() + ":layer" + "Error type 1 at Line " + ctx.exp(i).getStart().getLine() + ": undefine var \"" + values.get(ctx.exp(i)).name + "\"");
                                else {
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                }
                            }
                            else {
                                if (find.type!=Kind.ARRAY)
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                else {
                                    if (((Array)find).layers!=lay||((Array)find).ArrayType.type!=expF){
                                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                    }
                                }
                            }
                        }
                    }
                    else {
                        if (c.type==Kind.ARRAY)
                            expF = ((Array) c).ArrayType.type;
                        for (int i = 1; i < ctx.exp().size(); i++) {
                            Type exp=values.get(ctx.exp(i));
                            Type find;
                            if (!(exp.type==Kind.ARRAY&&((Array)exp).inside))
                                find=findSymbol(exp);
                            else
                                find=exp;
                            if (find == null) { //后面有变量找不到
                                if (values.get(ctx.exp(i)).name != null) //变量名不为空
                                    errList.add(ctx.depth() + ":layer" + "Error type 1 at Line " + ctx.exp(i).getStart().getLine() + ": undefine var \"" + values.get(ctx.exp(i)).name + "\"");
                                else {
                                    if (expF != values.get(ctx.exp(i)).type) { //直接数字
                                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                    }
                                }
                            }
                            else if (find.type==Kind.FUNCTION){
                                if (((Function)find).returnType.type!=expF)
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                            }
                            else if (find.type!=Kind.ARRAY&&expF != find.type && values.get(ctx.exp(i)).name != null) { //变量类型和第一个不一样
                                errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                            }
                            else if (find.type==Kind.ARRAY){
                                if (((Array)find).layers>0) //数组层数不是0（因为左值一定是基本数据类型）
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                                else if (((Array)find).ArrayType.type!=expF) //数组类型和第一个不一致
                                    errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                            }
                        }
                    }
                }
                if (c==null) {
                    c= values.get(ctx.exp(0));
                    c.cal=true;
                    values.put(ctx, c);
                }
                else {
                    c.cal=true;
                    values.put(ctx, c);
                }
            }

            @Override
            public void enterExpNegate(CmmParser.ExpNegateContext ctx) {

            }

            @Override
            public void exitExpNegate(CmmParser.ExpNegateContext ctx) {
                Type re=values.get(ctx.exp());
                if (re.name!=null){
                    re=findSymbol(re);
                    if (re==null)
                        errList.add(ctx.exp().depth()+":layer"+"Error type 1 at Line "+ctx.exp().getStart().getLine()+": Undefined variable  \""+values.get(ctx.exp()).name+"\"");
                    else if (re.type==Kind.ARRAY){
                        if (!(((Array)re).layers==0&&(((Array)re).ArrayType.type==Kind.INT||((Array)re).ArrayType.type==Kind.FLOAT)))
                            errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                    }
                    else
                        errList.add(ctx.depth() + ":layer" + "Error type 7 at Line " + ctx.getStart().getLine() + ":Type mismatched for operands.");
                }
                values.put(ctx,re);
            }

            @Override
            public void enterExpBrackets(CmmParser.ExpBracketsContext ctx) {

            }

            @Override
            public void exitExpBrackets(CmmParser.ExpBracketsContext ctx) {
                values.put(ctx,values.get(ctx.exp()));
            }

            @Override
            public void enterExpId(CmmParser.ExpIdContext ctx) {

            }

            @Override
            public void exitExpId(CmmParser.ExpIdContext ctx) {
                Type e=values.get(ctx.ID());
                values.put(ctx,values.get(ctx.ID()));
            }


            @Override
            public void enterArgs(CmmParser.ArgsContext ctx) {

            }

            @Override
            public void exitArgs(CmmParser.ArgsContext ctx) {
            }

            @Override
            public void enterDefList(CmmParser.DefListContext ctx) {

            }

            @Override
            public void exitDefList(CmmParser.DefListContext ctx) {
                origenSymbol=symbol;
                Structure structure=new Structure();
                structure.memberList=new FieldList();
                FieldList fieldList=new FieldList();
                structure.memberList.next=fieldList;
                for (CmmParser.DefContext def:
                        ctx.def()) {
                    for (CmmParser.DecContext dec :
                            def.decList().dec()) {
                        Type e=values.get(dec);
                        if (!e.invalid&&!e.initialization) {
                            fieldList.type = values.get(dec);
                            fieldList.name = values.get(dec).name;
                            fieldList.next = new FieldList();
                            deleteSymbol(fieldList.type.name);
                            setSymbol(fieldList.type);
                            fieldList = fieldList.next;
                        }
                    }
                }
                structure.type=Kind.STRUCTURE;
                structure.memberList=structure.memberList.next;
            }

            @Override
            public void enterDef(CmmParser.DefContext ctx) {

            }

            @Override
            public void exitDef(CmmParser.DefContext ctx) {
                Type specifier=values.get(ctx.specifier());
                ArrayList<Type> decs = new ArrayList<Type>();
                for (CmmParser.DecContext d :ctx.decList().dec()) {
//                    Type temp = new Type();
                    if (specifier==null) {
                        Type invalid=values.get(d);
                        deleteSymbol(invalid.name);
                        invalid.invalid =true;
                        values.put(d,invalid);
                    }
                    if (!values.get(d).invalid &&specifier!=null) {
                        if (specifier.type == Kind.INT && values.get(d).type != Kind.ARRAY) {//int类型的赋值，深拷贝的暴力方式
                            Int temp = new Int();
//                        temp.num = ((Int) values.get(d)).num; //不同的变量名
                            temp.name = values.get(d).name; //不同的变量名
                            temp.type = Kind.INT;
                            temp.invalid = values.get(d).invalid;
                            temp.initialization=values.get(d).initialization;

                            if (values.get(d).type != null && specifier.type != values.get(d).type) {
                                errList.add(d.depth()+":layer"+"Error type 5 at Line " + d.getStart().getLine() + ": Type mismatched for assignment.");
                            }
                            deleteBeginSymbol(temp.name);
                            setSymbol(temp);
                            values.put(d, temp);
                            decs.add(temp);

                        } else if (specifier.type == Kind.FLOAT && values.get(d).type != Kind.ARRAY) {
                            Float temp = new Float();
//                        temp.num = ((Float) values.get(d)).num; //不同的变量名
                            temp.name = values.get(d).name;
                            temp.type = Kind.FLOAT;
                            temp.invalid = values.get(d).invalid;
                            temp.initialization=values.get(d).initialization;

                                //name.add(temp.name);
                            if (values.get(d).type != null && specifier.type != values.get(d).type) {

                                    errList.add(d.depth()+":layer"+"Error type 5 at Line " + d.getStart().getLine() + ": Type mismatched for assignment.");
                            }
                            deleteBeginSymbol(temp.name);
                            setSymbol(temp);
                            values.put(d, temp);
                            decs.add(temp);

                        } else if (values.get(d).type == Kind.ARRAY) {
                            Array temp = new Array();
                            temp.name = values.get(d).name;
                            temp.typeArrayList = ((Array) values.get(d)).typeArrayList;
                            temp.ArrayType=specifier;
                            temp.initialization=values.get(d).initialization;
                            Array setType=temp;
                            while (setType.typeArrayList.size()>0){
                                ((Array)setType.typeArrayList.get(0)).ArrayType=specifier;
                                setType=(Array)setType.typeArrayList.get(0);
                            }
                            setType.ArrayType=specifier;
                            temp.type = Kind.ARRAY;
                            temp.layers = ((Array) values.get(d)).layers;
                            temp.invalid = values.get(d).invalid;
                                //name.add(temp.name);

                            if (values.get(d).type != null && values.get(d).type != Kind.ARRAY && specifier.type != values.get(d).type) {
                                    errList.add(d.depth()+":layer"+"Error type 5 at Line " + d.getStart().getLine() + ": Type mismatched for assignment.");
                            }
                            deleteBeginSymbol(temp.name);
                            setSymbol(temp);
                            values.put(d, temp);
                            decs.add(temp);

                        } else {
                            if (specifier.type!=null) {
                                Structure temp = new Structure();
                                temp.name = values.get(d).name;
                                temp.type = Kind.STRUCTURE;
                                temp.isVar = true;
                                if (specifier.name != null)
                                    temp.structType = specifier.name;
                                temp.memberList = ((Structure) specifier).memberList;
                                deleteBeginSymbol(temp.name);
                                setSymbol(temp);
                                values.put(d, temp);
                                decs.add(temp);
                            }
                        }
                    }

                }
                valueList.put(ctx,decs);
            }

            @Override
            public void enterDecList(CmmParser.DecListContext ctx) {

            }

            @Override
            public void exitDecList(CmmParser.DecListContext ctx) {

            }

            @Override
            public void enterDecWithInit(CmmParser.DecWithInitContext ctx) {

            }

            @Override
            public void exitDecWithInit(CmmParser.DecWithInitContext ctx) {
                Type t=values.get(ctx.exp());
                t.name=values.get(ctx.varDec()).name;
                t.initialization =true;
                values.put(ctx, t);
            }

            @Override
            public void enterDecWithoutInit(CmmParser.DecWithoutInitContext ctx) {

            }

            @Override
            public void exitDecWithoutInit(CmmParser.DecWithoutInitContext ctx) {
                values.put(ctx, values.get(ctx.varDec()));
            }


            @Override
            public void enterFunDecWithVar(CmmParser.FunDecWithVarContext ctx) {

            }

            @Override
            public void exitFunDecWithVar(CmmParser.FunDecWithVarContext ctx) {
                Function function=new Function();
                function.returnType=values.get(ctx.parent.getChild(0));
                function.type=Kind.FUNCTION;
                function.name=values.get(ctx.ID()).name;
                FieldList list = new FieldList();
                function.paramList=new FieldList();
                function.paramList.next = list;
                for (Type t : valueList.get(ctx.varList())) {
                    list.type = t;
                    list.name = list.type.name;
                    list.next = new FieldList();
                    list = list.next;
                }
                function.paramList=function.paramList.next;
                setSymbol_temp(function);
                valueList.put(ctx,valueList.get(ctx.varList()));
                values.put(ctx,values.get(ctx.ID()));
            }

            @Override
            public void enterFunDecWithoutVar(CmmParser.FunDecWithoutVarContext ctx) {

            }

            @Override
            public void exitFunDecWithoutVar(CmmParser.FunDecWithoutVarContext ctx) {
                Function function=new Function();
                function.returnType=values.get(ctx.parent.getChild(0));
                function.type=Kind.FUNCTION;
                function.name=values.get(ctx.ID()).name;
                function.paramList=new FieldList();
                setSymbol_temp(function);
                valueList.put(ctx,new ArrayList<Type>());
                values.put(ctx,values.get(ctx.ID()));
            }


            @Override
            public void enterVarList(CmmParser.VarListContext ctx) {

            }

            @Override
            public void exitVarList(CmmParser.VarListContext ctx) {
                ArrayList<Type> arrayList=new ArrayList<>();
                for (CmmParser.ParamDecContext p:
                ctx.paramDec()){
                    if (values.get(p)!=null)
                    arrayList.add(values.get(p));
                }
                valueList.put(ctx,arrayList);
            }

            @Override
            public void enterParamDec(CmmParser.ParamDecContext ctx) {

            }

            @Override
            public void exitParamDec(CmmParser.ParamDecContext ctx) {
                Type t=values.get(ctx.specifier());
                t.name=values.get(ctx.varDec()).name;
                t.invalid=values.get(ctx.varDec()).invalid;
//                if (findSymbol(t.name)==null) {
                if (!t.invalid&&t.type!=null) {
                    deleteSymbol(t.name);
                    values.put(ctx, t);
                    name.add(t.name);
                    setSymbol(t);
                }
            }

            @Override
            public void enterSpecifierForVar(CmmParser.SpecifierForVarContext ctx) {

            }

            @Override
            public void exitSpecifierForVar(CmmParser.SpecifierForVarContext ctx) {
                values.put(ctx, Specifier);
            }

            @Override
            public void enterSpecifierForStruct(CmmParser.SpecifierForStructContext ctx) {

            }

            @Override
            public void exitSpecifierForStruct(CmmParser.SpecifierForStructContext ctx) {
                values.put(ctx, values.get(ctx.structSpecifier()));
            }

            @Override
            public void enterStruct(CmmParser.StructContext ctx) {

            }

            @Override
            public void exitStruct(CmmParser.StructContext ctx) {
//                symbol=origenSymbol;
                Structure structure=new Structure();
                structure.memberList=new FieldList();
                FieldList fieldList=new FieldList();
                structure.memberList.next=fieldList;

                structure.type=Kind.STRUCTURE;
                structure.memberList=structure.memberList.next;
                values.put(ctx,structure);
                structure.name=values.get(ctx.optTag()).name;
                if (!sameName) {
                    for (CmmParser.DefContext def:
                            ctx.defList().def()) {
                        for (CmmParser.DecContext dec :
                                def.decList().dec()) {
                            Type e=values.get(dec);
                            if (e!=null) {
                                if (values.get(dec).invalid||values.get(dec).initialization) {
                                    removeError(3,dec.getStart().getLine());
                                    errList.add(dec.depth()+":layer"+"Error type 15 at Line " + dec.getStart().getLine() + ": initialization in a struct ");
//
                                } else {
                                    deleteSymbol(values.get(dec).name);
                                    fieldList.type = values.get(dec);
                                    fieldList.name = values.get(dec).name;
                                    fieldList.next = new FieldList();
                                    setSymbol(fieldList.type);
                                    fieldList = fieldList.next;
                                }
                            }
                        }
                    }
                    name.add(structure.name);
                    setSymbol(structure);
                    values.put(ctx, structure);
                }
                else {
                    for (CmmParser.DefContext def:
                            ctx.defList().def()) {
                        for (CmmParser.DecContext dec :
                                def.decList().dec()) {
                            Type e=values.get(dec);
                            if (e!=null) {
                                if (values.get(dec).invalid||values.get(dec).initialization) {
                                    removeError(3,dec.getStart().getLine());
                                    errList.add(dec.depth()+":layer"+"Error type 15 at Line " + dec.getStart().getLine() + ": initialization in a struct ");
//
                                } else {
                                    deleteSymbol(values.get(dec).name);
                                    fieldList.type = values.get(dec);
                                    fieldList.name = values.get(dec).name;
                                    fieldList.next = new FieldList();
                                    fieldList = fieldList.next;
                                }
                            }
                        }
                    }
                    errList.add(ctx.depth()+":layer"+"Error type 16 at Line "+ctx.getStart().getLine()+": redefine struct name \""+ structure.name+"\"");
                    if (ctx.defList().def().size()>0) {
                        for (int i = ctx.STRUCT().getSymbol().getLine()+1; i <= ctx.defList().def(ctx.defList().def().size() - 1).SEMI().getSymbol().getLine(); i++) {
                            neglectLines.add(i);
                        }
                    }
                    sameName = false;
                }
            }

            @Override
            public void enterReuseStruct(CmmParser.ReuseStructContext ctx) {

            }

            @Override
            public void exitReuseStruct(CmmParser.ReuseStructContext ctx) {
                Type a=findSymbol(values.get(ctx.tag().ID()));
                if (a!=null&&a.type==Kind.STRUCTURE&&!((Structure)a).isVar)
                    values.put(ctx,a);
                else{
                    errList.add(ctx.depth()+":layer"+"Error type 17 at Line "+ctx.getStart().getLine()+": Undefined structure \""+values.get(ctx.tag().ID()).name+"\"");
                    values.put(ctx,values.get(ctx.tag().ID()));
                }
            }

            @Override
            public void enterOptWithName(CmmParser.OptWithNameContext ctx) {

            }

            @Override
            public void exitOptWithName(CmmParser.OptWithNameContext ctx) {
                Structure t=new Structure();
                t.name=values.get(ctx.ID()).name;
                t.type=Kind.STRUCTURE;
                if (findSymbol(t.name)==null)
                    name.add(t.name);
                else
                    sameName=true;
                values.put(ctx,t);
            }

            @Override
            public void enterOptWithNoName(CmmParser.OptWithNoNameContext ctx) {

            }

            @Override
            public void exitOptWithNoName(CmmParser.OptWithNoNameContext ctx) {
                Structure t=new Structure();
                t.type=Kind.STRUCTURE;
                values.put(ctx,t);
            }


            @Override
            public void enterTag(CmmParser.TagContext ctx) {

            }

            @Override
            public void exitTag(CmmParser.TagContext ctx) {

            }
        };
        walker.walk(listener, tree);

        HashMap<Integer, Integer> typeAndLine=new HashMap<>();
        for (String s : errList) {
            if(!typeAndLine.containsKey(getLine(s)))
                typeAndLine.put(getLine(s),getlayer(s));
            else {
                if (typeAndLine.get(getLine(s))<getlayer(s))
                    typeAndLine.put(getLine(s),getlayer(s));
            }
        }
        for (int i = 0; i < errList.size()-1; i++) {
            for (int j = 0; j < errList.size()-1-i; j++) {
                if (getLine(errList.get(j))>getLine(errList.get(j+1))){
                    String temp=errList.get(j);
                    errList.set(j,errList.get(j+1));
                    errList.set(j+1,temp);
                }
            }
        }
        for (String s : errList) {
            if (!neglectLines.contains(getLine(s))&&typeAndLine.get(getLine(s))==getlayer(s)) {
                int start=0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i)=='E'){
                            start=i;
                            break;
                    }
                }
                System.err.println(s.substring(start));
            }
        }
        symbolTable s=first;
    }
}

