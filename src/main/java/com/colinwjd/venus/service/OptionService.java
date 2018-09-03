package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.Option;

import java.util.Map;

/**
 * 配置项服务
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
public interface OptionService {

    /**
     * 保存配置项
     *
     * @param option 配置项
     * @return 配置项
     */
    Option saveByOption(Option option);

    /**
     * 保存配置
     *
     * @param name  配置名称
     * @param value 配置值
     * @return 配置项
     */
    Option saveOption(String name, String value);

    /**
     * 批量保存配置
     *
     * @param options 配置集合
     */
    void saveOptions(Map<String, String> options);

    /**
     * 通过ID删除配置项
     *
     * @param id 配置项ID
     * @return 被删除的配置项
     */
    Option removeById(Long id);

    /**
     * 查询所有配置
     *
     * @return 配置集合
     */
    Map<String, String> findAll();

    /**
     * 通过名称查询配置项
     *
     * @param name 配置项名称
     * @return 配置项
     */
    Option findByName(String name);
}
