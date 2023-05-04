package com.fp3.haras.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Produto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int estoque;
    private float precoCusto ;
    private float precoVenda;

    public Produto() {
    }

    public Produto(String nome, int estoque, float presoCusto, float precoVenda) {
        this.nome = nome;
        this.estoque = estoque;
        this.precoCusto = presoCusto;
        this.precoVenda = precoVenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public float getPresoCusto() {
        return precoCusto;
    }

    public void setPresoCusto(float presoCusto) {
        this.precoCusto = presoCusto;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }
}
