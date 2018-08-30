package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.Category;
import com.colinwjd.venus.model.entity.Post;
import com.colinwjd.venus.model.entity.Tag;
import com.colinwjd.venus.model.vo.Archive;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 文章服务
 *
 * @author Colin Wang
 * @date 2018/8/27
 */
public interface PostService extends SearchService<Post> {

    /**
     * 保存文章
     *
     * @param post 文章
     * @return 保存的文章
     */
    Post saveByPost(Post post);

    /**
     * 通过ID删除文章
     *
     * @param id 文章ID
     * @return 被删除的文章
     */
    Post removeById(Long id);

    /**
     * 更新文章状态
     *
     * @param post   文章
     * @param status 文章状态
     * @return 状态更新后的文章
     */
    Post updateStatus(Post post, Integer status);

    /**
     * 更新文章阅读量
     *
     * @param post 文章
     * @return 阅读量更新后的文章
     */
    Post updateVisitCount(Post post);

    /**
     * 修改文章摘要字数
     *
     * @param wordCount 字数
     */
    void updateSummaryWordCount(Integer wordCount);

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
     * 通过ID查询文章
     *
     * @param id 文章ID
     * @return 文章
     */
    Post findById(Long id);

    /**
     * 通过地址查询文章
     *
     * @param url 文章地址
     * @return 文章
     */
    Post findByUrl(String url);

    /**
     * 查询最新的N篇文章
     *
     * @param n 数量
     * @return 最新的N篇文章列表
     */
    List<Post> findLatestN(int n);

    /**
     * 通过年份和月份归档文章
     *
     * @return 归档列表
     */
    List<Archive> archiveByYearAndMonth();

    /**
     * 通过年份归档文章
     *
     * @return 归档列表
     */
    List<Archive> archiveByYear();

    /**
     * 通过年份和月份查询文章
     *
     * @param year  年份
     * @param month 月份
     * @return 文章列表
     */
    List<Post> findByYearAndMonth(String year, String month);

    /**
     * 通过年份和月份查询文章 分页
     *
     * @param year     年份
     * @param month    月份
     * @param pageable 分页信息
     * @return 文章分页
     */
    Page<Post> findByYearAndMonth(String year, String month, Pageable pageable);

    /**
     * 通过年份查询文章
     *
     * @param year 年份
     * @return 文章列表
     */
    List<Post> findByYear(String year);

    /**
     * 通过年份查询文章 分页
     *
     * @param year     年份
     * @param pageable 分页信息
     * @return 文章分页
     */
    Page<Post> findByYear(String year, Pageable pageable);

    /**
     * 通过类目查询文章 分页
     *
     * @param category 文章类目
     * @param pageable 分页信息
     * @return 文章分页
     */
    Page<Post> findByCategory(Category category, Pageable pageable);

    /**
     * 通过标签查询文章 分页
     *
     * @param tag      文章标签
     * @param pageable 分页信息
     * @return 文章分页
     */
    Page<Post> findByTag(Tag tag, Pageable pageable);

    /**
     * 热门文章
     *
     * @return 热门文章列表
     */
    List<Post> popularPost();

    /**
     * 相似文章列表
     *
     * @param post 文章
     * @return 文章列表
     */
    List<Post> relatedPosts(Post post);

    /**
     * 文章阅读总量
     *
     * @return 总阅读量
     */
    Long totalVisitCount();

    /**
     * 通过状态统计文章数量
     *
     * @param status 文章状态
     * @return 对应状态的文章数量
     */
    Integer countByStatus(Integer status);

    /**
     * 文章关键词
     *
     * @param post 文章
     * @param num  关键词个数
     * @return 关键词列表
     */
    List<String> keywords(Post post, Integer num);
}
