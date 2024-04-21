package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "songs")
public class Song  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8435848840283522464L;
	@Id
	@Column(name = "song_id")
	private String id ;
	private String name ;
	private String runtime ;
	private String lyric ;
	@Column(name = "file_link")
	private String fileLink;
	@ManyToMany(mappedBy = "songs")
	private Set<Album> albums = new HashSet();
	
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Song(String id, String name, String runtime, String lyric, String fileLink, Set<Album> albums) {
		super();
		this.id = id;
		this.name = name;
		this.runtime = runtime;
		this.lyric = lyric;
		this.fileLink = fileLink;
		this.albums = albums;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public String getFileLink() {
		return fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", runtime=" + runtime + ", lyric=" + lyric + ", fileLink="
				+ fileLink +  "]";
	}
	
}
