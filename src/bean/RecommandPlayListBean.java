package bean;

import java.util.List;

public class RecommandPlayListBean {
	private List<PlayListBean> list;
	private String genreName;
	
	public RecommandPlayListBean() {}
	
	public RecommandPlayListBean(List<PlayListBean> list) {
		this.list = list;
		this.genreName = list.get(1).getMaingenre();
	}

	public List<PlayListBean> getList() {
		return list;
	}

	public void setList(List<PlayListBean> list) {
		this.list = list;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
}
