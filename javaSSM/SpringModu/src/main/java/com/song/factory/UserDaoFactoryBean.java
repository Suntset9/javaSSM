package com.song.factory;

import com.song.dao.UserDao;
import com.song.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;

/*FactoryBean创建对象
*       重点
* 后面整合的时候大量的框架都在使用这种方式
* */

public class UserDaoFactoryBean implements FactoryBean<UserDao> {

    //代替原始实例工厂中创建对象的方法，new一个
    @Override
    public UserDao getObject() throws Exception {
//        return new UserDaoImpl();
        return null;//跟构造方法注入冲突，因为需要传参
    }
    //getObjectType对象的类型
    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }

 /**
  * 默认返回单例对象
  *  return false为返回非单例对象
  * */

    @Override
    public boolean isSingleton() {
        return true;
    }
}
