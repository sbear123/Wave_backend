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
		
		SubGenreBean e1 = new SubGenreBean(1, "가", 1);
		SubGenreBean e2 = new SubGenreBean(2, "나", 1);
		SubGenreBean e3 = new SubGenreBean(3, "다", 1);
		SubGenreBean e4 = new SubGenreBean(4, "라", 1);
		SubGenreBean e5 = new SubGenreBean(5, "마", 1);
		SubGenreBean e6 = new SubGenreBean(6, "바", 1);
		SubGenreBean e7 = new SubGenreBean(7, "사", 1);
		SubGenreBean e8 = new SubGenreBean(8, "아", 1);
		SubGenreBean e9 = new SubGenreBean(9, "자", 1);
		
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
