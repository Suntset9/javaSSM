package com.song.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("tbl_user")//表名与编码不同时设置
public class User {
    /*
       id为Long类型，因为数据库中id为bigint类型，
       并且mybatis有自己的一套id生成方案，生成出来的id必须是Long类型
     */
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


    //public Long getId() {
    //    return id;
    //}
    //
    //public void setId(Long id) {
    //    this.id = id;
    //}
    //
    //public String getName() {
    //    return name;
    //}
    //
    //public void setName(String name) {
    //    this.name = name;
    //}
    //
    //public String getPassword() {
    //    return password;
    //}
    //
    //public void setPassword(String password) {
    //    this.password = password;
    //}
    //
    //public Integer getAge() {
    //    return age;
    //}
    //
    //public void setAge(Integer age) {
    //    this.age = age;
    //}
    //
    //public String getTel() {
    //    return tel;
    //}
    //
    //public void setTel(String tel) {
    //    this.tel = tel;
    //}
    //
    //@Override
    //public String toString() {
    //    return "User{" +
    //            "id=" + id +
    //            ", name='" + name + '\'' +
    //            ", password='" + password + '\'' +
    //            ", age='" + age + '\'' +
    //            ", tel='" + tel + '\'' +
    //            '}';
    //}
}
