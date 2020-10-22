package bean;

public class PListBean {
	private int playlistId;
	private int songId;
	
	public PListBean() {}
	
	public PListBean(int playlistid) {
		this.playlistId = playlistid;
	}
	
	public PListBean(int playlistid, int songid) {
		this.playlistId = playlistid;
		this.songId = songid;
	}

	public int getPlaylistid() {
		return playlistId;
	}

	public void setPlaylistid(int playlistid) {
		this.playlistId = playlistid;
	}

	public int getSongid() {
		return songId;
	}

	public void setSongid(int songid) {
		this.songId = songid;
	}
	
}
