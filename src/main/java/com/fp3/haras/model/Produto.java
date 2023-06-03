package com.fp3.haras.model;

import com.fp3.haras.utils.EntityUtils;
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
    private String name;
    private int stock;
    private double pdc;
    private double pdv;
    private boolean isDeleted = false;

    public Produto() {
    }

    public Produto(String nome, int estoque, double pdc, double pdv) {
        this.name = nome;
        this.stock = estoque;
        this.pdc = pdc;
        this.pdv = pdv;
    }
    
    public static Produto getProduto(long id) {
        Produto p = EntityUtils.select("SELECT c FROM Produto c WHERE id = " + id, Produto.class).get(0);
        return p;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
    
    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}