grammar Sicome;

prog: cableInstructionBlock variablesBlock programBlock;

cableInstructionBlock: '@cableado' 'instrucciones''{' cableInstruction+ '}';

cableInstruction: IDENTIFIER '(' instructionArgument ')' '{' cableStep+ '}';

instructionArgument: 'value'
         | 'dir'
         |
         ;
cableStep: '[' cableFlowControl+']' micro_instr* ';'  #simpleCableStep
    | '{'conditionalCableStep+ '}'                         #conditionalCableStepBlock
    ;

conditionalCableStep: flag (',' flag)* ':' '[' cableFlowControl+ ']' micro_instr* ';' ;

cableFlowControl: 'LOAD_SC' '('NUMBER ')' #LoadSC_FlowControl
          | 'LOAD_SR' '(' (NUMBER | 'START') ')'     #LoadSR_CableFlowControl
          | 'SR+1->SR'                #SRPlus_CableFlowControl
          | 'SC-1->SC'                #SCMinus_CableFlowControl
          ;
micro_instr: TEXT;
flag: TEXT;

variablesBlock: 'variables' '{' variableDeclaration* '}' ;
variableDeclaration: id=IDENTIFIER '=' value=(HEXNUMBER | NUMBER )              ';'  #simpleVariableDeclaration
                   | id=IDENTIFIER '[' size=NUMBER ']'  '=' '{' value+=(HEXNUMBER | NUMBER) (',' value+=(HEXNUMBER | NUMBER) )* '}' ';' #vectorVariableDeclaration
                   ;

programBlock: 'programa' '{' programLine* '}' ;
programLine: name=IDENTIFIER arg=(NUMBER|HEXNUMBER|IDENTIFIER)? #instructionUse
            | 'MARK' label=IDENTIFIER #markUse
            ;


IDENTIFIER: [a-z][a-zA-Z0-9]*; //debe empezar por minuscula
TEXT: [A-Z!][a-zA-Z0-9+\->_@]* ;
HEXNUMBER: '0x'[0-9a-fA-F]+ ;
NUMBER: [0-9]+;

LINE_COMMENT: '//' .*? '\r'? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip ;

NEWLINE: '\r'? '\n' -> skip;
WS : [ \t]+ -> skip;

