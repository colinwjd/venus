package com.colinwjd.venus.commons.enums;

/**
 * 评论状态枚举
 *
 * @author Colin Wang
 * @date 2018/8/20
 */
public enum CommentStatusEnum {

    PUBLISHED(0, "已生效"),
    CHECKING(1, "待审核"),
    RECYCLE(2, "回收站");

    private int value;
    private String desc;

    CommentStatusEnum(int value, String desc) {
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
