package wave.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.ListDBBean;
import bean.RecommandedPlayListBean;
import wave.action.Action;

public class ListJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		ListDBBean db = ListDBBean.getInstance();
		ArrayList<RecommandedPlayListBean> list = db.getCrews();
		
		Gson gson = new Gson();
		String result = gson.toJson(list).toString();
		return result;
	}

}