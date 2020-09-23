package bean;

public class ArtistBean {
	private int aritstid;
	private String artistname;
	
	public ArtistBean() {}
	
	public ArtistBean(int artistid, String artistname) {
		this.aritstid = artistid;
		this.artistname = artistname;
	}

	public int getAritstid() {
		return aritstid;
	}

	public void setAritstid(int aritstid) {
		this.aritstid = aritstid;
	}

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}
	
}
