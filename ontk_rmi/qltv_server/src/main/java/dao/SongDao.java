package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.Song;

public interface SongDao extends Remote{
	public boolean update (String song_id , String newName) throws RemoteException ;
	public List<Song> listSongsByAlbum(String albumTitle, int yearOfRelease) throws RemoteException;
}
