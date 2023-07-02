package com.song.domain;


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
public class User {
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String tel;


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
