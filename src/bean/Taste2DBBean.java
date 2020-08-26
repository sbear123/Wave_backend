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
		
		SubGenreBean e1 = new SubGenreBean(1, 1, "�떊�굹�뒗");
		SubGenreBean e2 = new SubGenreBean(2, 2, "�슦�슱�븳");
		SubGenreBean e3 = new SubGenreBean(3, 3, "�옱誘몄엳�뒗");
		SubGenreBean e4 = new SubGenreBean(4, 4, "洹몃（釉뚯엳�뒗");
		SubGenreBean e5 = new SubGenreBean(5, 5, "�떆�걚�윭�슫");
		SubGenreBean e6 = new SubGenreBean(6, 6, "議곗슜�븳");
		SubGenreBean e7 = new SubGenreBean(7, 7, "�궓�옄�끂�옒");
		SubGenreBean e8 = new SubGenreBean(8, 8, "�뿬�옄�끂�옒");
		SubGenreBean e9 = new SubGenreBean(9, 9, "吏쒖쬆�굹�뒗");
		
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
