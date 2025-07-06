package com.sagri.licenca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SagriEstoqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SagriEstoqueApplication.class, args);
    }
}