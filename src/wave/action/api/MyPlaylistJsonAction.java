package wave.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.MyPlayListDBBean;
import bean.MyPlaylistBean;
import bean.UserBean;
import wave.action.Action;

public class MyPlaylistJsonAction implements Action{
	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		
		// input
		String str = IOUtils.toString(request.getReader());
		UserBean requestUser = gson.fromJson(str, UserBean.class); 
		
		System.out.println(requestUser.getUserId());
		ArrayList<MyPlaylistBean> mylist = MyPlayListDBBean.getInstance().Mylist(requestUser.getUserId());

		String list = gson.toJson(mylist).toString();
		System.out.println(list);
		
		return list;
	}
}
