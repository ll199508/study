package com.ll.springcloudprovider1.LoginController;

import com.ll.springcloudapi.entities.User;
import com.ll.springcloudprovider1.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public User login(@RequestBody User userVo){
        System.out.println(userVo);
        return service.login(userVo);
    }
    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    public Boolean reigster(@RequestBody User userVo){
        System.out.println(userVo);

        return service.register(userVo);
    }
}
