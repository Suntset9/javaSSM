package com.song.domain;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;


/*
    1 生成getter和setter方法：@Getter、@Setter
      生成toString方法：@ToString
      生成equals和hashcode方法：@EqualsAndHashCode

    2 统一成以上所有：@Data

    3 生成空参构造： @NoArgsConstructor
      生成全参构造： @AllArgsConstructor

    4 lombok还给我们提供了builder的方式创建对象,好处就是可以链式编程。
    @Builder【扩展】
 */
@Data
//@TableName("tbl_user") //表名与编码不同时设置  application.yml,基本上都简化开发到yml文件中
public class User {
    /*
       id为Long类型，因为数据库中id为bigint类型，
       并且mybatis有自己的一套id生成方案，生成出来的id必须是Long类型
     */
    //@TableId(type = IdType.AUTO)    //设置主键生成策略
    private Long id;
    private String name;
    @TableField(value = "pwd",select = false)//select字设置为false不加入 select查询范围 查询时将pwd隐藏,目的在于不展示密码
    private String password;
    private Integer age;
    private String tel;
    /**
     * 编码中添加了数据库中未定义的属性
     * 表示online字段不参与CRUD操作
     * `exist`，设置该字段是否在数据库表中存在，
     * 如果设置为false则不存在，生成sql语句查询的时候，就不会再查询该字段了。
     */
    @TableField(exist = false)
    private Integer onlince;

    /**
     * 配置逻辑删除，删除一条数据，将业务数据从数据库中 丢弃
     * 逻辑删除：为数据设置是否可用状态字段，删除时设置状态字段为不可用状态，数据保留在数据库中
     */
    //@TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;

    /**
     * 乐观锁（Update）version
     * 需定义乐观锁拦截器
     */
    @Version
    private Integer version;


}
