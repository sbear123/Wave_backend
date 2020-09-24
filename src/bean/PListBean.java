package bean;

public class PListBean {
	private int playlistid;
	private int songid;
	
	public PListBean() {}
	
	public PListBean(int playlistid) {
		this.playlistid = playlistid;
	}
	
	public PListBean(int playlistid, int songid) {
		this.playlistid = playlistid;
		this.songid = songid;
	}

	public int getPlaylistid() {
		return playlistid;
	}

	public void setPlaylistid(int playlistid) {
		this.playlistid = playlistid;
	}

	public int getSongid() {
		return songid;
	}

	public void setSongid(int songid) {
		this.songid = songid;
	}
	
}
