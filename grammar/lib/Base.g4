lexer grammar Base;






FLAG: [A-Z!][a-z]?[a-z+]?;
IDENTIFIER: [a-z][a-zA-Z0-9]*; //debe empezar por minuscula
MICRO_INSTR: [A-Z!0][a-zA-Z0-9+\->_@]* ;

NUMBER: HEXNUMBER|DECNUMBER;
HEXNUMBER: '0x'[0-9a-fA-F]+ ;
DECNUMBER: [0-9]+;



LINE_COMMENT: '//' .*? '\r'? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip ;

NEWLINE: '\r'? '\n' -> skip;
WS : [ \t]+ -> skip;