package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.getname.AlbumDBBean;
import bean.getname.ArtistDBBean;
import bean.getname.MaingenreDBBean;
import bean.getname.SubgenreDBBean;

public class SongsDBBean extends CommonDBBean {
	//Singleton
		private static SongsDBBean instance = new SongsDBBean();
		private SongsDBBean() {}
		public static SongsDBBean getInstance() {
			return instance;
		}
		
		public SongBean getSong(int songid){
			SongBean song = null;
			Connection conn = getConnection();
			if(conn == null) return null;
			System.out.println("conn");
			
			String sql = "select * from song where songid=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, songid);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					song = new SongBean();
					song.setSongid(rs.getInt("songid"));
					song.setTitle(rs.getString("title"));
					song.setArtistid(rs.getInt("artistid"));
					song.setMaingenreid(rs.getInt("maingenreid"));
					song.setSubgenreid(rs.getInt("subgenreid"));
					song.setAlbumid(rs.getInt("albumid"));
					song.setLyric(rs.getString("lyric"));
					song.setSongurl(rs.getString("songurl"));
					song.setWriter(rs.getString("writer"));
					song.setAge(rs.getInt("age"));
					song.setGender(rs.getString("gender"));
					song.setArtistname(ArtistDBBean.getInstance().getArtist(song.getArtistid()));
					song.setMaingenrename(MaingenreDBBean.getInstance().getMaingenre(song.getMaingenreid()));
					song.setSubgenrename(SubgenreDBBean.getInstance().getSubgenre(song.getMaingenreid(), song.getSubgenreid()));
					SongBean album = AlbumDBBean.getInstance().getAlbum(song.getAlbumid());
					song.setAlbumname(album.getAlbumname());
					song.setJacket(album.getJacket());
				}
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeConnection(conn);
			}
			
			return song;
		}
}