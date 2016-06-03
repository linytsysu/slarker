package web.repositories;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.models.MovieScene;

@Repository
public interface MovieSceneRepository extends CrudRepository<MovieScene, Long> {

	public List<MovieScene> findByCalendarBetween(Calendar begin, Calendar end);
}
