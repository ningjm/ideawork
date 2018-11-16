package com.example.demo.controller;

import com.example.demo.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public Map<String,User> index(){
        Map<String,User> map = new HashMap();
        User user = new User();
        user.setName("NJM");
        user.setAge(155);
        user.setMoney(8830.6);
        User user2 = new User();
        user2.setName("NJM2");
        user2.setAge(1889);
        user2.setMoney(8830.1);
        User user3 = new User();
        user3.setName("NJM3");
        user3.setAge(234);
        user3.setMoney(8830.2);
        map.put("first",user);
        map.put("second",user2);
        map.put("third",user3);
        return map;
    }
}
