package pro.com.stocks_ms.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockUpdateDto {

    private long itemId;
    private long count;

    public StockUpdateDto(long itemId, long count) {
        this.itemId = itemId;
        this.count = count;
    }

    public StockUpdateDto() {
    }
}
