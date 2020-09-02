package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Taste1DBBean extends CommonDBBean {
	//Singleton
	private static Taste1DBBean instance = new Taste1DBBean();
	private Taste1DBBean() {}
	public static Taste1DBBean getInstance() {
		return instance;
	}
	
	public ArrayList<MainGenreBean> getFeels(){
		ArrayList<MainGenreBean> list = new ArrayList<>();
		
		MainGenreBean e1 = new MainGenreBean(1, "�帣1");
		MainGenreBean e2 = new MainGenreBean(2, "�帣2");
		MainGenreBean e3 = new MainGenreBean(3, "�帣3");
		MainGenreBean e4 = new MainGenreBean(4, "�帣4");
		MainGenreBean e5 = new MainGenreBean(5, "�帣5");
		MainGenreBean e6 = new MainGenreBean(6, "�帣6");
		MainGenreBean e7 = new MainGenreBean(7, "�帣7");
		MainGenreBean e8 = new MainGenreBean(8, "�帣8");
		MainGenreBean e9 = new MainGenreBean(9, "�帣9");
		
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
