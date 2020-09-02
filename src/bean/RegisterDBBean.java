package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDBBean extends CommonDBBean {
	//Singleton
		private static RegisterDBBean instance = new RegisterDBBean();
		private RegisterDBBean() {}
		public static RegisterDBBean getInstance() {
			return instance;
		}
		
		public int register(UserBean user) {
			int result = 0;
			Connection conn = getConnection();
			if(conn==null) return 0;
		
			
			String sql = "insert into user(userid, password, name) values (?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getUserid());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getName());
				
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
