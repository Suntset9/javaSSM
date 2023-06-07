package com.song.dao.impl;

import com.song.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository//按类型定义bean
public class BookDaoImpl implements BookDao {

    @Override
    public void save() {
        System.out.println("注解开发管理第三方bean测试...");
    }
}
