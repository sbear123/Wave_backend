package wave.action.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.DeleteLikeDBBean;
import bean.PlayListBean;
import bean.ResultBean;
import wave.action.Action;

public class DeleteLikeJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		Gson gson = new Gson();
		
		// input
		String str = IOUtils.toString(request.getReader());
		PlayListBean requestUser = gson.fromJson(str, PlayListBean.class); // input�뿉 �뵲�씪 �떖�씪吏��뒗 遺�遺� 
		
		System.out.println(str);
		
		ResultBean result = DeleteLikeDBBean.getInstance().deleteMyList(requestUser.getUserid(), requestUser.getPlaylistid());
		
		return gson.toJson(result, ResultBean.class);
	}
}
