package wave.action.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.UserFavoritesBean;
import bean.RegisterSongs1DBBean;
import bean.ResultBean;
import wave.action.Action;

public class RegisterSongs1JsonAction implements Action {

	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		ResultBean result = new ResultBean();
		
		// input
		String str = IOUtils.toString(request.getReader());
		UserFavoritesBean requestgenre = gson.fromJson(str, UserFavoritesBean.class); 
		
		System.out.println(requestgenre.getGenre() + requestgenre.getId());
		int count = RegisterSongs1DBBean.getInstance().getGenre(requestgenre);
		if(count==1)
			result.result="ok";
		
		return gson.toJson(result, ResultBean.class);
	}

}