parser grammar CmmParser;

options {
  tokenVocab=CmmLexer;
}

program: extDef* EOF;

extDef: specifier extDecList SEMI
  | specifier SEMI
  | specifier funDec compSt
  ;
extDecList: varDec (COMMA varDec)*;
varDec: ID (LB
      (
      FLOAT {notifyErrorListeners("array size must be an integer constant,not ");}
      |ID    {notifyErrorListeners("array size must be an integer constant,not ");}
      |INT
      )
RB)*
      ;

compSt: LC defList stmtList RC ;
stmtList:(stmt)*;
stmt: exp SEMI
    |compSt
    |RETURN  exp  SEMI
    |IF  LP  exp  RP  stmt
    |IF  LP  exp  RP  stmt  ELSE  stmt
    |WHILE  LP  exp  RP stmt
    ;


exp : ID LP args RP
    | ID LP RP
    | exp LB exp RB
    | exp DOT ID
    | <assoc=right> MINUS exp
    | <assoc=right> NOT exp
    | exp (DIV|STAR)exp
    | exp (MINUS|PLUS)exp
    | exp RELOP exp
    | exp AND exp
    | exp OR exp
    | <assoc=right> exp ASSIGNOP exp
    | LP exp RP
    | FLOAT
    | OCC
    | HEX
    | INT
    | ID
    ;
args:exp (COMMA exp)*;

defList: (def)*;
def: specifier decList SEMI;
decList:dec (COMMA dec)*;
dec:<assoc=right> (varDec ASSIGNOP exp)|varDec;

funDec: ID LP (varList) RP
    | ID LP RP
    ;
varList : paramDec (COMMA paramDec)* ;
paramDec:specifier varDec;


specifier: TYPE
         | structSpecifier
         ;
structSpecifier: STRUCT optTag LC defList RC
        | STRUCT tag
        ;
optTag: ID
        |
        ;
tag: ID;





