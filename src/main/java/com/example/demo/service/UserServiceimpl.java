package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: demo
 * @description: 用户类
 * @author: Mr.Ning
 * @create: 2018-11-16 16:25
 **/

@Service
public class UserServiceimpl implements IUserService {

    @Resource
    UserMapper userMapper;

    @Override
    public PageInfo<List<User>>  allUser() {
        PageHelper.startPage(1,10);
        List<User> users = userMapper.allUser();
        return new PageInfo(users);
    }

    @Transactional
    @Override
    public int insert(User record) {
        userMapper.insert(record);
        int a = 1/0;
        userMapper.insert(record);
        return 1;
    }
}
