package com.ll.springcloudconsumer.controller;

import com.ll.springcloudapi.entities.Dept;
import com.ll.springcloudapi.entities.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DeptController {
    private static final String REST_URL_PREFIX="http://springcloud-dept";
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "testFallBack")
    @RequestMapping(value = "/consumer/findAll",method = RequestMethod.GET)
    public Dept get(Dept dept){
        System.out.println("2222222222222");
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/findAll/"+1,Dept.class);
    }

    public Dept testFallBack(Dept dept){
        System.out.println("testFallBack-----------------"+dept.toString());
        return new Dept();
    }
}
