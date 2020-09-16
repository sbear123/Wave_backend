package bean;

import java.util.List;

public class RecommandPlayListBean {
	private List<PlayListBean> list;
	private String genreName;
	
	public RecommandPlayListBean() {}
	
	public RecommandPlayListBean(List<PlayListBean> lists) {
		this.list = lists;
		this.genreName = lists.get(1).getMaingenre();
	}

	public List<PlayListBean> getList() {
		return list;
	}

	public void setList(List<PlayListBean> lists) {
		this.list = lists;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
}
