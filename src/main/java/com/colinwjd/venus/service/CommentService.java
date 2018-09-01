package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.Comment;
import com.colinwjd.venus.model.entity.Post;
import com.colinwjd.venus.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 评论服务
 *
 * @author Colin Wang
 * @date 2018/8/31
 */
public interface CommentService extends SearchService<Comment> {

    /**
     * 保存评论
     *
     * @param comment 评论
     * @return 保存的评论
     */
    Comment saveByComment(Comment comment);

    /**
     * 通过ID删除评论
     *
     * @param id 评论ID
     * @return 被删除的评论
     */
    Comment removeCommentById(Long id);

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
     * 更新评论状态
     *
     * @param comment 评论
     * @param status  评论状态 0:已生效 1:待审核 2:回收站
     * @return 状态修改后的评论
     */
    Comment updateStatus(Comment comment, Integer status);

    /**
     * 通过ID查询评论
     *
     * @param id 评论ID
     * @return 评论
     */
    Comment findById(Long id);

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
     * 通过文章和状态(非)查询评论
     *
     * @param post   文章
     * @param status 评论状态 0:已生效 1:待审核 2:回收站
     * @return 评论列表
     */
    List<Comment> findByPostAndStatusNot(Post post, Integer status);

    /**
     * 通过文章和状态(非)查询评论
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
     * 获取最新的N条评论
     *
     * @param n 数量
     * @return 评论列表
     */
    List<Comment> findLatestN(int n);

    /**
     * 根据状态统计评论数量
     *
     * @param status 评论状态 0:已生效 1:待审核 2:回收站
     * @return 数量
     */
    Integer countByStatus(Integer status);
}
