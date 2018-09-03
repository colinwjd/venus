package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.Link;

import java.util.List;

/**
 * 友情链接服务
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
public interface LinkService {

    /**
     * 保存链接
     *
     * @param link 链接
     * @return 链接
     */
    Link saveByLink(Link link);

    /**
     * 通过ID删除链接
     *
     * @param id 链接ID
     * @return 被删除的链接
     */
    Link removeById(Long id);

    /**
     * 查询所有链接
     *
     * @return 链接列表
     */
    List<Link> findAll();

    /**
     * 通过ID查询链接
     *
     * @param id 链接ID
     * @return 链接
     */
    Link findById(Long id);

    /**
     * 通过地址查询链接
     *
     * @param url 链接地址
     * @return 链接
     */
    Link findByUrl(String url);

    /**
     * 通过名称查询链接
     *
     * @param name 链接名称
     * @return 链接
     */
    Link findByName(String name);
}
