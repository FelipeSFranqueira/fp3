package com.fp3.haras.model;

import java.time.LocalDateTime;
import java.util.List;

public class Estadia {

    private int id;
    private Animal cavalos;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private TipoDeEstadia tipoDeEstadia;
    private int cocheira;
    private List<Produto> produtos;
    private List<Servico> servico;

    public Estadia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal getCavalos() {
        return cavalos;
    }

    public void setCavalos(Animal cavalos) {
        this.cavalos = cavalos;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public TipoDeEstadia getTipoDeEstadia() {
        return tipoDeEstadia;
    }

    public void setTipoDeEstadia(TipoDeEstadia tipoDeEstadia) {
        this.tipoDeEstadia = tipoDeEstadia;
    }

    public int getCocheira() {
        return cocheira;
    }

    public void setCocheira(int cocheira) {
        this.cocheira = cocheira;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Servico> getServico() {
        return servico;
    }

    public void setServico(List<Servico> servico) {
        this.servico = servico;
    }
    
    
}
