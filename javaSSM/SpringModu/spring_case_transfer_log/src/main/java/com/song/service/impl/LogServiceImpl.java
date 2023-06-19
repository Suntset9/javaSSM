package com.song.service.impl;

import com.song.dao.LogDao;
import com.song.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    @Override
    public void log(String out, String in, double money) {
        logDao.log("转账操作由"+out+"到"+in+", 金额："+money);
    }
}
