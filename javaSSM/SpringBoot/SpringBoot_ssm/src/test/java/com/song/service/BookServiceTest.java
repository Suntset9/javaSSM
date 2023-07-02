package com.song.service;

import com.song.domain.Book;
import com.song.SpringBootSsmApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//配置文件不要放在包下面,会扫描当前包内所有包，在包里面的话就会扫描当前包的
@SpringBootTest(classes = SpringBootSsmApplication.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetById(){
        Book book = bookService.getById(2);
        System.out.println(book);
    }

    @Test
    public void testGetAll(){
        List<Book> all = bookService.getAll();
        System.out.println(all);
    }

}
