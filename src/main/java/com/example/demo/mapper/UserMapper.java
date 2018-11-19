package com.example.demo.mapper;

import com.example.demo.pojo.User;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    /**
     * 查询所有用户
     * @return
     */
    List<User> allUser();
}