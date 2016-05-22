package web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.models.Cinema;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Long> {
}
