package com.br.project.myfinance.model.entity;

public enum TipoMovimentacao {
    Despesa(0), Receita(1);

    private final int valor;

    TipoMovimentacao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static TipoMovimentacao fromValor(int valor) {
        return valor == 1 ? Receita : Despesa;
    }
}