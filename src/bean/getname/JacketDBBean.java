package bean.getname;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.CommonDBBean;

public class JacketDBBean extends CommonDBBean {
	
	//Singleton
			private static JacketDBBean instance = new JacketDBBean();
			
			private JacketDBBean() {}
			
			public static JacketDBBean getInstance() {
				return instance;
			}
	
	public String getJacket(int id){
		String jacket =  "";
		int songid = 0;
		Connection conn = getConnection();
		if(conn == null) return null;
		System.out.println("conn");
		
		String sql = "select * from playlistsong where playlistid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				songid = rs.getInt("songid");
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (songid == 0) {
			return "";
		}
		
		sql = "select * from song where songid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				jacket = AlbumDBBean.getInstance().getAlbum(rs.getInt("albumid")).getJacket();
				System.out.println(jacket);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		
		return jacket;
	}
}
