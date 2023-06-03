package com.fp3.haras.model;

import com.fp3.haras.utils.EntityUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StablesType")
public class StableType {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String type;
    private double price;
    private boolean isDeleted = false;

    public StableType() {
    }

    public StableType(String tipo, double preco) {
        this.type = tipo;
        this.price = preco;
    }
    
    public static StableType getTipoEstadia(long id) {
        StableType e = EntityUtils.select("SELECT c FROM TipoEstadia c WHERE id = " + id, StableType.class).get(0);
        return e;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}