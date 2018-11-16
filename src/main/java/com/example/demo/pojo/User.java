package com.example.demo.pojo;


/**
 * @program: demo
 * @description: 用户类
 * @author: Mr.Ning
 * @create: 2018-11-16 10:13
 **/

public class User {
    public String  name;
    public Integer age;
    public Double money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
