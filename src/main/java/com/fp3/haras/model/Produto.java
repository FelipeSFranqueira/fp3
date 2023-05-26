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
    private long id;
    private String nome;
    private int estoque;
    private double pdc;
    private double pdv;

    public Produto() {
    }

    public Produto(Integer id, String nome, int estoque, double pdc, double pdv) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.pdc = pdc;
        this.pdv = pdv;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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