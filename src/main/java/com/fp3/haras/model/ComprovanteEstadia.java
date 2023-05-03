package com.fp3.haras.model;

import java.security.Timestamp;

public class ComprovanteEstadia {

    private int id;
    private Timestamp dataRecebimentoAnimal;
    private Timestamp dataEntregaAnimal;
    private Animal animal;
    private Cliente cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}