package com.ll.consumer.controller;

import com.ll.consumer.config.MonitorUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StuInvocationHandler<T> implements InvocationHandler {
    T target;

    public StuInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行"+method.getName());
        MonitorUtil.start();
        Object result = method.invoke(target,args);
        MonitorUtil.finsh(method.getName());

        return result;
    }
}
