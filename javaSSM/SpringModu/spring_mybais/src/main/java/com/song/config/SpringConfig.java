package com.song.config;

import org.springframework.context.annotation.*;

@Configuration//声明配置类，替代xml
@ComponentScan("com.song")//扫描改路径下面的所有组件，如@service
@PropertySource("classpath:jdbc.properties")//获取/扫描文件
@Import({jdbcConfig.class, MybatisConfig.class})//指定两个配置类
public class SpringConfig {
}
