package com.fp3.haras.model;

import java.util.List;

public class Cliente {

    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String documento;
    private String endereco;
    private List<Animal> cavalos;

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Animal> getCavalos() {
        return cavalos;
    }

    public void setCavalos(List<Animal> cavalos) {
        this.cavalos = cavalos;
    }
}