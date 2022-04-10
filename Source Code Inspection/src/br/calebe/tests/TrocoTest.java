package br.calebe.tests;

import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.Troco;
import org.junit.Assert;
import org.junit.Test;


import java.util.Iterator;

import static org.hamcrest.CoreMatchers.hasItems;


public class TrocoTest {
    @Test
    public void calcularTrocoComumTeste() {
        int saldo = 532;
        PapelMoeda[] confere = {
                new PapelMoeda(100, 5),
                new PapelMoeda(50, 0),
                new PapelMoeda(20, 1),
                new PapelMoeda(10, 1),
                new PapelMoeda(5, 0),
                new PapelMoeda(2, 1),
        };

        Iterator<PapelMoeda> it = new Troco(saldo).getIterator();

        int i = 5;
        while(it.hasNext()) {
            Assert.assertEquals(confere[i--], it.next());
        }
    }

    @Test
    public void calcularTrocoZeroTeste() {
        Iterator<PapelMoeda> it = new Troco(0).getIterator();

        while(it.hasNext()) {
            Assert.assertEquals(0, it.next().getQuantidade());
        }
    }

    @Test
    public void calcularTrocoComRestoTeste() {
        int saldo = 531;

        Iterator<PapelMoeda> it = new Troco(saldo).getIterator();

        while(it.hasNext()) {
            PapelMoeda p = it.next();
            saldo -= p.getQuantidade() * p.getValor();
        }

        Assert.assertEquals(1, saldo);
    }

//    @Test()
//    public void calcularTrocoNegativoTeste() {
//        int saldo = -532;
//        PapelMoeda[] confere = {
//                new PapelMoeda(100, 0),
//                new PapelMoeda(50, 0),
//                new PapelMoeda(20, 0),
//                new PapelMoeda(10, 0),
//                new PapelMoeda(5, 0),
//                new PapelMoeda(2, 0),
//        };
//
//        Iterator<PapelMoeda> it = new Troco(saldo).getIterator();
//
//        int i = 5;
//        while(it.hasNext()) {
//            Assert.assertEquals(confere[i--], it.next());
//        }
//    }
}
