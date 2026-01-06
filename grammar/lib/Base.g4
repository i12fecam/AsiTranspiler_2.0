grammar Base;



fragment HEXNUMBER: '0x'[0-9a-fA-F]+ ;
fragment BINNUMBER: '0b'[01.]+;
fragment DECNUMBER: [0-9]+;
NUMBER: HEXNUMBER|BINNUMBER|DECNUMBER;


FLAG: [!]?[A-Z][a-z]?[a-z+1]?;
IDENTIFIER: [a-z][a-zA-Z0-9_]*; //debe empezar por minuscula
MICRO_INSTR: ([A-Z!]|[01]'-')[a-zA-Z0-9+\->_@{}]+ ;
microIntr: MICRO_INSTR ('(' arg=NUMBER ')')?;
specialMicroIntr: MICRO_INSTR ('(' arg=(NUMBER|'START') ')')?;





LINE_COMMENT: '//' .*? '\r'? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip ;

NEWLINE: '\r'? '\n' -> skip;
WS : [ \t]+ -> skip;