package com.ll.consumer.controller;

import com.ll.consumer.entities.person;

public class Student implements person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        try {
            Thread.sleep(1000);
            System.out.println("线程sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"交了班费");
    }
}
