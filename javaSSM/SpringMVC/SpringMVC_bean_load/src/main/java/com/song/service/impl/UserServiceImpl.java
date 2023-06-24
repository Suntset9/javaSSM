package com.song.service.impl;

import com.song.domain.User;
import com.song.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void save(User user) {
        System.out.println("user service ...");
    }
}
