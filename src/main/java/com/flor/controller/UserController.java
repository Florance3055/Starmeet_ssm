package com.flor.controller;

import com.flor.pojo.User;
import com.flor.service.UserService;
import com.flor.unit.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController /* @Controller + @ResponseBody*/
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/findAll")
    public JsonResult findAll(HttpServletResponse response) {
        List<User> list = userService.findAll();

        response.setHeader("Access-Control-Allow-Origin", "*");
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(200);
        jsonResult.setMsg("获取成功");
        jsonResult.add("data", list);
        return jsonResult;
    }


    @PostMapping("/register")
    public Map saveUser(User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public Map userLogin(User user) {
        return userService.UserLogin(user);
    }

    @PostMapping("/updatePassword")
    public Map updatePssWord(@RequestHeader("session") String session, String password, String newPassword) {
        return userService.updatePssWord(session, password, newPassword);
    }

    @DeleteMapping("/deleteUser")
    public Map deleteUser(@RequestHeader("session") String session) {
        return userService.deleteUser(session);
    }

    @GetMapping("/info")
    public Map userInfo(@RequestHeader("session") String session) {
        return userService.getIdentity(session);
    }

}
