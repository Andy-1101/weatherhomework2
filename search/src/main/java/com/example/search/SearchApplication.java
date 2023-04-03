package com.example.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableCircuitBreaker
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }

    // swagger Configuration
    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/weather/search/**"))
                .apis(RequestHandlerSelectors.basePackage("com"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Search Service API",
                "Search contains Student service and 3rd-party entries service",
                "1.0",
                "http://serviceTerm.com",
                new springfox.documentation.service.Contact("Junyu Mou","http://junyumou.com","test@test.com"),
                "ApI License",
                "http://test.io",
                Collections.emptyList());

    }


}