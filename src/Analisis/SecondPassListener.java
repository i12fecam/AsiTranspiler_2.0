package Analisis;

import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import internals.MicroInstruction;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Hacer comprobacion de microinstruciones solapadas
 * Hacer comprobaciones de logica condicional
 * Comprobar que los saltos se salgan del tamaño de la funcion y que SR+1->SR y load-sr no este en la misma linea
 */
public class SecondPassListener extends SicomeBaseListener {
    ParseTreeProperty<Integer> _ids = null;
    SymbolTable _st = null;
    public SecondPassListener(ParseTreeProperty<Integer> ids,SymbolTable st){
        _ids=ids;
        _st=st;
    }

    /**
     * Checks if any of the microinstruinstructions used in a step is part of the same group
     * @param ctx the parse tree
     */
    @Override
    public void enterSimpleCableStep(SicomeParser.SimpleCableStepContext ctx) {
        List<MicroInstruction> mInstrList = new ArrayList<>();

        var mInstrCtx = ctx.instr;

        for (var tn: mInstrCtx) {
            MicroInstruction newMI = MicroInstruction.valueOfInput(tn.getText());
            for (var recordedMi : mInstrList){
                if (newMI.getType().equals(recordedMi.getType())) {
                    throw new LogicException("Ya hay una instrucción que pertenece al mismo grupo de microinstrucción", tn);
                }
            }
            mInstrList.add(newMI);
        }

    }


    /**
     * Checks if the combination of conditions in a step is valid
     * @param ctx the parse tree
     */

        /**
         * A B C D E F
         * 0 0 T F T F
         * T F 0 T F 0
         * T T 0 F T 0
         *
         * 1º Transaladar columnas que esten más completas hacia la parte derecha
         * D E A B C F
         * F T 0 0 T F
         * T F T F 0 0
         * F T T T 0 0
         *
         * 2º Organizar filas en orden vacio, true, false
         * D E A B C F
         * T F T F 0 0
         * F T 0 0 T F
         * F T T T 0 0
         * 3º Se analiza fila a fila
         *
         * Si algo es V la siguiente afirmacion
         * F o F y algo mas
         */




}

