package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeletePlaylistDBBean extends CommonDBBean {

	private static DeletePlaylistDBBean instance = new DeletePlaylistDBBean();
	private DeletePlaylistDBBean() {}
	public static DeletePlaylistDBBean getInstance() {
		return instance;
	}

	public int DeleteList(String userid, int playlistid) {
		int result = 0;
		Connection conn = getConnection();
		if(conn==null) return 0;
		
		String sql = "Select * from wave.playlist where userid = ? And playlistid = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, playlistid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				SelectPlaylistSongs(playlistid,conn);
				result = DeletePlaylist(userid, playlistid, conn);
			}
			rs.close();
			pstmt.close();
			closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeConnection(conn);
		}
		
		return result;
	}
	
	private int DeletePlaylist(String userid, int playlistid, Connection conn) {
		int result = 0;

		String sql = "delete from wave.playlist where userid = ? And playlistid = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, playlistid);
			result = pstmt.executeUpdate();

			if(pstmt!=null) pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	private void SelectPlaylistSongs(int playlistid, Connection conn) {
		String sql = "Select * from wave.playlistsong where playlistid = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, playlistid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				DeletePlaylistSongs(rs.getInt("playlistid"),rs.getInt("songid"),conn);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void DeletePlaylistSongs(int playlistid, int songid, Connection conn) {
		String sql = "delete from wave.playlistsong where playlistid = ? And songid = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, playlistid);
			pstmt.setInt(2, songid);
			pstmt.executeUpdate();

			if(pstmt!=null) pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
