package com.song.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.song.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Configuration 把这个也算定义成一个xml的配置文件，通过扫描获得对象
 */
//@Configuration
public class jdbcConfig {
    /**
     * 为写死
     * @return
     */
//    @Bean
//    public DataSource dataSource(){
//        DruidDataSource ds = new DruidDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/spring_db");
//        ds.setName("root");
//        ds.setPassword("123456");
//        return ds;
//    }
    /**
     * 如果@Value()中使用了EL表达式读取properties属性文件中的内容，那么就需要加载properties属性文件。
     *
     */
    //1.定义一个方法获得要管理的对象
    @Value("com.mysql.jdbc.Driver")
    private String driver;
    @Value("jdbc:mysql://localhost:3306/spring_db")
    private String url;
    @Value("root")
    private String userName;
    @Value("root")
    private String password;
    //2.@Bean：表示当前方法的返回值是一个bean对象，添加到IOC容器中
    //Spring会自动从IOC容器中找到BookDao对象赋值给参数bookDao变量，如果没有就会报错。
    //引用类型BookDao bookDao，自动装配
    @Bean
    public DataSource dataSource(BookDao bookDao){
        System.out.println(bookDao);
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }


}
