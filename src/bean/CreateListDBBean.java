package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateListDBBean extends CommonDBBean{

	private static CreateListDBBean instance = new CreateListDBBean();
	private CreateListDBBean() {}
	public static CreateListDBBean getInstance() {
		return instance;
	}
	
	public int CreateList(PlayListBean list) {
		int result = 0;
		Connection conn = getConnection();
		if(conn==null) return 0;
		
		int Maingenreid = 0;
		int Subgenreid = 0;
		
		String sql = "select maingenreid from maingenre where name=?";
	
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, list.getMaingenre());
			
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
		
		sql = "select subgenreid from subgenre where name=? And maingenreid =?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, list.getSubgenre());
			pstmt.setInt(2, Maingenreid);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				Subgenreid = rs.getInt("subgenreid");
			}
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sql = "insert into playlist(userid, title, maingenreid, subgenreid) values (?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, list.getUserid());
			pstmt.setString(2, list.getTitle());
			pstmt.setInt(3, Maingenreid);
			pstmt.setInt(4, Subgenreid);
			
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
