package wave.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.UserFavoritesBean;
import bean.RegisterSongs1DBBean;
import wave.action.Action;

public class RegisterSongs1JsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		RegisterSongs1DBBean db = RegisterSongs1DBBean.getInstance();
		ArrayList<UserFavoritesBean> list = db.getCrews();
		
		Gson gson = new Gson();
		String result = gson.toJson(list).toString();
		return result;
	}

}