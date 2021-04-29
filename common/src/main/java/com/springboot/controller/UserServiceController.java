/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.controller;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.facade.service.UserService;
import com.facade.service.UserWebService;
import com.facade.service.model.MyPage;
import com.facade.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author rain
 * @version : UserServiceController.java, v 0.1 2020年12月30日 下午2:58 rain Exp $
 */
@RestController
@RequestMapping("/user")
public class UserServiceController {

    @Resource
    @Qualifier("userService1")
    private UserService userService1;//dubbo

    //@SofaReference(interfaceType = UserService.class,binding=@SofaReferenceBinding(bindingType = "bolt"))
    //private UserService userService;

   @Resource
    private UserService userService;

    //@SofaReference(binding=@SofaReferenceBinding(bindingType = "rest",directUrl = "127.0.0.1:8500"))
    //private UserService userService2;
   @Resource
    @Qualifier("userService2")
    private UserService userService2;

    // 代理
    @Resource
    @Qualifier("webUserService")
    private  UserService webUserService;//webservice
    @Resource
    @Qualifier("webUserService2")
    private  UserService webUserService2;

    @Resource
    private UserWebService userWebService;

    @GetMapping("/getUserByAge")
    public  List<User> getUserByAge(int age){
        List<User> byage = userService.getByage(age);//使用sofa 服务
        return byage;

    }
    @GetMapping("/getUserListByPageNo")
    public  MyPage<User> getUserListByPageNo(int pageNo){
        Page<User> page =new Page<>();
        page.setCurrent(pageNo);
        page.setSize(20);
       return userService1.findForPage(page);
    }


    @GetMapping("/getUserListByWeb")
    public MyPage<User> getUserListByPageUseWebservice(int pageNo){
        Page<User> page =new Page<>();
        page.setCurrent(pageNo);
        page.setSize(20);
        return webUserService2.findForPage(page);
    }

    @GetMapping("/test")
    public  String sayHiWithWebService(){
        String s = userWebService.sayHi("hell zhang");

        return LocalDateTime.now()+"==>"+s;

    }



}
