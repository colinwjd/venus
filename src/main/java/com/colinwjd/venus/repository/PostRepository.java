package com.colinwjd.venus.repository;

import com.colinwjd.venus.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 文章持久层
 *
 * @author Colin Wang
 * @date 2018/8/20
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    /**
     * 查询最新的N篇文章
     *
     * @param n 数量
     * @return 文章列表
     */
    @Query(value = "select * from venus_post where type = 'post' order by create_time desc limit ?1", nativeQuery = true)
    List<Post> findLatestN(int n);

    /**
     * 通过类型查询文章
     *
     * @param type 文章类型 post or page
     * @return 文章列表
     */
    List<Post> findPostByType(String type);

    /**
     * 通过类型查询文章 分页
     * @param type 文章类型 post or page
     * @param pageable 分页信息
     * @return 文章列表
     */
    List<Post> findPostByType(String type, Pageable pageable);
}
