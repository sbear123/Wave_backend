package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.getname.ArtistDBBean;
import bean.getname.PlaylistDBBean;

public class MylistDBBean extends CommonDBBean {
	private static MylistDBBean instance = new MylistDBBean();
	private MylistDBBean() {}
	public static MylistDBBean getInstance() {
		return instance;
	}
	
	public ArrayList<MyPlaylistBean> Mylist(String userid) {
		MyPlaylistBean mylist = null;
		ArrayList<MyPlaylistBean> list = new ArrayList<>();
		Connection conn = getConnection();
		if(conn == null) return null;
		System.out.println("conn");
		
		String sql = "select * from playlist where userid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				mylist = new MyPlaylistBean();
				int listid = rs.getInt("playlistid");
				mylist.setListId(listid);
				mylist.setListName(PlaylistDBBean.getInstance().getlist(listid).getTitle());
				MyPlaylistBean my = getsong(listid);
				mylist.setSongCount(my.getSongCount());
				mylist.setJacket(my.getJacket());
				System.out.println(mylist);
				list.add(mylist);
			}
			rs.close();
			pstmt.close();
			closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeConnection(conn);
		}
		
		return list;
	}
	
	private MyPlaylistBean getsong (int playlistid) {
		MyPlaylistBean song = new MyPlaylistBean();
		int amount = 0;
		Connection conn = getConnection();
		if(conn == null) return null;
		System.out.println("conn");
		
		String sql = "select * from playlistsong where playlistid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, playlistid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				amount++;
				if (amount == 1) {
					song.setJacket(SongsDBBean.getInstance().getSong(rs.getInt("songid")).getJacket());
				}
			}
			rs.close();
			pstmt.close();
			closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			closeConnection(conn);
		}
		
		song.setSongCount(amount);
		return song;
	}
}
