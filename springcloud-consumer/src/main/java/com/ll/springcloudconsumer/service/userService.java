package com.ll.springcloudconsumer.service;

import com.ll.springcloudapi.entities.User;
import com.ll.springcloudconsumer.controller.FeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "springcloud-dept",fallbackFactory = FeignClientFallback.class)
public interface userService {
    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public boolean add(User user);
    @RequestMapping(value = "/dept/findAll/{id}",method = RequestMethod.GET)
    public User get(@PathVariable Long id);

    @RequestMapping(value = "/user/hystrix",method = RequestMethod.GET)
    public String hystrix();
}
