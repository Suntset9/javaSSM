package com.song.appOut;

import com.song.config.SpringConfig;
import com.song.dao.BookDao;
import com.song.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppForAnnotation {
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext加载Spring配置类初始化Spring容器
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        System.out.println(bookDao);
//        BookDao bookDao1 = (BookDao) ctx.getBean("bookDao");
//        System.out.println(bookDao1);
        //按类型获取bean
        BookService bookService = ctx.getBean(BookService.class);
        System.out.println(bookService);
        //关闭流
        ctx.close();
    }
}
