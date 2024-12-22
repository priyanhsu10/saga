package pro.com.stocks_ms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pro.com.stocks_ms.entities.Item;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private long id;
    private String name;
    private long quantity;

    public  static ItemDto getItemFromItemDto(Item item){
        return new  ItemDto(item.getId(),item.getName(),item.getQuantity());
    }
}
