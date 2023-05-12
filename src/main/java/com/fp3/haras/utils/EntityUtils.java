package com.fp3.haras.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EntityUtils {

    private static final EntityManagerFactory emf;
    
    static {
        try {
            emf = Persistence.createEntityManagerFactory("haras");
        }
        catch (Exception e) {
            throw new ExceptionInInitializerError("Falha ao inicializar o "
                    + "EntityManagerFactory: " + e.getMessage());
        }
    }

    public static void insert(Object entity) {
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();        
            em.persist(entity);        
            em.getTransaction().commit();        
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
        
    }
    
    public static void update(Object entity) {
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    
    public static <T> List<T> select(String query, Class<T> resultClass) {
        EntityManager em = emf.createEntityManager();
        
        try {
            return em.createQuery(query, resultClass).getResultList();
        } catch(Exception e) {
            throw e;
        } finally {
            em.close();
        }
        
    }
    
}