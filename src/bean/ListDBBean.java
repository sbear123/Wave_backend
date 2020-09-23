package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ListDBBean extends CommonDBBean {
	//Singleton
	private static ListDBBean instance = new ListDBBean();
	private ListDBBean() {}
	public static ListDBBean getInstance() {
		return instance;
	}
	public ArrayList<RecommandPlayListBean> getRecommandedList() {
		ArrayList<RecommandPlayListBean> list = new ArrayList<>();
		ArrayList<PlayListBean> playlist1 = new ArrayList<>();
		ArrayList<PlayListBean> playlist2 = new ArrayList<>();
		ArrayList<PlayListBean> playlist3 = new ArrayList<>();
		ArrayList<SongBean> song1 = new ArrayList<>();
		ArrayList<SongBean> song2 = new ArrayList<>();
		ArrayList<SongBean> song3 = new ArrayList<>();
		ArrayList<SongBean> song4 = new ArrayList<>();
		
		SongBean s1 = new SongBean(1, "Ÿ��Ʋ1", 1, 1, 1, 1, "�������", "https://youtu.be/gKvbDkLeSo0", "Saavane");
		SongBean s2 = new SongBean(2, "Ÿ��Ʋ2", 1, 1, 1, 1, "��", "https://youtu.be/bK8fVyP-98Q", "Magic Mansion");
		SongBean s3 = new SongBean(3, "Ÿ��Ʋ3", 1, 1, 1, 1, "�������", "https://youtu.be/gKvbDkLeSo0", "Saavane");
		SongBean s4 = new SongBean(4, "Ÿ��Ʋ4", 1, 1, 1, 1, "�������", "https://youtu.be/gKvbDkLeSo0", "Saavane");
		
		s1.setJacket("https://images.genius.com/a8c57c8fe83eb985d31e9e27148f7cf4.600x600x1.jpg");
		s2.setJacket("https://image.chosun.com/sitedata/image/202005/15/2020051503438_0.jpg");
		s1.setJacket("https://images.genius.com/a8c57c8fe83eb985d31e9e27148f7cf4.600x600x1.jpg");
		s1.setJacket("https://images.genius.com/a8c57c8fe83eb985d31e9e27148f7cf4.600x600x1.jpg");
		
		song1.add(s1);
		song1.add(s2);
		song1.add(s3);
		song1.add(s4);
		
		song2.add(s1);
		song2.add(s2);
		song2.add(s3);
		song2.add(s4);
		
		song3.add(s1);
		song3.add(s2);
		song3.add(s3);
		song3.add(s4);
		
		song4.add(s1);
		song4.add(s2);
		song4.add(s3);
		song4.add(s4);
		
		PlayListBean p1 = new PlayListBean(1,"user","2020.06.06","����Ʈ1", song1, "��", "�ų���");
		PlayListBean p2 = new PlayListBean(2,"user","2020.06.06","����Ʈ2", song2, "��", "�ų���");
		PlayListBean p3 = new PlayListBean(3,"user","2020.06.06","����Ʈ3", song3, "��", "�ų���");
		PlayListBean p4 = new PlayListBean(4,"user","2020.06.06","����Ʈ4", song4, "��", "�ų���");
		
		playlist1.add(p1);
		playlist1.add(p2);
		playlist1.add(p3);
		playlist1.add(p4);
		
		playlist2.add(p1);
		playlist2.add(p2);
		playlist2.add(p3);
		playlist2.add(p4);
		
		playlist3.add(p1);
		playlist3.add(p2);
		playlist3.add(p3);
		playlist3.add(p4);
		
		RecommandPlayListBean rpb1 = new RecommandPlayListBean(playlist1);
		
		RecommandPlayListBean rpb2 = new RecommandPlayListBean(playlist2);
		
		RecommandPlayListBean rpb3 = new RecommandPlayListBean(playlist3);
		
		
		list.add(rpb1);
		list.add(rpb2);
		list.add(rpb3);
		
		return list;
	}
}
