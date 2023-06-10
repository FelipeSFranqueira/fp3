package com.fp3.haras.model;

import com.fp3.haras.utils.EntityUtils;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Cocheiras")
@Table(name="Stable")
public class Estadia implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @OneToOne
    @JoinTable(
        name = "StableXAnimal",
        joinColumns = @JoinColumn(name = "stable_id"),
        inverseJoinColumns = @JoinColumn(name = "animal_id")
    )
    private Animal animal;
    
    @OneToOne
    @JoinTable(
        name = "StableXTipoEstadia",
        joinColumns = @JoinColumn(name = "stable_id"),
        inverseJoinColumns = @JoinColumn(name = "TipoEstadia_id")
    )
    private TipoEstadia tipoEstadia;
    
    @ManyToMany
    @JoinTable(
        name = "consumo",
        joinColumns = @JoinColumn(name = "stable_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;
    
    @ManyToMany
    @JoinTable(
        name = "consumo",
        joinColumns = @JoinColumn(name = "stable_id"),
        inverseJoinColumns = @JoinColumn(name = "servico_id")
    )
    private List<Servico> servico;
    
    private boolean isCancelled;
    private Timestamp entrada;
    private Timestamp saida;
    private String cocheira;

    public Estadia() {
    }
    
    public Estadia(Animal animal, Timestamp entrada, 
    Timestamp saida, String cocheira, TipoEstadia tipoEstadia, boolean isCancelled) {
        this.animal = animal;
        this.entrada = entrada;
        this.saida = saida;
        this.isCancelled = isCancelled;
        this.cocheira = cocheira;
        this.tipoEstadia = tipoEstadia;
    }
    
    public static Object getState(long id) {
        Date now = new Date();
        Date n = new Date(now.getTime());
        Object result = null;
        Estadia e = getEstadia(id);
        
        if (String.valueOf(e.getId()) != null) {
            if (e.getEntrada().before(n) && e.getSaida().before(n)) {
                result = "FINALIZADA";
                
            } else if (e.getSaida().after(n) && (e.getEntrada().before(n) || e.getEntrada().equals(n))) {
                result = "ATIVA";

            } else if (e.getEntrada().after(n) && !e.getIsCancelled()) {
                result = "FUTURA";
            }
        }
        
        if (result == null)
            throw new RuntimeException("ERRO AO VERIFICAR STATUS DA ESTADIA");
            
        return result;
    }
    
    public static Estadia getEstadia(long id) {
        Estadia e = EntityUtils.select("SELECT c FROM Cocheiras c WHERE Id = " + id, Estadia.class).get(0);
        return e;
    }
    
    public double getConsumoTotal() {
        double total = 0;
        double sum = 0;
        TipoEstadia e = EntityUtils.select("SELECT c FROM TipoEstadia c WHERE id = " + getTipoEstadia().getId(), TipoEstadia.class).get(0);
        String query = "SELECT c FROM Consumo c WHERE stable_id = " + id;
        List<Consumo> consumo = EntityUtils.select(query, Consumo.class);
        
        for (Consumo c : consumo) {
            if (c.getProduto() != null || c.getServico() != null) {
                double price;
                if (c.getProduto() != null)
                    price = c.getProduto().getPdv();
                else
                    price = c.getServico().getPrice();
                sum += (price * c.getQtd());  
            } else {
                break;
            }
        }
        total += (sum + e.getPrice());
        
        return total;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
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

    public String getCocheira() {
        return cocheira;
    }

    public void setCocheira(String cocheira) {
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