package pro.com.stocks_ms.dtos;

import lombok.Data;

import java.util.List;
@Data
public class StockUpdateEvent {

    List<StockUpdateDto> stockUpdateDtoList;

}
