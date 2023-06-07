package com.song.dao.impl;

import com.song.dao.UserDao;

public class UserDaoImpl implements UserDao {
    /**
     * 配置set方法，可以通过set方法注入
     */
    private String databasesNam;
    private String tableName;

    public UserDaoImpl() {

    }

    public void setDatabasesNam(String databasesNam) {
        this.databasesNam = databasesNam;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 配置了构造函数，可通过构造函数注入
     * @param databasesNam
     * @param tableName
     */
    public UserDaoImpl(String databasesNam, String tableName) {
        this.databasesNam = databasesNam;
        this.tableName = tableName;
    }

    @Override
    public void save() {
        System.out.println("use dao save ..."+databasesNam+"--set简单注入or构造注入--"+tableName);
    }
}
