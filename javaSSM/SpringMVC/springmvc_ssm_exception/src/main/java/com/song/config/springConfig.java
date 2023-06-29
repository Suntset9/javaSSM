package com.song.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
// 设置需要扫描的组件的基础包路径，这里指定了com.song.service包下的所有组件会被扫描并注册到Spring容器中
@ComponentScan({"com.song.service"})
// 加载jdbc.properties配置文件
@PropertySource({"classpath:jdbc.properties"})
// 导入其他配置类，这里导入了jbdcConfig和MyBatisConfig类
@Import({jbdcConfig.class, MyBatisConfig.class})
// 开启Spring的事务管理功能
@EnableTransactionManagement
public class springConfig {
}
