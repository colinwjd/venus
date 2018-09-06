package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 用户服务
 *
 * @author Colin Wang
 * @date 2018/8/23
 */
public interface UserService extends UserDetailsService {

    /**
     * 保存用户
     *
     * @param user 用户
     * @return 保存的用户
     */
    User saveByUser(User user);

    /**
     * 用户注册
     *
     * @param user 用户
     * @return 注册的用户
     */
    User signUp(User user);

    /**
     * 修改密码
     *
     * @param user 用户
     * @return true:修改成功 false:修改失败
     */
    boolean updatePassword(User user, String oldPassword, String newPassword);

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

    /**
     * 通过ID查询用户
     *
     * @param id 用户ID
     * @return 用户
     */
    User findById(Long id);

    /**
     * 通过名称查询用户
     *
     * @param name 用户名称
     * @return 用户
     */
    User findByName(String name);

    /**
     * 通过邮箱查询用户
     *
     * @param email 用户邮箱
     * @return 用户
     */
    User findByEmail(String email);
}
