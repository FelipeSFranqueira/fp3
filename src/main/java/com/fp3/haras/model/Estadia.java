package com.fp3.haras.model;

import java.sql.Timestamp;
import java.util.List;

public class Estadia {

    private long id;
    private Animal animais;
    private Timestamp entrada;
    private Timestamp saida;
    private TipoEstadia tipoEstadia;
    private int cocheira;
    private List<Produto> produtos;
    private List<Servico> servico;
    private boolean isCancelled;

    public Estadia() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Animal getAnimais() {
        return animais;
    }

    public void setAnimais(Animal animais) {
        this.animais = animais;
    }

    public Timestamp getEntrada() {
        return entrada;
    }

    public void setEntrada(Timestamp entrada) {
        this.entrada = entrada;
    }

    public Timestamp getSaida() {
        return saida;
    }

    public void setSaida(Timestamp saida) {
        this.saida = saida;
    }

    public TipoEstadia getTipoEstadia() {
        return tipoEstadia;
    }

    public void setTipoEstadia(TipoEstadia tipoEstadia) {
        this.tipoEstadia = tipoEstadia;
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
    
    public boolean getIsCancelled() {
        return isCancelled;
    }
    
    public void setIsCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
}
