package com.fp3.haras.model;

import com.fp3.haras.utils.EntityUtils;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String telefone;
    private String email;
    private String documento;
    private String endereco;
    
    @ManyToMany(mappedBy = "owners")
    private List<Animal> animais;
    private boolean isDeleted = false;

    public Cliente() {
    }
    
    public Cliente(String nome,String telefone,String email,String documento,String endereco) {
        this.nome = nome;
        this.nome = telefone;
        this.nome = email;
        this.nome = documento;
        this.nome = endereco;
    }
        public static Cliente getCliente(long id) {
        Cliente c = EntityUtils.select("SELECT c FROM Cliente c WHERE id = " + id, Cliente.class).get(0);
        return c;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }
    
    public boolean getIsDeleted() {
        return isDeleted;
    }
    
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isIsDeleted() {
      return isDeleted;  
    }
}