package com.song.dao.impl;

import com.song.dao.BookDao;
import org.springframework.stereotype.Service;

@Service//服务层注入bean
public class BookDaoimpl implements BookDao {
    @Override
    public void update() {
        System.out.println("Book Dao update is running");
    }

    @Override
    public int select() {
        System.out.println("Book Dao select is running");
        //int i = 1/0;
        return 100;
    }
}
