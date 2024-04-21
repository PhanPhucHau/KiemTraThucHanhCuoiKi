package app;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import dao.SongDao;
import entities.Song;
import jakarta.persistence.EntityManager;
import service.EntityManagerFactoryUntil;
import service.SongService;

public class ServerRMI {
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
	
		// registry port
	Registry registry = LocateRegistry.createRegistry(2005);
	EntityManagerFactoryUntil entityManagerFactoryUntil = new EntityManagerFactoryUntil();
	EntityManager entityManager = entityManagerFactoryUntil.getEntityManager();
	
	SongDao songDao = new SongService(entityManager);
	registry.bind("songDao", songDao);
	System.out.println("Server ready");
		
		
	}
}
