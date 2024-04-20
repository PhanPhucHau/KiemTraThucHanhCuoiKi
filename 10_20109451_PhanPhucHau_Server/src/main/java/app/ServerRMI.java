package app;

import java.nio.channels.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import jakarta.persistence.EntityManager;
import dao.AlbumDAO;
import dao.SongDAO;
import service.*;


public class ServerRMI {
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		
		Registry registry = LocateRegistry.createRegistry(2001);
		EntityManagerFactoryUtil entityManagerFactoryUtil = new EntityManagerFactoryUtil();
		EntityManager entityManager = entityManagerFactoryUtil.getEntityManager();
		
//		SongDAO songDAO = new SongService(entityManager);
//		AlbumDAO albumDAO = new AlbumService(entityManager);
//		registry.bind("songDAO", songDAO);
//		registry.bind("albumDAO", albumDAO);
		System.out.println("RMI Server ready");
		
		
	}

}
