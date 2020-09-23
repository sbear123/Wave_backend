package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ListInfoDBBean extends CommonDBBean {
	//Singleton
		private static ListInfoDBBean instance = new ListInfoDBBean();
		private ListInfoDBBean() {}
		public static ListInfoDBBean getInstance() {
			return instance;
		}
		
		public ArrayList<PlayListBean> getList(){
			
			List<SongBean> songs = new ArrayList<>();
			SongBean song1 = new SongBean(1, "���씠��1", 1, 1, 1, 1, "�끂�옒�씠由�1", "媛��궗1", "�끂�옒二쇱냼1", "�뿬�옄1", 19, "�옉怨↔�1");
			SongBean song2 = new SongBean(2, "���씠��2", 2, 2, 2, 2, "�끂�옒�씠由�2", "媛��궗2", "�끂�옒二쇱냼2", "�뿬�옄2", 20, "�옉怨↔�2");
			SongBean song3 = new SongBean(3, "���씠��3", 3, 3, 3, 3, "�끂�옒�씠由�3", "媛��궗3", "�끂�옒二쇱냼3", "�뿬�옄3", 21, "�옉怨↔�3");
			
			songs.add(song1);
			songs.add(song2);
			songs.add(song3);
			
			MainGenreBean MainGenre = new MainGenreBean(1, "�옣瑜�1");
			
			List<SubGenreBean> SubGenres = new ArrayList<>();
			SubGenreBean sub1 = new SubGenreBean(1, "�꽌釉뚯옣瑜�1", 1);
			SubGenreBean sub2 = new SubGenreBean(2, "�꽌釉뚯옣瑜�2", 2);
			
			SubGenres.add(sub1);
			SubGenres.add(sub2);
			
			ArrayList<PlayListBean> list = new ArrayList<>();
			
			PlayListBean list1 = new PlayListBean(1, "user", "2020.09.01", "���씠��1", songs, MainGenre.getName(), "신나는");
			
			list.add(list1);
				
			
			return list;
		}
}
