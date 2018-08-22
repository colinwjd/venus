package com.colinwjd.venus.repository;

import com.colinwjd.venus.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 类目数据访问接口
 *
 * @author Colin Wang
 * @date 2018/8/22
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

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
