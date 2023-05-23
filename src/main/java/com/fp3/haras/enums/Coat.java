package com.fp3.haras.enums;

public enum Coat {

    BRANCA("Branca"),
    PRETA("Preta"),
    ALAZA("Alazã"),
    CASTANHA("Castanha"),
    BAIA("Baia"),
    PELO_DE_RATO("Pêlo de Rato"),
    TORDILHA("Tordilha"),
    ROSILHA("Rosilha"),
    LOBUNA("Lobuna"),
    RUAO("Ruão"),
    PAMPA("Pampa"),
    LEOPARDO("Leopardo"),
    MANTADO("Mantado"),
    NEVADO("Nevado");
    
    private String descricao;

    private Coat(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
