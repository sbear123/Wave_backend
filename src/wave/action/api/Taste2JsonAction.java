package wave.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.MainGenreBean;
import bean.SubGenreBean;
import bean.Taste2DBBean;
import wave.action.Action;

public class Taste2JsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		
		// input
		String str = IOUtils.toString(request.getReader());
		MainGenreBean requestList = gson.fromJson(str, MainGenreBean.class); 
		
		System.out.println(requestList.getMainGenreId());
		ArrayList<SubGenreBean> list = Taste2DBBean.getInstance().getFeels(requestList.getMainGenreId());

		return gson.toJson(list);
	}

}