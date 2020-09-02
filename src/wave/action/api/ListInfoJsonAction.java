package wave.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.ListInfoDBBean;
import bean.PlayListSongBean;
import wave.action.Action;

public class ListInfoJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		ListInfoDBBean db = ListInfoDBBean.getInstance();
		ArrayList<PlayListSongBean> list = db.getList();
		
		Gson gson = new Gson();
		String result = gson.toJson(list).toString();
		return result;
	}

}