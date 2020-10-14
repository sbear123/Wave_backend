package wave.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.ListDBBean;
import bean.PlayListBean;
import bean.RecommandPlayListBean;
import wave.action.Action;

public class ListJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		ArrayList<RecommandPlayListBean> result = new ArrayList<>();
		
		// input
		String str = IOUtils.toString(request.getReader());
		PlayListBean req = gson.fromJson(str, PlayListBean.class);
		
		result = ListDBBean.getInstance().show(req.getUserid());
		
		return gson.toJson(result, PlayListBean.class);
	}

}