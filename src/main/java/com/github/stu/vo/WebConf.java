package com.github.stu.vo;

/**
 * Author:zhangyingbing@github.com
 * Date:14-12-9
 * Time:下午1:20
 */
public class WebConf {

    // 正常
    public static final int STATUS_OK = 0;
    // 系统异常
    public static final int SYSTEM_ERROR = 1;
    // BA权限错误
    public static final int AUTH_ERROR = 2;
    // 参数错误
    public static final int PARAM_ERROR = 3;
    // 业务异常
    public static final int BIZ_ERROR = 4;
    // TOKEN权限验证错误
    public static final int TOKEN_ERROR = 5;
    // ecom商家登录错误
    public static final int ECOM_AUTH_ERROR = 6;


    public static final String SUCCESS_MESSAGE = "成功";
    public static final String AUTH_ERROR_MESSAGE = "BA权限验证失败";
    public static final String TOKEN_ERROR_MESSAGE = "TOKEN验证失败";
    public static final String PARAM_ERROR_MESSAGE = "参数错误";
    public static final String SYSTEM_ERROR_MESSAGE = "系统异常";
    public static final String BIZ_ERROR_MESSAGE = "业务异常";



}
