package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUntil {
	private EntityManagerFactory entityManagerFactory ;
	private EntityManager entityManager ;
	public EntityManagerFactoryUntil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("qltb_hil");
		entityManager = entityManagerFactory.createEntityManager();
	}
	public EntityManager getEntityManager () {
		return entityManager ;
	}
	public void closeEntityManager() {
		entityManager.close();
	}
	public void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
}
