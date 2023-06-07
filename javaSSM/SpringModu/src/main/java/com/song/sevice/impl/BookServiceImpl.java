package com.song.sevice.impl;

import com.song.dao.BookDao;
import com.song.dao.UserDao;
import com.song.dao.impl.BookDaoImpl;
import com.song.dao.impl.BookDaoImplLifecycle;
import com.song.sevice.BookService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PreDestroy;

public class BookServiceImpl implements BookService,InitializingBean,DisposableBean {
//    private BookDao bookDao = new BookDaoImpl();
    //去掉new方式创建对象，使用xml配置关联，

    public void save() {
        System.out.println("book service save ...");
        /**
         *
         * 调用    bookDao.save();
         *         userDao.save();实现set注入
         */
        bookDao.save();
        userDao.save();
    }

    /**
     *  可用于set注入
     *  bookDao和userDao
     *  这两个方法对应的是        --property标签：设置注入属性-->
     *         --name属性：设置注入的属性名，实际是set方法对应的名称--
     *         --ref属性：设置注入引用类型bean的id或name-
     *         <property name="bookDao" ref="bookDao"/>
     *         <property name="userDao" ref="userDao"/>
     *
     */
    private BookDao bookDao;
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    //提供依赖对象的set方法，使配置文件可以通过set方法传入参数来使用调用
    public void setBookDao(BookDao bookDao) {
//        System.out.println("set");
        this.bookDao = bookDao;
    }

    /**
     * 配置构造函数，使可以通过构造函数注入
     * @param bookDao
     * @param userDao
     */
    public BookServiceImpl(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    /**
     * Bean生命周期控制,由spring提供
     * @throws Exception
     */
    @PreDestroy
    @Override
    public void destroy() throws Exception {
        System.out.println("service destroy-spring提供");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service init-spring提供");
    }




}