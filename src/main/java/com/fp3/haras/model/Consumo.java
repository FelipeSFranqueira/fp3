package com.fp3.haras.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consumo")
public class Consumo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "stable_id")
    private Estadia estadia;
    
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
    
    private int qtd;
    
    public Consumo() {
    }
    
    public Consumo(Estadia estadia, Produto produto, int qtd) {
        this.estadia = estadia;
        this.produto = produto;
        this.qtd = qtd;
    }
    
    public Consumo(Estadia estadia, Servico servico, int qtd) {
        this.estadia = estadia;
        this.servico = servico;
        this.qtd = qtd;
    }
    
    public long getId() {
        return id;
    }
    
    public Estadia getEstadia() {
        return estadia;
    }
    
    public void setEstadia(Estadia estadia) {
        this.estadia = estadia;
    }
    
    public Produto getProduto() {
        return produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public Servico getServico() {
        return servico;
    }
    
    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
    public int getQtd() {
        return qtd;
    }
    
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
