package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ListDBBean {
	//Singleton
	private static ListDBBean instance = new ListDBBean();
	private ListDBBean() {}
	public static ListDBBean getInstance() {
		return instance;
	}
	
	public ArrayList<RecommandedPlayListBean> getRecommandedList(){
		
		List<SongBean> songs = new ArrayList<>();
		SongBean song1 = new SongBean(1,"노래제목1","재킷사진1","가수1","가사1","노래주소1");
		SongBean song2 = new SongBean(2,"노래제목2","재킷사진2","가수2","가사2","노래주소2");
		SongBean song3 = new SongBean(3,"노래제목3","재킷사진3","가수3","가사3","노래주소3");
		
		songs.add(song1);
		songs.add(song2);
		songs.add(song3);
		
		MainGenreBean MainGenre = new MainGenreBean(1, 1, "메인장르1");
		
		List<SubGenreBean> SubGenres = new ArrayList<>();
		SubGenreBean sub1 = new SubGenreBean(1 ,1,"서브장르1");
		SubGenreBean sub2 = new SubGenreBean(2 ,2,"서브장르2");
		
		SubGenres.add(sub1);
		SubGenres.add(sub2);
		
		ArrayList<PlayListBean> list = new ArrayList<>();
		
		PlayListBean list1 = new PlayListBean(1, "리스트 이름1", songs, MainGenre, SubGenres, "유저아이디" );
		PlayListBean list2 = new PlayListBean(2, "리스트 이름2", songs, MainGenre, SubGenres, "유저아이디" );
		
		list.add(list1);
		list.add(list2);
		
		ArrayList<RecommandedPlayListBean> Rlist = new ArrayList<>();
		
		RecommandedPlayListBean Rlist1 = new RecommandedPlayListBean(list);
		
		Rlist.add(Rlist1);
		
		return Rlist;
	}
}
