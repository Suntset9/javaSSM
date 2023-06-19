package com.song.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration//定义配置文件
@ComponentScan("com.song")//扫描bean
@EnableAspectJAutoProxy//开启aop
public class springConfig {
}
