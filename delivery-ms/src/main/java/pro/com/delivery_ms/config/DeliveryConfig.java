package pro.com.delivery_ms.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeliveryConfig {
@Bean
public ObjectMapper mapper(){
    return new ObjectMapper();
}
}
