package com.colinwjd.venus.commons.enums;

/**
 * 禁用评论枚举
 *
 * @author Colin Wang
 * @date 2018/8/20
 */
public enum DisableCommentEnum {

    /**
     * 禁用评论
     */
    DISABLE(1),

    /**
     * 开启评论
     */
    ENABLE(0);

    private int value;

    DisableCommentEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
