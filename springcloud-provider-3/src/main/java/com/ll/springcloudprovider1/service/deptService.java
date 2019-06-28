package com.ll.springcloudprovider1.service;

import com.ll.springcloudapi.entities.Dept;

import java.util.List;

public interface deptService {
    public Boolean add(Dept dept);

    public Dept findAll(Long id);
}
