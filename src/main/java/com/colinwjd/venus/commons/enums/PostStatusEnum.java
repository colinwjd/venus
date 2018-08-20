package com.colinwjd.venus.commons.enums;

/**
 * 文章状态枚举
 *
 * @author Colin Wang
 * @date 2018/8/20
 */
public enum PostStatusEnum {

    PUBLISHED(0, "已发布"),
    DRAFT(1, "草稿箱"),
    RECYCLE(2, "回收站");

    private int value;
    private String desc;

    PostStatusEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }
}
