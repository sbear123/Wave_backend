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
			SongBean song1 = new SongBean(1,"�뷡����1","��Ŷ����1","����1","����1","�뷡�ּ�1");
			SongBean song2 = new SongBean(2,"�뷡����2","��Ŷ����2","����2","����2","�뷡�ּ�2");
			SongBean song3 = new SongBean(3,"�뷡����3","��Ŷ����3","����3","����3","�뷡�ּ�3");
			
			songs.add(song1);
			songs.add(song2);
			songs.add(song3);
			
			MainGenreBean MainGenre = new MainGenreBean(1, 1, "�����帣1");
			
			List<SubGenreBean> SubGenres = new ArrayList<>();
			SubGenreBean sub1 = new SubGenreBean(1 ,1,"�����帣1");
			SubGenreBean sub2 = new SubGenreBean(2 ,2,"�����帣2");
			
			SubGenres.add(sub1);
			SubGenres.add(sub2);
			
			ArrayList<PlayListBean> list = new ArrayList<>();
			
			PlayListBean list1 = new PlayListBean(1, "����Ʈ �̸�", songs, MainGenre, SubGenres, "�������̵�" );
			
			list.add(list1);
				
			
			return list;
		}
}
