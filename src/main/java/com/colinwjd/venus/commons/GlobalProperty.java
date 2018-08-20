package com.colinwjd.venus.commons;

import com.colinwjd.venus.commons.enums.DisableCommentEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局属性
 *
 * @author Colin Wang
 * @date 2018/8/20
 */
public class GlobalProperty {

    /**
     * 全部配置项
     */
    public static final Map<String, String> OPTIONS = new HashMap<>();

    /**
     * OwO表情
     */
    public static final Map<String, String> OWO = new HashMap<>();

    /**
     * session key
     */
    public static final String USER_SESSION_KEY = "user_session";
}
