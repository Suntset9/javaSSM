package com.song.appOut;

import com.song.sevice.BookServiceAutoware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForDIAutoware {
    public static void main( String[] args ) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceAutoware bookService = (BookServiceAutoware) ctx.getBean("bookServiceImplAutoware");
        bookService.save();
    }
}
