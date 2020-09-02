package bean;

import java.util.List;

public class PlayListBean {
	
	private int playlistid;
	private String userid;
	private String date;
	private String title;
	private String tag;
	private String text;
	
	private List<SongBean> songs;
	private String maingenre;
	private List<SubGenreBean> subgenre;
	
	public PlayListBean() {}
		
	public PlayListBean(int playlistid, String userid, String date, String title, String tag, String text, List<SongBean> songs, List<SubGenreBean> subgenre, String maingenre) {
		this.date = date;
		this.playlistid = playlistid;
		this.songs = songs;
		this.subgenre = subgenre;
		this.tag = tag;
		this.text = text;
		this.title = title;
		this.userid = userid;
		this.maingenre = maingenre;
		
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<SongBean> getSongs() {
		return songs;
	}

	public void setSongs(List<SongBean> songs) {
		this.songs = songs;
	}

	public List<SubGenreBean> getSubgenre() {
		return subgenre;
	}

	public void setSubgenre(List<SubGenreBean> subgenre) {
		this.subgenre = subgenre;
	}

	
}
