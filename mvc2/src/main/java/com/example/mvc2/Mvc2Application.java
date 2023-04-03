package com.example.mvc2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Mvc2Application {

    public static void main(String[] args) {
        SpringApplication.run(Mvc2Application.class, args);
    }

}
