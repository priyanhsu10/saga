package pro.com.order_ms.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.com.order_ms.dtos.OrderDto;
import pro.com.order_ms.dtos.OrderEvent;
import pro.com.order_ms.entities.Order;
import pro.com.order_ms.repositories.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public OrderService(OrderRepository orderRepository, KafkaTemplate<String, OrderEvent> kafkaTemplate) {

        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public OrderDto create(OrderDto orderDto) {
        Order order = OrderDto.getOrderFrom(orderDto);
        order.setOrderStatus("Created");
        try {
            order = orderRepository.save(order);

            OrderEvent orderEvent = new OrderEvent();
            orderEvent.setOrder(order);
            orderEvent.setEventType("ORDER_CREATED");


            kafkaTemplate.send("new-order", orderEvent);


        } catch (Exception exception) {

            order.setOrderStatus("Failed");
            orderRepository.save(order);
        }
        return OrderDto.getOrderDtoFrom(order);

    }

    public  OrderDto getOrderById(long id){

        Optional<Order> optionalOrder = orderRepository.findById(id);

        if(optionalOrder.isPresent()){
            return OrderDto.getOrderDtoFrom( optionalOrder.get());
        }
        throw new RuntimeException("Order not found");

    }
}
