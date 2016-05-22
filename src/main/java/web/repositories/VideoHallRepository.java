package web.repositories;

import web.models.VideoHall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoHallRepository extends CrudRepository<VideoHall, Long> {
	public VideoHall findByVideoHallId(Long videoHallId);
}

