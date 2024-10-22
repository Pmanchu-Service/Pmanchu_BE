package org.example.pmanchu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PmanchuApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmanchuApplication.class, args);
    }

}
