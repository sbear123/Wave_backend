package bean;

public class PwBean {
	
	private String userId;
	private String orginPw;
	private String newPw;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getOrginPw() {
		return orginPw;
	}
	
	public void setOrginPw(String OrginPw) {
		this.orginPw = OrginPw;
	}
	
	public String getNewPw() {
		return newPw;
	}
	
	public void getNewPw(String NewPw) {
		this.newPw = NewPw;
	}
	
}
