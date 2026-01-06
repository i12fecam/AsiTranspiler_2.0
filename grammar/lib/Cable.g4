grammar Cable;
import Base;

cableInstructionBlock: '@cableado' 'instrucciones''{' cableInstruction+ '}';

cableInstruction: IDENTIFIER '(' arg=('value'|'dir'|'var')? ')' '{' cableStep* '}';

cableStep: '[' linstr=specialMicroIntr']' rinstr+=microIntr* ';'  #simpleCableStep
    | '{'conditionalCableStep+ '}'                         #conditionalCableStepBlock
    ;

conditionalCableStep: flags+=FLAG (',' flags+=FLAG)* ':' '[' linstr=specialMicroIntr ']' rinstr+=microIntr* ';' ;
