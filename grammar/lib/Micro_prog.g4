grammar Micro_prog;
import Base;



statusLogicBlock: 'estados' '{' statusLogic+ '}' ;

statusLogic: name=IDENTIFIER '->' option=('INCR'|'BIF'|'RTN') disable='DISABLE'? #simpleStatusLogic
           | name=IDENTIFIER '->' '{' statusLogicOption+ '}' #complexStatusLogic
           ;

statusLogicOption : flags+=FLAG (',' flags+=FLAG)* ':' option=('INCR'|'BIF'|'RET') disable='DISABLE'? ;






microInstructionBlock : '@microinstruccion' 'instrucciones''{' fetchMicroInstruction microInstruction+ '}';

fetchMicroInstruction: 'fetch' '{' microStep* '}';

microInstruction: IDENTIFIER '(' arg=('value'|'dir'|'var')? ')' '{' microStep* '}';

microStep: '|' biflogic=IDENTIFIER ('(' arg=NUMBER ')')? '|' instr+=microIntr* ';';
