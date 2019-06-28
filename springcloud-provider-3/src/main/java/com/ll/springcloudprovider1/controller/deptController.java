package com.ll.springcloudprovider1.controller;

import com.ll.springcloudapi.entities.Dept;
import com.ll.springcloudprovider1.service.deptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class deptController {

    @Autowired
    private deptService service;
    @RequestMapping(value = "dept/add",method = RequestMethod.POST)
    public Boolean add(@RequestBody Dept dept){
        System.out.println(dept);
       return   service.add(dept);
    }
    @RequestMapping(value = "/dept/findAll/{id}",method = RequestMethod.GET)
    private Dept  findAll(@PathVariable("id") Long id){
        System.out.println(123);
        return service.findAll(id);
    }

}
