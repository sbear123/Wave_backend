package bean;

import java.util.ArrayList;

public class MyPlayListDBBean extends CommonDBBean {
	private static MyPlayListDBBean instance = new MyPlayListDBBean();
	private MyPlayListDBBean() {}
	public static MyPlayListDBBean getInstance() {
		return instance;
	}
	
	public ArrayList<PlayListBean> playListBeans() {
		ArrayList<PlayListBean> playlist1 = new ArrayList<>();
		//ArrayList<PlayListBean> playlist2 = new ArrayList<>();
		//ArrayList<PlayListBean> playlist3 = new ArrayList<>();
		ArrayList<SongBean> songList1 = new ArrayList<>();
		ArrayList<SongBean> songList2 = new ArrayList<>();
		ArrayList<SongBean> songList3 = new ArrayList<>();
		ArrayList<SongBean> songList4 = new ArrayList<>();
		
		SongBean s1 = new SongBean(1, "지코", 1, 1, 1, 1, "she", "https://youtu.be/gKvbDkLeSo0", "Saavane");
		SongBean s2 = new SongBean(2, "이나은", 1, 1, 1, 1, "he", "https://youtu.be/bK8fVyP-98Q", "Magic Mansion");
		SongBean s3 = new SongBean(3, "제니", 1, 1, 1, 1, "We", "https://youtu.be/gKvbDkLeSo0", "Saavane");
		SongBean s4 = new SongBean(4, "싸이", 1, 1, 1, 1, "are", "https://youtu.be/gKvbDkLeSo0", "Saavane");
		
		s1.setJacket("https://images.genius.com/a8c57c8fe83eb985d31e9e27148f7cf4.600x600x1.jpg");
		s2.setJacket("https://image.chosun.com/sitedata/image/202005/15/2020051503438_0.jpg");
		s1.setJacket("https://images.genius.com/a8c57c8fe83eb985d31e9e27148f7cf4.600x600x1.jpg");
		s1.setJacket("https://images.genius.com/a8c57c8fe83eb985d31e9e27148f7cf4.600x600x1.jpg");
		
		songList1.add(s1);
		songList1.add(s2);
		songList1.add(s3);
		songList1.add(s4);
		
		songList2.add(s1);
		songList2.add(s2);
		songList2.add(s3);
		songList2.add(s4);
		
		songList3.add(s1);
		songList3.add(s2);
		songList3.add(s3);
		songList3.add(s4);
		
		songList4.add(s1);
		songList4.add(s2);
		songList4.add(s3);
		songList4.add(s4);
		
		PlayListBean p1 = new PlayListBean(1,"user","2020.06.06","뭐", songList1, "속았지", "메롱");
		PlayListBean p2 = new PlayListBean(2,"user","2020.06.06","히하호", songList2, "할꺼다", "당근");
		PlayListBean p3 = new PlayListBean(3,"user","2020.06.06","바다가마", songList3, "구라", "자전거");
		PlayListBean p4 = new PlayListBean(4,"user","2020.06.06","안한다", songList4, "지롱", "전용길");
		
		playlist1.add(p1);
		playlist1.add(p2);
		playlist1.add(p3);
		playlist1.add(p4);
		
		/*playlist2.add(p1);
		playlist2.add(p2);
		playlist2.add(p3);
		playlist2.add(p4);
		
		playlist3.add(p1);
		playlist3.add(p2);
		playlist3.add(p3);
		playlist3.add(p4);*/
		
		return playlist1;
	}
}
