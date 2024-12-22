package pro.com.order_ms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
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
