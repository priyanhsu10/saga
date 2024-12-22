package pro.com.stocks_ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.com.stocks_ms.entities.Item;
import pro.com.stocks_ms.repositories.ItemRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class StocksMsApplication implements CommandLineRunner {

	@Autowired
	ItemRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(StocksMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Item> collect = Stream.iterate(0, n -> n + 1)
				.map(x -> "item-" + x)
				.map(x->new Item(x,10))
				.limit(10)
				.toList();

		repository.saveAll(collect);
	}
}
