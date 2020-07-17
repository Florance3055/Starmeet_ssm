package com.flor.service;

import com.flor.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    //查询所有账户List<User>
    List<User> findAll();

    //保存账户信息
    Map saveUser(User user);

    //用户登录，更新session
    Map UserLogin(User user);

    //修改密码
    Map updatePssWord(String session, String password, String newPassword);

    Map deleteUser(String session);

    Map getIdentity(String session);
}
