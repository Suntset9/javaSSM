package com.song;

import com.song.dao.UserDao;
import com.song.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybaitsplusDmlApplicationTests {

    @Autowired
    public UserDao userDao;

    @Test
    void testSave(){
        User user = new User();
        user.setName("黑马程序员");
        user.setPassword("itheima");
        user.setAge(12);
        user.setTel("4006184000");
        userDao.insert(user);
    }

    /**
     * 删除+逻辑删除
     */
    @Test
    void testDeletById(){
        //删除指定多条数据
//        List<Long> list = new ArrayList<>();
//        list.add(1402551342481838081L);
//        list.add(1402553134049501186L);
//        list.add(1402553619611430913L);
//        userDao.deleteBatchIds(list);
        //查询指定多条数据
//        List<Long> list = new ArrayList<>();
//        list.add(1L);
//        list.add(3L);
//        list.add(4L);
//        userDao.selectBatchIds(list);

        //删除单条 --逻辑删除配置完成
        //userDao.deleteById(1675567477242736642L);
        //查询全部
        //System.out.println(userDao.selectList(null));
        userDao.selectById(2L);


    }

    /**
     * 乐观锁
     */
    @Test
    void testUpdate(){
        //没有携带version数据
//        User user = new User();
//        user.setId(3L);
//        user.setName("Jock666");
//        user.setVersion(1);
//        userDao.updateById(user);

//        //1.先通过要修改的数据id将当前数据查询出来
//        User user = userDao.selectById(3L);
//        //2.将要修改的属性逐一设置进去
//        user.setName("Jock888");
//        userDao.updateById(user);



        //1.先通过要修改的数据id将当前数据查询出来
        User user = userDao.selectById(3L);     //version=3

        User user2 = userDao.selectById(3L);    //version=3

        user2.setName("Jock aaa");
        userDao.updateById(user2);              //version=>4


        user.setName("Jock bbb");
        userDao.updateById(user);               //verion=3?条件还成立吗？

    }

}
