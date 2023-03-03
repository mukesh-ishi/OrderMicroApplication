package com.example.ordermicroapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderMicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderMicroApplication.class, args);
    }

}
