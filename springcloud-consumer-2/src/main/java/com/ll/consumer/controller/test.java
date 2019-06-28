package com.ll.consumer.controller;

import com.ll.consumer.config.MonitorUtil;
import com.ll.consumer.entities.person;

public class test {
    public static void main(String[] args) {
        try {
            //静态代理
            Class c =Class.forName("com.ll.consumer.controller.StudentProxy");
            MonitorUtil.start();
            person student = new Student("张三");
            person s = new StudentProxy((Student) student);
            s.giveMoney();
            MonitorUtil.finsh(c.getDeclaredMethod("giveMoney",null).toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
