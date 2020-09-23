package bean;

import java.util.List;

public class SearchBean {
	private List<ArtistBean> artist;
	private List<AlbumBean> album;
	private List<SongBean> song;
	
	public SearchBean() {
		this.artist = null;
		this.album = null;
		this.song = null;
	}

	public List<ArtistBean> getArtist() {
		return artist;
	}

	public void setArtist(List<ArtistBean> artist) {
		this.artist = artist;
	}

	public List<AlbumBean> getAlbum() {
		return album;
	}

	public void setAlbum(List<AlbumBean> album) {
		this.album = album;
	}

	public List<SongBean> getSong() {
		return song;
	}

	public void setSong(List<SongBean> song) {
		this.song = song;
	}
	
}
