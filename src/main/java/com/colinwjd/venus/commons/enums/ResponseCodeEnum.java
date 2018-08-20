package com.colinwjd.venus.commons.enums;

/**
 * 响应码枚举
 *
 * @author Colin Wang
 * @date 2018/8/20
 */
public enum ResponseCodeEnum {

    SUCCESS(200, "OK"),

    EMPTY(204, "No Content"),

    ERROR(500, "Internal Server Error"),

    NOT_FOUND(404, "Not Found");

    private int code;
    private String message;

    ResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
