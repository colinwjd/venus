package com.colinwjd.venus.commons.enums;

/**
 * 文章类型枚举
 *
 * @author Colin Wang
 * @date 2018/8/20
 */
public enum PostTypeEnum {

    /**
     * 文章类型
     */
    POST("post"),

    /**
     * 页面类型
     */
    PAGE("page");

    private String value;

    PostTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
