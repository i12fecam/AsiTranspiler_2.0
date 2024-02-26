grammar Sicome;

prog: cableInstructionBlock;

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
          | 'LOAD_SR' '(' NUMBER ')'     #LoadSR_CableFlowControl
          | 'SR+1->SR'                #SRPlus_CableFlowControl
          | 'SC-1->SC'                #SCMinus_CableFlowControl
          ;
micro_instr: TEXT;
flag: TEXT;
//MICRO_INSTR:[A-Z!][A-Za-z\->+_@]*;//debe empezar por mayuscula
//FLAG: ('!')?[A-Z+][a-z+]?[a-z1]?;//Tendido que
IDENTIFIER: [a-z][a-zA-Z0-9]*; //debe empezar por minuscula
TEXT: [A-Z!][a-zA-Z0-9+\->_@]* ;
NUMBER: [0-9]+;
//PC+1->PC !Zsc hola
LINE_COMMENT: '//' .*? '\r'? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip ;

NEWLINE: '\r'? '\n' -> skip;
WS : [ \t]+ -> skip;

