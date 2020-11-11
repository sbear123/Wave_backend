package bean.getname;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.CommonDBBean;
import bean.PlayListBean;

public class PlaylistDBBean extends CommonDBBean {
	
	//Singleton
		private static PlaylistDBBean instance = new PlaylistDBBean();
		
		private PlaylistDBBean() {}
		
		public static PlaylistDBBean getInstance() {
			return instance;
		}
	
	public PlayListBean getlist(int id){
		PlayListBean playlist =  null;
		
		Connection conn1 = getConnection();
		if(conn1 == null) return null;
		System.out.println("conn");
		
		String sql = "select * from playlist where playlistid=?";
		try {
			PreparedStatement pstmt = conn1.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				playlist = new PlayListBean();
				playlist.setPlaylistid(rs.getInt("playlistid"));
				playlist.setJacket(JacketDBBean.getInstance().getJacket(id));
				playlist.setUserid(rs.getString("userid"));
				playlist.setDate(rs.getString("date"));
				playlist.setTitle(rs.getString("title"));
				playlist.setMainGenreId(rs.getInt("maingenreid"));
				playlist.setMaingenre(MaingenreDBBean.getInstance().getMaingenre(playlist.getMainGenreId()));
				playlist.setSubGenreId(rs.getInt("subgenreid"));
				playlist.setSubgenre(SubgenreDBBean.getInstance().getSubgenre(playlist.getMainGenreId(), playlist.getSubGenreId()));
			}
			rs.close();
			pstmt.close();
			closeConnection(conn1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeConnection(conn1);
		}
		
		return playlist;
	}
}
