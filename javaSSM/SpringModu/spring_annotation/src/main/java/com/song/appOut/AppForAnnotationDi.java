package com.song.appOut;

import com.song.config.SpringConfig;
import com.song.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppForAnnotationDi {
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext加载Spring配置类初始化Spring容器
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//        BookService bookService = ctx.getBean(BookService.class);
        BookService bookService = ctx.getBean("BookServiceImpl2", BookService.class);
        //在没有装配对象时，调用save里面的嵌套调用 bookDao.save();会显示空异常
        bookService.save();
//        System.out.println(bookService);
        //关闭流
        ctx.close();
    }
}
