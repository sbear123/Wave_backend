package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Taste2DBBean extends CommonDBBean {
	//Singleton
	private static Taste2DBBean instance = new Taste2DBBean();
	private Taste2DBBean() {}
	public static Taste2DBBean getInstance() {
		return instance;
	}
	
	public ArrayList<SubGenreBean> getFeels(int genreid){
		ArrayList<SubGenreBean> list = new ArrayList<>();
		SubGenreBean genre = null;
		Connection conn = getConnection();
		if(conn == null) return null;
		System.out.println("conn");
		
		String sql = "select * from subgenre where maingenreid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, genreid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				genre = new SubGenreBean();
				genre.setSubGenreId(rs.getInt("subgenreid"));
				genre.setSubGenreName(rs.getString("name"));
				list.add(genre);
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
}
