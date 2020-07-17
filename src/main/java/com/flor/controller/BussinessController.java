package com.flor.controller;

import com.flor.service.BussinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController /* @Controller + @ResponseBody*/
@RequestMapping("/api/bussiness")
public class BussinessController {


    @Autowired
    private BussinessService bussinessService;

    //初始化bussiness
    @PostMapping("/init")
    public Map initBussiness(@RequestHeader("session") String session) {
        return bussinessService.initBussiness(session);
    }

    //充值或者购买
    @PostMapping("/money")
    public Map changeMoney(Integer money, @RequestHeader("session") String session) {
        return bussinessService.changeMoney(money, session);
    }

    //获得证明
    @PostMapping("/certification")
    public Map updateCertification(Integer certification, @RequestHeader("session") String session) {
        return bussinessService.updateCertification(certification, session);
    }

    //获得证明
    @GetMapping("/info")
    public Map getBussiness(@RequestHeader("session") String session) {
        return bussinessService.getBussiness(session);
    }

}
