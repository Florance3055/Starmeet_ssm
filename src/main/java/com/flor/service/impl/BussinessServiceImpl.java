package com.flor.service.impl;

import com.flor.dao.BussinessDao;
import com.flor.dao.UserDao;
import com.flor.pojo.Bussiness;
import com.flor.service.BussinessService;
import com.flor.unit.tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("bussinessService")
public class BussinessServiceImpl implements BussinessService {

    @Autowired
    private BussinessDao bussinessDao;
    private final UserDao userDao;

    public BussinessServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public Map initBussiness(String session) {

        Bussiness bussiness = new Bussiness();
        Map identity = userDao.GetIdentity(session);

        bussiness.setUid((Integer) identity.get("id"));
        bussiness.setMoney(1410065407);
        bussiness.setCertification(0);

        HashMap map = new HashMap();
        if (bussinessDao.initBussiness(bussiness) == 1) {
            map.put("code", "200");
            map.put("message", "用户Bussiness初始化成功");
        } else {
            map.put("code", "210");
            map.put("message", "用户Bussiness初始化失败");
        }

        return map;
    }


    @Override
    public Map changeMoney(Integer money, String session) {
        HashMap map = new HashMap();
        Bussiness bussiness = new Bussiness();
        Map identity = userDao.GetIdentity(session);
        bussiness.setUid((Integer) identity.get("id"));

        Map getMoney = bussinessDao.getBussiness(bussiness);
        int trueMoney = (Integer) getMoney.get("money") - money;
        if (trueMoney >= 0) {
            bussiness.setMoney(trueMoney);
        } else {
            map.put("code", "211");
            map.put("message", "您的金额不足！");
            return map;
        }

        if (bussinessDao.changeMoney(bussiness) == 1) {
            map.put("code", "200");
            map.put("message", "修改Money成功");
        } else {
            map.put("code", "210");
            map.put("message", "修改Money失败");
        }

        return map;
    }


    @Override
    public Map updateCertification(Integer certification, String session) {

        Bussiness bussiness = new Bussiness();
        Map identity = userDao.GetIdentity(session);

        bussiness.setUid((Integer) identity.get("id"));
        bussiness.setCertification(certification);

        HashMap map = new HashMap();
        if (bussinessDao.updateCertification(bussiness) == 1) {
            map.put("code", "200");
            map.put("message", "修改Certification成功");
        } else {
            map.put("code", "210");
            map.put("message", "修改Certification失败");
        }

        return map;
    }


    @Override
    public Map getBussiness(String session) {
        Bussiness bussiness = new Bussiness();
        Map identity = userDao.GetIdentity(session);
        bussiness.setUid((Integer) identity.get("id"));

        Map bussinessInfo = bussinessDao.getBussiness(bussiness);

        HashMap map = new HashMap();
        if (!tool.isNull(bussinessInfo) && !bussinessInfo.isEmpty()) {
            map.put("code", "200");
            map.put("message", "获取用户Bussiness成功");
            map.put("uid", bussinessInfo.get("uid"));
            map.put("money", bussinessInfo.get("money"));
            map.put("certification", bussinessInfo.get("certification"));
        } else {
            map.put("code", "210");
            map.put("message", "获取用户Bussiness失败");
        }

        return map;
    }
}
