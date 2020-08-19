package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LoginDBBean {
	//Singleton
	private static LoginDBBean instance = new LoginDBBean();
	private LoginDBBean() {}
	public static LoginDBBean getInstance() {
		return instance;
	}
	
	public UserBean login(String userid, String password) {
		UserBean user=null;
		
		/*try {
			InitialContext cxt = new InitialContext();
			DataSource ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/TestDB" );
			Connection conn = ds.getConnection();
			
			if(conn != null) {
				System.out.println("conn!!");
				conn.close();
			}
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		if(userid.equals("user") && password.equals("1234"))
			user = new UserBean("user", "1234");
		
		return user;
	}
}
