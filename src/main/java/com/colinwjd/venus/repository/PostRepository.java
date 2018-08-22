package com.colinwjd.venus.repository;

import com.colinwjd.venus.model.entity.Category;
import com.colinwjd.venus.model.entity.Post;
import com.colinwjd.venus.model.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 文章数据访问接口
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
    List<Post> findByType(String type);

    /**
     * 通过类型查询文章 分页
     *
     * @param type     文章类型 post or page
     * @param pageable 分页信息
     * @return 文章分页
     */
    Page<Post> findByType(String type, Pageable pageable);

    /**
     * 通过类型和状态查询文章
     *
     * @param type   文章类型 post or page
     * @param status 文章状态 0:已发布 1:草稿箱 2:回收站
     * @return 文章列表
     */
    List<Post> findByTypeAndStatus(String type, Integer status);

    /**
     * 通过类型和状态查询文章 分页
     *
     * @param type     文章类型 post or page
     * @param status   文章状态 0:已发布 1:草稿箱 2:回收站
     * @param pageable 分页信息
     * @return 文章分页
     */
    Page<Post> findByTypeAndStatus(String type, Integer status, Pageable pageable);

    /**
     * 通过地址查询文章
     *
     * @param url 文章地址
     * @return 文章
     */
    Post findByUrl(String url);

    /**
     * 通过类型和地址查询文章
     *
     * @param type 文章类型 post or page
     * @param url  文章地址
     * @return 文章
     */
    Post findByTypeAndUrl(String type, String url);

    /**
     * 根据年份和月份统计文章归档信息
     *
     * @return [年份, 月份, 文章数] 列表
     */
    @Query(value = "select year(create_time) as year, month(create_time) as month, count(*) as count from venus_post where status = 0 and type = 'post' group by year(create_time), month(create_time) order by year desc, month desc", nativeQuery = true)
    List<Object[]> countPostGroupByYearAndMonth();

    /**
     * 根据年份统计文章归档信息
     *
     * @return [年份, 文章数] 列表
     */
    @Query(value = "select year(create_time) as year, count(*) as count from venus_post where status = 0 and type = 'post' group by year(create_time) order by year desc", nativeQuery = true)
    List<Object[]> countPostGroupByYear();

    /**
     * 根据年份和月份查询文章
     *
     * @param year  年份
     * @param month 月份
     * @return 文章列表
     */
    @Query(value = "select * from venus_post where status = 0 and type = 'post' and year(create_time) = :year and month(create_time) = :month order by create_time desc", nativeQuery = true)
    List<Post> findByYearAndMonth(@Param("year") String year, @Param("month") String month);

    /**
     * 根据年份和月份查询文章 分页
     *
     * @param year     年份
     * @param month    月份
     * @param pageable 分页信息
     * @return 文章分页
     */
    @Query(value = "select * from venus_post where status = 0 and type = 'post' and year(create_time) = :year and month(create_time) = :month order by create_time desc",
            countQuery = "select count(*) from venus_post where status = 0 and type = 'post' and year(create_time) = :year and month(create_time) = :month",
            nativeQuery = true)
    Page<Post> findByYearAndMonth(@Param("year") String year, @Param("month") String month, Pageable pageable);

    /**
     * 根据年份查询文章
     *
     * @param year 年份
     * @return 文章列表
     */
    @Query(value = "select * from venus_post where status = 0 and type = 'post' and year(create_time) = :year order by create_time desc", nativeQuery = true)
    List<Post> findByYear(@Param("year") String year);

    /**
     * 根据年份查询文章 分页
     *
     * @param year     年份
     * @param pageable 分页信息
     * @return 文章分页
     */
    @Query(value = "select * from venus_post where status = 0 and type = 'post' and year(create_time) = :year order by create_time desc",
            countQuery = "select count(*) from venus_post where status = 0 and type = 'post' and year(create_time) = :year", nativeQuery = true)
    Page<Post> findByYear(@Param("year") String year, Pageable pageable);

    /**
     * 通过类目和状态查询文章 分页
     *
     * @param category 文章类目
     * @param status   文章状态 0:已发布 1:草稿箱 2:回收站
     * @param pageable 分页信息
     * @return 文章分页
     */
    Page<Post> findByCategoriesAndStatus(Category category, Integer status, Pageable pageable);

    /**
     * 通过标签和状态查询文章 分页
     *
     * @param tag      文章标签
     * @param status   文章状态 0:已发布 1:草稿箱 2:回收站
     * @param pageable 分页信息
     * @return 文章分页
     */
    Page<Post> findByTagsAndStatus(Tag tag, Integer status, Pageable pageable);

    /**
     * 文章标题模糊搜索 分页
     *
     * @param keyword  关键词
     * @param pageable 分页信息
     * @return 文章分页
     */
    Page<Post> findByTitleLike(String keyword, Pageable pageable);

    /**
     * 文章标题或文章内容模糊搜索 分页
     *
     * @param keyword  关键词
     * @param pageable 分页信息
     * @return 文章分页
     */
    @Query(value = "select * from venus_post where status = 0 and type='post' and title like '%=:keyword%' or content_md like '%=:keyword%' or content_html like '%=:keyword%'", nativeQuery = true)
    Page<Post> findByTitleLikeOrContentLike(String keyword, Pageable pageable);

    /**
     * 通过状态查询文章并根据访问量倒序排序
     *
     * @param status 文章状态 0:已发布 1:草稿箱 2:回收站
     * @return 文章列表
     */
    List<Post> findByStatusOrderByVisitCountDesc(Integer status);

    /**
     * 获取全部文章阅读总量
     *
     * @return 阅读量
     */
    @Query(value = "select sum(visit_count) from venus_post", nativeQuery = true)
    Long getTotalVisitCount();

    /**
     * 根据类型和状态统计文章数量
     *
     * @param type   文章类型 post or page
     * @param status 文章状态 0:已发布 1:草稿箱 2:回收站
     * @return 文章数
     */
    Integer countPostByTypeAndStatus(String type, Integer status);
}
