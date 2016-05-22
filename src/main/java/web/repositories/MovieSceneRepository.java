package web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.models.MovieScene;

@Repository
public interface MovieSceneRepository extends CrudRepository<MovieScene, Long> {
}
