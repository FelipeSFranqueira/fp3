package com.fp3.haras.model;

import java.sql.Timestamp;

public class EstadiaComprovante {

    private long id;
    private Timestamp dataRecebimentoAnimal;
    private Timestamp dataEntregaAnimal;
    private Animal animal;
    private Client cliente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getDataRecebimentoAnimal() {
        return dataRecebimentoAnimal;
    }

    public void setDataRecebimentoAnimal(Timestamp dataRecebimentoAnimal) {
        this.dataRecebimentoAnimal = dataRecebimentoAnimal;
    }

    public Timestamp getDataEntregaAnimal() {
        return dataEntregaAnimal;
    }

    public void setDataEntregaAnimal(Timestamp dataEntregaAnimal) {
        this.dataEntregaAnimal = dataEntregaAnimal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }
}