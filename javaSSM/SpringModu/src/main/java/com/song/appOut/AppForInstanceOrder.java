package com.song.appOut;

import com.song.dao.OrderDao;
import com.song.factory.OrderDaoFatory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForInstanceOrder {
    public static void main(String[] args) {
        //调用静态工程的方法，new一个对象
//        OrderDao orderDao = OrderDaoFatory.getorderDao();
//        orderDao.save();

        //使用spring的方式调用, 别人的工厂里可能写了一些代码等，不能丢，所以一般为了兼容早期系统遗留使用，了解即可
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderDao orderdao = (OrderDao) ctx.getBean("orderdao");
        orderdao.save();
    }
}
