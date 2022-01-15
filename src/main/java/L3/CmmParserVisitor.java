// Generated from D:/complier/src/main/java/L3\CmmParser.g4 by ANTLR 4.9.2
package L3;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CmmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CmmParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CmmParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code extDefForVar}
	 * labeled alternative in {@link CmmParser#extDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtDefForVar(CmmParser.ExtDefForVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code extDefForStruct}
	 * labeled alternative in {@link CmmParser#extDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtDefForStruct(CmmParser.ExtDefForStructContext ctx);
	/**
	 * Visit a parse tree produced by the {@code extDefForFuc}
	 * labeled alternative in {@link CmmParser#extDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtDefForFuc(CmmParser.ExtDefForFucContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#extDecList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtDecList(CmmParser.ExtDecListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDecNormal}
	 * labeled alternative in {@link CmmParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecNormal(CmmParser.VarDecNormalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDecForArray}
	 * labeled alternative in {@link CmmParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecForArray(CmmParser.VarDecForArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#compSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompSt(CmmParser.CompStContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#stmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtList(CmmParser.StmtListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtexp}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtexp(CmmParser.StmtexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compStStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompStStmt(CmmParser.CompStStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(CmmParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(CmmParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifelseStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfelseStmt(CmmParser.IfelseStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link CmmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(CmmParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expOr}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpOr(CmmParser.ExpOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expWithFucNoParameters}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpWithFucNoParameters(CmmParser.ExpWithFucNoParametersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expNegative}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpNegative(CmmParser.ExpNegativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expWithArray}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpWithArray(CmmParser.ExpWithArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expWithStruct}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpWithStruct(CmmParser.ExpWithStructContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expAssign}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAssign(CmmParser.ExpAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expFloat}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpFloat(CmmParser.ExpFloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expAnd}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAnd(CmmParser.ExpAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expDivOrStar}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpDivOrStar(CmmParser.ExpDivOrStarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expCompare}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpCompare(CmmParser.ExpCompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expInt}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpInt(CmmParser.ExpIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expWithFuc}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpWithFuc(CmmParser.ExpWithFucContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expPlusOrMinus}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpPlusOrMinus(CmmParser.ExpPlusOrMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expNegate}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpNegate(CmmParser.ExpNegateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expBrackets}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpBrackets(CmmParser.ExpBracketsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expId}
	 * labeled alternative in {@link CmmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpId(CmmParser.ExpIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(CmmParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#defList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefList(CmmParser.DefListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(CmmParser.DefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#decList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecList(CmmParser.DecListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decWithInit}
	 * labeled alternative in {@link CmmParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecWithInit(CmmParser.DecWithInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decWithoutInit}
	 * labeled alternative in {@link CmmParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecWithoutInit(CmmParser.DecWithoutInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funDecWithVar}
	 * labeled alternative in {@link CmmParser#funDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDecWithVar(CmmParser.FunDecWithVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funDecWithoutVar}
	 * labeled alternative in {@link CmmParser#funDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDecWithoutVar(CmmParser.FunDecWithoutVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#varList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarList(CmmParser.VarListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#paramDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamDec(CmmParser.ParamDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code specifierForVar}
	 * labeled alternative in {@link CmmParser#specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecifierForVar(CmmParser.SpecifierForVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code specifierForStruct}
	 * labeled alternative in {@link CmmParser#specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecifierForStruct(CmmParser.SpecifierForStructContext ctx);
	/**
	 * Visit a parse tree produced by the {@code struct}
	 * labeled alternative in {@link CmmParser#structSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct(CmmParser.StructContext ctx);
	/**
	 * Visit a parse tree produced by the {@code reuseStruct}
	 * labeled alternative in {@link CmmParser#structSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReuseStruct(CmmParser.ReuseStructContext ctx);
	/**
	 * Visit a parse tree produced by the {@code optWithName}
	 * labeled alternative in {@link CmmParser#optTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptWithName(CmmParser.OptWithNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code optWithNoName}
	 * labeled alternative in {@link CmmParser#optTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptWithNoName(CmmParser.OptWithNoNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(CmmParser.TagContext ctx);
}