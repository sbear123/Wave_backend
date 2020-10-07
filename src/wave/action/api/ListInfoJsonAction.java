package wave.action.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.ListInfoDBBean;
import bean.PlayListBean;
import wave.action.Action;

public class ListInfoJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		
		// input
		String str = IOUtils.toString(request.getReader());
		PlayListBean requestList = gson.fromJson(str, PlayListBean.class); 
		
		System.out.println(requestList.getPlaylistid());
		PlayListBean list = ListInfoDBBean.getInstance().getList(requestList.getPlaylistid());

		return gson.toJson(list, PlayListBean.class);
	}

}