/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.facade.service;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.facade.service.model.MyPage;
import com.facade.service.model.User;


import javax.jws.WebMethod;
import javax.jws.WebService;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
import java.util.List;


/**
 * @author rain
 * @version : UserService.java, v 0.1 2020年08月05日 10:48 rain Exp $
 */
@WebService
//@Path("/user")
public interface UserService {

    //@Path("/getByage")
    //@POST
    //@Consumes("application/json")
    //@Produces("application/json;charset=GBK")
    public List<User> getByage(Integer age);

    /**
     * 保存用户
     * @param user
     * @return
     */
    boolean save(User user);

    void batchSave(List<User> users);

    void  batchDel(List<Integer> ids);

     List<User> getAllUsers();
    @WebMethod
    MyPage<User> findForPage(Page<User> page);




}
