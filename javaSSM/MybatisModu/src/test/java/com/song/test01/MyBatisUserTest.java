package com.song.test01;

import com.song.mybatis.mapper.BrandMapper;
import com.song.mybatis.mapper.UserMapper;
import com.song.mybatis.pojo.Brand;
import com.song.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisUserTest {
    /**
     * 多个参数传递 非注解方法  不推荐
     * @throws IOException
     */
    @Test
    public void select() throws IOException {
        //获取sqlSessionFactory
        String resoure = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);

        //执行方法
        User select = usermapper.select("zhangsan", "123");
        System.out.println(select);

        //释放资源
        sqlSession.close();
    }

    /**
     * 多个参数传递 注解方法 推荐
     * 结论：以后接口参数是多个时，在每个参数上都使用 `@Param` 注解。这样代码的可读性更高。
     * @throws IOException
     */
    @Test
    public void select1() throws IOException {
        //获取sqlSessionFactory
        String resoure = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);

        //执行方法
        User select = usermapper.select1("zhangsan", "123");
        System.out.println(select);

        //释放资源
        sqlSession.close();
    }

    /**
     * 设置对象传入多个参数传入map接收
     * @throws IOException
     */
    @Test
    public void selectMap() throws IOException {
        //设置Map接收参数
        String username="zhangsan";
        String password="123";

        //获取sqlSessionFactory
        String resoure = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);

        HashMap map = new HashMap();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        map.put("user",user);

        //执行方法
        User select =  usermapper.selectMap(map);
//        usermapper.selectMap(map);
        System.out.println(select);

        //释放资源
        sqlSession.close();
    }

    /**
     * 注解查询id
     * @throws IOException
     */
    @Test
    public void selectById() throws IOException {
        //获取sqlSessionFactory
        String resoure = "mybatis-config.xml";//声明配置文件信息
        InputStream resourceAsStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);

        //执行方法
        User selectById = usermapper.selectById(2);
        System.out.println(selectById);

        //释放资源
        sqlSession.close();
    }




}
