package pro.com.stocks_ms.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pro.com.stocks_ms.dtos.ItemDto;
import pro.com.stocks_ms.dtos.StockUpdateDto;
import pro.com.stocks_ms.repositories.ItemRepository;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemDto> getQuantity(List<Long> itemIds) {

        return itemRepository.findByIdIn(itemIds)
                .stream().map(ItemDto::getItemFromItemDto)
                .toList();

    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void update(List<StockUpdateDto> stockUpdateDtoList) {

        List<Long> itemIds = stockUpdateDtoList.stream().map(x -> x.getItemId()).toList();

        var itemsList = itemRepository.findByIdIn(itemIds);

        for (StockUpdateDto x : stockUpdateDtoList) {
            var item = itemsList.
                    stream()
                    .filter(y -> y.getId() == x.getItemId())
                    .findFirst().get();
            item.setQuantity(item.getQuantity() + x.getCount());

        }
        itemRepository.saveAll(itemsList);

    }
}
