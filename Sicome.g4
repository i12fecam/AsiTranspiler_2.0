grammar Sicome;

prog: cableInstructionBlock;

cableInstructionBlock: '@cableado' 'instrucciones''{' cableInstruction+ '}';

cableInstruction: IDENTIFIER '(' instructionArgument ')' '{' cableStep+ '}';

instructionArgument: 'value'
         | 'dir'
         |
         ;
cableStep: '[' cableFlowControl+']' MICRO_INSTR* ';'  #simpleCableStep
    | '{'conditionalCableStep+ '}'                         #conditionalCableStepBlock
    ;

conditionalCableStep: FLAG+ ':' '[' cableFlowControl+ ']' MICRO_INSTR* ';' ;

cableFlowControl: 'LOAD_SC' '('NUMBER ')' #LoadSC_FlowControl
          | 'LOAD_SR' '(' NUMBER ')'     #LoadSR_CableFlowControl
          | 'SR+1->SR'                #SRPlus_CableFlowControl
          | 'SC-1->SC'                #SCMinus_CableFlowControl
          ;

NUMBER: [0-9]+;
IDENTIFIER: [a-zA-Z]+;
MICRO_INSTR:[a-zA-Z->+]+;//no se si poner mas simbolos que acepte
FLAG:[a-zA-Z!]+;//debo especificar que puede tener interrogación al principio o no?

LINE_COMMENT: '//' .*? '\r'? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip ;

NEWLINE: '\r'? '\n' -> skip;
WS : [ \t]+ -> skip;

