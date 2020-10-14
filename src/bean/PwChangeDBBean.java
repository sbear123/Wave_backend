package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PwChangeDBBean extends CommonDBBean {
	private static PwChangeDBBean instance = new PwChangeDBBean();
	private PwChangeDBBean() {}
	private static PwChangeDBBean getInstance() {
		return instance;
	}
	
	public String ChangePw(PwBean userId) {
		String result = "fail";
		Connection conn = getConnection();
		
		if(conn==null) {
			return "fail";
		}
		
		if(originPw == newPw) {
			String sql = "UPDATE user SET password = ? WHERE userid=user";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newPw);
				
				result = "sucess";
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			result = "fail";
		}
		
		closeConnection(conn);
		return result;
		
	}
}
