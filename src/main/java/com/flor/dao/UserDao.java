package com.flor.dao;

import com.flor.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {

    //查询所有账户
    @Select("select * from t_user")
    List<User> findAll();

    //登录
    @Select("select * from t_user where username= #{username} and password = #{password} ")
    Map UserLogin(@Param("username") String username, @Param("password") String password);

    //更新session
    @Update("update t_user set session = #{session} where username=#{username}")
    void UserUpdateSession(@Param("session") String session, @Param("username") String username);

    //保存账户信息
    @Insert("insert into t_user(username,password) values (#{username},#{password})")
    int saveUser(User user);

    //先验证身份
    @Select("select * from t_user where session= #{session} ")
    Map GetIdentity(@Param("session") String session);

    //修改密码
    @Update("update t_user set password = #{newPassword} where username=#{username} and password=#{password}")
    int updatePassWord(@Param("username") String username, @Param("password") String password,
                          @Param("newPassword") String newPassword);

//    @Update("update t_user set password = #{newPassword} where username=#{username} and password=#{password}")
//    int updatePassWord(@Param("username") String username, @Param("password") String password,
//                       @Param("newPassword") String newPassword);

    //删除账号DELETE FROM 表名称 WHERE 列名称 = 值
    @Delete("delete from t_user  where id=#{id} ")
    int deleteUser(@Param("id") Integer id);
}
