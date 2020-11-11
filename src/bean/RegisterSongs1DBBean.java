package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		Connection conn = getConnection();
		if(conn==null) return 0;
		
		String sql = "insert into userfavorites(userid, maingenre) values (?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, favorite.getId());
			pstmt.setInt(2, favorite.getMainGenreId());
			
			result = pstmt.executeUpdate();
			if(pstmt!=null) pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		
		return result;
	}
}
