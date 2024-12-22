package pro.com.payment_ms.Dtos;

import lombok.Data;
import pro.com.payment_ms.entities.Payment;

@Data
public class PaymentEvent {
    String eventType;
    Payment payment;
}
