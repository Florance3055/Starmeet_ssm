package com.flor.test;

import com.flor.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void run1(){
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        //获取对象
        UserService us = (UserService) ac.getBean("userService");
        //调用方法
        us.findAll();
    }
}
