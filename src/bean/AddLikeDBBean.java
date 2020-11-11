package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddLikeDBBean extends CommonDBBean {
	//Singleton
	private static AddLikeDBBean instance = new AddLikeDBBean();
	private AddLikeDBBean() {}
	public static AddLikeDBBean getInstance() {
		return instance;
	}
	
	public ResultBean addMyList(String userid, int listid){
		ResultBean result = new ResultBean();
		int count = 0;
		Connection conn = getConnection();
		if(conn == null) return null;
		System.out.println("conn");
		
		String sql = "insert into mylist(userid, playlistid) values (?,?)";
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
  