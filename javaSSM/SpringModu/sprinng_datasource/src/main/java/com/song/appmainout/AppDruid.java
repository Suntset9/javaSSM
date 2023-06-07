package com.song.appmainout;

import com.song.dao.BookDao;
import com.song.dao.impl.BookDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class AppDruid {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");
//        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
//        System.out.println(dataSource);

        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();
    }
}
