package com.ll.springcloudprovider1;


import com.ll.springcloudapi.entities.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public User login(User userVo);
    public Boolean register(User userVo);
}
