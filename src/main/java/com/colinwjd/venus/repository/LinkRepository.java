package com.colinwjd.venus.repository;

import com.colinwjd.venus.model.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 友情链接数据访问接口
 *
 * @author Colin Wang
 * @date 2018/8/22
 */
public interface LinkRepository extends JpaRepository<Link, Long> {

    /**
     * 通过名称查询友情链接
     *
     * @param name 友情链接名称
     * @return 友情链接
     */
    Link findByName(String name);

    /**
     * 通过地址查询友情链接
     *
     * @param url 友情链接地址
     * @return 友情链接
     */
    Link findByUrl(String url);
}
