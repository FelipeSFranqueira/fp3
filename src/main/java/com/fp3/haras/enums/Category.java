package com.fp3.haras.enums;

public enum Category {

    APPALOOSA("Appaloosa"),
    CAMPOLINA("Campolina"),
    BRETAO("Bretão"),
    LUSITANO("Lusitano"),
    MANGALARGA("Mangalarga"),
    NORDESTINO("Nordestino"),
    PAMPA("Pampa"),
    QUARTO_DE_MILHA("Quarto de Milha"),
    AKJAL_TEKE("Akhal-Teke");
    
    private String descricao;

    private Category(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
