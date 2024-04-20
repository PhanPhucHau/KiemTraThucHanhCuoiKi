package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.SongDAO;
import entities.Song;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class SongService extends UnicastRemoteObject implements SongDAO{

	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;
	public  SongService(EntityManager entityManager) throws RemoteException {
		this.entityManager = entityManager;
	}
	

	@Override
	public boolean updateNameOfSong(String id, String newName) {
		   try {
		        entityManager.getTransaction().begin();
		        Song song = entityManager.find(Song.class, id);
		        if (song != null) {
		            song.setName(newName);
		            entityManager.getTransaction().commit();
		            return true;
		        } else {
		            System.out.println("Song with ID " + id + " not found.");
		            return false;
		        }
		    } catch (Exception e) {
		        if (entityManager.getTransaction().isActive()) {
		            entityManager.getTransaction().rollback();
		        }
		        e.printStackTrace();
		        return false;
		    }
	}

	@Override
	public List<Song> listSongByAlbum(String title, int year) {
		  try {
		        // Truy vấn cơ sở dữ liệu để lấy danh sách các bài hát
		        String queryString = "SELECT s FROM Song s JOIN s.albums a WHERE a.title LIKE :title AND a.yearOfRelease = :year";
		        TypedQuery<Song> query = entityManager.createQuery(queryString, Song.class);
		        query.setParameter("title", "%" + title + "%");
		        query.setParameter("year", year);
		        List<Song> songs = query.getResultList();
		        return songs;
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null;
		    }
	}
	

}
