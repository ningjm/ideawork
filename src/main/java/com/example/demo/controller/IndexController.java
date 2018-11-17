package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

    @Resource
    public IUserService userService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public PageInfo<List<User>> index(){
        PageInfo<List<User>> users = userService.allUser();
        return users;
    }
}
