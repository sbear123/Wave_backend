package bean;

import java.util.List;

public class RegisterSongs2Bean {
	
	private List<UserFavoritesBean> list;
	
	public RegisterSongs2Bean() {}
	
	public RegisterSongs2Bean(List<UserFavoritesBean> list) {
		this.list = list;
	}

	public List<UserFavoritesBean> getList() {
		return list;
	}

	public void setList(List<UserFavoritesBean> list) {
		this.list = list;
	}
}
