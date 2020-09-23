package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchDBBean extends CommonDBBean{
	// Singleton
	private static SearchDBBean instance = new SearchDBBean();

	private SearchDBBean() {}

	public static SearchDBBean getInstance() {
		return instance;
	}

	public SearchBean search(String keyword) {
		SearchBean result = new SearchBean();
		AlbumBean album = null;
		ArtistBean artist = null;
		SongBean song = null;
		ArrayList<SongBean> songs = null;
		ArrayList<AlbumBean> albums = null;
		ArrayList<ArtistBean> artists = null;
		Connection conn = getConnection();
		if (conn == null)
			return null;
		System.out.println("conn");
		
		String albumsql = "select * from album where title LIKE ?";
		String artistsql = "select * from artist where title LIKE ?";
		String songsql = "select * from song where title LIKE ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(albumsql);
			pstmt.setString(1, ("%"+keyword+"%"));
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				album = new AlbumBean();
				album.setAlbumid(rs.getInt("albumid"));
				album.setAlbumname(rs.getString("albumname"));
				album.setAritstid(rs.getInt("artistid"));
				album.setJacket(rs.getString("jacket"));
				album.setArtistname(artistname(rs.getInt("artistid")));
				albums.add(album);
			}
			pstmt = conn.prepareStatement(artistsql);
			pstmt.setString(1, ("%"+keyword+"%"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				artist = new ArtistBean();
				artist.setAritstid(rs.getInt("artistid"));
				artist.setArtistname(rs.getString("artistname"));
				artists.add(artist);
			}
			pstmt = conn.prepareStatement(songsql);
			pstmt.setString(1, ("%"+keyword+"%"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				song = new SongBean();
				song.setAlbumid(rs.getInt("albumid"));
				song.setArtistid(rs.getInt("artistid"));
				song.setArtistname(artistname(rs.getInt("artistid")));
				song.setMaingenreid(rs.getInt("maingenreid"));
				song.setSongid(rs.getInt("songid"));
				song.setSongurl(rs.getString("songurl"));
				song.setSubgenreid(rs.getInt("subgenreid"));
				song.setTitle(rs.getString("title"));
				song.setWriter(rs.getString("writer"));
				songs.add(song);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		result.setAlbum(albums);
		result.setArtist(artists);
		result.setSong(songs);

		closeConnection(conn);
		return result;
	}
	
	private String artistname(int artistid) {
		Connection conn = getConnection();
		String artistname = "";
		if (conn == null)
			return null;
		System.out.println("conn");
		
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
