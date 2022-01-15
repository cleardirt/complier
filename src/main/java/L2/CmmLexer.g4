lexer grammar CmmLexer;

TYPE: 'int' | 'float';
STRUCT: 'struct';
RETURN: 'return';
IF: 'if';
ELSE: 'else';
WHILE: 'while';


FLOAT :(DIGIT+ DOT DIGIT+|DOT DIGIT+ |DIGIT+ DOT) FLOAT_EXPONENT
      |DIGIT+ DOT DIGIT+
      |  INT FLOAT_EXPONENT
      ;
OCC:'0'[0-7]+;
HEX:'0' [xX] [a-fA-F0-9]+;
ID : (LETTER | '_') WORD* ;
INT : ('0'|[1-9][0-9]*);



WS : [ \t\r\n]+ -> skip ;
SEMI:';';
COMMA:',';
ASSIGNOP:'=';
RELOP: '>' | '<' | '>=' | '<=' | '==' | '!=';
PLUS: '+';
MINUS: '-';
STAR: '*';
DIV: '/';
AND: '&&';
OR: '||';
DOT: '.';
NOT: '!';
LP: '(';
RP: ')';
LB: '[';
RB: ']';
LC: '{';
RC: '}';
// Note: in antlr4, '.' matches any (single) character, including '\n'.
SL_COMMENT : '//' .*? '\n' -> skip;  // non-greedy
ML_COMMENT : '/*' .*? '*/' -> skip;  // non-greedy

//fragment
//INT : '0' | ([1-9] [0-9]*) ;

fragment
DIGIT : [0-9] ;
fragment
LETTER : [a-zA-Z] ;
fragment
HEX_D : [a-fA-F] ;
fragment
WORD : [a-zA-Z0-9_] ;
fragment
NE:('e'|'E') '-' DIGIT*;
fragment
PE:('e'|'E') ('+'? DIGIT*);
fragment
E:NE|PE;
fragment
FLOAT_EXPONENT : [eE]('-' | '+') ? DIGIT+;