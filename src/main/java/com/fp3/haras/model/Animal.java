package com.fp3.haras.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToMany
    @JoinTable(
        name = "OwnerXAnimal",
        joinColumns = @JoinColumn(name = "animal_id"),
        inverseJoinColumns = @JoinColumn(name = "owner_id")
    )
    private List<Cliente> owners = new ArrayList<>();
    
    private String name;
    private String coat;
    private String sex;
    private String category;
    private String origin;
    private boolean hasExamAie;
    private boolean hasExamMormo;
    private boolean hasGta;
    private boolean isDeleted;

    public Animal(String name, String coat, String sex, String category, String origin, boolean hasExamAie, boolean hasExamMormo, boolean hasGta) {
        this.name = name;
        this.coat = coat;
        this.sex = sex;
        this.category = category;
        this.origin = origin;
        this.hasExamAie = hasExamAie;
        this.hasExamMormo = hasExamMormo;
        this.hasGta = hasGta;
    }

    public Animal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Cliente> getOwners() {
        return owners;
    }

    public void setOwners(List<Cliente> owners) {
        this.owners = owners;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoat() {
        return coat;
    }

    public void setCoat(String coat) {
        this.coat = coat;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean getHasExameAie() {
        return hasExamAie;
    }

    public void setHasExamAie(boolean hasExamAie) {
        this.hasExamAie = hasExamAie;
    }

    public boolean getHasExameMormo() {
        return hasExamMormo;
    }

    public void setHasExamMormo(boolean hasExamMormo) {
        this.hasExamMormo = hasExamMormo;
    }

    public boolean getHasGta() {
        return hasGta;
    }

    public void setGta(boolean hasGta) {
        this.hasGta = hasGta;
    }
    
    public boolean getIsDeleted() {
        return isDeleted;
    }
    
    public void setIsDeleted() {
        this.isDeleted = isDeleted;
    }
}
