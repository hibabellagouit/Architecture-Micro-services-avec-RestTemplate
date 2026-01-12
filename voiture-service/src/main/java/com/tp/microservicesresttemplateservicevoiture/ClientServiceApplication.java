package com.tp.microservicesresttemplateservicevoiture;

import com.tp.microservicesresttemplateservicevoiture.entities.Car;
import com.tp.microservicesresttemplateservicevoiture.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        // Configuration des timeouts
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);  // 5 secondes pour la connexion
        requestFactory.setReadTimeout(5000);     // 5 secondes pour la lecture

        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }

    @Bean
    CommandLineRunner initialiserBaseH2(CarRepository carRepository) {
        return args -> {
            carRepository.save(new Car(null, "Toyota", "Corolla", "A 25 333", 1L));
            carRepository.save(new Car(null, "Renault", "Megane", "B 6 3456", 1L));
            carRepository.save(new Car(null, "Peugeot", "301", "A 55 4444", 2L));
        };
    }
}