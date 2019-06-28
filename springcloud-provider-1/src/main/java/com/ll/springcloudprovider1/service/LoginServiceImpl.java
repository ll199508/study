package com.ll.springcloudprovider1.service;

import com.ll.springcloudapi.entities.User;
import com.ll.springcloudprovider1.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    UserDao userDao;
    @Override
    public User login(User userVo) {
        return userDao.login(userVo);
    }

    @Override
    public Boolean register(User user) {
        return userDao.register(user);
    }
}
