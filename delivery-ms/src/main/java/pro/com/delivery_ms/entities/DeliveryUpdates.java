package pro.com.delivery_ms.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DeliveryUpdates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String updates;
    private String status;
    private String trackingId;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

}
