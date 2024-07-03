grammar Cable;
import Base;

cableInstructionBlock: '@cableado' 'instrucciones''{' cableInstruction+ '}';

cableInstruction: IDENTIFIER '(' arg=('value'|'dir'|'var')? ')' '{' cableStep* '}';

cableStep: '[' cableFlowControl+']' instr+=MICRO_INSTR* ';'  #simpleCableStep
    | '{'conditionalCableStep+ '}'                         #conditionalCableStepBlock
    ;

conditionalCableStep: flags+=FLAG (',' flags+=FLAG)* ':' '[' cableFlowControl+ ']' instr+=MICRO_INSTR* ';' ;

cableFlowControl: type='LOAD_SC' '('value=NUMBER ')'
          | type='LOAD_SR' '(' value=(NUMBER | 'START') ')'
          | type='SR+1->SR'
          | type='SC-1->SC'
          ;