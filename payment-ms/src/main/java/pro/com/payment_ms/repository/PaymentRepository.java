package pro.com.payment_ms.repository;

import org.springframework.data.repository.CrudRepository;
import pro.com.payment_ms.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment,Long> {
}
