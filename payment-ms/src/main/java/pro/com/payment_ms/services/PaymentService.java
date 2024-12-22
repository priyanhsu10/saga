package pro.com.payment_ms.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.com.payment_ms.Dtos.DeliveryEvent;
import pro.com.payment_ms.Dtos.PaymentDto;
import pro.com.payment_ms.Dtos.PaymentEvent;
import pro.com.payment_ms.entities.Payment;
import pro.com.payment_ms.repository.PaymentRepository;

@Service
public class PaymentService {


    private final PaymentRepository repository;
    private final KafkaTemplate<String, PaymentEvent> paymentEventKafkaTemplate;
    private final KafkaTemplate<String, DeliveryEvent> deliveryEventKafkaTemplate;

    public PaymentService(PaymentRepository repository,
                          KafkaTemplate<String, PaymentEvent> paymentEventKafkaTemplate,
                          KafkaTemplate<String, DeliveryEvent> deliveryEventKafkaTemplate
    ) {
        this.repository = repository;
        this.paymentEventKafkaTemplate = paymentEventKafkaTemplate;
        this.deliveryEventKafkaTemplate = deliveryEventKafkaTemplate;
    }

    @Transactional
    public void registerPayment(PaymentDto paymentDto) {

        //create payment
        Payment paymentFrom = PaymentDto.getPaymentFrom(paymentDto);
        //save payment
        Payment payment = repository.save(paymentFrom);
        //send notification
        sendNotification(payment);


    }

    public void sendNotification(Payment payment) {
        PaymentEvent paymentEvent = new PaymentEvent();
        paymentEvent.setPayment(payment);
        if (payment.getPaymentStatus().equals("Success")) {
            paymentEvent.setEventType("PAYMENT_SUCCESS");

            paymentEventKafkaTemplate.send("payment_status", paymentEvent);
            DeliveryEvent deliveryEvent = new DeliveryEvent();
            deliveryEvent.setOrderId(payment.getOrderId());
            deliveryEventKafkaTemplate.send("initiate_delivery", deliveryEvent);


        } else {
            paymentEvent.setEventType("PAYMENT_FAILED");

            paymentEventKafkaTemplate.send("payment_status", paymentEvent);
        }

    }


}
