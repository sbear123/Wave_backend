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

			SongBean song1 = new SongBean(1, "노래", 1, 1, 1, 1, "노래", "노래", "노래", "노래", 19, "노래");
				
			list.add(song1);
			
			return list;
		}
}
