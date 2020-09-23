package bean;

public class AlbumBean {
	private int albumid;
	private String albumname;
	private String jacket;
	private int aritstid;
	private String artistname;
	
	public AlbumBean() {}
	
	public AlbumBean(int albumid, String albumname) {
		this.albumid = albumid;
		this.albumname = albumname;
	}

	public int getAlbumid() {
		return albumid;
	}

	public void setAlbumid(int albumid) {
		this.albumid = albumid;
	}

	public String getAlbumname() {
		return albumname;
	}

	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}

	public String getJacket() {
		return jacket;
	}

	public void setJacket(String jacket) {
		this.jacket = jacket;
	}

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}

	public int getAritstid() {
		return aritstid;
	}

	public void setAritstid(int aritstid) {
		this.aritstid = aritstid;
	}
	
}
