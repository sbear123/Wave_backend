package bean.getname;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.CommonDBBean;
import bean.PlayListBean;

public class PlaylistDBBean extends CommonDBBean {
	
	public PlayListBean getlist(int id){
		PlayListBean playlist =  null;
		Connection conn = getConnection();
		if(conn == null) return null;
		System.out.println("conn");
		
		String sql = "select * from playlist where playlistid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				playlist = new PlayListBean();
				playlist.setPlaylistid(rs.getInt("playlistid"));
				JacketDBBean jacket = new JacketDBBean();
				playlist.setJacket(jacket.getJacket(id));
				playlist.setUserid(rs.getString("userid"));
				playlist.setDate(rs.getString("date"));
				playlist.setTitle(rs.getString("title"));
				MaingenreDBBean name = new MaingenreDBBean();
				playlist.setMaingenre(name.getMaingenre(rs.getInt("maingenreid")));
				SubgenreDBBean name1 = new SubgenreDBBean();
				playlist.setSubgenre(name1.getSubgenre(rs.getInt("maingenreid"), rs.getInt("subgenreid")));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection(conn);
		return playlist;
	}
}
