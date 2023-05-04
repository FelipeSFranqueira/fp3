package com.fp3.haras.model;

public class TipoEstadia {

    private long id;
    private String tipo;
    private double preco;

    public TipoEstadia() {
    }

    public TipoEstadia(long id, String tipo, double preco) {
        this.id = id;
        this.tipo = tipo;
        this.preco = preco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}