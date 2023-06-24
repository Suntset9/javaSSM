package com.song.mainOut;

import com.song.config.SpringConfig;
import com.song.controller.UserController;
import com.song.domain.User;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class app {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println(ctx.getBean(UserController.class));
    }
}
