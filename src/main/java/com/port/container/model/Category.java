package com.port.container.model;

public enum Category {
    IMPORTACAO("Importação"),
    EXPORTACAO("Exportação");

    private String descricao;

    Category(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
