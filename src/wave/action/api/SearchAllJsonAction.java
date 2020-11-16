package wave.action.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.SearchBean;
import bean.SearchAllDBBean;
import wave.action.Action;

public class SearchAllJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		
		SearchBean result = new SearchBean();
		result = SearchAllDBBean.getInstance().searchAll();
		
		return gson.toJson(result, SearchBean.class);
	}
}