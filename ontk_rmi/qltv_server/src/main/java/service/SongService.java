package service;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.SongDao;
import entities.Song;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class SongService extends UnicastRemoteObject implements SongDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager ;
	
	

	

	public SongService(EntityManager entityManager) throws RemoteException {
		super();
		this.entityManager = entityManager;
	}





	@Override
	public boolean update(String song_id, String newName) throws RemoteException {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Song song = entityManager.find(Song.class, song_id);
			if (song!= null) {
				song.setName(newName);
				entityManager.merge(song);
				transaction.commit();
				return true;
			}else {
				transaction.rollback();
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction.isActive()) {
				transaction.rollback();
				return false;
			}
		}
	return false;
	}





	@Override
	public List<Song> listSongsByAlbum(String albumTitle, int yearOfRelease) throws RemoteException {
		// TODO Auto-generated method stub
//	
		 List<Song> songs = new ArrayList<>();

		    try {
		        // Bắt đầu giao dịch
		        EntityTransaction trans = entityManager.getTransaction();
		        trans.begin();

		        // Tạo truy vấn JPQL để lấy các bài hát thuộc album có tiêu đề và năm phát hành chỉ định
		        String jpql = "SELECT s FROM Album a JOIN a.songs s WHERE a.title LIKE :albumTitle AND a.yearOfRelease = :yearOfRelease";
		        Query query = entityManager.createQuery(jpql, Song.class);
		        query.setParameter("albumTitle", "%" + albumTitle + "%"); // Tìm kiếm tương đối
		        query.setParameter("yearOfRelease", yearOfRelease);

		        // Thực hiện truy vấn và lấy danh sách kết quả
		        songs = query.getResultList();

		        // Commit giao dịch
		        trans.commit();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return songs;
	}
	
}
