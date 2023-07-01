package com.song.service.impl;

import com.song.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public void save() {
        System.out.println("Book service save running ...");
    }
}
