package bean;

public class MainGenreBean {
	
	private int mainGenreId;
	private int index;
	private String mainGenreName;
	
	public MainGenreBean () {}
	
	public MainGenreBean (int mainGenreId, int index, String mainGenreName) {
		this.index = index;
		this.mainGenreId = mainGenreId;
		this.mainGenreName = mainGenreName;
	}
	
	public int getMainGenreId() {
		return mainGenreId;
	}
	public void setMainGenreId(int mainGenreId) {
		this.mainGenreId = mainGenreId;
	}
	public String getMainGenreName() {
		return mainGenreName;
	}
	public void setMainGenreName(String mainGenreName) {
		this.mainGenreName = mainGenreName;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
