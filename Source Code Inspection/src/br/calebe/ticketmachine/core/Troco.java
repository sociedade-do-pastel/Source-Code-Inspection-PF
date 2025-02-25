package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int[] notas = {100, 50, 20, 10, 5, 2};
        int i = 0;

        for (int nota: notas) {
            papeisMoeda[i] = new PapelMoeda(nota, (int)(valor/nota));
            valor = valor % nota;
            i++;
        }
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = troco.papeisMoeda.length-1; i >= 0; i--) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            for (int i = troco.papeisMoeda.length-1; i >= 0; i--) {
                if (troco.papeisMoeda[i] != null) {
                    PapelMoeda ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                    return ret;
                }
            }
            return null;
        }

        @Override
        public void remove() {
            next();
        }
    }
}
