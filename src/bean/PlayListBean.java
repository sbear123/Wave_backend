package bean;

import java.util.List;

public class PlayListBean {
	
	private int listId;
	private String listName;
	private List<SongBean> songs;
	private MainGenreBean mainGenre;
	private List<SubGenreBean> subGenres;
	private String userId;
	
	public PlayListBean() {}
		
	public PlayListBean(int listId, String listName, List<SongBean> songs, MainGenreBean mainGenre,
			List<SubGenreBean> subGenres, String userId) {
		
		this.listId = listId;
		this.listName = listName;
		this.songs = songs;
		this.mainGenre = mainGenre;
		this.subGenres = subGenres;
		this.userId = userId;
	}

	public int getListId() {
		return listId;
	}
	public void setListId(int listId) {
		this.listId = listId;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public List<SongBean> getSongs() {
		return songs;
	}
	public void setSongs(List<SongBean> songs) {
		this.songs = songs;
	}
	public MainGenreBean getMainGenre() {
		return mainGenre;
	}
	public void setMainGenre(MainGenreBean mainGenre) {
		this.mainGenre = mainGenre;
	}
	public List<SubGenreBean> getSubGenres() {
		return subGenres;
	}
	public void setSubGenres(List<SubGenreBean> subGenres) {
		this.subGenres = subGenres;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
