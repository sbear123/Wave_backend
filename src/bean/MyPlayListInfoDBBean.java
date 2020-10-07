package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MyPlayListInfoDBBean extends CommonDBBean{
	private static MyPlayListInfoDBBean instance = new MyPlayListInfoDBBean();
	
	public static MyPlayListInfoDBBean getInstance() {
		return instance;
	}
	
	public ArrayList<PlayListBean> getList(){
		
		List<SongBean> songs = new ArrayList<>();
		SongBean song1 = new SongBean(1, "가", 1, 1, 1, 1, "내", "노", "래", "다", 19, "이");
		SongBean song2 = new SongBean(2, "나", 2, 2, 2, 2, "플", "레", "이", "리스", 20, "트");
		SongBean song3 = new SongBean(3, "다", 3, 3, 3, 3, "싼", "타", "클", "로", 21, "스");
		
		songs.add(song1);
		songs.add(song2);
		songs.add(song3);
		
		MainGenreBean MainGenre = new MainGenreBean(1, "게");
		
		List<SubGenreBean> SubGenres = new ArrayList<>();
		SubGenreBean sub1 = new SubGenreBean(1, "눈누", 1);
		SubGenreBean sub2 = new SubGenreBean(2, "난나", 2);
		
		SubGenres.add(sub1);
		SubGenres.add(sub2);
		
		ArrayList<PlayListBean> list = new ArrayList<>();
		
		PlayListBean list1 = new PlayListBean(1, "user", "2020.09.01", "홀리마리오루이지데이지", songs, MainGenre.getName(), "신나는");
		
		list.add(list1);
			
		
		return list;
	}
	
}
