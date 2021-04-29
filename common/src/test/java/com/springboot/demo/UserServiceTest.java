/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alipay.sofa.common.utils.AssertUtil;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.facade.service.UserService;
import com.facade.service.UserWebService;
import com.facade.service.model.MyPage;
import com.facade.service.model.User;
import com.springboot.DemoApplication;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author rain
 * @version : UserServiceTest.java, v 0.1 2020年08月05日 11:26 rain Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    //@SofaReference(binding=@SofaReferenceBinding(bindingType = "bolt",directUrl = "127.0.0.1:12208"))
    //private UserService userService;
   // @SofaReference(interfaceType = UserService.class,binding=@SofaReferenceBinding(bindingType = "bolt"))
    @Resource
    private UserService userService;
    //@Autowired
    //private  UserService userService;//sofa

   // @Reference(version = "1.0.0", timeout = 8000)
    @Autowired
    private UserService userService1;//dubbo

    //@SofaReference(binding=@SofaReferenceBinding(bindingType = "rest",directUrl = "127.0.0.1:8500"))
    //private UserService userService2;
    @Autowired
    private UserService userService2;

   // 代理
    @Autowired
    private  UserService webUserService;
    @Resource
    private  UserService webUserService2;
    @Autowired
    private UserWebService userWebService;
    @Test
    public void userServiceGetListWithSofa() {
        Long s = System.currentTimeMillis();
        System.out.println(s);
        List<User> byage = userService.getByage(19);
        System.out.println(JSON.toJSONString(byage));
        System.out.println("用时:"+(System.currentTimeMillis() - s));
       // userService2.getByage(1);

    }

    @Test
    public void userServiceGetListWithDubbo() {
        Long s = System.currentTimeMillis();
        System.out.println(s);
        List<User> byage = userService1.getByage(19);
        System.out.println(JSON.toJSONString(byage));
        System.out.println("用时:"+(System.currentTimeMillis() - s));

    }
   @Test
    public  void userServieceTestWithSofaRest(){
        Long s = System.currentTimeMillis();
        System.out.println(s);
        List<User> byage = userService2.getByage(1);
        System.out.println(JSON.toJSONString(byage));
        System.out.println("用时:"+(System.currentTimeMillis() - s));
        byage.stream().forEach(user-> System.out.println(JSON.toJSONString(user)));
    }

    @Test
    public void userServiceGetListWithWebService() {
        Long s = System.currentTimeMillis();
        System.out.println(s);
        Page<User> page =new Page<>();
        page.setPages(1);
        page.setSize(20);
       // List<User> byage = webUserService.findForPage(page);
       // System.out.println();
        System.out.println(JSON.toJSONString(webUserService2.findForPage(page),SerializerFeature.PrettyFormat,SerializerFeature.WriteDateUseDateFormat));
        System.out.println("用时:"+(System.currentTimeMillis() - s));

    }
    @Test
    public void userServiceGetListWithWebService2() {
        Long s = System.currentTimeMillis();
        System.out.println(s);
        List<User> byage = webUserService2.getByage(1);
        System.out.println(JSON.toJSONString(byage));
        System.out.println("用时:"+(System.currentTimeMillis() - s));

    }

    @Test
    public void userWebServiceGetListWithWebService() {
        Long s = System.currentTimeMillis();
        System.out.println(s);
        List<User> byage = userWebService.getByage(1);
        System.out.println(JSON.toJSONString(byage));
        System.out.println("用时:"+(System.currentTimeMillis() - s));
        Assert.assertNotNull(byage);

    }


    @Test
    public  void testSaveUser(){

        Long s = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            User user =new User();
            user.setAge(i);
            user.setName("rain.zhang"+i);
            user.setEmail("254856090"+i+"@qq.com");
            user.setCreateTime(new Date());
           boolean res= userService.save(user);
            AssertUtil.isTrue(res);
        }
        System.out.println("插入1000条用时:"+(System.currentTimeMillis() - s));





    }

    @Test
    public  void  testBatchSaveWithSofa(){
        Long s = System.currentTimeMillis();
        List<User> users =new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            User user =new User();
            user.setId(Long.valueOf(i));
            user.setAge(i);
            user.setName("rain.zhang"+i);
            user.setEmail("254856090"+i+"@qq.com");
            user.setCreateTime(new Date());
            users.add(user);

        }
        userService.batchSave(users);
        System.out.println("插入10000条用时:"+(System.currentTimeMillis() - s));
    }


    @Test
    public  void tsetGetAllUsersWithDubbo(){
        Long s = System.currentTimeMillis();
        List<User> users = userService1.getAllUsers();
        System.out.println(JSON.toJSONString(users, SerializerFeature.PrettyFormat,SerializerFeature.WriteDateUseDateFormat));
        System.out.println("用时:"+(System.currentTimeMillis() - s));
    }

    @Test
    public  void  testBatchDel(){
        Long s = System.currentTimeMillis();
        List<Integer> list =new ArrayList<>(10000);
        for (int i = 0; i < 10000 ; i++) {
            list.add(i);
        }
        userService1.batchDel(list);
        System.out.println("用时:"+(System.currentTimeMillis() - s));
    }


    @Test
    public  void  testBatchDelWithWebservice(){
        Long s = System.currentTimeMillis();
        List<Integer> list =new ArrayList<>(10000);
        for (int i = 0; i < 10000 ; i++) {
            list.add(i);
        }
        webUserService2.batchDel(list);
        System.out.println("用时:"+(System.currentTimeMillis() - s));
    }




  @Test
    public  void testGetListPage(){
        Long s = System.currentTimeMillis();
        Page<User> page =new Page<>();
        page.setPages(1);
        page.setSize(20);
        MyPage<User> pages = userService.findForPage(page);
        System.out.println(JSON.toJSONString(pages,SerializerFeature.PrettyFormat,SerializerFeature.WriteDateUseDateFormat));
        System.out.println("用时:"+(System.currentTimeMillis() - s));
    }


    @Test
    public  void testGetListPageWithDubbo(){
        Long s = System.currentTimeMillis();
        Page<User> page =new Page<>();
        page.setPages(1);
        page.setSize(20);
        MyPage<User> pages = userService1.findForPage(page);
        System.out.println(JSON.toJSONString(pages,SerializerFeature.PrettyFormat,SerializerFeature.WriteDateUseDateFormat));
        System.out.println("用时:"+(System.currentTimeMillis() - s));
    }



    }
