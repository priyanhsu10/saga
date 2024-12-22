package pro.com.order_ms.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pro.com.order_ms.entities.Order;
import pro.com.order_ms.repositories.OrderRepository;

import java.util.Optional;
@Slf4j
@Service
public class ReverseOrder {

    private final OrderRepository orderRepository;

    public ReverseOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
@KafkaListener(topics = {"reversed-order"},groupId = "order-group")
    public void reverseOrder(String orderJson) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            Order order = mapper.readValue(orderJson, Order.class);
            Optional<Order> oderlatest = orderRepository.findById(order.getId());
            oderlatest.ifPresent(x -> {
                x.setOrderStatus("Failed");
                orderRepository.save(x);

            });
        } catch (Exception exception) {

      //handle exception
            log.error(exception.getMessage(),exception);
        }
    }

}
