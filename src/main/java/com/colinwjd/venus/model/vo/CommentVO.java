package com.colinwjd.venus.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 评论 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
public class CommentVO {

    /**
     * 评论ID
     */
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /**
     * 评论用户
     */
    private String user;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论用户user-agent信息
     */
    private String ua;

    /**
     * 是否作者本人评论 0:否 1:是
     */
    private Integer isAuthor;

    /**
     * 子评论列表
     */
    private List<CommentVO> children;
}
