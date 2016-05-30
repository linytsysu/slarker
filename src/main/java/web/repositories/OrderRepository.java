package web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.models.TicketOrder;

@Repository
public interface OrderRepository extends CrudRepository<TicketOrder, Long>{
}
