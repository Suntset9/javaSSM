package com.song.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

//@Configuation等价于<Beans></Beans>
//@Bean等价于<Bean></Bean>
//@ComponentScan等价于<context:component-scan base-package=”com.dxz.demo”/>
////二者需要搭配使用，一个声明一个扫描
/**
 * - @Configuration注解用于设定当前类为配置类
 * - @ComponentScan注解用于设定扫描路径，此注解只能添加一次，多个数据请用数组格式
 *
 *@Import({jdbcConfig.class}) 多个下使用{a,b,c};导入配置信息
 *
 * 两种方式：
 * @Import注解导入式 @Import({JdbcConfig.class}) 建议使用这种模式
 *
 *  @Configuration
 * @ComponentScan({"com.song.config","com.song.service","com.song.dao"})
 * 只要com.song.config包扫到了就行，三个包可以合并写成com.song
 */
@Configuration
//@ComponentScan("com.song")//会扫描这个文件下所有的包

@Import({jdbcConfig.class}) //建议使用这种模式
public class SpringConfig {
    //这里只放spring配置的信息，像其他的连接的对象等都新建文件来放



}
