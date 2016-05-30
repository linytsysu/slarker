package web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.models.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region, String> {

	public Region findByCode(String code);

}
