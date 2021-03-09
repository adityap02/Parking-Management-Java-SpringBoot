package com.epam.parking.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConnection {
	EntityManager entityManager;
	EntityManagerFactory eFactory = Persistence.createEntityManagerFactory("my-local-db");
	
	public EntityManager getEntity() {
		return eFactory.createEntityManager();
	}
}
