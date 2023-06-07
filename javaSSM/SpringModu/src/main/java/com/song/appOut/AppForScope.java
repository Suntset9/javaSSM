package com.song.appOut;

import com.song.sevice.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForScope {
    public static void main(String[] args) {
        //
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

       /* 单例对象 测试发现：
       com.song.sevice.impl.BookServiceImpl@2d928643
        com.song.sevice.impl.BookServiceImpl@2d928643；
        输出的地址一样

        scope="prototype"加入运行发现，
        com.song.sevice.impl.BookServiceImpl@5702b3b1
        com.song.sevice.impl.BookServiceImpl@69ea3742
        地址不一样了，为不是同一个对象了
        */
        BookService service = (BookService) ctx.getBean("service");
        service.save();

//        System.out.println(service);
//        BookService service1 = (BookService) ctx.getBean("service");
//        System.out.println(service1);
        ctx.registerShutdownHook();
    }
}
