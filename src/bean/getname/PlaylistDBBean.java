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
	
	public PlayListBean getlist(int id, Connection conn){
		PlayListBean playlist =  null;
		
		String sql = "select * from playlist where playlistid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				playlist = new PlayListBean();
				playlist.setPlaylistid(rs.getInt("playlistid"));
				playlist.setJacket(JacketDBBean.getInstance().Jacket(id, conn));
				playlist.setUserid(rs.getString("userid"));
				playlist.setDate(rs.getString("date"));
				playlist.setTitle(rs.getString("title"));
				playlist.setMainGenreId(rs.getInt("maingenreid"));
				playlist.setMaingenre(MaingenreDBBean.getInstance().getMaingenre(playlist.getMainGenreId(),conn));
				playlist.setSubGenreId(rs.getInt("subgenreid"));
				playlist.setSubgenre(SubgenreDBBean.getInstance().getSubgenre(playlist.getMainGenreId(), playlist.getSubGenreId(),conn));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return playlist;
	}
}
