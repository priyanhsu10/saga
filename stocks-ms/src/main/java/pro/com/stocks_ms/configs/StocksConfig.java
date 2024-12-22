package pro.com.stocks_ms.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StocksConfig {
    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper();
    }
}
