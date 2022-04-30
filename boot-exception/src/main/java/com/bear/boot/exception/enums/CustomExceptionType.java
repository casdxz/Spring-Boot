package com.bear.boot.exception.enums;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-11 13:50
 **/
public enum CustomExceptionType {

    /**
     *
     */
    USER_INPUT_ERROR(400,"你输入的数据错误或您没有权限访问资源！"),

    /**
     *
     */
    SYSTEM_ERROR(500,"系统出现一异常，请你稍后再试或联系管理员！"),
    /**
     *
     */
    OTHER_ERROR(999, "系统出现未知异常，请联系管理员");

    CustomExceptionType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     *
     */
    private final String desc;


    private final Integer code;
}
