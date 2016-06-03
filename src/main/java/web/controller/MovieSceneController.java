package web.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import utils.SlkUtil;
import web.models.MovieScene;
import web.repositories.MovieSceneRepository;

@Controller
public class MovieSceneController {
	@Autowired
	private MovieSceneRepository movie_scene_repo;
	
	@RequestMapping("/get_movie_scene")
	public @ResponseBody Map< Calendar, List<MovieScene> > getMovieScene() {
		Map< Calendar, List<MovieScene> > rst = new HashMap< Calendar, List<MovieScene> >();
		Calendar begin = Calendar.getInstance();
		begin.set(Calendar.MONTH, 5);
		begin.set(Calendar.DAY_OF_MONTH, 27);
		begin.set(Calendar.HOUR, 0);
		begin.set(Calendar.MINUTE, 0);
		begin.set(Calendar.SECOND, 0);
		
//		int cnt = 10;
		for (int i = 1, cnt = 7; i < cnt; ++i) {
			Calendar end = (Calendar) SlkUtil.deepClone(begin);
			end.add(Calendar.DAY_OF_MONTH, 1);
			List<MovieScene> movie_scenes = movie_scene_repo.findByCalendarBetween(begin, end);
			rst.put(begin, movie_scenes);
			begin = end;
		}
		
		return rst;
	}
}
