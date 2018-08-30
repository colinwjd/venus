package com.colinwjd.venus.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 搜索服务
 *
 * @author Colin Wang
 * @date 2018/8/30
 */
public interface SearchService<T> {

    /**
     * 通过关键词搜索
     *
     * @param keyword 关键词
     * @return 搜索结果列表
     */
    List<T> search(String keyword);

    /**
     * 通过关键词搜索 分页
     *
     * @param keyword  关键词
     * @param pageable 分页信息
     * @return 搜索结果分页
     */
    Page<T> search(String keyword, Pageable pageable);
}
