parser grammar CmmParser;

options {
  tokenVocab=CmmLexer;
}

program: extDef* EOF;

extDef: specifier extDecList SEMI # extDefForVar
  | specifier SEMI # extDefForStruct
  | specifier funDec compSt # extDefForFuc
  ;
extDecList: varDec (COMMA varDec)*;
varDec:
      ID # varDecNormal
      |ID (LB
      (
      FLOAT {notifyErrorListeners("array size must be an integer constant,not ");}
      |ID    {notifyErrorListeners("array size must be an integer constant,not ");}
      |INT
      )
RB)* # varDecForArray
      ;

compSt: LC defList stmtList RC ;
stmtList:(stmt)*;
stmt: exp SEMI # stmtexp
    |compSt # compStStmt
    |RETURN  exp  SEMI # returnStmt
    |IF  LP  exp  RP  stmt # ifStmt
    |IF  LP  exp  RP  stmt  ELSE  stmt # ifelseStmt
    |WHILE  LP  exp  RP stmt # whileStmt
    ;


exp : ID LP args RP # expWithFuc
    | ID LP RP # expWithFucNoParameters
    | exp LB exp RB # expWithArray
    | exp DOT ID # expWithStruct
    | <assoc=right> MINUS exp # expNegative
    | <assoc=right> NOT exp # expNegate
    | exp (DIV|STAR)exp # expDivOrStar
    | exp (MINUS|PLUS)exp # expPlusOrMinus
    | exp RELOP exp # expCompare
    | exp AND exp # expAnd
    | exp OR exp # expOr
    | <assoc=right> exp ASSIGNOP exp # expAssign
    | LP exp RP # expBrackets
    | FLOAT # expFloat
    | INT # expInt
    | ID # expId
    ;
args:exp (COMMA exp)*;

defList: (def)*;
def: specifier decList SEMI;
decList:dec (COMMA dec)*;
dec:<assoc=right> (varDec ASSIGNOP exp) # decWithInit
    | varDec # decWithoutInit;

funDec: ID LP (varList) RP # funDecWithVar
    | ID LP RP # funDecWithoutVar
    ;
varList : paramDec (COMMA paramDec)* ;
paramDec:specifier varDec;


specifier: TYPE # specifierForVar
         | structSpecifier # specifierForStruct
         ;
structSpecifier: STRUCT optTag LC defList RC # struct
        | STRUCT tag # reuseStruct
        ;
optTag: ID # optWithName
        | # optWithNoName
        ;
tag: ID;





