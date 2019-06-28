package com.ll.consumer.config;

import com.ll.consumer.service.HelloService;
import com.ll.consumer.service.HelloService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

@Component
public class TestStarted implements ServletContextAware {
    @Autowired
    HelloService service;

    @Autowired
    HelloService2 service2;
    /**
     * 在填充普通bean属性之后但在初始化之前调用
     * 类似于initializingbean的afterpropertiesset或自定义init方法的回调
     *
     */
    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setAttribute("test","测试");
        System.out.println("setServletContext方法");
        service2.hello();

    }
}