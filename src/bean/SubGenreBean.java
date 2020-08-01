package bean;

public class SubGenreBean {
	
	private int subGenreId;
	private int index;
	private String subGenreName;
	
	public SubGenreBean() {}
	
	public SubGenreBean(int subGenreId, int index, String subGenreName) {
		this.index = index;
		this.subGenreId = subGenreId;
		this.subGenreName = subGenreName;
	}
	
	public int getSubGenreId() {
		return subGenreId;
	}
	public void setSubGenreId(int subGenreId) {
		this.subGenreId = subGenreId;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getSubGenreName() {
		return subGenreName;
	}
	public void setSubGenreName(String subGenreName) {
		this.subGenreName = subGenreName;
	}
	
	
}
