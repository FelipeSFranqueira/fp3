package com.fp3.haras.model;

public class Produto {

    private int id;
    private String nome;
    private int estoque;
    private double pdc;
    private double pdv;

    public Produto() {
    }

    public Produto(int id, String nome, int estoque, double pdc, double pdv) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.pdc = pdc;
        this.pdv = pdv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPdc() {
        return pdc;
    }

    public void setPdc(double pdc) {
        this.pdc = pdc;
    }

    public double getPdv() {
        return pdv;
    }

    public void setPdv(double pdv) {
        this.pdv = pdv;
    }
}