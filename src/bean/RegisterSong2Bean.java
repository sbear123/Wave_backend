package bean;

public class RegisterSong2Bean {
	
	private int subGenreId;
	private int rank;
	
	public RegisterSong2Bean() {}
	
	public RegisterSong2Bean(int subGenreId, int rank) {
		this.rank = rank;
		this.subGenreId = subGenreId;
	}
	
	public int getMainGenreId() {
		return subGenreId;
	}
	public void setMainGenreId(int subGenreId) {
		this.subGenreId = subGenreId;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}
