package com.ll.springcloudprovider1.service;

import com.ll.springcloudapi.entities.User;

public interface LoginService {

    public User login(User userVo);
    public Boolean register(User user);
}
