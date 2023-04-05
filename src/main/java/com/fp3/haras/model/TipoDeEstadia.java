package com.fp3.haras.model;

public class TipoDeEstadia {

    private int id;
    private String tipo;
    private float preco;

    public TipoDeEstadia() {
    }

    public TipoDeEstadia(int id, String tipo, float preco) {
        this.id = id;
        this.tipo = tipo;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
