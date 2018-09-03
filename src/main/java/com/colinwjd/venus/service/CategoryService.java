package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.Category;

import java.util.List;

/**
 * 类目服务
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
public interface CategoryService {

    /**
     * 保存类目
     *
     * @param category 类目
     * @return 类目
     */
    Category saveByCategory(Category category);

    /**
     * 通过ID删除类目
     *
     * @param id 类目ID
     * @return 被删除的类目
     */
    Category removeById(Long id);

    /**
     * 查询所有类目
     *
     * @return 类目列表
     */
    List<Category> findAll();

    /**
     * 通过ID查询类目
     *
     * @param id 类目ID
     * @return 类目
     */
    Category findById(Long id);

    /**
     * 通过地址查询类目
     *
     * @param url 类目地址
     * @return 类目
     */
    Category findByUrl(String url);

    /**
     * 通过名称查询类目
     *
     * @param name 类目名称
     * @return 类目
     */
    Category findByName(String name);
}
