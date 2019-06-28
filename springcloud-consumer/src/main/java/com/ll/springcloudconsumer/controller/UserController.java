package com.ll.springcloudconsumer.controller;

import com.ll.springcloudapi.entities.Dept;
import com.ll.springcloudapi.entities.User;
import com.ll.springcloudconsumer.service.userService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    private static final String REST_URL_PREFIX="http://springcloud-dept";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private userService service;
    @RequestMapping(value = "/consumer/getU/{id}")
    public User get(@PathVariable Long id){
        System.out.println(id);
        return service.get(id);
    }
    @GetMapping(value = "/user/hystrix")
    public String hystrix(){
        service.hystrix();
        System.out.println("testFallBack---");
        return "hystrix";
    }
    @RequestMapping(value = "/consumer/addU")
    public boolean add(User user){
        return service.add(user);
    }

}
