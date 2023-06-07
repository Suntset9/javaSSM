package com.song.appOut;

import com.song.sevice.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForDISet {
    /**
     * 测试set注入
     * @param args
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) ctx.getBean("bookService01");
        bookService.save();

        ctx.registerShutdownHook();

    }
}
