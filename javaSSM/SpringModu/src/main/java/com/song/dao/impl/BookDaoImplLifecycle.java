package com.song.dao.impl;

import com.song.dao.BookDao;
import com.song.sevice.BookService;
import org.springframework.stereotype.Component;

//@Component("BookDaoImplLifecycle")
public class BookDaoImplLifecycle implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao ifecycle save ...");
    }
    //表示bean初始化对应的操作
    public void init() {
        System.out.println("init-自定义");
    }
    ////表示bean销毁前对应的操作
    public void destory() {
        System.out.println("destory-自定义");
    }

//    private BookService bookService;
//    public void setBookService(BookService bookService) {
//        this.bookService = bookService;
//    }
}
