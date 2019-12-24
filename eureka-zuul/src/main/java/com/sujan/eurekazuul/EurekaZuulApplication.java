package com.sujan.eurekazuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy //enable zuul proxy
public class EurekaZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaZuulApplication.class, args);
    }

}
