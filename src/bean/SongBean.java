package bean;

public class SongBean {
	
	private int songid;
	private String title;
	private int artistid;
	private int maingenreid;
	private int subgenreid;
	private int albumid;
	private String songname;
	private String lyric;
	private String songurl;
	private String gender;
	private int age;
	private String writer;
	
	
	public SongBean(){}
	
	public SongBean(int songid, String title, int artistid, int maingenreid, int subgenreid, int albumid, String songname, String lyric, String songurl, String writer) {
		this.albumid = albumid;
		this.artistid = artistid;
		this.maingenreid = maingenreid;
		this.songid = songid;
		this.songname = songname;
		this.songurl = songurl;
		this.subgenreid = subgenreid;
		this.title = title;
		this.writer = writer;
	}
	
	public SongBean(int songid, String title, int artistid, int maingenreid, int subgenreid, int albumid, String songname, String lyric, String songurl, String gender, int age, String writer) {
		this.age = age;
		this.albumid = albumid;
		this.artistid = artistid;
		this.gender = gender;
		this.lyric = lyric;
		this.maingenreid = maingenreid;
		this.songid = songid;
		this.songname = songname;
		this.songurl = songurl;
		this.subgenreid = subgenreid;
		this.title = title;
		this.writer = writer;
	}


	public int getSongid() {
		return songid;
	}


	public void setSongid(int songid) {
		this.songid = songid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getArtistid() {
		return artistid;
	}


	public void setArtistid(int artistid) {
		this.artistid = artistid;
	}


	public int getMaingenreid() {
		return maingenreid;
	}


	public void setMaingenreid(int maingenreid) {
		this.maingenreid = maingenreid;
	}


	public int getSubgenreid() {
		return subgenreid;
	}


	public void setSubgenreid(int subgenreid) {
		this.subgenreid = subgenreid;
	}


	public int getAlbumid() {
		return albumid;
	}


	public void setAlbumid(int albumid) {
		this.albumid = albumid;
	}


	public String getSongname() {
		return songname;
	}


	public void setSongname(String songname) {
		this.songname = songname;
	}


	public String getLyric() {
		return lyric;
	}


	public void setLyric(String lyric) {
		this.lyric = lyric;
	}


	public String getSongurl() {
		return songurl;
	}

	public void setSongurl(String songurl) {
		this.songurl = songurl;
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
}