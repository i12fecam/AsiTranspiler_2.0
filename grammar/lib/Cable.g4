grammar Cable;
import Base;

cableInstructionBlock: '@Cable' 'Instrucciones''{' fetchCableInstruction cableInstruction+ '}';

cableInstruction: IDENTIFIER '(' arg=('Value'|'Dir'|'Var')? ')' '{' cableStep* '}';

fetchCableInstruction: 'Fetch' '{' cableStep+ '}';

cableStep: '|' linstr=specialMicroIntr '|' rinstr+=microIntr* ';'  #simpleCableStep
    | '{'conditionalCableStep+ '}'                         #conditionalCableStepBlock
    ;

conditionalCableStep: flags+=FLAG (',' flags+=FLAG)* ':' '|' linstr=specialMicroIntr '|' rinstr+=microIntr* ';' ;
