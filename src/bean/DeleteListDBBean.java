package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteListDBBean extends CommonDBBean{

	private static DeleteListDBBean instance = new DeleteListDBBean();
	private DeleteListDBBean() {}
	public static DeleteListDBBean getInstance() {
		return instance;
	}
	
	public int DeleteList(int playlistid) {
		
		int result = 0;
		Connection conn = getConnection();
		if(conn==null) return 0;
		
		String sql = "delete from playlist where playlistid = "+playlistid;
	
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
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
