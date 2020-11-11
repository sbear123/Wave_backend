package bean.getname;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.CommonDBBean;

public class ArtistDBBean extends CommonDBBean {
	
	//Singleton
	private static ArtistDBBean instance = new ArtistDBBean();
	
	private ArtistDBBean() {}
	
	public static ArtistDBBean getInstance() {
		return instance;
	}
	
	public String getArtist(int id){
		String name = "";
		Connection conn = getConnection();
		if(conn == null) return null;
		System.out.println("conn");
		
		String sql = "select * from artist where artistid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		
		return name;
	}
}
