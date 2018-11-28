package com.example.demo.service;

import com.example.demo.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @program: demo
 * @description: 用户类
 * @author: Mr.Ning
 * @create: 2018-11-16 16:24
 **/

public interface IUserService {
    /**
     * 查询所有用户
     * @return
     */
    PageInfo<List<User>> allUser();

//    void job();

    int insert(User record);
}
