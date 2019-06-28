package com.ll.springcloudprovider1;

import com.ll.springcloudapi.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

    public Boolean add(Dept dept);

    public Dept findAll(Long id);
}
