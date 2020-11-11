package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		String sql = "insert into wave.playlist(userid, title, maingenreid, subgenreid, date) values (?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, list.getUserid());
			pstmt.setString(2, list.getTitle());
			pstmt.setInt(3, list.getMainGenreId());
			pstmt.setInt(4, list.getSubGenreId());
			
			SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
			Date time = new Date();
			String time1 = format1.format(time);
			pstmt.setString(5, time1);
			
			result = pstmt.executeUpdate();
			if(pstmt!=null) pstmt.close();
			closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeConnection(conn);
		}
		
		return result;
	}
}
