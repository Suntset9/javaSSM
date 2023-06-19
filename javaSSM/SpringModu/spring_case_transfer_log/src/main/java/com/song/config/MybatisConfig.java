package com.song.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {
    // 创建 SqlSessionFactoryBean 实例，并设置需要扫描的实体类的包路径和数据源
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setTypeAliasesPackage("com.song.domain"); // 设置需要扫描的实体类的包路径
        ssfb.setDataSource(dataSource); // 设置数据源
        return ssfb;
    }
    // 创建 MapperScannerConfigurer 实例，并设置需要扫描的 Mapper 接口所在的包路径
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.song.dao"); // 设置需要扫描的 Mapper 接口所在的包路径
        return mapperScannerConfigurer;
    }
}
