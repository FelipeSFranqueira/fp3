package com.fp3.haras.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StablesType")
public class TipoEstadia {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String tipo;
    private double preco;
    private boolean isDeleted = false;

    public TipoEstadia() {
    }

    public TipoEstadia(String tipo, double preco) {
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

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}