package com.ford.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CouponManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponManagementSystemApplication.class, args);
    }

}
