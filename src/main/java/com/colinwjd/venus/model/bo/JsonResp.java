package com.colinwjd.venus.model.bo;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Map;

/**
 * Restful Json 响应结果
 *
 * @author Colin Wang
 * @date 2018/9/4
 */
@Data
public class JsonResp<T> implements Serializable {

    private static final long serialVersionUID = 317009052871918210L;

    protected Integer code;

    protected String message;

    protected T data;

    protected Map<String, Object> extra;

    public JsonResp() {
        this.code = HttpStatus.OK.value();
        this.message = HttpStatus.OK.getReasonPhrase();
    }

    public JsonResp(Integer code, String message) {
        this(code, message, null, null);
    }

    public JsonResp(Integer code, String message, T data) {
        this(code, message, data, null);
    }

    public JsonResp(Integer code, String message, T data, Map<String, Object> extra) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.extra = extra;
    }

    public static <T> JsonResp success() {
        return new JsonResp<T>();
    }

    public static <T> JsonResp success(T data) {
        return new JsonResp<T>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    public static <T> JsonResp success(String message, T data) {
        return new JsonResp<T>(HttpStatus.OK.value(), message, data);
    }

    public static <T> JsonResp success(String message, T data, Map<String, Object> extra) {
        return new JsonResp<T>(HttpStatus.OK.value(), message, data, extra);
    }

    public static <T> JsonResp build(Integer code, String message) {
        return new JsonResp<T>(code, message);
    }

    public static <T> JsonResp build(Integer code, String message, T data) {
        return new JsonResp<T>(code, message, data);
    }

    public static <T> JsonResp build(Integer code, String message, T data, Map<String, Object> extra) {
        return new JsonResp<T>(code, message, data, extra);
    }
}
