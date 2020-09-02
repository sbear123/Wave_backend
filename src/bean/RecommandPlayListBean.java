package bean;

import java.util.List;

public class RecommandPlayListBean {

	private List<PlayListBean> lists;
	
	public RecommandPlayListBean() {}
	
	public RecommandPlayListBean(List<PlayListBean> lists) {
		this.lists = lists;
	}

	public List<PlayListBean> getLists() {
		return lists;
	}

	public void setLists(List<PlayListBean> lists) {
		this.lists = lists;
	}
	
}
