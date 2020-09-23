package wave.action.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.CreateListDBBean;
import bean.PlayListBean;
import bean.ResultBean;
import wave.action.Action;

public class CreatePlaylistJsonAction implements Action{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		ResultBean result = new ResultBean();
		
		// input
		String str = IOUtils.toString(request.getReader());
		PlayListBean requestList = gson.fromJson(str, PlayListBean.class); 
		
		System.out.println(requestList.getTitle() + requestList.getUserid());
		int count = CreateListDBBean.getInstance().CreateList(requestList);
		if(count==1)
			result.result="ok";
		
		return gson.toJson(result, ResultBean.class);
	}
}
