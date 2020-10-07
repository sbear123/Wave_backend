package wave.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.ListDBBean;
import bean.MyPlayListDBBean;
import bean.PlayListBean;
import bean.RecommandPlayListBean;
import wave.action.Action;

public class MyPlaylistSongJsonAction implements Action{
	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		MyPlayListDBBean db = MyPlayListDBBean.getInstance();
		ArrayList<PlayListBean> list = db.playListBeans();
		
		Gson gson = new Gson();
		String result = gson.toJson(list).toString();
		System.out.println(result);
		
		return result;
	}
}
