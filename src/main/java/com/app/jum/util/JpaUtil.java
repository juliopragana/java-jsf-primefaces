package com.app.jum.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("AppsPU");
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
