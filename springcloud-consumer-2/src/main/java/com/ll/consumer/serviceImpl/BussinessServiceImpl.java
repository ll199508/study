package com.ll.consumer.serviceImpl;

import com.ll.consumer.service2.BussinessService;

import java.util.logging.Logger;

public class BussinessServiceImpl implements BussinessService {
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    @Override
    public String login(String username, String password) {
        return "login success";
    }

    @Override
    public String find() {
        return "find success";
    }
}
