package pro.com.payment_ms.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.com.payment_ms.Dtos.PaymentDto;
import pro.com.payment_ms.services.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService service) {
        this.paymentService = service;
    }

    @PostMapping
    public ResponseEntity<Void> registerPayment(PaymentDto paymentDto) {


        paymentService.registerPayment(paymentDto);

        return ResponseEntity.ok().build();
    }

}
