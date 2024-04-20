package app;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dao.AlbumDAO;
import dao.SongDAO;

public class Client {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException{
		String URL = "rmi://192.168.1.28:2006/";
		AlbumDAO albumDAO = (AlbumDAO)Naming.lookup(URL + "albumDAO");
		SongDAO songDAO = (SongDAO)Naming.lookup(URL + "songDAO");
		
		songDAO.updateNameOfSong("1", "hau");
		songDAO.listSongByAlbum("tua", 2);
	//	albumDAO.getNumberOfAlbumByGenre().forEach(x -> System.out.println(x));
		
		
		System.out.print("Nhập được tính hiệu");
	}

}
