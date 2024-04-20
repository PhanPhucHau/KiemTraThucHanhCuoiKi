package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "albums")
public class Album implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2816238408422907456L;

	@Id
	@Column(name = "album_id")
	private String id;
	
	@Column(name = "title", unique = true, nullable = false)
	private String title;
	private double price;
	
	@Column(name = "year_of_release")
	private int yearOfRelease;
	
	@Column(name = "download_link")
	private String downloadLink;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "genre_id")
	private Genre genre;
	
	@ManyToMany
	@JoinTable(name = "albums_artists",joinColumns = @JoinColumn(name = "album_id"),
	               inverseJoinColumns = @JoinColumn(name = "artist_id"))
	private Set<Artist> artist_id = new HashSet<Artist>();

	@ManyToMany
	@JoinTable(name = "albums_songs",joinColumns = @JoinColumn(name = "album_id"),
	               inverseJoinColumns = @JoinColumn(name = "song_id"))
	private Set<Song> song_id = new HashSet<>();
	

	public Album() {
	}

	public Album(String id, String title, double price, int yearOfRelease, String downloadLink) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.yearOfRelease = yearOfRelease;
		this.downloadLink = downloadLink;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public String getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", price=" + price + ", yearOfRelease=" + yearOfRelease
				+ ", downloadLink=" + downloadLink + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
