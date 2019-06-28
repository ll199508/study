package com.ll.consumer.controller;

import com.ll.consumer.entities.person;

public class StudentProxy implements person {
    Student stu;

    public StudentProxy(Student stu) {
        if(stu.getClass()==Student.class){
            this.stu = (Student)stu;
        }

    }

    @Override
    public void giveMoney() {
        System.out.println("线程sleep1");
        try {
            Thread.sleep(1000);
            System.out.println("线程sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stu.giveMoney();
    }
}
