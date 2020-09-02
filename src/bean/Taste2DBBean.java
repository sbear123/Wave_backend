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
		
		SubGenreBean e1 = new SubGenreBean(1, "�����帣1", 1);
		SubGenreBean e2 = new SubGenreBean(2, "�����帣2", 1);
		SubGenreBean e3 = new SubGenreBean(3, "�����帣3", 1);
		SubGenreBean e4 = new SubGenreBean(4, "�����帣4", 1);
		SubGenreBean e5 = new SubGenreBean(5, "�����帣5", 1);
		SubGenreBean e6 = new SubGenreBean(6, "�����帣6", 1);
		SubGenreBean e7 = new SubGenreBean(7, "�����帣7", 1);
		SubGenreBean e8 = new SubGenreBean(8, "�����帣8", 1);
		SubGenreBean e9 = new SubGenreBean(9, "�����帣9", 1);
		
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
