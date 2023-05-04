package com.fp3.haras.enums;

public enum Sexo {
    
    MACHO("Macho"),
    FEMEA("Femea");
    
    private String descricao;

    private Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}