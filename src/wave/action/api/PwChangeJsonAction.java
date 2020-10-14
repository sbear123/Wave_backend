package wave.action.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.PwBean;
import bean.PwChangeDBBean;
import bean.ResultBean;
import wave.action.Action;

public class PwChangeJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		ResultBean result = new ResultBean();
		
		String str = IOUtils.toString(request.getReader());
		PwBean requestUser = gson.fromJson(str, PwBean.class); 
		
		String Check = PwChangeDBBean.getInstance().ChangePw(originPw, newPw)
		
		return gson.toJson(result, ResultBean.class);
	}
}
