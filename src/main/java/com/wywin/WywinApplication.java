package com.wywin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class WywinApplication {

    public static void main(String[] args) {
        SpringApplication.run(WywinApplication.class, args);
    }

}
