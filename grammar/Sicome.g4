grammar Sicome;
import Cable,Micro_prog;
prog:   statusLogicBlock #microProgramableLogic
    | cableInstructionBlock (variablesBlock programBlock | programBlock variablesBlock)? #cableProgram
    | (statusLogicBlock microInstructionBlock | microInstructionBlock statusLogicBlock ) (variablesBlock programBlock | programBlock variablesBlock)? #microProgramableProgram
    ;



variablesBlock: 'variables' '{' variableDeclaration* '}' ;
variableDeclaration: id=IDENTIFIER '=' value=MEMORYVALUE              ';'  #simpleVariableDeclaration
                   | id=IDENTIFIER '(' size=DECNUMBER ')'  '=' '{' value+=MEMORYVALUE (',' value+=MEMORYVALUE )* '}' ';' #vectorVariableDeclaration
                   ;

programBlock: 'programa' '{' programLine* '}' ;
programLine: name=IDENTIFIER arg=instructionUseArgument ';'#instructionUse
            | 'MARK' label=IDENTIFIER  ';' #markUse
            ;
instructionUseArgument: var=IDENTIFIER ('('offset=DECNUMBER')')?
                      | num=MEMORYVALUE
                      |
                      ;


