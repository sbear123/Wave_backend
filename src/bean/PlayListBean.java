package bean;

import java.util.List;

public class PlayListBean {
	
	private int playlistid;
	private String userid;
	private String date;
	private String title;
	private String jacket;
	
	private List<SongBean> song;
	private String maingenre;
	private String subgenre;
	
	public PlayListBean() {}
		
	public PlayListBean(int playlistid, String userid, String date, String title, List<SongBean> songs, String subgenre, String maingenre) {
		this.playlistid = playlistid;
		this.userid = userid;
		this.date = date;
		this.title = title;
		this.jacket = songs.get(0).getJacket();
		this.song = songs;
		this.maingenre = maingenre;
		this.subgenre = subgenre;
	}
	
	public PlayListBean(int playlistid, String title, String jacket, String maingenre, String subgenre) {
		this.playlistid = playlistid;
		this.title = title;
		this.jacket = jacket;
		this.maingenre = maingenre;
		this.subgenre = subgenre;
	}
	
	public PlayListBean(int playlistid) {
		this.playlistid = playlistid;
	}

	public String getMaingenre() {
		return maingenre;
	}

	public void setMaingenre(String maingenre) {
		this.maingenre = maingenre;
	}

	public int getPlaylistid() {
		return playlistid;
	}

	public void setPlaylistid(int playlistid) {
		this.playlistid = playlistid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<SongBean> getSongs() {
		return song;
	}

	public void setSongs(List<SongBean> songs) {
		this.song = songs;
	}

	public String getSubgenre() {
		return subgenre;
	}

	public void setSubgenre(String subgenre) {
		this.subgenre = subgenre;
	}

	public String getJacket() {
		return jacket;
	}

	public void setJacket(String jacket) {
		this.jacket = jacket;
	}
	
}
