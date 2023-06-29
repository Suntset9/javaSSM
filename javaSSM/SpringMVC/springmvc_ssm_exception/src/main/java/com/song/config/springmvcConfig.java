package com.song.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
// 设置需要扫描的组件的基础包路径，这里指定了com.song.controller包下的所有组件会被扫描并注册到Spring容器中
@ComponentScan({"com.song.controller","com.song.config"})
// 启用Spring MVC框架的功能 开启json数据类型自动转换
@EnableWebMvc
public class springmvcConfig {
}
