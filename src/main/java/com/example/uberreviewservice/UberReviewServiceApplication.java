package com.example.uberreviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = {"com.example.uberprojectentity.models"})
public class UberReviewServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UberReviewServiceApplication.class, args);
    }

}
