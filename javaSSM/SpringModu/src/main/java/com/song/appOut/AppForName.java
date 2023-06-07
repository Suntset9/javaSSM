package com.song.appOut;

import com.song.dao.BookDao;
import com.song.sevice.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForName {

    public static void main(String[] args) {
        //1.创建Ioc容器对象，加载spring核心配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean中的BookService对象
//        BookService bookService = (BookService) ctx.getBean("service");
//        bookService.save();

        //获取bookdao对象
        BookDao boolDao = (BookDao) ctx.getBean("bookDao");
        boolDao.save();


    }
}
