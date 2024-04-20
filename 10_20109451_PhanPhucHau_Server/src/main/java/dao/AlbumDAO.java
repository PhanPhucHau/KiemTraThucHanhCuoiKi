package dao;

import java.rmi.Remote;
import java.util.Map;

public interface AlbumDAO extends Remote{
	public Map<String, Integer> getNumberOfAlbumByGenre();

}
