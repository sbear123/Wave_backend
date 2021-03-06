package bean.getname;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.CommonDBBean;

public class SubgenreDBBean extends CommonDBBean {
	
	//Singleton
		private static SubgenreDBBean instance = new SubgenreDBBean();
		
		private SubgenreDBBean() {}
		
		public static SubgenreDBBean getInstance() {
			return instance;
		}
	
	public String getSubgenre(int mainid, int subid, Connection conn){
		String name = "";
		
		String sql = "select * from subgenre where maingenreid=? And subgenreid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mainid);
			pstmt.setInt(2, subid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}
}
