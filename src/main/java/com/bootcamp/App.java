package com.bootcamp;

import java.util.Properties;
import javax.persistence.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Persistence.generateSchema("com.bootcamp_TpJPA", new Properties());
        Persistence.generateSchema("tpJpa", new Properties());

        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bootcamp_TpJPA");
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("tpJpa");
        EntityManager em = emf.createEntityManager();
        Bailleur bailleur = new Bailleur();
        bailleur.setNom("toto");
        bailleur.setTypeDeBailleur(TypeDeBailleur.privé);
        em.getTransaction().begin();
        em.persist(bailleur);
        em.getTransaction().commit();
         */
    }
}
