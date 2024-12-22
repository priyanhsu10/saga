package pro.com.order_ms.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import pro.com.order_ms.entities.Order;

@Data
public class OrderDto {
        private Long id;
        private String item;
        private int quantity;
        private double amount;
        private String dispatchAddress;
        private String orderStatus;
        private String pickupAddress;

        public static Order getOrderFrom(OrderDto orderDto) {

                Order order = new Order();
                order.setItem(orderDto.getItem());
                order.setAmount(orderDto.getAmount());
                order.setQuantity(orderDto.getQuantity());
                order.setDispatchAddress(orderDto.getDispatchAddress());
                order.setPickupAddress(order.getPickupAddress());
                return order;
        }
        public static OrderDto getOrderDtoFrom(Order order) {

                OrderDto orderDto = new OrderDto();
                orderDto.setItem(order.getItem());
                orderDto.setAmount(order.getAmount());
                orderDto.setQuantity(order.getQuantity());
                order.setDispatchAddress(orderDto.getDispatchAddress());
                order.setPickupAddress(order.getPickupAddress());
                orderDto.setId(order.getId());
                return orderDto;
        }
}
