/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.zyy.sofa.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.facade.service.UserService;
import com.facade.service.model.MyPage;
import com.facade.service.model.User;
import com.zyy.sofa.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rain
 * @version : UserServiceImpl.java, v 0.1 2020年08月05日 10:52 rain Exp $
 */

@WebService(targetNamespace = "com.facade.service.UserService")
@Service
@SofaService(interfaceType = UserService.class,bindings = {@SofaServiceBinding(bindingType = "bolt"),@SofaServiceBinding(bindingType = "rest")})
@org.apache.dubbo.config.annotation.Service(version = "1.0.0")
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getByage(Integer age) {
      //  List<com.zyy.sofa.model.User> users = userMapper.getByage(1);

        LambdaQueryWrapper<User> queryWrapper = new QueryWrapper<User>().lambda().le(
               User::getAge, age).ge(User::getAge, 1).orderByDesc(User::getAge);
        List<User> users = userMapper.selectList(queryWrapper);

        return users;
    }

    /**
     * @param user
     * @return
     */
    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public boolean save(User user) {

        int insert = userMapper.insert(user);


        return insert>0;
    }

    @Override
    public void batchSave(List<User> users) {
        List<User> list = new ArrayList<>();
        userMapper.addBatch(users);

    }

    @Override
    public void batchDel(List<Integer> ids) {
          userMapper.deleteBatchIds(ids);
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = userMapper.selectList(new QueryWrapper<>());

        return users;
    }

    @Override
    public MyPage<User> findForPage(Page<User> page) {
        Page<User> userPage = userMapper.selectPage(page);
        MyPage<User> myPage= new MyPage<User>();

       // BeanUtils.copyProperties(userPage,myPage);
        myPage.setData(userPage.getRecords());
        myPage.setPageNo(page.getCurrent());
        myPage.setPageSize(page.getSize());
        myPage.setTotalCount(page.getTotal());
        System.out.println(JSON.toJSONString(myPage));
         return myPage;



    }
}
