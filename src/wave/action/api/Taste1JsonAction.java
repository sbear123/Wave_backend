package wave.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.MainGenreBean;
import bean.Taste1DBBean;
import wave.action.Action;

public class Taste1JsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Taste1DBBean db = Taste1DBBean.getInstance();
		ArrayList<MainGenreBean> list = db.getCrews();
		
		Gson gson = new Gson();
		String result = gson.toJson(list).toString();
		return result;
	}

}