package pro.com.order_ms.dtos;

import lombok.Data;
import pro.com.order_ms.entities.Order;

@Data
public class OrderEvent {

    private Order order;
    private String eventType;

}
