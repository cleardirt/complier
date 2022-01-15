// Generated from D:/complier/src/main/java/L3\CmmParser.g4 by ANTLR 4.9.2
package L3;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CmmParser}.
 */
public interface CmmParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code extDefForVar}
	 * labeled alternative in {@link CmmParser#extDef}.
	 * @param ctx the parse tree
	 */
	void enterExtDefForVar(CmmParser.ExtDefForVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code extDefForVar}
	 * labeled alternative in {@link CmmParser#extDef}.
	 * @param ctx the parse tree
	 */
	void exitExtDefForVar(CmmParser.ExtDefForVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code extDefForStruct}
	 * labeled alternative in {@link CmmParser#extDef}.
	 * @param ctx the parse tree
	 */
	void enterExtDefForStruct(CmmParser.ExtDefForStructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code extDefForStruct}
	 * labeled alternative in {@link CmmParser#extDef}.
	 * @param ctx the parse tree
	 */
	void exitExtDefForStruct(CmmParser.ExtDefForStructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code extDefForFuc}
	 * labeled alternative in {@link CmmParser#extDef}.
	 * @param ctx the parse tree
	 */
	void enterExtDefForFuc(CmmParser.ExtDefForFucContext ctx);
	/**
	 * Exit a parse tree produced by the {@code extDefForFuc}
	 * labeled alternative in {@link CmmParser#extDef}.
	 * @param ctx the parse tree
	 */
	void exitExtDefForFuc(CmmParser.ExtDefForFucContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#extDecList}.
	 * @param ctx the parse tree
	 */
	void enterExtDecList(CmmParser.ExtDecListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#extDecList}.
	 * @param ctx the parse tree
	 */
	void exitExtDecList(CmmParser.ExtDecListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDecNormal}
	 * labeled alternative in {@link CmmParser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterVarDecNormal(CmmParser.VarDecNormalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDecNormal}
	 * labeled alternative in {@link CmmParser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitVarDecNormal(CmmParser.VarDecNormalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDecForArray}
	 * labeled alternative in {@link CmmParser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterVarDecForArray(CmmParser.VarDecForArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDecForArray}
	 * labeled alternative in {@link CmmParser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitVarDecForArray(CmmParser.VarDecForArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#compSt}.
	 * @param ctx the parse tree
	 */
	void enterCompSt(CmmParser.CompStContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#compSt}.
	 * @param ctx the parse tree
	 */
	void exitCompSt(CmmParser.CompStContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void enterStmtList(CmmParser.StmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void exitStmtList(CmmParser.StmtListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtexp}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtexp(CmmParser.StmtexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtexp}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtexp(CmmParser.StmtexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compStStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterCompStStmt(CmmParser.CompStStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compStStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitCompStStmt(CmmParser.CompStStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(CmmParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(CmmParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(CmmParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(CmmParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifelseStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfelseStmt(CmmParser.IfelseStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifelseStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfelseStmt(CmmParser.IfelseStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(CmmParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(CmmParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expOr}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpOr(CmmParser.ExpOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expOr}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpOr(CmmParser.ExpOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expWithFucNoParameters}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpWithFucNoParameters(CmmParser.ExpWithFucNoParametersContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expWithFucNoParameters}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpWithFucNoParameters(CmmParser.ExpWithFucNoParametersContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expNegative}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpNegative(CmmParser.ExpNegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expNegative}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpNegative(CmmParser.ExpNegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expWithArray}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpWithArray(CmmParser.ExpWithArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expWithArray}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpWithArray(CmmParser.ExpWithArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expWithStruct}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpWithStruct(CmmParser.ExpWithStructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expWithStruct}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpWithStruct(CmmParser.ExpWithStructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expAssign}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpAssign(CmmParser.ExpAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expAssign}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpAssign(CmmParser.ExpAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expFloat}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpFloat(CmmParser.ExpFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expFloat}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpFloat(CmmParser.ExpFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expAnd}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpAnd(CmmParser.ExpAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expAnd}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpAnd(CmmParser.ExpAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expDivOrStar}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpDivOrStar(CmmParser.ExpDivOrStarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expDivOrStar}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpDivOrStar(CmmParser.ExpDivOrStarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expCompare}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpCompare(CmmParser.ExpCompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expCompare}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpCompare(CmmParser.ExpCompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expInt}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpInt(CmmParser.ExpIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expInt}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpInt(CmmParser.ExpIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expWithFuc}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpWithFuc(CmmParser.ExpWithFucContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expWithFuc}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpWithFuc(CmmParser.ExpWithFucContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expPlusOrMinus}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpPlusOrMinus(CmmParser.ExpPlusOrMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expPlusOrMinus}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpPlusOrMinus(CmmParser.ExpPlusOrMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expNegate}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpNegate(CmmParser.ExpNegateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expNegate}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpNegate(CmmParser.ExpNegateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expBrackets}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpBrackets(CmmParser.ExpBracketsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expBrackets}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpBrackets(CmmParser.ExpBracketsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expId}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpId(CmmParser.ExpIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expId}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpId(CmmParser.ExpIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(CmmParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(CmmParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#defList}.
	 * @param ctx the parse tree
	 */
	void enterDefList(CmmParser.DefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#defList}.
	 * @param ctx the parse tree
	 */
	void exitDefList(CmmParser.DefListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(CmmParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(CmmParser.DefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#decList}.
	 * @param ctx the parse tree
	 */
	void enterDecList(CmmParser.DecListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#decList}.
	 * @param ctx the parse tree
	 */
	void exitDecList(CmmParser.DecListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decWithInit}
	 * labeled alternative in {@link CmmParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDecWithInit(CmmParser.DecWithInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decWithInit}
	 * labeled alternative in {@link CmmParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDecWithInit(CmmParser.DecWithInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decWithoutInit}
	 * labeled alternative in {@link CmmParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDecWithoutInit(CmmParser.DecWithoutInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decWithoutInit}
	 * labeled alternative in {@link CmmParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDecWithoutInit(CmmParser.DecWithoutInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funDecWithVar}
	 * labeled alternative in {@link CmmParser#funDec}.
	 * @param ctx the parse tree
	 */
	void enterFunDecWithVar(CmmParser.FunDecWithVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funDecWithVar}
	 * labeled alternative in {@link CmmParser#funDec}.
	 * @param ctx the parse tree
	 */
	void exitFunDecWithVar(CmmParser.FunDecWithVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funDecWithoutVar}
	 * labeled alternative in {@link CmmParser#funDec}.
	 * @param ctx the parse tree
	 */
	void enterFunDecWithoutVar(CmmParser.FunDecWithoutVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funDecWithoutVar}
	 * labeled alternative in {@link CmmParser#funDec}.
	 * @param ctx the parse tree
	 */
	void exitFunDecWithoutVar(CmmParser.FunDecWithoutVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#varList}.
	 * @param ctx the parse tree
	 */
	void enterVarList(CmmParser.VarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#varList}.
	 * @param ctx the parse tree
	 */
	void exitVarList(CmmParser.VarListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#paramDec}.
	 * @param ctx the parse tree
	 */
	void enterParamDec(CmmParser.ParamDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#paramDec}.
	 * @param ctx the parse tree
	 */
	void exitParamDec(CmmParser.ParamDecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code specifierForVar}
	 * labeled alternative in {@link CmmParser#specifier}.
	 * @param ctx the parse tree
	 */
	void enterSpecifierForVar(CmmParser.SpecifierForVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code specifierForVar}
	 * labeled alternative in {@link CmmParser#specifier}.
	 * @param ctx the parse tree
	 */
	void exitSpecifierForVar(CmmParser.SpecifierForVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code specifierForStruct}
	 * labeled alternative in {@link CmmParser#specifier}.
	 * @param ctx the parse tree
	 */
	void enterSpecifierForStruct(CmmParser.SpecifierForStructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code specifierForStruct}
	 * labeled alternative in {@link CmmParser#specifier}.
	 * @param ctx the parse tree
	 */
	void exitSpecifierForStruct(CmmParser.SpecifierForStructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code struct}
	 * labeled alternative in {@link CmmParser#structSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterStruct(CmmParser.StructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code struct}
	 * labeled alternative in {@link CmmParser#structSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitStruct(CmmParser.StructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code reuseStruct}
	 * labeled alternative in {@link CmmParser#structSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterReuseStruct(CmmParser.ReuseStructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code reuseStruct}
	 * labeled alternative in {@link CmmParser#structSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitReuseStruct(CmmParser.ReuseStructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code optWithName}
	 * labeled alternative in {@link CmmParser#optTag}.
	 * @param ctx the parse tree
	 */
	void enterOptWithName(CmmParser.OptWithNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code optWithName}
	 * labeled alternative in {@link CmmParser#optTag}.
	 * @param ctx the parse tree
	 */
	void exitOptWithName(CmmParser.OptWithNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code optWithNoName}
	 * labeled alternative in {@link CmmParser#optTag}.
	 * @param ctx the parse tree
	 */
	void enterOptWithNoName(CmmParser.OptWithNoNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code optWithNoName}
	 * labeled alternative in {@link CmmParser#optTag}.
	 * @param ctx the parse tree
	 */
	void exitOptWithNoName(CmmParser.OptWithNoNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(CmmParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(CmmParser.TagContext ctx);
}