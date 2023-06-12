package com.song.dao;

import com.song.domain.Account;
import com.song.service.AccountService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountDao {
    //配置Dao数据访问层，对数据进行增删改查
    @Insert("insert into tbl_account(name,money)values(#{name},#{money})")
    void save(Account account);
    @Delete("delete from tbl_account where id = #{id}")
    void delete(Integer id);
    @Update("update tbl_account set name = #{name} , money = #{money} where id = #{id}}")
    void Update(Account account);
    @Select("select * from tbl_account")
    List<Account> findAll();
    @Select("select * from tbl_account where id = #{id} ")
    Account findById(Integer id);
}
