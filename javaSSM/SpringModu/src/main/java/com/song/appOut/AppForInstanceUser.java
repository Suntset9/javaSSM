package com.song.appOut;

import com.song.dao.UserDao;
import com.song.factory.UserDaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForInstanceUser {
    public static void main(String[] args) {
        //通过new实例化工厂
//        UserDaoFactory userDaoFactory = new UserDaoFactory();
//        //通过实例化工厂对象创建对象，
//        UserDao userDao = userDaoFactory.getUserDao();
//        //查看地址
//        System.out.println(userDao);
//        //调用save方法
//        userDao.save();

        //通过spring方式实例化工厂
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //接口等于实现类
        UserDao userDao = (UserDao) ctx.getBean("userDao1");
        UserDao userDao1 = (UserDao) ctx.getBean("userDao1");
        System.out.println(userDao);
        System.out.println(userDao1);
        userDao.save();
    }
}
