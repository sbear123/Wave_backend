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
			SongBean song1 = new SongBean(1, "타이틀1", 1, 1, 1, 1, "노래이름1", "가사1", "노래주소1", "여자1", 19, "작곡가1");
			SongBean song2 = new SongBean(2, "타이틀2", 2, 2, 2, 2, "노래이름2", "가사2", "노래주소2", "여자2", 20, "작곡가2");
			SongBean song3 = new SongBean(3, "타이틀3", 3, 3, 3, 3, "노래이름3", "가사3", "노래주소3", "여자3", 21, "작곡가3");
			
			songs.add(song1);
			songs.add(song2);
			songs.add(song3);
			
			MainGenreBean MainGenre = new MainGenreBean(1, "장르1");
			
			List<SubGenreBean> SubGenres = new ArrayList<>();
			SubGenreBean sub1 = new SubGenreBean(1, "서브장르1", 1);
			SubGenreBean sub2 = new SubGenreBean(2, "서브장르2", 2);
			
			SubGenres.add(sub1);
			SubGenres.add(sub2);
			
			ArrayList<PlayListBean> list = new ArrayList<>();
			
			PlayListBean list1 = new PlayListBean(1, "user", "2020.09.01", "타이틀1", "pop", "hi", songs, SubGenres, MainGenre.getName());
			
			list.add(list1);
				
			
			return list;
		}
}
