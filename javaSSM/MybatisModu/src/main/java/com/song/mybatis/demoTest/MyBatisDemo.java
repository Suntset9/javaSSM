package com.song.mybatis.demoTest;

import com.song.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDemo {

    /**
     * 入门代码
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //加载mybatis的核心配置文件,获取sql SessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象,用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行
        List<User> user = sqlSession.selectList("test.selectAll");
        System.out.println(user);
        //释放资源
        inputStream.close();

    }
}
