package com.ll.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class HelloService2 {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void hello(){
        ValueOperations ops = stringRedisTemplate.opsForValue();
        ops.set("k2","v2");
        String v2= (String) ops.get("k2");
        System.out.println(v2);
    }
}
