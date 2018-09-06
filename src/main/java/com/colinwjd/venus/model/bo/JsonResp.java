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

    /**
     * 响应编码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 额外信息
     */
    private Map<String, Object> extra;

    private JsonResp(Integer code, String message, T data, Map<String, Object> extra) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.extra = extra;
    }

    public static <T> JsonResp<T> success() {
        return httpStatus(HttpStatus.OK);
    }

    public static <T> JsonResp<T> success(T data) {
        return httpStatus(HttpStatus.OK, data);
    }

    public static <T> JsonResp<T> success(T data, Map<String, Object> extra) {
        return httpStatus(HttpStatus.OK, data, extra);
    }

    public static <T> JsonResp<T> success(String message, T data) {
        return build(HttpStatus.OK.value(), message, data);
    }

    public static <T> JsonResp<T> success(String message, T data, Map<String, Object> extra) {
        return build(HttpStatus.OK.value(), message, data, extra);
    }

    public static <T> JsonResp<T> httpStatus(HttpStatus status) {
        return build(status.value(), status.getReasonPhrase());
    }

    public static <T> JsonResp<T> httpStatus(HttpStatus status, T data) {
        return build(status.value(), status.getReasonPhrase(), data);
    }

    public static <T> JsonResp<T> httpStatus(HttpStatus status, T data, Map<String, Object> extra) {
        return build(status.value(), status.getReasonPhrase(), data, extra);
    }

    public static <T> JsonResp<T> build(Integer code, String message) {
        return build(code, message, null, null);
    }

    public static <T> JsonResp<T> build(Integer code, String message, T data) {
        return build(code, message, data, null);
    }

    public static <T> JsonResp<T> build(Integer code, String message, T data, Map<String, Object> extra) {
        return new JsonResp<>(code, message, data, extra);
    }
}
