package bean;

public class MainGenreBean {
	
	private int maingenreid;
	private String name;
	
	public MainGenreBean () {}
	
	public MainGenreBean (int maingenreid, String name) {
		this.maingenreid = maingenreid;
		this.name = name;
	}

	public int getMaingenreid() {
		return maingenreid;
	}

	public void setMaingenreid(int maingenreid) {
		this.maingenreid = maingenreid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
