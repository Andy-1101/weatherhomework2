package com.example.mvc1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Mvc1Application {

    public static void main(String[] args) {
        SpringApplication.run(Mvc1Application.class, args);
    }

}
