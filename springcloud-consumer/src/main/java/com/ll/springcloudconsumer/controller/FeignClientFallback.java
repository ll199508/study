package com.ll.springcloudconsumer.controller;

import com.ll.springcloudapi.entities.User;
import com.ll.springcloudconsumer.service.userService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements FallbackFactory<userService> {

    @Override
    public userService create(Throwable throwable) {
        System.out.println(throwable.toString());
        return new userService() {
            @Override
            public boolean add(User user) {
                return false;
            }

            @Override
            public User get(Long id) {
                return null;
            }

            @Override
            public String hystrix() {

                System.out.println("进入FeignClientFallback");
                return "FeignClientFallback";

            }
        };
    }
}
