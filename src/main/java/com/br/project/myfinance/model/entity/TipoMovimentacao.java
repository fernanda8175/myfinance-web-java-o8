package com.br.project.myfinance.model.entity;

public enum TipoMovimentacao {
    DESPESA(0), RECEITA(1);

    private final int valor;

    TipoMovimentacao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static TipoMovimentacao fromValor(int valor) {
        return valor == 1 ? RECEITA : DESPESA;
    }
}