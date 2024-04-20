package service;

import org.hibernate.dialect.lock.PessimisticForceIncrementLockingStrategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public EntityManagerFactoryUtil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("school_server");
		entityManager = entityManagerFactory.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void closEntityManager() {
		entityManager.close();
	}
	
	public void closEntityManagerFactory() {
		entityManagerFactory.close();
	}


	
	

}
