package com.song.dao.impl;

import com.song.dao.BookDao;

public class BookDaoImpl implements BookDao {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("重写接口方法！！"+name);
    }
}
