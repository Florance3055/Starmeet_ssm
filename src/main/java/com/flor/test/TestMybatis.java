//package com.flor.test;
//
//import com.flor.dao.UserDao;
//import com.flor.pojo.User;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//public class TestMybatis {
//    @Test
//    public void run1() throws IOException {
//        //加载配置文件
//        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        //创建sqlSessionFactory对象
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        //创建SqlSession对象
//        SqlSession session = factory.openSession();
//        //获取到代理对象
//        UserDao dao = session.getMapper(UserDao.class);
//        //查询所有账户信息
//        List<User>  list= dao.findAll();
//        for(User user : list){
//            System.out.println(user);
//        }
//        //关闭资源
//        session.close();
//        in.close();
//    }
//
//    @Test
//    public void run2() throws IOException {
//        User user = new User();
//        user.setUsername("Adair");
//        user.setPassword("15343631");
//        //加载配置文件
//        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        //创建sqlSessionFactory对象
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        //创建SqlSession对象
//        SqlSession session = factory.openSession();
//        //获取到代理对象
//        UserDao dao = session.getMapper(UserDao.class);
//        //保存账户信息
//        dao.saveUser(user);
//        //提交事务
//        session.commit();
//        //关闭资源
//        session.close();
//        in.close();
//    }
//}
