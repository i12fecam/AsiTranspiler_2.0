grammar Micro_prog;
import Base;



statusLogicBlock: 'estados' '{' statusLogic+ '}' ;

statusLogic: name=IDENTIFIER '->' option=('INCR'|'BIF'|'RET') disable='DISABLE'? #simpleStatusLogic
           | name=IDENTIFIER '->' '{' statusLogicOption+ '}' #complexStatusLogic
           ;

statusLogicOption : flags+=FLAG (',' flags+=FLAG)* ':' option=('INCR'|'BIF'|'RET') disable='DISABLE'? ;






microInstructionBlock : '@microinstruccion' 'instrucciones''{' microInstruction+ '}';

microInstruction: IDENTIFIER '(' arg=('value'|'dir'|'var')? ')' '{' microStep* '}';

microStep:  '[' flow+=microFlowControl*']' instr+=MICRO_INSTR* ';';
microFlowControl: action='LOAD_SC' '(' value=NUMBER ')'
                | action='SC-1->SC'
                | action=IDENTIFIER ('(' value=NUMBER ')')?
                ;
