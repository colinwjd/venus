package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.Tag;

import java.util.List;

/**
 * 标签服务
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
public interface TagService {

    /**
     * 保存标签
     *
     * @param tag 标签
     * @return 标签
     */
    Tag saveByTag(Tag tag);

    /**
     * 通过ID删除标签
     *
     * @param id 标签ID
     * @return 被删除的标签
     */
    Tag removeById(Long id);

    /**
     * 查询所有标签
     *
     * @return 标签列表
     */
    List<Tag> findAll();

    /**
     * 通过ID查询标签
     *
     * @param id 标签ID
     * @return 标签
     */
    Tag findById(Long id);

    /**
     * 通过地址查询标签
     *
     * @param url 标签地址
     * @return 标签
     */
    Tag findByUrl(String url);

    /**
     * 通过名称查询标签
     *
     * @param name 标签名称
     * @return 标签
     */
    Tag findByName(String name);
}
