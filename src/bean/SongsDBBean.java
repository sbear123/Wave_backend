package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SongsDBBean extends CommonDBBean {
	//Singleton
		private static SongsDBBean instance = new SongsDBBean();
		private SongsDBBean() {}
		public static SongsDBBean getInstance() {
			return instance;
		}
		
		public ArrayList<SongBean> getSong(){
			ArrayList<SongBean> list = new ArrayList<>();

			SongBean song1 = new SongBean(1, "타이틀", 1, 1, 1, 1, "노래이름", "가사", "노래주소", "여자", 19, "작곡가");
				
			list.add(song1);
			
			return list;
		}
}
