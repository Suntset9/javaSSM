package com.song.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//web控制器
public class UserController {
    //设置映射路径为/save，即外部访问路径
    @RequestMapping("/save")
    @ResponseBody//告诉web这是响应体不是页面  设置当前操作返回结果为指定json数据（本质上是一个字符串信息）
    public String save(){
        System.out.println("user save ...");
        return "{'info':'springMVC'}";
    }

}
