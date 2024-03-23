lexer grammar Base;



MICRO_INSTR: TEXT;
FLAG: TEXT;
NUMBER: HEXNUMBER|DECNUMBER;


IDENTIFIER: [a-z][a-zA-Z0-9]*; //debe empezar por minuscula
TEXT: [A-Z!][a-zA-Z0-9+\->_@]* ;
HEXNUMBER: '0x'[0-9a-fA-F]+ ;
DECNUMBER: [0-9]+;

LINE_COMMENT: '//' .*? '\r'? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip ;

NEWLINE: '\r'? '\n' -> skip;
WS : [ \t]+ -> skip;