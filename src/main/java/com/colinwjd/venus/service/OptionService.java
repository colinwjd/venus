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

    Option saveByOption(Option option);

    Option saveOption(String name, String value);

    void saveOptions(Map<String, String> options);

    Option removeById(Long id);

    Map<String, String> findAll();

    Option findByName(String name);
}
