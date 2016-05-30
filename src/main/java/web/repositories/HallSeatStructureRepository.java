package web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.models.HallSeatStructure;

@Repository
public interface HallSeatStructureRepository extends CrudRepository<HallSeatStructure, Long> {
}
