package pro.com.delivery_ms.dtos;

import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private String item;
    private int quantity;
    private double amount;
    private String dispatchAddress;
    private String pickupAddress;
    private String orderStatus;
    private String paymentStatus;
    private String deliveryStatus;

}
