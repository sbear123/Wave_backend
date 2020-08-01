package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class RegisterSongs2DBBean {
	//Singleton
	private static RegisterSongs2DBBean instance = new RegisterSongs2DBBean();
	private RegisterSongs2DBBean() {}
	public static RegisterSongs2DBBean getInstance() {
		return instance;
	}
	
	public ArrayList<RegisterSongs2Bean> getCrews(){
		ArrayList<RegisterSongs2Bean> list = new ArrayList<>();
		
		return list;
	}
}
