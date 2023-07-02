package com.song;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.song.dao.UserDao;
import com.song.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusQuickstartApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testSave() {
        // 新增用户
        User user = new User();
        user.setName("宋宋");
        user.setPassword("song");
        user.setAge(12);
        user.setTel("1834437");
        userDao.insert(user);
    }
    @Test
    void testDelete() {
        // 根据ID删除用户
        userDao.deleteById(1675417455079481345L);
    }
    @Test
    void testUpdate() {
        // 更新用户信息
        User user = new User();
        user.setId(1L);
        user.setName("Tom888");
        user.setPassword("tom888");
        userDao.updateById(user);
    }
    @Test
    void testGetById() {
        // 根据ID查询用户
        User user = userDao.selectById(2L);
        System.out.println(user);
    }
    /**
     * 查询全部用户
     */
    @Test
    void testGetAll() {
        List<User> userList = userDao.selectList(null);
        System.out.println(userList);
    }
    /**
     * 分页查询用户
     */
    @Test
    void testSelectPage(){
        //1 创建IPage分页对象,设置分页参数
        IPage<User> page=new Page<>(3,3);
        //2 执行分页查询
        userDao.selectPage(page,null);
        //3 获取分页结果
        System.out.println("当前页码值："+page.getCurrent());
        System.out.println("每页显示数："+page.getSize());
        System.out.println("总页数："+page.getPages());
        System.out.println("总条数："+page.getTotal());
        System.out.println("当前页数据："+page.getRecords());
    }

}
