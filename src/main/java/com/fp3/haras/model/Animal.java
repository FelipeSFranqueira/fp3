package com.fp3.haras.model;

import com.fp3.haras.enums.Category;
import com.fp3.haras.enums.Coat;
import com.fp3.haras.enums.Sex;
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
        joinColumns = @JoinColumn(name = "owners_id"),
        inverseJoinColumns = @JoinColumn(name = "animals_id")
    )
    private List<Cliente> owners;
    
    private String name;
    private Coat coat;
    private Sex sex;
    private Category category;
    private String origin;
    private boolean hasExamAie;
    private boolean hasExamMormo;
    private boolean hasGta;
    private boolean isDeleted;

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

    public Coat getCoat() {
        return coat;
    }

    public void setCoat(Coat coat) {
        this.coat = coat;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public void setCategory() {
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
