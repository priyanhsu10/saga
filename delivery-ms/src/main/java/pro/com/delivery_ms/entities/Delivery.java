package pro.com.delivery_ms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String DeliveryMode;
    private String Courier;
    private long orderId;
    private String pickupAddress;
    private String dispatchAddress;

    private String trackingId;
    private  String trackingStatus;
    @OneToMany(mappedBy = "delivery")
    private List<DeliveryUpdates> deliveryUpdatesList;

}
