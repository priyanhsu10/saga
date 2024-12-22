package pro.com.delivery_ms.Listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.id.GUIDGenerator;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pro.com.delivery_ms.dtos.DeliveryEvent;
import pro.com.delivery_ms.dtos.OrderDto;
import pro.com.delivery_ms.entities.Delivery;
import pro.com.delivery_ms.repository.DeliveryRepository;
import pro.com.delivery_ms.services.OderService;

import java.util.UUID;
@Component
public class OderInitiateListener {
    private final ObjectMapper mapper;
    private final OderService service;
    private final DeliveryRepository repository;

    public OderInitiateListener(ObjectMapper mapper, OderService service,
                                DeliveryRepository repository) {
        this.mapper = mapper;
        this.service = service;
        this.repository = repository;
    }

    @KafkaListener(topics = {"initiate_delivery"}, groupId = "initiate_delivery")

    public void initiate(String data) throws JsonProcessingException {

        DeliveryEvent deliveryEvent = mapper.readValue(data, DeliveryEvent.class);

        OrderDto orderDto = service.getOrderById(deliveryEvent.getOrderId());

        Delivery delivery = new Delivery();
        delivery.setPickupAddress(orderDto.getPickupAddress());
        delivery.setDispatchAddress(orderDto.getDispatchAddress());
        delivery.setCourier("AMAZON");
        delivery.setOrderId(orderDto.getId());
        delivery.setTrackingId(UUID.randomUUID().toString());
        repository.save(delivery);


    }
}
