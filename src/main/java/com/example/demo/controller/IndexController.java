package com.example.demo.controller;

import com.example.demo.pojo.Shop;
import com.example.demo.pojo.User;
import com.example.demo.service.IUserService;
import com.github.pagehelper.PageInfo;
import com.mongodb.client.result.UpdateResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 可以用maven的install来打jar、war包
 */

//@RestController
@Controller
@RequestMapping("/njm1/test1")
public class IndexController {

    private static Logger logger =  LoggerFactory.getLogger(IndexController.class);

    @Resource
    public IUserService userService;

    @RequestMapping(value = "/page_info",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<List<User>> page_info(){
        //若要返回json数据，把Controller改为RestController
        PageInfo<List<User>> users = userService.allUser();
        return users;
    }

    @RequestMapping(value = "/index_html",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index_html(){
        /**
         * spring.thymeleaf.prefix
         * 指定模板的前缀，默认为:classpath:/templates/
         * spring.thymeleaf.suffix
         * 指定模板的后缀，默认为:.html
         */
        PageInfo<List<User>> page = userService.allUser();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(page);
        modelAndView.setViewName("htl/index");
        return modelAndView;
    }


    @RequestMapping(value = "/index_html2",method = RequestMethod.GET)
    public ModelAndView index_html2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("htl/2");
        return modelAndView;
    }

    @RequestMapping(value = "/free",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView free(){
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("njm1");
        User user2 = new User();
        user2.setName("njm2");
        User user3 = new User();
        user3.setName(null);
        User user4 = null;
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("htl/vue");
        modelAndView.addObject("users", users);
        modelAndView.addObject("aa", "njjjjj");
        return modelAndView;
    }


    @RequestMapping(value = "/vue",method = RequestMethod.GET)
//    @ResponseBody
    public ModelAndView vue(){
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("njm1");
        User user2 = new User();
        user2.setName("njm2");
//        User user3 = new User();
//        user3.setName(null);
//        User user4 = null;
        users.add(user1);
        users.add(user2);
//        users.add(user3);
//        users.add(user4);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("htl/vue");
        modelAndView.addObject("users", users);
        modelAndView.addObject("user", user1);
        modelAndView.addObject("aa", "njjjjj");
        return modelAndView;
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert(User user){
        //若要返回json数据，把Controller改为RestController
        return userService.insert(user);
    }

//    @Scheduled(cron = "*/6 * * * * ?")
//    public void job(){
//        PageInfo<List<User>> users = userService.allUser();
//        System.out.println(users.toString());
//        System.out.println(1);
//    }

    @Resource
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/save_shop",method = RequestMethod.POST)
    public Shop saveShop(){
        Shop shop = new Shop();
        shop.setCategory("奶茶");
        shop.setMoney(100.2);
        shop.setLoc(new Double[]{113.62608274774987,23.151410724530546});
        return mongoTemplate.save(shop);
    }

    @RequestMapping(value = "/del_shop",method = RequestMethod.POST)
    public Shop delShop(){
        return mongoTemplate.findAndRemove(new Query(Criteria.where("category").is("奶茶")),Shop.class );
    }

    @RequestMapping(value = "/update_shop",method = RequestMethod.POST)
    public UpdateResult updateShop(){
        Update update = new Update();
        update.set("category", "奶茶2");
        return mongoTemplate.updateMulti(new Query(Criteria.where("category").is("奶茶")), update, Shop.class);
    }

    @RequestMapping(value = "/query_shop",method = RequestMethod.GET)
    public List<Shop> queryShop(){
        //地理位置查询
//        Query query = new Query(Criteria.where("loc").nearSphere(new Point(113.62608274774988, 23.151410724530547)));
//        query.with(new Sort(Sort.Direction.ASC,   "money"));//排序

        //Pattern.CASE_INSENSITIVE参数：忽略大小写
        //模糊匹配
        Pattern pattern = Pattern.compile("^.*水.*$",Pattern.CASE_INSENSITIVE);
//        //完全匹配
//        Pattern pattern = Pattern.compile("^张$", Pattern.CASE_INSENSITIVE);
//        //右匹配
//        Pattern pattern = Pattern.compile("^.*张$", Pattern.CASE_INSENSITIVE);
//        //左匹配
//        Pattern pattern = Pattern.compile("^张.*$", Pattern.CASE_INSENSITIVE);
//        //模糊匹配
//        Pattern pattern = Pattern.compile("^.*张.*$", Pattern.CASE_INSENSITIVE);

        Query query = new Query(Criteria.where("category").regex(pattern));
        return mongoTemplate.find(query,Shop.class);
    }
}
