package com.colinwjd.venus.repository;

import com.colinwjd.venus.model.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 配置项数据访问接口
 *
 * @author Colin Wang
 * @date 2018/8/22
 */
public interface OptionRepository extends JpaRepository<Option, Long> {

    /**
     * 通过名称查询配置项
     *
     * @param name 配置项名称
     * @return 配置项
     */
    Option findByName(String name);
}
