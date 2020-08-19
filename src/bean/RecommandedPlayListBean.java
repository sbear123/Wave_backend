package bean;

import java.util.List;

public class RecommandedPlayListBean {

	private List<PlayListBean> lists;
	
	public RecommandedPlayListBean() {}
	
	public RecommandedPlayListBean(List<PlayListBean> lists) {
		this.lists = lists;
	}

	public List<PlayListBean> getLists() {
		return lists;
	}

	public void setLists(List<PlayListBean> lists) {
		this.lists = lists;
	}
	
}
