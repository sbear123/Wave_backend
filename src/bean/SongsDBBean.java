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
					song.setTitle(rs.getString("title"));
					song.setArtistid(rs.getInt("artistid"));
					song.setMaingenreid(rs.getInt("maingenreid"));
					song.setSubgenreid(rs.getInt("subgenreid"));
					song.setAlbumid(rs.getInt("albumid"));
					song.setLyric(rs.getString("lyric"));
					song.setSongurl(rs.getString("songurl"));
					song.setWriter(rs.getString("songurl"));
					song.setAge(rs.getInt("age"));
					song.setGender(rs.getString("gender"));
					ArtistDBBean name = new ArtistDBBean();
					song.setArtistname(name.getArtist(song.getArtistid()));
					MaingenreDBBean name2 = new MaingenreDBBean();
					song.setMaingenrename(name2.getMaingenre(song.getMaingenreid()));
					SubgenreDBBean name3 = new SubgenreDBBean();
					song.setSubgenrename(name3.getSubgenre(song.getMaingenreid(), song.getSubgenreid()));
					AlbumDBBean name4 = new AlbumDBBean();
					SongBean album = name4.getAlbum(song.getAlbumid());
					song.setAlbumname(album.getAlbumname());
					song.setJacket(album.getJacket());
				}
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			closeConnection(conn);
			return song;
		}
}