package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Taste1DBBean extends CommonDBBean {
	//Singleton
	private static Taste1DBBean instance = new Taste1DBBean();
	private Taste1DBBean() {}
	public static Taste1DBBean getInstance() {
		return instance;
	}
	
	public ArrayList<MainGenreBean> getGenres(){
		ArrayList<MainGenreBean> list = new ArrayList<>();
		MainGenreBean genre = null;
		Connection conn = getConnection();
		if(conn == null) return null;
		System.out.println("conn");
		
		String sql = "select * from maingenre";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				genre = new MainGenreBean();
				genre.setMainGenreId(rs.getInt("maingenreid"));
				genre.setMainGenreName(rs.getString("name"));
				list.add(genre);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		
		return list;
	}
}
