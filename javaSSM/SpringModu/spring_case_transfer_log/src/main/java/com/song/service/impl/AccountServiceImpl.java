package com.song.service.impl;

import com.song.dao.AccountDao;
import com.song.service.AccountService;
import com.song.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private LogService logService;

    @Override
    public void transfer(String out, String in, double money){
        try {
            accountDao.outMoney(out,money);
            //int i = 1/0;
            accountDao.inMoney(in,money);
        }finally {
            logService.log(out,in,money);
        }
    }


}
