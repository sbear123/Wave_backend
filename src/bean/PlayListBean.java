package bean;

import java.util.List;

public class PlayListBean {
	
	private int listId;
	private String userId;
	private String date;
	private String listName;
	private String jacket;
	
	private List<SongBean> song;
	private String mainGenre;
	private String subGenre;
	
	public PlayListBean() {}
		
	public PlayListBean(int playlistid, String userid, String date, String title, List<SongBean> songs, String subgenre, String maingenre) {
		this.listId = playlistid;
		this.userId = userid;
		this.date = date;
		this.listName = title;
		this.jacket = songs.get(0).getJacket();
		this.song = songs;
		this.mainGenre = maingenre;
		this.subGenre = subgenre;
	}
	
	public PlayListBean(int playlistid, String title, String jacket, String maingenre, String subgenre) {
		this.listId = playlistid;
		this.listName = title;
		this.jacket = jacket;
		this.mainGenre = maingenre;
		this.subGenre = subgenre;
	}
	
	public PlayListBean(int playlistid) {
		this.listId = playlistid;
	}

	public String getMaingenre() {
		return mainGenre;
	}

	public void setMaingenre(String maingenre) {
		this.mainGenre = maingenre;
	}

	public int getPlaylistid() {
		return listId;
	}

	public void setPlaylistid(int playlistid) {
		this.listId = playlistid;
	}

	public String getUserid() {
		return userId;
	}

	public void setUserid(String userid) {
		this.userId = userid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return listName;
	}

	public void setTitle(String title) {
		this.listName = title;
	}

	public List<SongBean> getSongs() {
		return song;
	}

	public void setSongs(List<SongBean> songs) {
		this.song = songs;
	}

	public String getSubgenre() {
		return subGenre;
	}

	public void setSubgenre(String subgenre) {
		this.subGenre = subgenre;
	}

	public String getJacket() {
		return jacket;
	}

	public void setJacket(String jacket) {
		this.jacket = jacket;
	}
	
}
