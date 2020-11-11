package bean.getname;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.CommonDBBean;
import bean.SongBean;

public class AlbumDBBean extends CommonDBBean {
	
	//Singleton
		private static AlbumDBBean instance = new AlbumDBBean();
		
		private AlbumDBBean() {}
		
		public static AlbumDBBean getInstance() {
			return instance;
		}
	
	public SongBean getAlbum(int id, Connection conn){
		SongBean album = null;
		
		String sql = "select * from album where albumid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				album = new SongBean();
				album.setJacket(rs.getString("jacket"));
				album.setAlbumname(rs.getString("name"));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return album;
	}
}
