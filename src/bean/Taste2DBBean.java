package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Taste2DBBean extends CommonDBBean {
	//Singleton
	private static Taste2DBBean instance = new Taste2DBBean();
	private Taste2DBBean() {}
	public static Taste2DBBean getInstance() {
		return instance;
	}
	
	public ArrayList<SubGenreBean> getFeels(){
		ArrayList<SubGenreBean> list = new ArrayList<>();
		
		SubGenreBean e1 = new SubGenreBean(1, "서브장르1", 1);
		SubGenreBean e2 = new SubGenreBean(2, "서브장르2", 1);
		SubGenreBean e3 = new SubGenreBean(3, "서브장르3", 1);
		SubGenreBean e4 = new SubGenreBean(4, "서브장르4", 1);
		SubGenreBean e5 = new SubGenreBean(5, "서브장르5", 1);
		SubGenreBean e6 = new SubGenreBean(6, "서브장르6", 1);
		SubGenreBean e7 = new SubGenreBean(7, "서브장르7", 1);
		SubGenreBean e8 = new SubGenreBean(8, "서브장르8", 1);
		SubGenreBean e9 = new SubGenreBean(9, "서브장르9", 1);
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		list.add(e9);
		
		return list;
	}
}
