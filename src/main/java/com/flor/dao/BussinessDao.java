package com.flor.dao;

import com.flor.pojo.Bussiness;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;
public interface BussinessDao {
    //初始化用户的Bussiness
    @Insert("insert into t_bussiness(uid,money,certification) values (#{uid},#{money},#{certification})")
    int initBussiness(Bussiness bussiness);

    //获取用户的Bussiness记录
    @Select("select * from t_bussiness where t_bussiness.uid=#{uid}")
    Map getBussiness(Bussiness bussiness);//用户id

    //充钱 or 购买
    @Update("update t_bussiness set money = #{money} where t_bussiness.uid=#{uid}")
    int changeMoney(Bussiness bussiness);

    //获得证明
    @Update("update t_bussiness set certification = #{certification} where t_bussiness.uid=#{uid}")
    int updateCertification(Bussiness bussiness);

}
