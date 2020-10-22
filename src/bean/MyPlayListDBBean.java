package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.getname.PlaylistDBBean;

public class MyPlayListDBBean extends CommonDBBean {
	private static MyPlayListDBBean instance = new MyPlayListDBBean();
	private MyPlayListDBBean() {}
	public static MyPlayListDBBean getInstance() {
		return instance;
	}
	
	public ArrayList<MyPlaylistBean> Mylist(String userid) {
		MyPlaylistBean mylist = null;
		ArrayList<MyPlaylistBean> list = new ArrayList<>();
		Connection conn = getConnection();
		if(conn == null) return null;
		System.out.println("conn");
		
		String sql = "select * from mylist where userid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				mylist = new MyPlaylistBean();
				int listid = rs.getInt("playlistid");
				mylist.setListId(listid);
				PlaylistDBBean plist = new PlaylistDBBean();
				mylist.setListName(plist.getlist(listid).getTitle());
				MyPlaylistBean my = getsong(listid);
				mylist.setSongCount(my.getSongCount());
				mylist.setJacket(my.getJacket());
				list.add(mylist);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection(conn);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		song.setSongCount(amount);
		closeConnection(conn);
		return song;
	}
}
