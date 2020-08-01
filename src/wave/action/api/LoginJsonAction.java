package wave.action.api;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.RegisterDBBean;
import bean.ResultBean;
import wave.action.Action;

public class LoginJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		RegisterDBBean db = RegisterDBBean.getInstance();
		ArrayList<ResultBean> list = db.getResult();
		
		Gson gson = new Gson();
		String result = gson.toJson(list).toString();
		return result;
	}

}
