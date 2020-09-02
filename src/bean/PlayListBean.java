package bean;

import java.util.List;

public class PlayListBean {

	private List<PlayListSongBean> lists;
	
	public PlayListBean() {}
	
	public PlayListBean(List<PlayListSongBean> lists) {
		this.lists = lists;
	}

	public List<PlayListSongBean> getLists() {
		return lists;
	}

	public void setLists(List<PlayListSongBean> lists) {
		this.lists = lists;
	}
	
}
