package com.song.controller;

public class Code {
    public static final Integer SAVE_OK = 20011;
    public static final Integer DELETE_OK = 20021;
    public static final Integer UPDATE_OK = 20031;
    public static final Integer GET_OK = 20041;

    public static final Integer SAVE_ERR = 20010;
    public static final Integer DELETE_ERR = 20020;
    public static final Integer UPDATE_ERR = 20030;
    public static final Integer GET_ERR = 20040;

    //之前其他状态码省略没写，以下是新补充的状态码，可以根据需要自己补充
    //异常代码根据业务需求 或者公司内自定的异常代码来编写
    public static final Integer SYSTEM_ERR=5001;
    public static final Integer SYSTEM_TIMEOUT_ERR=5002;
    public static final Integer SYSTEM_UNKNOW_ERR=5999;
    public static final Integer BUSINESS_ERR=6002;


}
