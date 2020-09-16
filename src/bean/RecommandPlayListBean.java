package bean;

import java.util.List;

public class RecommandPlayListBean {
	private List<PlayListBean> lists;
	private String genreName;
	private String jacket;
	
	public RecommandPlayListBean() {}
	
	public RecommandPlayListBean(List<PlayListBean> lists) {
		this.lists = lists;
		this.genreName = lists.get(1).getMaingenre();
		this.jacket = lists.get(1).getSongs().get(0).getJacket();
	}

	public List<PlayListBean> getLists() {
		return lists;
	}

	public void setLists(List<PlayListBean> lists) {
		this.lists = lists;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getJacket() {
		return jacket;
	}

	public void setJacket(String jacket) {
		this.jacket = jacket;
	}
	
}
