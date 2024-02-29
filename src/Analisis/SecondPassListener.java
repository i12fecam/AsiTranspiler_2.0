package Analisis;

import Parsing.SicomeBaseListener;
import Parsing.SicomeParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

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
        //TODO mirar si es necesario hacer esta comprobacion en cableado
        /*
        Set<MicroInstruction> mInstrList = HashSet.newHashSet(6);

        List<TerminalNode> mInstr = ctx.MICRO_INSTR();
        for (TerminalNode tn: mInstr){
            String mInstrName = tn.getSymbol().getText();
            mInstrList.add(new MicroInstruction(mInstrName));
            //TODO echar error al haber repeticion de tipos
        }

         */
    }


    /**
     * Checks if the combination of conditions in a step is valid
     * @param ctx the parse tree
     */
    @Override
    public void enterConditionalCableStep(SicomeParser.ConditionalCableStepContext ctx) {
        List<SicomeParser.FlagContext> conds = ctx.flag();
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




}

