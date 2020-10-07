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
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		
		ArrayList<MainGenreBean> list = Taste1DBBean.getInstance().getGenres();

		return gson.toJson(list);
	}

}