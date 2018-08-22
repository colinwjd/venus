package com.colinwjd.venus.repository;

import com.colinwjd.venus.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户数据访问接口
 *
 * @author Colin Wang
 * @date 2018/8/20
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 通过用户名查询
     *
     * @param name 用户名
     * @return User
     */
    User findByName(String name);

    /**
     * 通过用户名和密码查询
     *
     * @param name     用户名
     * @param password 密码
     * @return User
     */
    User findByNameAndPassword(String name, String password);

    /**
     * 通过邮箱查询
     *
     * @param email 用户邮箱
     * @return User
     */
    User findByEmail(String email);

    /**
     * 通过邮箱和密码查询
     *
     * @param email    用户邮箱
     * @param password 用户密码
     * @return User
     */
    User findByEmailAndPassword(String email, String password);
}
