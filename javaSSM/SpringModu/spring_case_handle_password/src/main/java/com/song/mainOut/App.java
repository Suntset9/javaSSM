package com.song.mainOut;

import com.song.config.springConfig;
import com.song.service.ResourcesService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(springConfig.class);

        ResourcesService bean = acac.getBean(ResourcesService.class);

        boolean root = bean.openURl("http://pan.baidu.com/haha", "root ");

        System.out.println(root);

        acac.close();

    }

}
