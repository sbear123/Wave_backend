package bean;

public class AlbumBean {
	private int albumId;
	private String albumName;
	private String jacket = "";
	private int aritstId;
	private String artistName;
	
	public AlbumBean() {}
	
	public AlbumBean(int albumid, String albumname) {
		this.albumId = albumid;
		this.albumName = albumname;
	}

	public int getAlbumid() {
		return albumId;
	}

	public void setAlbumid(int albumid) {
		this.albumId = albumid;
	}

	public String getAlbumname() {
		return albumName;
	}

	public void setAlbumname(String albumname) {
		this.albumName = albumname;
	}

	public String getJacket() {
		return jacket;
	}

	public void setJacket(String jacket) {
		this.jacket = jacket;
	}

	public String getArtistname() {
		return artistName;
	}

	public void setArtistname(String artistname) {
		this.artistName = artistname;
	}

	public int getAritstid() {
		return aritstId;
	}

	public void setAritstid(int aritstid) {
		this.aritstId = aritstid;
	}
	
}
