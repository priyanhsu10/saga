package pro.com.stocks_ms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pro.com.stocks_ms.entities.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    public List<Item> findByIdIn(List<Long> ids);

}
