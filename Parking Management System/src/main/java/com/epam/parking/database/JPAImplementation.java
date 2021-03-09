package com.epam.parking.database;

import javax.persistence.EntityManager;

public class JPAImplementation implements DBOperations {
	@Override
	public void insert(EntityManager entityManager, Object obj) {
		entityManager.getTransaction().begin();

		try {

			entityManager.persist(obj);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();

		}

	}

	@Override
	public void delete(EntityManager entityManager, Object obj) {
		entityManager.getTransaction().begin();

		try {

			entityManager.remove(obj);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();

		}

	}

}
