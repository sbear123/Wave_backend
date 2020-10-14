package bean;

public class PwBean {
	
	private String userId;
	private String orginPw;
	private String newPw;
	
	public PwBean() {}
	
	public PwBean(String userId, String orginPw, String newPw) {
		this.userId = userId;
		this.orginPw = orginPw;
		this.newPw = newPw;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getOrginPw() {
		return orginPw;
	}
	
	public String getNewPw() {
		return newPw;
	}
	
}
