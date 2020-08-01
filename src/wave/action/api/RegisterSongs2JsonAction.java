package wave.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.RegisterSongs2Bean;
import bean.RegisterSongs2DBBean;
import wave.action.Action;

public class RegisterSongs2JsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		RegisterSongs2DBBean db = RegisterSongs2DBBean.getInstance();
		ArrayList<RegisterSongs2Bean> list = db.getCrews();
		
		Gson gson = new Gson();
		String result = gson.toJson(list).toString();
		return result;
	}

}