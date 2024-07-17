grammar Sicome;
import Cable,Micro_prog;


//Base
fragment HEXNUMBER: '0x'[0-9a-fA-F]+ ;
fragment DECNUMBER: [0-9]+;
NUMBER: HEXNUMBER|DECNUMBER;



IDENTIFIER: [a-z][a-zA-Z0-9_]*; //debe empezar por minuscula
SYSTEM_IDENTIFIER:[!A-Z/].+;






LINE_COMMENT: '//' .*? '\r'? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip ;

NEWLINE: '\r'? '\n' -> skip;
WS : [ \t]+ -> skip;

//Micro

flowLogicBlock: 'estados' '{' flowLogic+ '}' ;

flowLogic: name=IDENTIFIER '->' option=('INCR'|'BIF'|'RET') disable='DISABLE'? #simpleStatusLogic
           | name=IDENTIFIER '->' '{' flowLogicConditional+ '}' #complexStatusLogic
           ;

flowLogicConditional : flags+=SYSTEM_IDENTIFIER (',' flags+=SYSTEM_IDENTIFIER)* ':' option=('INCR'|'BIF'|'RET') disable='DISABLE'? ;






microInstructionBlock : '@microinstruccion' 'instrucciones''{' microInstruction+ '}';

microInstruction: IDENTIFIER '(' arg=('value'|'dir'|'var')? ')' '{' microStep* '}';

microStep:  '[' flow+=microFlowControl*']' instr+=SYSTEM_IDENTIFIER* ';';
microFlowControl: action='LOAD_SC' '(' value=NUMBER ')'
                | action='SC-1->SC'
                | action=IDENTIFIER ('(' value=NUMBER ')')?
                ;



//Cable
cableInstructionBlock: '@cableado' 'instrucciones''{' cableInstruction+ '}';

cableInstruction: IDENTIFIER '(' arg=('value'|'dir'|'var')? ')' '{' cableStep* '}';

cableStep: '[' cableFlowControl*']' instr+=SYSTEM_IDENTIFIER* ';'  #simpleCableStep
    | '{'conditionalCableStep+ '}'                         #conditionalCableStepBlock
    ;

conditionalCableStep: flags+=SYSTEM_IDENTIFIER (',' flags+=SYSTEM_IDENTIFIER)* ':' '[' cableFlowControl+ ']' instr+=SYSTEM_IDENTIFIER* ';' ;

cableFlowControl: type='LOAD_SC' '('value=NUMBER ')'
          | type='LOAD_SR' '(' value=(NUMBER | 'START') ')'
          | type='SR+1->SR'
          | type='SC-1->SC'
          ;






start: cableInstructionBlock variablesBlock programBlock #cableProgram
    | flowLogicBlock microInstructionBlock variablesBlock programBlock #microCableProgram
    ;



variablesBlock: 'variables' '{' variableDeclaration* '}' ;
variableDeclaration: id=IDENTIFIER '=' value=NUMBER              ';'  #simpleVariableDeclaration
                   | id=IDENTIFIER '[' size=NUMBER ']'  '=' '{' value+=NUMBER (',' value+=NUMBER )* '}' ';' #vectorVariableDeclaration
                   ;

programBlock: 'programa' '{' programStep* '}' ;
programStep: name=IDENTIFIER arg=instructionCallArgument ';'#instructionUse
            | 'MARK' label=IDENTIFIER  ';' #markUse
            ;
instructionCallArgument: var=IDENTIFIER ('['offset=NUMBER']')?
                      | num=NUMBER
                      |
                      ;
