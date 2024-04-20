package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import dao.AlbumDAO;
import dao.SongDAO;
import entities.Song;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class AlbumService extends UnicastRemoteObject implements AlbumDAO{
	
	private EntityManager entityManager;

	public  AlbumService(EntityManager entityManager) throws RemoteException {
		this.entityManager= entityManager;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Map<String, Integer> getNumberOfAlbumByGenre() {
		 try {
		        // Truy vấn cơ sở dữ liệu để thống kê số album cho mỗi thể loại
		        String queryString = "SELECT g.name, COUNT(a) FROM Genre g LEFT JOIN g.albums a GROUP BY g.name";
		        TypedQuery<Object[]> query = entityManager.createQuery(queryString, Object[].class);
		        List<Object[]> resultList = query.getResultList();

		        // Tạo một Map để lưu trữ kết quả
		        Map<String, Integer> numberOfAlbumsByGenre = new TreeMap<>();
		        // Duyệt qua kết quả và đưa vào Map
		        for (Object[] result : resultList) {
		            String genreName = (String) result[0];
		            Long albumCount = (Long) result[1];
		            numberOfAlbumsByGenre.put(genreName, albumCount.intValue());
		        }
		        return numberOfAlbumsByGenre;
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null;
		    }
	}


}
