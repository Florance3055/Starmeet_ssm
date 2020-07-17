package com.flor.service;

import java.util.Map;

public interface BussinessService {
    //初始化bussiness
    Map initBussiness(String session);

    //充值或者购买
    Map changeMoney(Integer money, String session);

    //获得证明
    Map updateCertification(Integer certification, String session);

    Map getBussiness(String session);
}
