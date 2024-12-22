package pro.com.order_ms.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.com.order_ms.dtos.OrderDto;
import pro.com.order_ms.services.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService service;


    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto orderDto) {

        var order = service.create(orderDto);

        return ResponseEntity.ok(order);

    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> get(@PathVariable long id) {

        return ResponseEntity.ok(service.getOrderById(id)) ;

    }

}
