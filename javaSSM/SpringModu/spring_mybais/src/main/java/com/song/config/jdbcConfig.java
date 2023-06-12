package com.song.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class jdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();
//        ds.setDriverClassName(driver);//jdbc.driver=com.mysql.jdbc.Driver已被废弃使用，新驱动是com.mysql.cj.jdbc.Driver，驱动程序通常会通过SPI（Service Provider Interface）自动注册，因此手动加载驱动程序类通常是不必要的。
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }
}
