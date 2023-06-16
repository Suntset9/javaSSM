package com.song.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.song")
//1.在配置类上添加@EnableAspectJAutoProxy注解，开启注解版的AOP功能
@EnableAspectJAutoProxy
public class SpringConfig {


}
