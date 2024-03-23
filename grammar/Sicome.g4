grammar Sicome;
import Cable,Micro_prog;
prog: cableInstructionBlock variablesBlock programBlock #cableProgram
    | statusLogicBlock microInstructionBlock variablesBlock programBlock #microCableProgram
    ;



variablesBlock: 'variables' '{' variableDeclaration* '}' ;
variableDeclaration: id=IDENTIFIER '=' value=NUMBER              ';'  #simpleVariableDeclaration
                   | id=IDENTIFIER '[' size=NUMBER ']'  '=' '{' value+=NUMBER (',' value+=NUMBER )* '}' ';' #vectorVariableDeclaration
                   ;

programBlock: 'programa' '{' programLine* '}' ;
programLine: name=IDENTIFIER arg=instructionUseArgument ';'#instructionUse
            | 'MARK' label=IDENTIFIER  ';' #markUse
            ;
instructionUseArgument: var=IDENTIFIER ('['offset=NUMBER']')?
                      | num=NUMBER
                      |
                      ;


