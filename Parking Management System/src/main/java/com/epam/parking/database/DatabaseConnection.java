package com.epam.parking.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseConnection {
	EntityManagerFactory eFactory = Persistence.createEntityManagerFactory("my-local-db");
	public EntityManager getEntityManager() {
		return eFactory.createEntityManager();
		
	}

}
