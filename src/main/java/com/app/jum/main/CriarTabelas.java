package com.app.jum.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CriarTabelas {
	
	public static void main(String[] args) {
		try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppsPU");
            EntityManager em = emf.createEntityManager();
            System.out.println("EntityManager criado com sucesso!");

            // Feche o EntityManager e o EntityManagerFactory
            em.close();
            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
