package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.User;

import java.util.Date;

/**
 * 用户服务
 *
 * @author Colin Wang
 * @date 2018/8/23
 */
public interface UserService {

    /**
     * 保存用户
     *
     * @param user 用户
     * @return 保存的用户
     */
    User saveByUser(User user);

    /**
     * 通过用户名和密码登录
     *
     * @param name     用户名
     * @param password 密码
     * @return 用户
     */
    User loginByName(String name, String password);

    /**
     * 通过邮箱和密码登录
     *
     * @param email    邮箱地址
     * @param password 密码
     * @return 用户
     */
    User loginByEmail(String email, String password);
}
