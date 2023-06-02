package com.fp3.haras;

import com.fp3.haras.model.Cliente;
import com.fp3.haras.model.Produto;
import com.fp3.haras.utils.EntityUtils;
import com.fp3.haras.view.screens.auth.LoginScreen;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Haras {
    public static void main(String[] args) {
        new LoginScreen().setVisible(true);
        
        // Mock data for testing JPA
        Produto prod = new Produto("Test 2", 1, 1f, 1f);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("haras");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(prod);
        em.getTransaction().commit();
        
//        Cliente c1 = new Cliente();
//        Cliente c2 = new Cliente();
//        
//        c1.setNome("Teste1");
//        c2.setNome("Teste2");
//        
//        EntityUtils.insert(c1);
//        EntityUtils.insert(c2);
    }
}
