package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.getname.JacketDBBean;

public class SearchAllDBBean extends CommonDBBean{
	// Singleton
	private static SearchAllDBBean instance = new SearchAllDBBean();

	private SearchAllDBBean() {}

	public static SearchAllDBBean getInstance() {
		return instance;
	}

	public SearchBean searchAll() {
		SearchBean result = new SearchBean();
		AlbumBean album = null;
		ArtistBean artist = null;
		SongBean song = null;
		ArrayList<SongBean> songs = new ArrayList<>();
		ArrayList<AlbumBean> albums = new ArrayList<>();
		ArrayList<ArtistBean> artists = new ArrayList<>();
		Connection conn = getConnection();
		if (conn == null)
			return null;
		System.out.println("conn");
		
		String albumsql = "select * from album";
		String artistsql = "select * from artist";
		String songsql = "select * from song";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(albumsql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				album = new AlbumBean();
				album.setAlbumid(rs.getInt("albumid"));
				album.setAlbumname(rs.getString("name"));
				album.setAritstid(rs.getInt("artistid"));
				album.setJacket(rs.getString("jacket"));
				album.setArtistname(artistname(rs.getInt("artistid"),conn));
				albums.add(album);
			}
			
			pstmt = conn.prepareStatement(artistsql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				artist = new ArtistBean();
				artist.setAritstid(rs.getInt("artistid"));
				artist.setArtistname(rs.getString("name"));
				artists.add(artist);
			}
			
			pstmt = conn.prepareStatement(songsql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				song = new SongBean();
				song.setAlbumid(rs.getInt("albumid"));
				song.setArtistid(rs.getInt("artistid"));
				song.setArtistname(artistname(rs.getInt("artistid"), conn));
				song.setMaingenreid(rs.getInt("maingenreid"));
				song.setSongid(rs.getInt("songid"));
				song.setSongurl(rs.getString("songurl"));
				song.setSubgenreid(rs.getInt("subgenreid"));
				song.setTitle(rs.getString("title"));
				song.setWriter(rs.getString("writer"));
				song.setJacket(JacketDBBean.getInstance().getJacket(rs.getInt("songid"), conn));
				songs.add(song);
			}
			rs.close();
			pstmt.close();
			closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			closeConnection(conn);
		}
		result.setAlbum(albums);
		result.setArtist(artists);
		result.setSong(songs);

		return result;
	}
	
	private String artistname(int artistid, Connection conn) {
		String artistname = "";
		
		String albumsql = "select * from artist where artistid=?";
		
		try {
			PreparedStatement pstmts = conn.prepareStatement(albumsql);
			pstmts.setInt(1, (artistid));
			ResultSet rss = pstmts.executeQuery();
			if (rss.next()) {
				artistname = rss.getString("name");
			}
			pstmts.close();
			rss.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return artistname;
	}
}
