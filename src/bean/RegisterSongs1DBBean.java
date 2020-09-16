package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class RegisterSongs1DBBean extends CommonDBBean {
	//Singleton
	private static RegisterSongs1DBBean instance = new RegisterSongs1DBBean();
	private RegisterSongs1DBBean() {}
	public static RegisterSongs1DBBean getInstance() {
		return instance;
	}
	
	public ArrayList<RegisterSongBean> getCrews(){
		ArrayList<RegisterSongBean> list = new ArrayList<>();
		
		return list;
	}
}
