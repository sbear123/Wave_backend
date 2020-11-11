package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMylistDBBean extends CommonDBBean {
	//Singleton
	private static DeleteMylistDBBean instance = new DeleteMylistDBBean();
	private DeleteMylistDBBean() {}
	public static DeleteMylistDBBean getInstance() {
		return instance;
	}
	
	public ResultBean deleteMyList(String userid, int listid){
		ResultBean result = new ResultBean();
		int count = 0;
		Connection conn = getConnection();
		if(conn == null) return result;
		System.out.println("conn");
		
		String sql = "delete from wave.playlist where userid = ? And playlistid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, listid);
			
			count = pstmt.executeUpdate();
			if(pstmt!=null) pstmt.close();
			closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeConnection(conn);
		}
		
		if (count == 1) {
			result.result = "ok";
		}
		
		return result;
	}
}
