package pro.com.delivery_ms.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pro.com.delivery_ms.dtos.OrderDto;

@FeignClient(name = "example-api", url = "https://localhost:8081")
public interface OderService {

    @GetMapping("/api/order/{id}")
    OrderDto getOrderById(@PathVariable("id") Long id);


}
