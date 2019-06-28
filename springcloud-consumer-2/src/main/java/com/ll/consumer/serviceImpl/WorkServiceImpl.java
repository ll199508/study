package com.ll.consumer.serviceImpl;

import com.ll.consumer.service2.WorkService;

public class WorkServiceImpl implements WorkService {
    @Override
    public String work() {
        return "work success";
    }

    @Override
    public String sleep() {
        return "sleep success";
    }
}