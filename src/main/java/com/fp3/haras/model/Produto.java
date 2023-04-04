package com.fp3.haras.model;

public class Produto {

    private int id;
    private String nome;
    private String estoque;
    private float presoCusto;
    private float precoVenda;

    public Produto() {
    }

    public Produto(int id, String nome, String estoque, float presoCusto, float precoVenda) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.presoCusto = presoCusto;
        this.precoVenda = precoVenda;
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

    public String getEstoque() {
        return estoque;
    }

    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }

    public float getPresoCusto() {
        return presoCusto;
    }

    public void setPresoCusto(float presoCusto) {
        this.presoCusto = presoCusto;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }
}
