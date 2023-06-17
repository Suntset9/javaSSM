package com.song.service;

import com.song.daomain.Account;

import java.util.List;


public interface AccountService {


    void save(Account account);

    void delete(Integer id);

    void update(Account account);

    List<Account> findAll();

    Account findById(Integer id);
}
