package com.fp3.haras.model;

import com.fp3.haras.utils.EntityUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="TipoEstadia")
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
    
    public static TipoEstadia getTipoEstadia(long id) {
        TipoEstadia e = EntityUtils.select("SELECT c FROM TipoEstadia c WHERE Id = " + id, TipoEstadia.class).get(0);
        return e;
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