package wave.action.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.AddPlaylistSongDBBean;
import bean.PListBean;
import bean.ResultBean;
import wave.action.Action;

public class AddPlaylistSongJsonAction implements Action{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		ResultBean result = new ResultBean();
		
		// input
		String str = IOUtils.toString(request.getReader());
		PListBean requestList = gson.fromJson(str, PListBean.class); 
		
		System.out.println(requestList.getPlaylistid() + requestList.getSongid());
		int count = AddPlaylistSongDBBean.getInstance().add(requestList);
		if(count==1)
			result.result="ok"; 
		
		return gson.toJson(result, ResultBean.class);
	}
}