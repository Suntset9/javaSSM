package com.song.config;

import org.springframework.context.annotation.*;

@Configuration//定义spring配置类
@ComponentScan("com.song")//扫描包下的所以bean
@PropertySource("classpath:jdbc.properties")
@Import({jdbcConfig.class, MybatisConfig.class})//声明多个配置文件
@EnableAspectJAutoProxy//开启注解功能
public class SpringConfig {
}
