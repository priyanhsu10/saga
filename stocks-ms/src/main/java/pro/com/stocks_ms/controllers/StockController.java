package pro.com.stocks_ms.controllers;

import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.*;
import pro.com.stocks_ms.dtos.ItemDto;
import pro.com.stocks_ms.services.ItemService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final ItemService service;

    public StockController(ItemService service) {
        this.service = service;
    }

    @GetMapping
 public List<ItemDto> getItems(@RequestParam("ids") String  ids){

    List<Long> list = Arrays.stream(ids.split(",")).map(Long::parseLong).toList();

    return  service.getQuantity(list);

}
}
