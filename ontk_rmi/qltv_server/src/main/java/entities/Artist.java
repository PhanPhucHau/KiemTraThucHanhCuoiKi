package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artists")
public class Artist implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8612012325750551291L;
	@Id
	@Column(name = "artist_id")
	private String id ;
	private String name ; 
	@Column(name = "birth_date")
	private LocalDate birthDate;
	private String url ;
	@ManyToMany(mappedBy = "artists")
	private Set<Album> albums = new HashSet();
	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Artist(String id, String name, LocalDate birthDate, String url, Set<Album> albums) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.url = url;
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
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
		return "Artist [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", url=" + url + ", albums="
				+ albums + "]";
	}
	
}
