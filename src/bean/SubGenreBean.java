package bean;

public class SubGenreBean {
	
	private int subgenreid;
	private String name;
	private int maingenreid;
	
	public SubGenreBean() {}
	
	public SubGenreBean(int subgenreid, String name, int maingenreid) {
		this.subgenreid = subgenreid;
		this.name = name;
		this.maingenreid = maingenreid;
	}

	public int getSubgenreid() {
		return subgenreid;
	}

	public void setSubgenreid(int subgenreid) {
		this.subgenreid = subgenreid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaingenreid() {
		return maingenreid;
	}

	public void setMaingenreid(int maingenreid) {
		this.maingenreid = maingenreid;
	}
	
	
	
	
}
