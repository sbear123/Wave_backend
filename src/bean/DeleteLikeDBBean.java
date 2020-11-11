package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteLikeDBBean extends CommonDBBean {
	//Singleton
	private static DeleteLikeDBBean instance = new DeleteLikeDBBean();
	private DeleteLikeDBBean() {}
	public static DeleteLikeDBBean getInstance() {
		return instance;
	}
	
	public ResultBean deleteMyList(String userid, int listid){
		ResultBean result = new ResultBean();
		int count = 0;
		Connection conn = getConnection();
		if(conn == null) return null;
		System.out.println("conn");
		
		String sql = "delete from wave.mylist where userid = ? And playlistid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, listid);
			
			count = pstmt.executeUpdate();
			if(pstmt!=null) pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		
		if (count == 1) {
			result.result = "ok";
		}
		
		return result;
	}
}
