package bean;

public class UserBean {
	
	private String userid;
	private String password;
	private String name;
	private String favorite;
	private String email;
	
	public UserBean() {}
	
	public UserBean(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}
	
	public UserBean(String userid, String password, String name, String favorite) {
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.favorite = favorite;
	}
	
	public UserBean(String userid, String password, String name, String favorite, String email) {
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.favorite = favorite;
		this.email = email;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFavorite() {
		return favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
