package com.song.sevice.impl;


import com.song.dao.BookDaoAutoware;
import com.song.sevice.BookServiceAutoware;

public class BookServiceImplAutoware implements BookServiceAutoware {
    private BookDaoAutoware bookDaoAutoware;

    public void setBookDaoAutoware(BookDaoAutoware bookDaoAutoware) {
        this.bookDaoAutoware = bookDaoAutoware;
    }

    public void save() {
        System.out.println("book service save ...");
        bookDaoAutoware.save();
    }
}
