package pro.com.delivery_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.com.delivery_ms.entities.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {

}
