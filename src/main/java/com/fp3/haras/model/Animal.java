package com.fp3.haras.model;

import com.fp3.haras.enums.Pelagem;
import com.fp3.haras.enums.Sexo;
import java.util.List;

public class Animal {

    private long id;
    private List<Cliente> proprietarios;
    private String nome;
    private Pelagem pelagem;
    private Sexo sexo;
    private boolean hasExameAie;
    private boolean hasExameMormo;
    private boolean hasGta;
    private List<Estadia> estadias;
    private boolean isDeleted;

    public Animal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Cliente> getProprietarios() {
        return proprietarios;
    }

    public void setProprietarios(List<Cliente> proprietarios) {
        this.proprietarios = proprietarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pelagem getPelagem() {
        return pelagem;
    }

    public void setPelagem(Pelagem pelagem) {
        this.pelagem = pelagem;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public boolean getHasExameAie() {
        return hasExameAie;
    }

    public void setHasExameAie(boolean hasExameAie) {
        this.hasExameAie = hasExameAie;
    }

    public boolean getHasExameMormo() {
        return hasExameMormo;
    }

    public void setHasExameMormo(boolean hasExameMormo) {
        this.hasExameMormo = hasExameMormo;
    }

    public boolean getHasGta() {
        return hasGta;
    }

    public void setGta(boolean hasGta) {
        this.hasGta = hasGta;
    }

    public List<Estadia> getEstadias() {
        return estadias;
    }

    public void setEstadias(List<Estadia> estadias) {
        this.estadias = estadias;
    }
    
    public boolean getIsDeleted() {
        return isDeleted;
    }
    
    public void setIsDeleted() {
        this.isDeleted = isDeleted;
    }
}
