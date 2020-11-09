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
	private int mainGenreId;
	private String subGenre;
	private int subGenreId;

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

	public int getMainGenreId() {
		return mainGenreId;
	}

	public void setMainGenreId(int mainGenreId) {
		this.mainGenreId = mainGenreId;
	}

	public int getSubGenreId() {
		return subGenreId;
	}

	public void setSubGenreId(int subGenreId) {
		this.subGenreId = subGenreId;
	}
	
}
