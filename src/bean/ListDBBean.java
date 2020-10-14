package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.getname.MaingenreDBBean;
import bean.getname.PlaylistDBBean;
import bean.getname.SubgenreDBBean;

public class ListDBBean extends CommonDBBean {
	//Singleton
	private static ListDBBean instance = new ListDBBean();
	
	private ListDBBean() {}
	
	public static ListDBBean getInstance() {
		return instance;
	}

	public ArrayList<RecommandPlayListBean> show(String userid) {
		RecommandPlayListBean result = new RecommandPlayListBean();
		ArrayList<RecommandPlayListBean> list = new ArrayList<>();
		PlayListBean playlist = new PlayListBean();
		List<PlayListBean> lists = new ArrayList<PlayListBean>();
		MaingenreDBBean main = new MaingenreDBBean();
		
		int Maingenre=0;
		int Subgenre1=0;
		int Subgenre2=0;
		
		Connection conn = getConnection();
		if(conn==null) return null;
		
		String sql = "Select * from userfavorites where userid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Maingenre = rs.getInt("maingenre");
				Subgenre1 = rs.getInt("subgenre1");
				Subgenre2 = rs.getInt("subgenre2");
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql1 = "select * from playlist where maingenreid=?";
		try {
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, userid);
			ResultSet rs = pstmt1.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("playlistid");
				PlaylistDBBean plist = new PlaylistDBBean();
				playlist = plist.getlist(id);
				lists.add(playlist);
			}
			rs.close();
			pstmt1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result.setGenreId(Maingenre);
		result.setGenreName(main.getMaingenre(Maingenre));
		result.setList(lists);
		list.add(result);
		
		list.add(playlist(Maingenre, Subgenre1));
		list.add(playlist(Maingenre, Subgenre2));
		
		return list;
	}
	
	
	
	private RecommandPlayListBean playlist(int mainid, int subid) {
		//서브장르받아오기 짜
		RecommandPlayListBean result = new RecommandPlayListBean();
		PlayListBean playlist = new PlayListBean();
		List<PlayListBean> lists = new ArrayList<PlayListBean>();
		SubgenreDBBean sub = new SubgenreDBBean();
		
		Connection conn = getConnection();
		if(conn==null) return null;
		
		String sql1 = "select * from playlist where maingnreid=? subgenreid=?";
		try {
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, mainid);
			pstmt1.setInt(2, subid);
			ResultSet rs = pstmt1.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("playlistid");
				PlaylistDBBean plist = new PlaylistDBBean();
				playlist = plist.getlist(id);
				lists.add(playlist);
			}
			rs.close();
			pstmt1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result.setGenreId(subid);
		result.setGenreName(sub.getSubgenre(mainid, subid));
		result.setList(lists);
		
		return result;
	}
}
