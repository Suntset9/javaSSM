package com.song.controller;

import com.song.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @PostMapping
    public String save(@RequestBody Book book){
        System.out.println("book save ==>"+book);
        return "{'module':'book save success'}";
    }

    @GetMapping
    public List<Book> getAll(){
        System.out.println("book getAll is running ...");
        ArrayList<Book> bookLists = new ArrayList<Book>();

        Book book1 = new Book();
        book1.setType("计算机");
        book1.setName("SpringMVC入门教程");
        book1.setDescription("小试牛刀");
        bookLists.add(book1);

        Book book2 = new Book();
        book2.setType("计算机");
        book2.setName("SpringMVC实战教程");
        book2.setDescription("一代宗师");
        bookLists.add(book2);

        Book book3 = new Book();
        book3.setType("计算机");
        book3.setName("SpringMVC实战进阶教程");
        book3.setDescription("一代宗师呕心创作");
        bookLists.add(book3);

        return bookLists;
    }
}
