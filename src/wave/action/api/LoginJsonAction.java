package wave.action.api;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.LoginDBBean;
import bean.ResultBean;
import bean.UserBean;
import wave.action.Action;

public class LoginJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		Gson gson = new Gson();
		ResultBean result = new ResultBean(); // return에 따라 달라지는 부분 
		
		// input
		String str = IOUtils.toString(request.getReader());
		UserBean requestUser = gson.fromJson(str, UserBean.class); // input에 따라 달라지는 부분 
		
		
		
		UserBean user = LoginDBBean.getInstance().login(requestUser.getUserId(), requestUser.getPassword());
		if(user!=null)
			result.result="ok";
		
		return gson.toJson(result, ResultBean.class);
	}

}
