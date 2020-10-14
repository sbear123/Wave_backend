package wave.action.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.SearchDBBean;
import bean.KeywordBean;
import bean.SearchBean;
import wave.action.Action;

public class SearchJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		SearchBean result = new SearchBean();
		
		// input
		String str = IOUtils.toString(request.getReader());
		KeywordBean requestKeyword = gson.fromJson(str, KeywordBean.class);
		
		System.out.println(requestKeyword.getKeyword());
		result = SearchDBBean.getInstance().search(requestKeyword.getKeyword());
		
		return gson.toJson(result, SearchBean.class);
	}

}