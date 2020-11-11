package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddPlaylistSongDBBean extends CommonDBBean{
	//Singleton
	private static AddPlaylistSongDBBean instance = new AddPlaylistSongDBBean();
	private AddPlaylistSongDBBean() {}
	public static AddPlaylistSongDBBean getInstance() {
		return instance;
	}
	
	public int add(PListBean plist) {
		int result = 0;
		Connection conn = getConnection();
		if(conn==null) return 0;
		System.out.println("conn");
		
		String sql = "insert into wave.playlistsong(playlistid, songid) values (?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, plist.getPlaylistid());
			pstmt.setInt(2, plist.getSongid());
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
