package com.song.dao.impl;

import com.song.dao.ResourcesDao;
import com.song.service.ResourcesService;
import org.springframework.stereotype.Repository;

@Repository
public class ResourcesDaoImpl implements ResourcesDao {
    //通过服务层调用传入的参数来判断是否符合
    @Override
    public boolean readResources(String url, String password) {
        System.out.println(password.length());
        //模拟校验
        return password.equals("root");
    }
}
