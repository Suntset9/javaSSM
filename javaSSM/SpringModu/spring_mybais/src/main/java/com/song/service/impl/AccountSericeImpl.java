package com.song.service.impl;

import com.song.dao.AccountDao;
import com.song.domain.Account;
import com.song.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountSericeImpl implements AccountService {
//将接口方法AccountDao获取，传给对应得服务层获取增删改查方法
    @Autowired
    private AccountDao accountDao;

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void delete(Integer id) {
        accountDao.delete(id);
    }


    @Override
    public void update(Account account) {
        accountDao.Update(account);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }
}
