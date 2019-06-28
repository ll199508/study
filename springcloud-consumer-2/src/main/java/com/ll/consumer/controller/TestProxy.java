package com.ll.consumer.controller;

import com.ll.consumer.entities.person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
//动态代理
        person stu = new Student("张三");

        InvocationHandler invocationHandler = new StuInvocationHandler<person>(stu);

        person person = (person) Proxy.newProxyInstance(person.class.getClassLoader(),new Class<?>[]{person.class},invocationHandler);
        person.giveMoney();

    }
}
