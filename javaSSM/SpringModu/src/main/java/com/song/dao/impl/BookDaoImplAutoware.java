package com.song.dao.impl;


import com.song.dao.BookDaoAutoware;

public class BookDaoImplAutoware implements BookDaoAutoware {
    public void save() {
        System.out.println("book dao save ...");
    }
}
