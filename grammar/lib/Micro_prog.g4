grammar Micro_prog;
import Base;



statusLogicBlock: 'Lógica' '{' statusLogic+ '}' ;

statusLogic: name=IDENTIFIER '->' option=('INCR'|'BIF'|'RTN')? disable='DISABLE'? #simpleStatusLogic
           | name=IDENTIFIER '->' '{' statusLogicOption+ '}' #complexStatusLogic
           ;

statusLogicOption : flags+=FLAG (',' flags+=FLAG)* ':' option=('INCR'|'BIF'|'RTN')? disable='DISABLE'? ;






microInstructionBlock : '@Micro' 'Instrucciones''{' fetchMicroInstruction microInstruction+ '}';

fetchMicroInstruction: 'Fetch' '{' microStep+ '}';

microInstruction: IDENTIFIER '(' arg=('Value'|'Dir'|'Var')? ')' '{' microStep* '}';

microStep: '|' biflogic=IDENTIFIER ('(' bifLogicArgument ')')? '|' instr+=microIntr* ';';

bifLogicArgument: instr=IDENTIFIER '~' arg=DECNUMBER #instructionBifLogicArgument
                | DECNUMBER #startBifLogicArgument
                ;