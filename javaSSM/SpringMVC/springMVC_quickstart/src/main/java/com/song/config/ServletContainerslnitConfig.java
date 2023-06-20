package com.song.config;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

//web 容器配置类
public class ServletContainerslnitConfig extends AbstractDispatcherServletInitializer {
    //加载springMvc配置类，产生springmvc容器（本质还是spring容器）
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        //初始化webApplicationcontet对象
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        //加载指定配置类
        ctx.register(SpringMvcConfig.class);

        return ctx;
    }
    //设置由springmvc控制器处理的请求映射路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //加载spring配置类
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
