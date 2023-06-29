package com.song.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MyBatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        // 创建SqlSessionFactoryBean对象
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        factoryBean.setDataSource(dataSource);
        // 设置类型别名的包路径，指定com.song.domain包下的类都会被注册为类型别名
        factoryBean.setTypeAliasesPackage("com.song.domain");
        // 返回SqlSessionFactoryBean对象
        return factoryBean;
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        // 创建MapperScannerConfigurer对象
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        // 设置Mapper接口的基础包路径，指定com.song.dao包下的接口都会被扫描并注册为Mapper
        msc.setBasePackage("com.song.dao");
        // 返回MapperScannerConfigurer对象
        return msc;
    }
}