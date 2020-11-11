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
		
		int maingenre = 0;
		int subgenre1 = 0;
		int subgenre2 = 0;
		
		Connection conn = getConnection();
		if(conn==null) return null;
		
		String sql = "Select * from wave.userfavorites where userid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				maingenre = rs.getInt("maingenre");
				subgenre1 = rs.getInt("subgenre1");
				subgenre2 = rs.getInt("subgenre2");
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql1 = "select * from wave.playlist where maingenreid=?";
		try {
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, maingenre);
			ResultSet rs = pstmt1.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("playlistid");
				playlist = PlaylistDBBean.getInstance().getlist(id);
				lists.add(playlist);
			}
			rs.close();
			pstmt1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		
		result.setGenreId(maingenre);
		result.setGenreName(MaingenreDBBean.getInstance().getMaingenre(maingenre));
		result.setList(lists);
		list.add(result);
		
		list.add(playlist(maingenre, subgenre1));
		System.out.println(list);
		list.add(playlist(maingenre, subgenre2));
		
		return list;
	}
	
	public RecommandPlayListBean playlist(int mainid, int subid) {
		//서브장르받아오기 짜
		RecommandPlayListBean result = new RecommandPlayListBean();
		PlayListBean playlist = new PlayListBean();
		List<PlayListBean> lists = new ArrayList<PlayListBean>();
		
		Connection conn = getConnection();
		if(conn==null) return null;
		
		String sql2 = "select * from wave.playlist where maingenreid=? And subgenreid=?";
		try {
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, mainid);
			pstmt2.setInt(2, subid);
			ResultSet rs1 = pstmt2.executeQuery();
			
			while(rs1.next()) {
				int id = rs1.getInt("playlistid");
				System.out.println(id);
				playlist = PlaylistDBBean.getInstance().getlist(id);
				lists.add(playlist);
			}
			rs1.close();
			pstmt2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		
		result.setGenreId(subid);
		result.setGenreName(SubgenreDBBean.getInstance().getSubgenre(mainid, subid));
		result.setList(lists);
		
		return result;
	}
}
