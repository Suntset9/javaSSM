package com.song.controller;

import com.song.domain.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @RestController注解的作用主要有两个：
 *
 *
 * 标识类为一个控制器类，告诉Spring Boot该类中的方法可以处理HTTP请求。
 *
 * 自动将方法的返回值转换为JSON或XML等格式的响应，
 * 而不是将返回值作为视图名称进行解析。
 * 总的来说，@RestController注解的作用是简化了Spring MVC开发中的配置，
 * 使得开发者可以更方便地编写处理HTTP请求的方法，并将返回值直接作为响应返回给客户端。
 */
@RestController
@RequestMapping("/books")
public class BookController {
    // 使用@Value读取单一属性数据
    @Value("${lesson}") // 从配置文件中读取名为lesson的属性值
    private String lesson;
    @Value("${server.port}") // 从配置文件中读取名为server.port的属性值
    private Integer port;
    @Value("${enterprise.subject[0]}") // 从配置文件中读取名为enterprise.subject[0]的属性值
    private String subject;
    @Value("${enterprise.likes[0]}")
    private List<String> likes;

    // 使用Environment封装全配置数据
    @Autowired
    private Environment environment;

    @Autowired
    private Enterprise enterprise;
    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println(lesson); // 打印从配置文件读取的lesson属性值
        System.out.println(port); // 打印从配置文件读取的server.port属性值
        System.out.println(subject); // 打印从配置文件读取的enterprise.subject[0]属性值
        System.out.println(likes);
        System.out.println("--------------------");
        System.out.println(environment.getProperty("lesson")); // 使用Environment从配置文件中获取名为lesson的属性值
        System.out.println(environment.getProperty("server.port")); // 使用Environment从配置文件中获取名为server.port的属性值
        System.out.println(environment.getProperty("enterprise.age")); // 使用Environment从配置文件中获取名为enterprise.age的属性值
        System.out.println(environment.getProperty("enterprise.subject[2]")); // 使用Environment从配置文件中获取名为enterprise.subject[1]的属性值
        System.out.println(environment.getProperty("enterprise.likes[1]"));
        System.out.println("---------------------");
        System.out.println(enterprise); // 打印注入的Enterprise对象
        return "hello , spring boot!";
    }
}
