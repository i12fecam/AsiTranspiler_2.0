grammar Micro_prog;
import Base;



statusLogicBlock: 'estados' '{' statusLogic+ '}' ;

statusLogic: name=IDENTIFIER '->' option=('INCR'|'BIF'|'RET') disable='DISABLE'? #simpleStatusLogic
           | name=IDENTIFIER '->' '{' statusLogicOption+ '}' #complexStatusLogic
           ;

statusLogicOption : flags=FLAG (',' flags=FLAG)* ':' option=('INCR'|'BIF'|'RET') disable='DISABLE'? ;

microInstructionBlock : '@microinstruccion' 'instrucciones''{' microInstruction+ '}';

microInstruction: IDENTIFIER '(' arg=('value'|'dir')? ')' '{' microStep+ '}';

microStep:  '[' microFlowControl+']' instr=MICRO_INSTR* ';'  #simpleMicroStep
               | '{'conditionalMicroStep+ '}'                #conditionalMicroStepBlock
               ;
microFlowControl: action='LOAD_SR' '(' value=NUMBER ')'
                | action='SR+1->SR'
                | action=IDENTIFIER ('(' value=NUMBER ')')?
                ;
conditionalMicroStep: flags+=FLAG (',' flags+=FLAG)* ':' '[' microFlowControl+ ']' instr=MICRO_INSTR* ';' ;