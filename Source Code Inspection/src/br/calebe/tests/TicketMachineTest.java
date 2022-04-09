package br.calebe.tests;

import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.Assert;
import org.junit.Test;

public class TicketMachineTest {
    @Test
    public void insereNotaComumTeste() throws PapelMoedaInvalidaException {
        TicketMachine t = new TicketMachine(10);
        int[] quantias = {2, 5, 10, 20, 50, 100};
        for (int quantia: quantias) {
            t.inserir(quantia);
        }
    }

    @Test
    public void adicionaSaldoAoInserirNotasTeste() throws PapelMoedaInvalidaException {
        TicketMachine t = new TicketMachine(10);
        int[] quantias = {2, 5, 10, 20, 50, 100};
        for (int quantia: quantias) {
            t.inserir(quantia);
        }

        Assert.assertEquals(187, t.getSaldo());
    }

    @Test(expected = PapelMoedaInvalidaException.class)
    public void erroAoInserirNotaInvalidaTeste() throws PapelMoedaInvalidaException {
        TicketMachine t = new TicketMachine(10);
        t.inserir(1);
    }

    @Test
    public void imprimeBilheteComumTeste() throws PapelMoedaInvalidaException, SaldoInsuficienteException {
        TicketMachine t = new TicketMachine(10);
        t.inserir(10);
        t.imprimir();
        Assert.assertEquals(0, t.getSaldo());
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void falhaAoImprimirBilheteSemSaldoTeste() throws SaldoInsuficienteException {
        TicketMachine t = new TicketMachine(10);
        t.imprimir();
    }
}
