package com.song.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {
    //请求路径映射，因为不同模块开发可能会有同名方法，所以将路径提取为类上方/book，代表这个路径下的方法
    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        System.out.println("book save 。。。");
        return "{'info':'springMvc:book-save'}";
    }

}
