package pro.com.order_ms.repositories;

import org.springframework.data.repository.CrudRepository;
import pro.com.order_ms.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
