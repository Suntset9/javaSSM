package com.song.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//springmvc配置类，本质上还是一个spring配置类
@ComponentScan("com.song.controller")
public class SpringMvcConfig {
}
