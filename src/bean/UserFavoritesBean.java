package bean;

public class UserFavoritesBean {
	private String userId;
	private int mainGenreId;
	private int subGenreId;

	public String getId() {
		return userId;
	}

	public void setId(String id) {
		this.userId = id;
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
