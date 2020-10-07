package wave.action.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.SongBean;
import bean.SongsDBBean;
import wave.action.Action;

public class SongsJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		
		String str = IOUtils.toString(request.getReader());
		SongBean input = gson.fromJson(str, SongBean.class);
		
		SongBean song = SongsDBBean.getInstance().getSong(input.getSongid());
		
		return gson.toJson(song, SongBean.class);
	}

}