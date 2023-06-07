package com.song.factory;

import com.song.dao.UserDao;
import com.song.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    /**
     * 创建了实例工厂；非静态
     * @return
     */
    public UserDao getUserDao(){
//        return new UserDaoImpl();
        return null;//跟构造方法冲突，因为需要传参数
    }

}
