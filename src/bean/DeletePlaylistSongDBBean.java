package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletePlaylistSongDBBean extends CommonDBBean {

	private static DeletePlaylistSongDBBean instance = new DeletePlaylistSongDBBean();
	private DeletePlaylistSongDBBean() {}
	public static DeletePlaylistSongDBBean getInstance() {
		return instance;
	}

	public int DeleteSong(int playlistid, int songid) {

		int result = 0;
		Connection conn = getConnection();
		if(conn==null) return 0;

		String sql = "delete from wave.playlistsong where playlistid = "+playlistid+" And songid ="+ songid;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();

			if(pstmt!=null) pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		
		return result;
	}
}
