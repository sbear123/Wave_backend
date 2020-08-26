package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ListDBBean extends CommonDBBean {
	//Singleton
	private static ListDBBean instance = new ListDBBean();
	private ListDBBean() {}
	public static ListDBBean getInstance() {
		return instance;
	}
	
	public ArrayList<RecommandedPlayListBean> getCrews(){
		ArrayList<RecommandedPlayListBean> list = new ArrayList<>();
		
		return list;
	}
}
