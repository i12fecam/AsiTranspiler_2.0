lexer grammar Base;



fragment HEXNUMBER: '0x'[0-9a-fA-F]+ ;
fragment DECNUMBER: [0-9]+;
NUMBER: HEXNUMBER|DECNUMBER;

LOAD_SC: 'LOAD_SC';
LOAD_SR: 'LOAD_SR';
SR_INCREMENT: 'SR+1->SR';
SC_DECREMENT: 'SC-1->SC';

FLAG: [!]?[A-Z][a-z]?[a-z+1]?;
IDENTIFIER: [a-z][a-zA-Z0-9_]*; //debe empezar por minuscula
MICRO_INSTR: ([A-Z!]|[01]'-')[a-zA-Z0-9+\->_@{}]+ ;





LINE_COMMENT: '//' .*? '\r'? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip ;

NEWLINE: '\r'? '\n' -> skip;
WS : [ \t]+ -> skip;