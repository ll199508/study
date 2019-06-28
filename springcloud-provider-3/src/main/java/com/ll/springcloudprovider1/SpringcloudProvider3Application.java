package com.ll.springcloudprovider1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudProvider3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvider3Application.class, args);
    }

}
