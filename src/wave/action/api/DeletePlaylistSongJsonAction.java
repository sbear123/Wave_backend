package wave.action.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.DeletePlaylistSongDBBean;
import bean.PListBean;
import bean.ResultBean;
import wave.action.Action;

public class DeletePlaylistSongJsonAction implements Action{

	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		ResultBean result = new ResultBean();

		// input
		String str = IOUtils.toString(request.getReader());
		PListBean list = gson.fromJson(str, PListBean.class);

		System.out.println(list.getlistId());
		int count = DeletePlaylistSongDBBean.getInstance().DeleteSong(list.getlistId(), list.getSongid());

		if(count==1)
			result.result="ok";

		return gson.toJson(result, ResultBean.class);
	}
}
