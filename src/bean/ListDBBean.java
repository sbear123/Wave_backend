package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ListDBBean extends CommonDBBean {
	//Singleton
	private static ListDBBean instance = new ListDBBean();
	
	private ListDBBean() {}
	
	public static ListDBBean getInstance() {
		return instance;
	}

	public RecommandPlayListBean show(String userid) {
		RecommandPlayListBean result = new RecommandPlayListBean();
		
		int Maingenre=0;
		int Subgenre1=0;
		int Subgenre2=0;
		
		PlayListBean list = null;
		ArrayList<PlayListBean> lists = new ArrayList<>();
		
		Connection conn = getConnection();
		if(conn==null) return null;
		
		String sql = "Select * from userfavorites where userid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				Maingenre = rs.getInt("maingenre");
				Subgenre1 = rs.getInt("Subgenre1");
				Subgenre2 = rs.getInt("Subgenre2");
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<String> jacketlist = new ArrayList<>();
		for(int i = 1; i<=3; i++) {
			jacketlist = getJacketUrl(Maingenre, Subgenre1, Subgenre2, i);
		}
		
		for(String i : jacketlist) { //for문을 통한 전체출력
		    System.out.println(i);
		}
		
		
		return null;
	}
	
	
	
	private ArrayList<String> getJacketUrl(int maingenre, int subgenre1, int subgenre2, int num) {
		Connection conn = getConnection();
		if (conn == null)
			return null;
		System.out.println("conn");
		
		String genre = null;
		int choose = 0;
		int count = 0;
		ArrayList<String> jacketlist = new ArrayList<>();
		
		switch(num) {
		case 1:
			genre = "maingenreid";
			choose = maingenre;
			break;
		case 2:
			genre = "subgenreid";
			choose = subgenre1;
			break;
		case 3:
			genre = "subgenreid";
			choose = subgenre2;
			break;
		}
		
		String playlistsql = "select playlistid from playlist where" + genre +"= ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(playlistsql);
			pstmt.setInt(1, choose);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next() && count<3) {
				count++;
				ArrayList<Integer> playlist = new ArrayList<>();
				playlist.add(rs.getInt("playlistid"));
				
				String songsql = "select songid from playlistsong where playlistid = ?";
				try {
					PreparedStatement pstmt1 = conn.prepareStatement(songsql);
					for(Integer i : playlist) { //for문을 통한 전체출력
						pstmt1.setInt(1, i);
						ResultSet rs1 = pstmt1.executeQuery();
						if(rs1.next()) {
							//ArrayList<Integer> songlist = new ArrayList<>();
							//songlist.add(rs.getInt("songid"));
							int songid = (rs1.getInt("songid"));
							
							String albumsql = "select albumid from song where songid = ?";
							try {
								PreparedStatement pstmt2 = conn.prepareStatement(albumsql);
									pstmt2.setInt(1, songid);
									ResultSet rs2 = pstmt2.executeQuery();
									if(rs2.next()) {
										int albumid = rs2.getInt("albumid");
										
										String jacketsql = "select jacket from album where albumid = ?";
										try {
											PreparedStatement pstmt3 = conn.prepareStatement(jacketsql);
											pstmt3.setInt(1, albumid);
											ResultSet rs3 = pstmt3.executeQuery();
											if(rs3.next()) {
											jacketlist.add(rs3.getString("jacket"));
											}
											
											rs3.close();
											pstmt3.close();
											
										}catch (SQLException e) {
											e.printStackTrace();
										}
										
									}
									rs2.close();
									pstmt2.close();
									
								}catch(SQLException e) {
								e.printStackTrace();
							}
						}
					}
					//rs1.close();
					pstmt1.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return jacketlist;
	}
}
