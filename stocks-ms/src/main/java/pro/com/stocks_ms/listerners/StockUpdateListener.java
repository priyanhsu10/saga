package pro.com.stocks_ms.listerners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pro.com.stocks_ms.dtos.StockUpdateEvent;
import pro.com.stocks_ms.services.ItemService;

@Component
public class StockUpdateListener {

    private final ObjectMapper mapper;
    private final ItemService service;

    public StockUpdateListener(ObjectMapper mapper, ItemService service) {
        this.mapper = mapper;
        this.service = service;
    }
    @KafkaListener(topics = {"update_stocks"},groupId = "update_stock")
    public  void updateStocks(String data) throws JsonProcessingException {

    var event = mapper.readValue(data, StockUpdateEvent.class);

    service.update(event.getStockUpdateDtoList());
}
}
