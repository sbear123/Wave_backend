package bean;

public class ArtistBean {
	private int aritstId;
	private String artistName;
	
	public ArtistBean() {}
	
	public ArtistBean(int artistid, String artistname) {
		this.aritstId = artistid;
		this.artistName = artistname;
	}

	public int getAritstid() {
		return aritstId;
	}

	public void setAritstid(int aritstid) {
		this.aritstId = aritstid;
	}

	public String getArtistname() {
		return artistName;
	}

	public void setArtistname(String artistname) {
		this.artistName = artistname;
	}
	
}
