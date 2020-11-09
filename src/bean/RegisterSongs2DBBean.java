package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterSongs2DBBean extends CommonDBBean {
	// Singleton
	private static RegisterSongs2DBBean instance = new RegisterSongs2DBBean();

	private RegisterSongs2DBBean() {
	}

	public static RegisterSongs2DBBean getInstance() {
		return instance;
	}

	public int getGenre(UserFavoritesBean favorite) {

		int result = 0;
		int checkNull = 0;
		int subgenre1 = 0;
		Connection conn = getConnection();
		if (conn == null)
			return 0;
		
		String sql = "select subgenre1 from userfavorites where userid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, favorite.getId());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				if (rs.getInt("subgenre1") != 0) {
					checkNull = 1;
					subgenre1 = rs.getInt("subgenre1");
				}
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (subgenre1 == favorite.getSubGenreId()) {
			return 0;
		}
		if (checkNull == 0) {
			sql = "UPDATE userfavorites set subgenre1 = ? where userid = ?";
		} else {
			sql = "UPDATE userfavorites set subgenre2 = ? where userid = ?";
		}
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, favorite.getSubGenreId());
			pstmt.setString(2, favorite.getId());

			result = pstmt.executeUpdate();
			if (pstmt != null)
				pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection(conn);

		return result;
	}

}
