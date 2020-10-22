package bean;

public class MyPlaylistBean {
	private int listId;
	private int songCount;
	private String jacket;
	private String listName;
	
	public int getListId() {
		return listId;
	}
	public void setListId(int listId) {
		this.listId = listId;
	}
	public int getSongCount() {
		return songCount;
	}
	public void setSongCount(int songCount) {
		this.songCount = songCount;
	}
	public String getJacket() {
		return jacket;
	}
	public void setJacket(String jacket) {
		this.jacket = jacket;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
}
