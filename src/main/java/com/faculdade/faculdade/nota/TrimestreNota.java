package com.faculdade.faculdade.nota;

public enum TrimestreNota {

    T1("1º Trimestre"),
    T2("2º Trimestre"),
    T3("3º Trimestre"),
    T4("4º Trimestre");

    private final String descricao;

    TrimestreNota(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
