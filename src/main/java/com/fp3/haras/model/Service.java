package com.fp3.haras.model;

import com.fp3.haras.utils.EntityUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Services")
public class Service {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private boolean isDeleted = false;

    public Service() {
    }

    public Service(String nome, double preco) {
        this.name = nome;
        this.price = preco;
    }
    
    public static Service getServico(long id) {
        Service s = EntityUtils.select("SELECT c FROM Servico c WHERE id = " + id, Service.class).get(0);
        return s;
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
