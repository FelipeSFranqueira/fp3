package com.fp3.haras.model;

import java.util.List;

public class Cavalo {

    private int registro;
    private List<Cliente> proprietarios;
    private String nome;
    private String pelagem;
    private String sexo;
    private String exameAie;
    private String exameMormo;
    private String gta;
    private List<Estadia> estadias;

    public Cavalo() {
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
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

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getExameAie() {
        return exameAie;
    }

    public void setExameAie(String exameAie) {
        this.exameAie = exameAie;
    }

    public String getExameMormo() {
        return exameMormo;
    }

    public void setExameMormo(String exameMormo) {
        this.exameMormo = exameMormo;
    }

    public String getGta() {
        return gta;
    }

    public void setGta(String gta) {
        this.gta = gta;
    }

    public List<Estadia> getEstadias() {
        return estadias;
    }

    public void setEstadias(List<Estadia> estadias) {
        this.estadias = estadias;
    }
}
