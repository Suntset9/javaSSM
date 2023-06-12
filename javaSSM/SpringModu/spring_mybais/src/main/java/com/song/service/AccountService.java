package com.song.service;

import com.song.domain.Account;

import java.util.List;

//服务层
public interface AccountService {
    void save(Account account);

    void delete(Integer id);

    void update(Account account);

    List<Account> findAll();

    Account findById(Integer id);

}
