package com.song.springboot_ssm;

import com.song.domain.Book;
import com.song.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootSsmApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    public void TestgetById(){
        Book byId = bookService.getById(2);
        System.out.println(byId);
    }

}
