package br.calebe.ticketmachine.core;

import java.util.Objects;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class PapelMoeda {

    protected int valor;
    protected int quantidade;

    public PapelMoeda(int valor, int quantidade) {
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public int getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null || getClass() != obj.getClass()) { return false; }

        PapelMoeda p = (PapelMoeda) obj;
        return (this.valor == p.getValor() && this.quantidade == p.getQuantidade());
    }

    @Override
    public  int hashCode() {
        return Objects.hash(valor, quantidade);
    }
}
