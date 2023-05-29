package com.fp3.haras.enums;

public enum Sex {
    
    MACHO("Macho"),
    FEMEA("Femea");
    
    private String descricao;

    private Sex(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}