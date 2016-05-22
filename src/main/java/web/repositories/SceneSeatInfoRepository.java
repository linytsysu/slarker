package web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.models.SceneSeatInfo;

@Repository
public interface SceneSeatInfoRepository extends CrudRepository<SceneSeatInfo, Long> {
}
