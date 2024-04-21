package app;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Iterator;
import java.util.List;

import dao.SongDao;
import entities.Song;

public class Client {
  public static void main(String[] args) throws RemoteException, NotBoundException {
	  Registry registry = LocateRegistry.getRegistry("192.168.1.28",2005);
	  SongDao songDao = (SongDao) registry.lookup("songDao");
	  
	  
//	  Song song = new Song();
//	  song.setId("S1");
//	  song.setName("Solid");
//	  songDao.update(song.getId(), song.getName());
	  
	
	  List<Song> songs =   songDao.listSongsByAlbum("eee", 2000);
	  for (Song song2 : songs) {
		 System.out.println(song2);
	}
}
  
}
