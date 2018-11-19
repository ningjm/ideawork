package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * 可以用maven的install来打jar、war包
 */

//@RestController
@Controller
public class IndexController {

    @Resource
    public IUserService userService;

    @RequestMapping(value = "/page_info",method = RequestMethod.GET)
    public PageInfo<List<User>> page_info(){
        //若要返回json数据，把Controller改为RestController
        PageInfo<List<User>> users = userService.allUser();
        return users;
    }

    @RequestMapping(value = "/index_html",method = RequestMethod.GET)
    public String index_html(){
        /**
         * spring.thymeleaf.prefix
         * 指定模板的前缀，默认为:classpath:/templates/
         * spring.thymeleaf.suffix
         * 指定模板的后缀，默认为:.html
         */
        return "htl/index";
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert(User user){
        //若要返回json数据，把Controller改为RestController
        return userService.insert(user);
    }
}
