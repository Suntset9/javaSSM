package com.song.factory;

import com.song.dao.OrderDao;
import com.song.dao.impl.OrderDaoImpl;

public class OrderDaoFatory {
    /**
     * static
     * 静态工厂创建对象
     * @return
     */
    public static OrderDao getorderDao() {

//        System.out.println("factory setup ...");
        return new OrderDaoImpl();
    }
}
