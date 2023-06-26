package com.song.controller;

import com.song.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Controller//请求参数
@RequestMapping("/controller")
public class UserController {

    //普通参数：请求参数与形参名称对应即可完成参数传递
    @RequestMapping("/commonParm")
    @ResponseBody
    public String commonParam(String name,int age){
        System.out.println("普通参数传递 name==》"+name);
        System.out.println("普通参数传递 age==》"+age);
        return "{module:common param}";
    }

    /**
     * - 名称：@RequestParam
     * - 类型：形参注解
     * - 位置：SpringMVC控制器方法形参定义前面
     * - 作用：绑定请求参数与处理器方法形参间的关系
     * - 参数：
     *   - required：是否为必传参数
     *   - defaultValue：参数默认值
     *      普通参数：请求参数名与形参名不同时，使用@RequestParam注解关联请求参数名称与形参名称之间的关系
     *     //@RequestParam("name")用于将指定的请求参数赋值给方法中的形参。
     * @param userName
     * @param age
     * @return
     */
    @RequestMapping("/commonParamDifferentName")
    @ResponseBody
    public String commonParamDifferentName(@RequestParam("name") String userName, int age){
        System.out.println("普通参数传递 name===》"+userName);
        System.out.println("普通参数传递 name===》"+age);
        return "{'module':'common param different name'}";
    }

    //POJO参数：请求参数与形参对象中的属性对应即可完成参数传递
    @RequestMapping("pojoParm")
    @ResponseBody
    public String pojoParam(User user){
        System.out.println("POJO参数传递==》"+user);
        return "{'module':'pojo param'}";

    }

    //嵌套POJO参数，请求参数与形参对象中的属性对应即可完成参数传递
    @RequestMapping("/pojoContainPojoParam")
    @ResponseBody
    public String pojoContainPojoParam(User user){
        System.out.println("Pojo嵌套pojo参数传递 user===》"+ user);
        return "{'module':'pojo cantain pojo param'}";
    }

    //数组参数：同名请求参数可以直接映射到对应名称的形参数组对象中 ==只接收同名称参数
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes){
        System.out.println("数组参数传递 likes ==> "+ Arrays.toString(likes));
        return "{'module':'array param'}";
    }

    //集合参数：同名请求参数可以使用@RequestParam注解映射到对应名称的集合对象中作为数据\
    //java.lang.NoSuchMethodException: java.util.List.<init>()
    //不加入@RequestParam注解为默认是引用类型，会创建实体类，则会报错无法找到该接口下实体类，需要指定
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes){
        System.out.println("集合参数传递 likes ==> "+ likes);
        return "{'module':'list param'}";
    }

    /**
     * - 名称：@RequestBody
     * - 类型：==形参注解==
     * - 位置：SpringMVC控制器方法形参定义前面
     * - 作用：将请求中请求体所包含的数据传递给请求参数，此注解一个处理器方法只能使用一次
     *
     * //集合参数：json格式
     *     //1.开启json数据格式的自动转换，在配置类中开启@EnableWebMvc
     *     //2.使用@RequestBody注解将外部传递的json数组数据映射到形参的保存实体类对象的集合对象中，要求属性名称一一对应
     *
     * @param likes
     * @return
     */
    @RequestMapping("/pojoParamForjson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes){
        System.out.println("POJO(josn)参数传递==》"+likes);
        return "{'module':'list pojo for json param'}";
    }

    //POJO参数：json格式
    //1.开启json数据格式的自动转换，在配置类中开启@EnableWebMvc
    //2.使用@RequestBody注解将外部传递的json数据映射到形参的实体类对象中，要求属性名称一一对应
    @RequestMapping("/pojoParamForJson")
    @ResponseBody
    public String pojoParamForJson(@RequestBody User user){
        System.out.println("list pojo(json)参数传递 user ==》"+user);
        return "{'module':'pojo for json param'}";
    }

    //集合参数：json格式
    //1.开启json数据格式的自动转换，在配置类中开启@EnableWebMvc
    //2.使用@RequestBody注解将外部传递的json数组数据映射到形参的保存实体类对象的集合对象中，要求属性名称一一对应
    @RequestMapping("/listPojoParamForJson")
    @ResponseBody
    public String listPojoParamForJson(@RequestBody List<User> list){
        System.out.println("list pojo(json)参数传递 list ==> "+list);
        return "{'module':'list pojo for json param'}";
    }

    /**
     * 2088-08-18
     * 2088/08/18
     * 08/18/2088
     *
     * - 名称：@DateTimeFormat
     * - 类型：==形参注解==
     * - 位置：SpringMVC控制器方法形参前面
     * - 作用：设定日期时间型数据格式
     * - 属性：pattern：指定日期时间格式字符串
     *
     * @param date
     * @param date1
     * @param date2
     * @return
     */
    //日期参数 :http://localhost/controller/dateParam?date=2028/6/26&date1=2025-6-27&date2=2002/03/01 12:00:11
    //使用@DateTimeFormat注解设置日期类型数据格式，默认格式yyyy/MM/dd
    @RequestMapping("/dateParam")
    @ResponseBody
    public String dateParam(Date date,
                    @DateTimeFormat(pattern ="yyyy-mm-dd") Date date1,
                    @DateTimeFormat(pattern ="yyyy/mm/dd HH:mm:ss") Date date2)
    {
        System.out.println("参数传递 date ==》"+date);
        System.out.println("参数传递 date1(yyyy-mm-dd) ==》"+date1);
        System.out.println("参数传递 date2(yyyy/mm/dd HH:mm:ss) ==》"+date2);
        return "{'module':'data param'}";
    }


}
