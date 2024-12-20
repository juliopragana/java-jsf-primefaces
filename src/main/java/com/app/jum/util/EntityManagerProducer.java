package com.app.jum.util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory;

	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("AppsPU");
	}

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		System.out.println("EntityManager criado!");
		return factory.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}
