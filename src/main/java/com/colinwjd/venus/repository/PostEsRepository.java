package com.colinwjd.venus.repository;

import com.colinwjd.venus.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 文章 ElasticSearch 接口
 *
 * @author Colin Wang
 * @date 2018/9/17
 */
public interface PostEsRepository extends ElasticsearchRepository<Post, Long> {

    /**
     * 通过标题进行关键词模糊查询
     *
     * @param keyword 关键词
     * @return 文章列表
     */
    List<Post> findByTitleLike(String keyword);

    /**
     * 通过内容进行关键词模糊查询
     *
     * @param keyword 关键词
     * @return 文章列表
     */
    List<Post> findByContentLike(String keyword);

    /**
     * 通过内容进行关键词模糊查询 分页
     *
     * @param keyword  关键词
     * @param pageable 分页信息
     * @return 文章分页
     */
    Page<Post> findByContentLike(String keyword, Pageable pageable);
}
