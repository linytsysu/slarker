package web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.models.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
