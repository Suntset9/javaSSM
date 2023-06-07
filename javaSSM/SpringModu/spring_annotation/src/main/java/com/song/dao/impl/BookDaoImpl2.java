package com.song.dao.impl;

import com.song.dao.BookDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component定义bean
//@Component("bookDao")
//@Repository：@Component衍生注解
@Repository("bookDao2") //数据仓库，数据层
@Scope("singleton") //singleton单例对象；prototype非单例
public class BookDaoImpl2 implements BookDao {
    public void save() {
        System.out.println("book dao save ...bki2");
    }

    /**
     * 通过注解配置生命周期
     *  @PostConstruct 和 @PreDestroy 注解是jdk中提供的注解，从jdk9开始，
     * jdk中的javax.annotation包被移除了，也就是说这两个注解就用不了了，可以额外导入一下依赖解决这个问题。
     *  @PostConstruct 生命周期开始
     *  @PreDestroy 生命周期结束
     */
//    @PostConstruct
//    public void init() {
//        System.out.println("book init ...");
//    }
//    @PreDestroy
//    public void destroy() {
//        System.out.println("book destory ...");
//    }
}
