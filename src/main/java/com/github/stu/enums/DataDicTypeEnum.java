package com.github.stu.enums;

/**
 * Author:chyl2005
 * Date:17/2/4
 * Time:11:45
 * Desc:描述该类的作用
 */
public enum DataDicTypeEnum {
    SEX(1, "性别"),
    ZZMM(2,"政治面貌"),
    NATION(3, "民族");

    private int code;
    private String name;

    DataDicTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
