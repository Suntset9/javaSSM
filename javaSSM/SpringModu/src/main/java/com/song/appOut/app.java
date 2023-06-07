package com.song.appOut;

import com.song.sevice.BookService;
import com.song.sevice.impl.BookServiceImpl;
import com.sun.deploy.security.BrowserKeystore;

public class app {
    public static void main(String[] args) {
        //接口等于实现类，每有变动都需要新new一个对象，耦合度高
        //设置了构造函数-需要传参
//        BookServiceImpl bookService = new BookServiceImpl();
//        bookService.save();
    }



}
