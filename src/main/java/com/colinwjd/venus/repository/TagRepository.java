package com.colinwjd.venus.repository;

import com.colinwjd.venus.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 标签数据访问接口
 *
 * @author Colin Wang
 * @date 2018/8/21
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

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
