package com.flor.service.impl;

import com.flor.dao.UserDao;
import com.flor.pojo.User;
import com.flor.service.UserService;
import com.flor.unit.Sha256;
import com.flor.unit.tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


    @Override
    public Map saveUser(User user) {

//        user.setUsername(Sha256.getSHA256(user.getUsername()));
        user.setPassword(Sha256.getSHA256(user.getPassword()));

        HashMap map = new HashMap();
        if (userDao.saveUser(user) == 1) {
            map.put("code", "200");
            map.put("message", "注册成功");
        } else {
            map.put("code", "210");
            map.put("message", "注册失败");
        }

        return map;
    }


    //登录检测,登录成功更新session
    @Override
    public Map UserLogin(User user) {

        String username = user.getUsername();
        String password = Sha256.getSHA256(user.getPassword());

        HashMap map = new HashMap();
        Map userInfo = userDao.UserLogin(username, password);
        if (!tool.isNull(userInfo)) {
            String session = Sha256.getSHA256(username + password + System.currentTimeMillis());
            userDao.UserUpdateSession(session, username);
            map.put("code", 200);
            map.put("message", "登录成功");
            map.put("session", session);
//            map.put("userInfo", userInfo);
        } else {
            map.put("code", 210);
            map.put("message", "登录失败");
        }

        return map;
    }


    //修改密码
    @Override
    public Map updatePssWord(String session, String password, String newPassword) {

        Map identity = userDao.GetIdentity(session);

        HashMap map = new HashMap();

        if (newPassword.length() > 16 || newPassword.length() < 6) {
            map.put("code", 210);
            map.put("message", "密码必须在6~16位之间");
            return map;
        }
        if (!tool.isNull(identity) && !identity.isEmpty()) {
            String username = identity.get("username").toString();
            int i = userDao.updatePassWord(username, Sha256.getSHA256(password), Sha256.getSHA256(newPassword));
            if (i == 1) {
                String updateSession = username + Sha256.getSHA256(newPassword) + System.currentTimeMillis();
                userDao.UserUpdateSession(updateSession, username);
                map.put("code", 200);
                map.put("message", "密码修改成功");
            } else {
                map.put("code", 210);
                map.put("message", "密码修改失败");
            }
        }
        return map;
    }


    //删除账号
    @Override
    public Map deleteUser(String session) {

        Map identity = userDao.GetIdentity(session);
        int id = (int) identity.get("id");

        HashMap map = new HashMap();
        if (userDao.deleteUser(id) == 1) {
            map.put("code", "200");
            map.put("message", "账号删除成功");
        } else {
            map.put("code", "210");
            map.put("message", "账号删除失败");
        }

        return map;
    }

    @Override
    public Map getIdentity(String session) {

        Map identity = userDao.GetIdentity(session);

        HashMap map = new HashMap();
        if (!tool.isNull(identity) && !identity.isEmpty()) {
            map.put("code", "200");
            map.put("message", "获取个人信息成功");
            map.put("id", identity.get("id"));
            map.put("username", identity.get("username"));
        } else {
            map.put("code", "210");
            map.put("message", "获取个人信息失败");
        }

        return map;
    }

}
