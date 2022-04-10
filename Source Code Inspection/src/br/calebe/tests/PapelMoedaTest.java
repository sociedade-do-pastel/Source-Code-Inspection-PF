import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.TicketMachine;

public class PapelMoedaTest {
       
    // Teste para conferir se quando o software é iniciado, o saldo está zerado.
    @Test
    public void confereSaldo(){
        int a = 0;
        TicketMachine novo = new TicketMachine(2);
        Assert.assertEquals(a, novo.getSaldo());
    } 

    // Teste para conferir se a classe PapelMoeda está registrando os valores e quantidades inseridos.
    @Test
    public void conferePalpelMoedaPositivo(){
        PapelMoeda positivo = new PapelMoeda(5,20);
        Assert.assertEquals(5, positivo.getValor());
        Assert.assertEquals(20, positivo.getQuantidade());
    }

    // Teste para conferir se a classe PapelMoeda retorna erro quando são inseridos valores negativos.
    @Test(expected = Exception.class)
    public void conferePalpelMoedaNegativo(){
        PapelMoeda negativo = new PapelMoeda(-5,-10);
        Assert.assertEquals(0, negativo.getValor());
        Assert.assertEquals(0, negativo.getQuantidade());

    }

}
