package com.song.service.impl;

import com.song.dao.BookDao;
import com.song.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component定义bean，工具类等地方使用
//@Component
//@Service：@Component衍生注解
//@Service //不写名称=按类型访问，service业务层
@Repository("BookServiceImpl2")
public class BookServiceImpl2 implements BookService {
    /**
     *  @Autowired ：注入引用类型，自动装配模式，默认按类型装配, :反射的暴力反射
     *  默认按照类型自动装配，如果IOC容器中同类的Bean有多个，
     *  那么默认按照变量名和Bean的名称匹配，建议使用@Qualifier注解指定要装配的bean名称
     */
    @Autowired
    private BookDao bookDao;

    public void save() {
        System.out.println("book service save ...bsi2");
        bookDao.save();
    }
}
