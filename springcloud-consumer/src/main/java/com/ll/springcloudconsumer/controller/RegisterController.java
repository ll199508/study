package com.ll.springcloudconsumer.controller;

import com.ll.springcloudapi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegisterController {
    private static final String REST_URL_PREFIX="http://springcloud-dept";
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value="/register",method= RequestMethod.GET)
    public ModelAndView toRegister(Model model){
        model.addAttribute("user", new User());
        return new ModelAndView("service/register");
    }

    @RequestMapping(value="/register",method=RequestMethod.POST)
    public ModelAndView register(@ModelAttribute(value="user") User user, Model model){
        String url = "service/login";

        User isTrue = restTemplate.postForObject(REST_URL_PREFIX+"/user/register/",user, User.class);

        if(isTrue!=null){
            model.addAttribute("register_success", "注册成功");
            url = "service/login";
        }else{
            url = "service/register";
        }


        return new ModelAndView(url);
    }

}
