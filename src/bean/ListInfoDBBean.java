package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.getname.PlaylistDBBean;

public class ListInfoDBBean extends CommonDBBean {
	//Singleton
		private static ListInfoDBBean instance = new ListInfoDBBean();
		private ListInfoDBBean() {}
		public static ListInfoDBBean getInstance() {
			return instance;
		}
		
		public PlayListBean getList(int listid){
			PlayListBean list = null;
			List<SongBean> songlist = new ArrayList<>();
			SongBean song = null;
			boolean check = false;
			
			Connection conn = getConnection();
			if(conn == null) return null;
			System.out.println("conn");
			
			String sql = "select * from playlistsong where playlistid=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, listid);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					song = SongsDBBean.getInstance().getSong(rs.getInt("songid"), conn);
					songlist.add(song);
					if(!check) {
						list = new PlayListBean();
						list.setJacket(song.getJacket());
					}
					list = new PlayListBean();
					list.setPlaylistid(listid);
					PlayListBean samplelist = PlaylistDBBean.getInstance().getlist(listid, conn);
					list.setDate(samplelist.getDate());
					list.setMaingenre(samplelist.getMaingenre());
					list.setSongs(songlist);
					list.setSubgenre(samplelist.getSubgenre());
					list.setTitle(samplelist.getTitle());
					list.setUserid(samplelist.getUserid());
				}
				rs.close();
				pstmt.close();
				closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				closeConnection(conn);
			}
			
			return list;
		}
}
