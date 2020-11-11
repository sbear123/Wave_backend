package bean;

public class SongBean {
	
	private int songId;
	private String title;
	private int artistId;
	private String artistName;
	private int mainGenreId;
	private String mainGenreName;
	private String subGenreName;
	private int subGenreId;
	private int albumId;
	private String albumName;
	private String songName;
	private String lyric;
	private String songUrl;
	private String gender;
	private int age;
	private String writer;
	private String jacket = "";
	
	public SongBean(){}
	
	public SongBean(int songid, String title, int artistid, int maingenreid, int subgenreid, int albumid, String songname, String songurl, String writer) {
		this.songId = songid;
		this.title = title;
		this.artistId = artistid;
		this.mainGenreId = maingenreid;
		this.subGenreId = subgenreid;
		this.albumId = albumid;
		this.songName = songname;
		this.lyric = null;
		this.songUrl = songurl;
		this.gender = null;
		this.age = 0;
		this.writer = writer;
		this.jacket = null;
	}
	
	public SongBean(int songid, String title, int artistid, int maingenreid, int subgenreid, int albumid, String songname, String lyric, String songurl, String writer) {
		this.songId = songid;
		this.title = title;
		this.artistId = artistid;
		this.mainGenreId = maingenreid;
		this.subGenreId = subgenreid;
		this.albumId = albumid;
		this.songName = songname;
		this.lyric = lyric;
		this.songUrl = songurl;
		this.gender = null;
		this.age = 0;
		this.writer = writer;
	}
	
	public SongBean(int songid, String title, int artistid, int maingenreid, int subgenreid, int albumid, String songname, String lyric, String songurl, String gender, int age, String writer) {
		this.songId = songid;
		this.title = title;
		this.artistId = artistid;
		this.mainGenreId = maingenreid;
		this.subGenreId = subgenreid;
		this.albumId = albumid;
		this.songName = songname;
		this.lyric = lyric;
		this.songUrl = songurl;
		this.gender = gender;
		this.age = age;
		this.writer = writer;
	}


	public int getSongid() {
		return songId;
	}


	public void setSongid(int songid) {
		this.songId = songid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getArtistid() {
		return artistId;
	}


	public void setArtistid(int artistid) {
		this.artistId = artistid;
	}


	public int getMaingenreid() {
		return mainGenreId;
	}


	public void setMaingenreid(int maingenreid) {
		this.mainGenreId = maingenreid;
	}


	public int getSubgenreid() {
		return subGenreId;
	}


	public void setSubgenreid(int subgenreid) {
		this.subGenreId = subgenreid;
	}


	public int getAlbumid() {
		return albumId;
	}


	public void setAlbumid(int albumid) {
		this.albumId = albumid;
	}


	public String getSongname() {
		return songName;
	}


	public void setSongname(String songname) {
		this.songName = songname;
	}


	public String getLyric() {
		return lyric;
	}


	public void setLyric(String lyric) {
		this.lyric = lyric;
	}


	public String getSongurl() {
		return songUrl;
	}

	public void setSongurl(String songurl) {
		this.songUrl = songurl;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public String getMaingenrename() {
		return mainGenreName;
	}

	public void setMaingenrename(String maingenrename) {
		this.mainGenreName = maingenrename;
	}

	public String getSubgenrename() {
		return subGenreName;
	}

	public void setSubgenrename(String subgenrename) {
		this.subGenreName = subgenrename;
	}

	public String getAlbumname() {
		return albumName;
	}

	public void setAlbumname(String albumname) {
		this.albumName = albumname;
	}
	
}