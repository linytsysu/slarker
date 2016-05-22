package web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.models.CityTown;

@Repository
public interface CityTownRepository extends CrudRepository<CityTown, String> {
}
