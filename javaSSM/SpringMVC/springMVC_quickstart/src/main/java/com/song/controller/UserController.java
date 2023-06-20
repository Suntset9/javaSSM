package com.song.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * name：@Controller
 * 类型：类注解
 * 位置：springMVC控制类定义上方
 * 作用：设定springMVC的核心控制器bean
 *
 */
@Controller//定义表现层控制器bean
public class UserController {
    /**
     * name：@RequestMapping
     * 类型：方法注解
     * 位置：springMVC控制器方法定义上方
     * 作用：设置当前控制器方法请求访问路径
     * value（默认）：请求访问路径
     * ===============================================
     * name：@ResponseBody
     * 类型：方法注解
     * 位置：springMVC控制器方法定义上方
     * 作用：设置当前控制器方法响应内容为当前返回值，无需解析
     * @return
     */

    //设置映射路径为/save，即外部访问路径
    @RequestMapping("/user/save")
    //设置当前操作返回结果为指定json数据（本质上是一个字符串信息）
    @ResponseBody//告诉web这是响应体不是页面
    public String save(){
        System.out.println("user save ... ");
        return "{'info':'springMvc--save'}";//返回json数据
    }

    //设置映射路径为/delete，即外部访问路径
    @RequestMapping("/user/delete")
    @ResponseBody
    public String delete(){
        System.out.println("user delete ...");
        return "{'info':'springmvc--delete'}";
    }

}
