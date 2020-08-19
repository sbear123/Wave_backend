package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Taste1DBBean {
	//Singleton
	private static Taste1DBBean instance = new Taste1DBBean();
	private Taste1DBBean() {}
	public static Taste1DBBean getInstance() {
		return instance;
	}
	
	public ArrayList<MainGenreBean> getFeels(){
		ArrayList<MainGenreBean> list = new ArrayList<>();
		
		MainGenreBean e1 = new MainGenreBean(1, 1, "발라드");
		MainGenreBean e2 = new MainGenreBean(2, 2, "랩");
		MainGenreBean e3 = new MainGenreBean(3, 3, "아이돌노래");
		MainGenreBean e4 = new MainGenreBean(4, 4, "재즈");
		MainGenreBean e5 = new MainGenreBean(5, 5, "POP");
		MainGenreBean e6 = new MainGenreBean(6, 6, "클래식");
		MainGenreBean e7 = new MainGenreBean(7, 7, "락");
		MainGenreBean e8 = new MainGenreBean(8, 8, "국악");
		MainGenreBean e9 = new MainGenreBean(9, 9, "몰라할거 없어");
		
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
