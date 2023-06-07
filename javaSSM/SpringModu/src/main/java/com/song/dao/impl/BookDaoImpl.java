package com.song.dao.impl;

import com.song.dao.BookDao;

import java.util.*;

public class BookDaoImpl implements BookDao {
    /**
     * 配置set简单注入
     */
    private int connectionNum;
    private String databaseName;

    public void setConnectionNum(int connectionNum) {
        this.connectionNum = connectionNum;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    /**
     * 配置构造函数，使可以通过构造函数注入
     * @param connectionNum
     * @param databaseName
     */
    public BookDaoImpl(int connectionNum, String databaseName) {
        this.connectionNum = connectionNum;
        this.databaseName = databaseName;
    }

    /**
     * 定义了无参的构造方法，bean调用默认调用的是无参构造方法
     * 如果定义了构造方法，那么无参构造方法就不会自动生成了
     * 无参构造方法如果不存在，将抛出异常`BeanCreationExceptio
     */
    public BookDaoImpl() {
        System.out.println("book dao constructor is running ... ");
    }

    /**
     * 接口方法
     */
//    public void save() {
//        System.out.println("book dao save ..."+databaseName+"--set简单注入or构造注入--"+connectionNum);
//    }

    private int[] array;

    private List<String> list;

    private Set<String> set;

    private Map<String,String> map;

    private Properties properties;




    public void setArray(int[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }




    public void save() {
        System.out.println("book dao save ...");

        System.out.println("遍历数组:" + Arrays.toString(array));

        System.out.println("遍历List" + list);

        System.out.println("遍历Set" + set);

        System.out.println("遍历Map" + map);

        System.out.println("遍历Properties" + properties);
    }




}