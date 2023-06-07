package com.song.appOut;

import com.song.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForLifeCycle {
    public static void main(String[] args) {
//        Bean生命周期控制
        //ApplicationContext接口中没有定义close方法，使用ClassPathXmlApplicationContext
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDaoLifecycle = (BookDao) cxt.getBean("bookDaoLifecycle");
        bookDaoLifecycle.save();
        //注册关闭钩子
        cxt.registerShutdownHook();
        //创建关闭容器，执行销毁方法
//        cxt.close();
    }
}
