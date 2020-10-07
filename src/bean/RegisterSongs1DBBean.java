package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterSongs1DBBean extends CommonDBBean {
	//Singleton
	private static RegisterSongs1DBBean instance = new RegisterSongs1DBBean();
	private RegisterSongs1DBBean() {}
	public static RegisterSongs1DBBean getInstance() {
		return instance;
	}
	
	public int getGenre(UserFavoritesBean favorite){
		
		int result = 0;
		int Maingenreid = 0;
		Connection conn = getConnection();
		if(conn==null) return 0;
		
		
		String sql = "select maingenreid from maingenre where name=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, favorite.getGenre());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				Maingenreid = rs.getInt("maingenreid");
			}
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sql = "insert into userfavorites(userid, maingenre) values (?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, favorite.getId());
			pstmt.setInt(2, Maingenreid);
			
			result = pstmt.executeUpdate();
			if(pstmt!=null) pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection(conn);
		
		
		return result;
	}
}
