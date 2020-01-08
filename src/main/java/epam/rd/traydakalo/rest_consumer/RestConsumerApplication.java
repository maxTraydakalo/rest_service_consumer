package epam.rd.traydakalo.rest_consumer;

import epam.rd.traydakalo.rest_consumer.entity.Claim;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestConsumerApplication {
    private static final Logger log = LoggerFactory.getLogger(RestConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestConsumerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            Claim claim = restTemplate.getForObject(
                    "http://localhost:8080/claim/1", Claim.class);
            log.info(claim != null ? claim.toString() : null);
        };
    }
}
