package com.song.mainOut;

import com.song.config.SpringConfig;
import com.song.domain.Account;
import com.song.service.AccountService;
import org.apache.ibatis.javassist.CtBehavior;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = ctx.getBean(AccountService.class);
        Account ac = accountService.findById(2);
        System.out.println(ac);

    }



}
