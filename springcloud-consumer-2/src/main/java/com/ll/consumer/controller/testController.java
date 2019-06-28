package com.ll.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
@RestController
public class testController {
    @Autowired
    HttpServletRequest request;
    @RequestMapping(value = "/test")
    public void test(){
        String test = (String) request.getServletContext().getAttribute("test");
        System.out.println(test);
    }
}
