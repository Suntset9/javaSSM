package com.song.dao;

import com.song.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//一般测试类测试接口层
@RunWith(SpringJUnit4ClassRunner.class)//设置类运行器
@ContextConfiguration(classes = SpringConfig.class)//设置Spring环境对应的配置类
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testUpdate(){
        bookDao.update();
    }

    @Test
    public void testSelcet(){
        //select有返回值，需要进行参数收打印
        int select = bookDao.select();
        System.out.println(select);
    }





}
