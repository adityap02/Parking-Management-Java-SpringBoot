package com.epam.parking.database;

import javax.persistence.EntityManager;

public interface DBOperations {

	void insert(EntityManager entityManager, Object obj);

	void delete(EntityManager entityManager, Object obj);

}
