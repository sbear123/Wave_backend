package wave.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.SongBean;
import bean.SongsDBBean;
import wave.action.Action;

public class SongsJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		SongsDBBean db = SongsDBBean.getInstance();
		ArrayList<SongBean> list = db.getSong();
		
		Gson gson = new Gson();
		String result = gson.toJson(list).toString();
		return result;
	}

}