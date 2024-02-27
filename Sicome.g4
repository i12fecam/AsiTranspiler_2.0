grammar Sicome;

prog: cableInstructionBlock variablesBlock programBlock;

cableInstructionBlock: '@cableado' 'instrucciones''{' cableInstruction+ '}';

cableInstruction: IDENTIFIER '(' arg=('value'|'dir')? ')' '{' cableStep+ '}';


cableStep: '[' cableFlowControl+']' micro_instr* ';'  #simpleCableStep
    | '{'conditionalCableStep+ '}'                         #conditionalCableStepBlock
    ;

conditionalCableStep: flag (',' flag)* ':' '[' cableFlowControl+ ']' micro_instr* ';' ;

cableFlowControl: type='LOAD_SC' '('value=NUMBER ')'
          | type='LOAD_SR' '(' value=(NUMBER | 'START') ')'
          | type='SR+1->SR'
          | type='SC-1->SC'
          ;
micro_instr: TEXT;
flag: TEXT;

variablesBlock: 'variables' '{' variableDeclaration* '}' ;
variableDeclaration: id=IDENTIFIER '=' value=(HEXNUMBER | NUMBER )              ';'  #simpleVariableDeclaration
                   | id=IDENTIFIER '[' size=NUMBER ']'  '=' '{' value+=(HEXNUMBER | NUMBER) (',' value+=(HEXNUMBER | NUMBER) )* '}' ';' #vectorVariableDeclaration
                   ;

programBlock: 'programa' '{' programLine* '}' ;
programLine: name=IDENTIFIER arg=instructionUseArgument ';'#instructionUse
            | 'MARK' label=IDENTIFIER  ';' #markUse
            ;
instructionUseArgument: var=IDENTIFIER ('['offset=(NUMBER|HEXNUMBER) ']')?
                      | num=(NUMBER|HEXNUMBER)
                      |
                      ;

IDENTIFIER: [a-z][a-zA-Z0-9]*; //debe empezar por minuscula
TEXT: [A-Z!][a-zA-Z0-9+\->_@]* ;
HEXNUMBER: '0x'[0-9a-fA-F]+ ;
NUMBER: [0-9]+;

LINE_COMMENT: '//' .*? '\r'? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip ;

NEWLINE: '\r'? '\n' -> skip;
WS : [ \t]+ -> skip;

