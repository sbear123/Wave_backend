package bean;

public class UserBean {
	
	private String userId;
	private String password;
	private String name;
	private String favorite;
	private String email;
	
	public UserBean() {}
	
	public UserBean(String userid, String password) {
		this.userId = userid;
		this.password = password;
	}
	
	public UserBean(String userId, String password, String name) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = null;
	}
	
	public UserBean(String userId, String password, String name, String email) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userid) {
		this.userId = userid;
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
