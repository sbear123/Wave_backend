package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterSongs2DBBean extends CommonDBBean {
	//Singleton
	private static RegisterSongs2DBBean instance = new RegisterSongs2DBBean();
	private RegisterSongs2DBBean() {}
	public static RegisterSongs2DBBean getInstance() {
		return instance;
	}
	
public int getGenre(UserFavoritesBean favorite){
		
		int result = 0;
		int Subgenreid = 0;
		int Maingenreid = 0;
		Connection conn = getConnection();
		if(conn==null) return 0;
		
		String sql = "select maingenre from userfavorites where userid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, favorite.getId());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				Maingenreid = rs.getInt("maingenre");
			}
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//서브장르 번호 체크
		sql = "select subgenreid from subgenre where name=? AND maingenreid ='"+Maingenreid+"'";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, favorite.getGenre());
			
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
		
		if(Subgenreid == 0) {
			closeConnection(conn);
			return result;
		}
		
		//서브장르 1 유무 체크
		sql = "select subgenre1 from userfavorites where userid='"+favorite.getId()+"'";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
			int subgenre1 = rs.getInt("subgenre1");
			
			if(subgenre1 != 0) {
				if(subgenre1 == Subgenreid) {
					closeConnection(conn);
					return result;
				}
				sql = "update userfavorites set subgenre2 = '"+Subgenreid+"'where userid ='"+favorite.getId()+"'";
				
				try {
					PreparedStatement pstmt2 = conn.prepareStatement(sql);
					
					result = pstmt2.executeUpdate();
					if(pstmt2!=null) pstmt2.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				sql = "update userfavorites set subgenre1 = '"+Subgenreid+"'where userid ='"+favorite.getId()+"'";
				
				try {
					PreparedStatement pstmt2 = conn.prepareStatement(sql);
					
					result = pstmt2.executeUpdate();
					if(pstmt2!=null) pstmt2.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			 
			}
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection(conn);
		
		
		return result;
	}

	}

