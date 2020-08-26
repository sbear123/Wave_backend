package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class RegisterDBBean extends CommonDBBean {
	//Singleton
		private static RegisterDBBean instance = new RegisterDBBean();
		private RegisterDBBean() {}
		public static RegisterDBBean getInstance() {
			return instance;
		}
		
		public ArrayList<ResultBean> getResult(){
			ArrayList<ResultBean> list = new ArrayList<>();
			
			ResultBean e1 = new ResultBean("ok");
			
			list.add(e1);
			
			return list;
		}
}
