package com.ll.consumer.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Test2 {
    //静态代码块会在依赖注入后自动执行,并优先执行
    static{

        System.out.println("---static--");
    }
    /**
     *  @Postcontruct’在依赖注入完成后自动调用
     */
    @PostConstruct
    public static void haha(){
        System.out.println("@Postcontruct’在依赖注入完成后自动调用");
    }
}