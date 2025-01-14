package org.example.pmanchu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@ConfigurationPropertiesScan
@EnableJpaAuditing
public class PmanchuApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmanchuApplication.class, args);
    }

}
