package com.song.mybatis.mapper;

import com.song.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> selectAll();

    User select(String username,String password);

    User select1(@Param("username") String username, @Param("password") String password);

    //设置Map集合测试方法
    User selectMap(Map<String,User> map);

    @Select("select * from tb_user where id = #{id}")
    User selectById(int id);



}
