package com.ll.springcloudconsumer.controller;

import com.ll.springcloudapi.entities.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * 页面登陆控制器
 * @Description:
 * @Author:libin
 * @Date: Created in 15:28 2017/11/13
 */
@RestController
@RequestMapping("/")
public class LoginController {
    private static final String REST_URL_PREFIX="http://springcloud-dept";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/")
    public ModelAndView login(ModelAndView modelAndView){

        modelAndView.addObject(new User());
        modelAndView.setViewName("service/login");
        return modelAndView;
    }




    @PostMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, @Valid User userVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            modelAndView.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("service/login");
            return modelAndView;
        }
        modelAndView.setViewName("main");


        String userName = userVo.getUsername();
        String password = userVo.getPassword();
        User userVo1 = restTemplate.postForObject(REST_URL_PREFIX+"/user/login/",userVo, User.class);
        if(userVo1!=null){
            modelAndView.addObject("userName",userName);
            modelAndView.setViewName("main");
            return modelAndView;
        }else {
            modelAndView.setViewName("service/login");
            return modelAndView;
        }
    }


}