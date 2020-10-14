package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PwChangeDBBean extends CommonDBBean {
	private static PwChangeDBBean instance = new PwChangeDBBean();
	private PwChangeDBBean() {}
	public static PwChangeDBBean getInstance() {
		return instance;
	}
	
	
	public String ChangePw(PwBean user) {
		String result = "fail";
		Connection conn = getConnection();
		if(conn==null) {
			return "fail";
		}
		
		String getPw = "select * from user where userid = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(getPw);
			pstmt.setString(1, user.getUserId());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString("password"));
				System.out.println(user.getOrginPw());
				if (user.getOrginPw().equals(rs.getString("password"))) {
					UpdatePassword(user.getUserId(), user.getNewPw());
					result = "ok";
				}
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection(conn);
		return result;
		
	}
	
	private void UpdatePassword(String userid,String password) {
		Connection conn = getConnection();
		if(conn==null) {
			return;
		}
		
		String updatePw = "UPDATE user set password = ? where userid = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(updatePw);
			pstmt.setString(1, password);
			pstmt.setString(2, userid);
			
			pstmt.executeUpdate();
			if(pstmt!=null) pstmt.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(conn);
	}
}