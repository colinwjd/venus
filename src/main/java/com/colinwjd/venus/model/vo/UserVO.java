package com.colinwjd.venus.model.vo;

import lombok.Data;

/**
 * 用户 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
public class UserVO {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户昵称
     */
    private String nick;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 简介
     */
    private String desc;

    /**
     * 用户主页
     */
    private String url;

    /**
     * GitHub地址
     */
    private String github;
}
