package com.colinwjd.venus.repository;

import com.colinwjd.venus.model.entity.Comment;
import com.colinwjd.venus.model.entity.Post;
import com.colinwjd.venus.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 评论数据访问接口
 *
 * @author Colin Wang
 * @date 2018/8/22
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    /**
     * 通过状态查询评论
     *
     * @param status 评论状态 0:已生效 1:待审核 2:回收站
     * @return 评论列表
     */
    List<Comment> findByStatus(Integer status);

    /**
     * 通过状态查询评论 分页
     *
     * @param status   评论状态 0:已生效 1:待审核 2:回收站
     * @param pageable 分页信息
     * @return 评论分页
     */
    Page<Comment> findByStatus(Integer status, Pageable pageable);

    /**
     * 通过文章查询评论
     *
     * @param post 文章
     * @return 评论列表
     */
    List<Comment> findByPost(Post post);

    /**
     * 通过文章查询评论 分页
     *
     * @param post     文章
     * @param pageable 分页信息
     * @return 评论分页
     */
    Page<Comment> findByPost(Post post, Pageable pageable);

    /**
     * 通过文章和状态查询评论
     *
     * @param post   文章
     * @param status 评论状态 0:已生效 1:待审核 2:回收站
     * @return 评论列表
     */
    List<Comment> findByPostAndStatus(Post post, Integer status);

    /**
     * 通过文章和状态查询评论 分页
     *
     * @param post     文章
     * @param status   评论状态 0:已生效 1:待审核 2:回收站
     * @param pageable 分页信息
     * @return 评论分页
     */
    Page<Comment> findByPostAndStatus(Post post, Integer status, Pageable pageable);

    /**
     * 根据文章和状态(非)查询评论
     *
     * @param post   文章
     * @param status 评论状态 0:已生效 1:待审核 2:回收站
     * @return 评论列表
     */
    List<Comment> findByPostAndStatusNot(Post post, Integer status);

    /**
     * 根据文章和状态(非)查询评论 分页
     *
     * @param post     文章
     * @param status   评论状态 0:已生效 1:待审核 2:回收站
     * @param pageable 分页信息
     * @return 评论分页
     */
    Page<Comment> findByPostAndStatusNot(Post post, Integer status, Pageable pageable);

    /**
     * 通过用户查询评论
     *
     * @param user 用户
     * @return 评论列表
     */
    List<Comment> findByUser(User user);

    /**
     * 通过用户查询评论 分页
     *
     * @param user     用户
     * @param pageable 分页信息
     * @return 评论分页
     */
    Page<Comment> findByUser(User user, Pageable pageable);

    /**
     * 通过用户和状态查询评论
     *
     * @param user   用户
     * @param status 评论状态 0:已生效 1:待审核 2:回收站
     * @return 评论列表
     */
    List<Comment> findByUserAndStatus(User user, Integer status);

    /**
     * 通过用户和状态查询评论 分页
     *
     * @param user     用户
     * @param status   评论状态 0:已生效 1:待审核 2:回收站
     * @param pageable 分页信息
     * @return 评论分页
     */
    Page<Comment> findByUserAndStatus(User user, Integer status, Pageable pageable);

    /**
     * 通过关键词模糊查询评论
     *
     * @param keyword 关键词
     * @return 评论列表
     */
    List<Comment> findByContentLike(String keyword);

    /**
     * 通过关键词模糊查询评论 分页
     *
     * @param keyword  关键词
     * @param pageable 分页信息
     * @return 评论分页
     */
    Page<Comment> findByContentLike(String keyword, Pageable pageable);

    /**
     * 查询最新的N条评论
     *
     * @param n 数量
     * @return 评论列表
     */
    @Query(value = "select * from venus_comment order by create_time desc limit ?1", nativeQuery = true)
    List<Comment> findLatestN(int n);

    /**
     * 根据状态统计评论数量
     *
     * @param status 评论状态 0:已生效 1:待审核 2:回收站
     * @return 评论数
     */
    Integer countByStatus(Integer status);
}
