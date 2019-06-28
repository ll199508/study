package com.ll.springcloudprovider1.service;

import com.ll.springcloudapi.entities.Dept;
import com.ll.springcloudprovider1.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class deptServiceImpl implements deptService{

    @Autowired
    private DeptDao deptDao;
    @Override
    public Boolean add(Dept dept) {
        return deptDao.add(dept);
    }

    @Override
    public Dept findAll(Long id) {
        return deptDao.findAll(id);
    }
}
