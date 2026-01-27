grammar Cable;
import Base;

cableInstructionBlock: '@cableado' 'instrucciones''{' fetchCableInstruction cableInstruction+ '}';

cableInstruction: IDENTIFIER '(' arg=('value'|'dir'|'var')? ')' '{' cableStep* '}';

fetchCableInstruction: 'fetch' '{' cableStep+ '}';

cableStep: '|' linstr=specialMicroIntr '|' rinstr+=microIntr* ';'  #simpleCableStep
    | '{'conditionalCableStep+ '}'                         #conditionalCableStepBlock
    ;

conditionalCableStep: flags+=FLAG (',' flags+=FLAG)* ':' '|' linstr=specialMicroIntr '|' rinstr+=microIntr* ';' ;
