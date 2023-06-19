package com.song.service.impl;

import com.song.dao.ResourcesDao;
import com.song.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired//自动注入bean
    private ResourcesDao resourcesDao;
    @Override
    public boolean openURl(String url, String password) {
        //调用dao层，数据连接层方法；传入参数判断是否符合
        return resourcesDao.readResources(url, password);
    }
}
